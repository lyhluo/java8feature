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

        // 应用在静态引用
        Convertor<String, Integer> staticRef = demo02_functionref::str2int;

        Integer convert = staticRef.convert("200");

        System.out.println(convert);

        // 应用在实例方法引用
//        Helper helper = new Helper();
//        Convertor<String, Integer> shiliRef = (param) -> helper::str2int(param);// 错误写法

        Helper helper = new Helper();
        Convertor<String, Integer> converter = helper::str2int;
        converter.convert("120");
    }

    // 配合静态引用
    static Integer str2int(String param) {
        return Integer.valueOf(param);
    }


    static class Helper {
        public Integer str2int(String param) {
            return Integer.valueOf(param);
        }
    }

}
