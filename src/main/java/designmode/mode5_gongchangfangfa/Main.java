package designmode.mode5_gongchangfangfa;

import java.math.BigDecimal;

/**
 * 工厂方法模式
 * 理解： 在简单工厂模式基础上的延伸，简单工厂将算法细节暴露给主程序，将算法的选择暴露给工厂
 * 一旦需要追加算法，由于工厂和算法选择的耦合，还是会改动工厂，工厂方法模式就是为了解决这个问题
 * 工厂方法模式将简单工厂模式中的工厂进一步抽象，将算法的各种选择改动为每一种算法写一个算法工厂类
 * 再讲各算法工厂类向上抽取父类工厂,这样保证了父工厂无论追加还是减少都无需变更！
 */
public class Main {

    public static void main(String[] args) {
        BigDecimal left = new BigDecimal("11");
        BigDecimal right = new BigDecimal("11");
        Content.getOper("加法").getResult(left, right);
    }
}

/**
 * 利用策略模式隐藏算法实现细节
 */
class Content {
    public static Oper getOper(String operDesc) {
        switch (operDesc) {
            case "加法":
                return new AddFactory().getOper("+");
            case "减法":
                return new SubFactory().getOper("-");
            default:
                return null;
        }
    }
}

/**
 * 利用工厂方法模式解除工厂和算法的耦合
 */
class BaseFactory {
    protected Oper getOper(String oper) {
        return null;
    }
}

class AddFactory extends BaseFactory {
    @Override
    protected Oper getOper(String oper) {
        if ("+".equals(oper)) {
            return new Add();
            // .... 可以追加if else条件
        } else {
            return null;
        }
    }
}


class SubFactory extends BaseFactory {
    @Override
    protected Oper getOper(String oper) {
        if ("-".equals(oper)) {
            return new Sub();
            // .... 可以追加if else条件
        } else {
            return null;
        }
    }
}

class Oper {

    protected BigDecimal getResult (BigDecimal left, BigDecimal right) {
        return null;
    }

    private BigDecimal left;
    private BigDecimal right;

    public BigDecimal getLeft() {
        return left;
    }

    public void setLeft(BigDecimal left) {
        this.left = left;
    }

    public BigDecimal getRight() {
        return right;
    }

    public void setRight(BigDecimal right) {
        this.right = right;
    }
}

class Sub extends Oper{
    @Override
    protected BigDecimal getResult(BigDecimal left, BigDecimal right) {
        BigDecimal result = left.subtract(right);
        System.out.println("计算结果" + result);
        return result;
    }
}

class Add extends Oper{
    @Override
    protected BigDecimal getResult(BigDecimal left, BigDecimal right) {
        BigDecimal result = left.add(right);
        System.out.println("计算结果" + result);
        return result;
    }
}