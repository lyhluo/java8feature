package designmode.mode2_celuemoshi;

import java.math.BigDecimal;

/**
 * 策略模式
 * 思路：简单工厂是把算法暴露给客户端（main），让客户端去选择算法（+ - * / 打折等），
 * 而策略模式则是所谓的“将算法封装起来不暴露给客户端”， 实际上和简单工厂看起来很相似
 * 但策略模式可以只传递想法(算法类)， 比如我要打折，我要做加法，
 * 然后通过一个上下文类（可以看作工厂类）调用相应算法类
 */

/**
 * 以下是简单工厂与策略结合
 */
public class Main {
    public static void main(String[] args) {
        Content.instance("加法");
    }
}
class Content {

    public static BigDecimal instance(String method) {

        switch (method) {
            case "加法":
                return  new OperAdd().getResult(new BigDecimal(0), new BigDecimal(1));
            case "打折":
                return  new OperMul().getResult(new BigDecimal(0), new BigDecimal(1));
            default:
                return null;
        }
    }
}
class Oper {
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

    protected BigDecimal getResult(BigDecimal left, BigDecimal right) {
        return null;
    }
}


class OperAdd extends Oper {
    @Override
    protected BigDecimal getResult(BigDecimal left, BigDecimal right) {
        return left.add(right);
    }
}

class OperSub extends Oper {
    @Override
    protected BigDecimal getResult(BigDecimal left, BigDecimal right) {
        return left.subtract(right);
    }
}

class OperMul extends Oper {
    @Override
    protected BigDecimal getResult(BigDecimal left, BigDecimal right) {
        return left.multiply(right);
    }
}

class OperDiv extends Oper {
    @Override
    protected BigDecimal getResult(BigDecimal left, BigDecimal right) {
        return left.divide(right);
    }
}