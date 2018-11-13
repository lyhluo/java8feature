package designmode.mode5_gongchangfangfa;

/**
 * 工厂方法模式
 * 理解： 在简单工厂模式基础上的延伸，简单工厂将算法细节暴露给主程序，将算法的选择暴露给工厂
 * 一旦需要追加算法，由于工厂和算法选择的耦合，还是会改动工厂，工厂方法模式就是为了解决这个问题
 * 工厂方法模式将简单工厂模式中的工厂进一步抽象，将算法的各种选择改动为每一种算法写一个算法工厂类
 * 再讲各算法工厂类向上抽取父类工厂
 */
public class Main {
    public static void main(String[] args) {

    }
}
