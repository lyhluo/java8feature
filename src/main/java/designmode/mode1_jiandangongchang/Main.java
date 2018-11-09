package designmode.mode1_jiandangongchang;

import java.math.BigDecimal;

/**
 * 简单工厂模式
 * 以两位数计算器为例
 *
 * 思路1：各种计算方式，能抽取的东西，抽取出来，作为父类
 * 思路2：为了不让客户端主流程代码与算法类过于耦合，特将创建算法类的方法放到工厂类进行生产
 */
public class Main {
    private static BigDecimal left = new BigDecimal(7);
    private static BigDecimal right = new BigDecimal(17);
    public static void main(String[] args) {
        // 输入两个数
        // 思路2：为了不让客户端主流程代码与算法类过于耦合，特将创建算法类的方法放到工厂类进行生产
        System.out.println(OperFactory.getOper('+').getResult(left, right));
    }
}

class OperFactory {
    public static Oper getOper(char method) {
        switch (method) { // 这里只能放 byte, char, short, int
            case '+':
                return new OperAdd();
            case '-':
                return new OperSub();
            case '*':
                return new OperMul();
            case '/':
                return new OperDiv();
            default :
                return null;
        }

    }
}

/**
 * 思路1： 各种计算方式，能抽取的东西，抽取出来，作为父类
 */
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


class OperAdd extends Oper{
    @Override
    protected BigDecimal getResult(BigDecimal left, BigDecimal right) {
        return left.add(right);
    }
}

class OperSub extends Oper{
    @Override
    protected BigDecimal getResult(BigDecimal left, BigDecimal right) {
        return left.subtract(right);
    }
}

class OperMul extends Oper{
    @Override
    protected BigDecimal getResult(BigDecimal left, BigDecimal right) {
        return left.multiply(right);
    }
}

class OperDiv extends Oper{
    @Override
    protected BigDecimal getResult(BigDecimal left, BigDecimal right) {
        return left.divide(right);
    }
}

