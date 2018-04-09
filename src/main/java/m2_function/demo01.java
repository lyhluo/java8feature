package m2_function;

import org.junit.Test;

import java.util.Objects;
import java.util.function.*;

public class demo01 {


    /**
     * Predicate接口
     * 输入一个参数, 并返回一个Boolean值, 内置几个默认实现的逻辑判断方法
     */
    @Test
    public void predicateTest() {
        Predicate<String> predicate = (s) -> s.length() > 0;
        boolean test = predicate.test("test");
        System.out.println(test);


        Predicate<Object> objectPredicate = Objects::nonNull;
    }

    /**
     * Function 接口
     * 接受一个参数, 返回单一的结果, 默认的方法(andThen) 可将多个函数穿在一起, 形成符合Funtion(有输入, 有输出)结果
     */
    @Test
    public void functionTest() {
        // 泛型第一位为入参, 第二位为出参
        Function<String, Integer> stringIntegerFunction = Integer::valueOf;
        Integer apply = stringIntegerFunction.apply("123");
        System.out.println(apply);

        Function<Integer, Integer> integerIntegerFunction = (i) -> {
            System.out.println("input => " + i);
            return i * 2;
        };

        Function<Integer, Integer> zero = integerIntegerFunction.andThen((i) ->{
            System.out.println("second input => " + i);
            return i * 0;
        });
        System.out.println("result -- > " + zero.apply(1234));
    }

    /**
     * Supplier接口
     * 返回一个给定类型的结果, 与Function不同的是Supplier有出参无入参
     */
    @Test
    public void supplierTest() {
        Supplier<String> stringSupplier = () -> "我是str";
        System.out.println(stringSupplier.get());
    }

    /**
     * Consumer接口
     * 代表了在单一输入参数上做的操作, 和Function不同的是, 有入参无出参
     */
    @Test
    public void consumerTest() {
        Consumer<Integer> consumer = (p) -> {
            p *= 1024;
            System.out.println(p);
        };
//        consumer.andThen(null)
        consumer.accept(2);
    }
}
