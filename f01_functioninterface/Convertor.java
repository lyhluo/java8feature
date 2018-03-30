package lambda.f01_functioninterface;

/**
 * 该注解是jdk1.8开始的, 使用在只有一个抽象方法的接口里
 * @param <F>
 * @param <T>
 */
@FunctionalInterface
interface Convertor<F, T> {
    T convert(F param);

}
