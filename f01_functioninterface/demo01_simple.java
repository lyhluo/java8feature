package lambda.f01_functioninterface;

/**
 * lambda在FunctionInterface中的应用
 */
public class demo01_simple {

    public static void main(String[] args) {

    }

    Object ex01() {
        Convertor<String, Integer> convertor = new Convertor<String , Integer>() {
            @Override
            public Integer convert(String param) {
                return Integer.valueOf(param);
            }
        };
        return convertor.convert("3000");
    }

    Object ex02() {
        Convertor<String, Integer> convertor = (param) -> Integer.valueOf(param);
        return convertor.convert("2000");
    }

    Object ex03() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello runnable");
            }
        });

        new Thread( () -> System.out.println("hello lambda!")).run();

        return null;
    }
}


