package lambda.f02_reference;

/**
 * lambda的域
 *
 * 域即作用域, Lambda表达式中的参数列表中的参数在该lambda的表达式范围(域)内有效.
 * 在Lambda表达式域内, 可以访问外部的变量: 局部变量, 类变量和静态变量, 但操作受限程度不同
 */
public class demo01 {

    public static void main(String[] args) {


        // 1 lambda表达式访问局部变量
        int n = 3;

        Calculate simple = (param) -> (n + param);

        Calculate calculate = (param) -> {
//            n +=3; 在lambda表达式外部的局部变量会被jvm隐式的编译成final, 因而只能访问, 不能修改
            System.out.println(n);
            return n + param;
        };

        System.out.println(simple.calculate(1));
        System.out.println(calculate.calculate(1));
    }

    // 2 类变量在lambda表达式中可读写
    private static int NUM_3 = 3;
    private void staticParam() {
        Calculate calculate = param -> {
            NUM_3 += 1;
            return NUM_3 + param;
        };
        System.out.println(calculate.calculate(1));
    }

    // 3 普通成员变量在lambda表达式中可读写

    private int num_4 = 4;
    private void bodyParam() {
        Calculate calculate = param -> {
            num_4 += 1;
            return num_4 + param;
        };
        System.out.println(calculate.calculate(1));
    }


}

@FunctionalInterface
interface Calculate {
    int calculate(int param);
}