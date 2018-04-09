package lambda.f01_functioninterface;

/**
 * lambda表达式在方法引用中的使用
 * ObjectRef::methodName
 * 左边是类名或者实例名, 中间是方法引用符号"::", 右边是相应的方法名. 方法引用被分为三类:
 * 1. 静态方法引用
 * 2. 实例方法引用
 * 3. 构造方法引用
 */

public class demo02_functionref {
    public static void main(String[] args) {

        // 传统方式

        Convertor<String, Integer> traditionalConvertor = new Convertor<String, Integer>() {
            @Override
            public Integer convert(String param) {
                return str2int(param);
            }
        };


        Convertor<String, Integer> convertor = (param -> str2int(param));

        // 1 应用在静态引用
        Convertor<String, Integer> staticRef = demo02_functionref::str2int;

        Integer convert = staticRef.convert("200");

        System.out.println(convert);

        // 2 应用在实例方法引用
//        Helper helper = new Helper();
//        Convertor<String, Integer> shiliRef = (param) -> helper::str2int(param);// 错误写法

        Helper helper = new Helper();
        Convertor<String, Integer> converter = helper::str2int;
        converter.convert("120");

        // 3 在构造方法中的引用
        applyinConstructor();


    }

    // 1 配合静态方法引用
    static Integer str2int(String param) {
        return Integer.valueOf(param);
    }


    //2 配合实例方法引用
    static class Helper {// 由于在main方法中引用, 因此要加static. 因为main是static的
        public Integer str2int(String param) {
            return Integer.valueOf(param);
        }
    }

    // 3 在构造方法中的引用
    private static void applyinConstructor() {
        // 传统方式:

        AnimalFactory birdFactory = new AnimalFactory() {
            @Override
            public Bird create(String name, Integer age) {
                return new Bird(name, age);
            }
        };
        Bird bird = (Bird) birdFactory.create("", 0);

        AnimalFactory dogFactory = new AnimalFactory() {
            @Override
            public Dog create(String name, Integer age) {
                return new Dog(name, age);
            }
        };

        Dog dog = (Dog) dogFactory.create("", 1);


        // lambda方法:

        AnimalFactory birdFactoryLambda = Bird::new;

        birdFactoryLambda.create("", 9);

        AnimalFactory dogFactoryLambda = Dog::new;

        dogFactoryLambda.create("", 1);
    }



}

// 3 配合构造方法引用
class Animal {
    private String name;
    private Integer age;

    public Animal(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

class Bird extends Animal{

    public Bird(String name, Integer age) {
        super(name, age);
    }
}

class Dog extends Animal{

    public Dog(String name, Integer age) {
        super(name, age);
    }
}

@FunctionalInterface
interface AnimalFactory{

    Animal create(String name, Integer age);

}