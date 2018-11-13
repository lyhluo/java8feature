package designmode.mode4_dailimoshi;

/**
 * 代理模式
 *
 * 举例： 小华追求小红，但是小红不认识小华，所以小华让小红的朋友小明帮自己送礼物
 */
public class Main {
    public static void main(String[] args) {
        Xiaohong xiaohong = new Xiaohong();
        Xiaoming xiaoming = new Xiaoming();
        xiaoming.giveGifts(xiaohong.getName());
    }
}

/**
 * 送礼物的动作可以抽象出来
 */
abstract class Act {
    public abstract void giveGifts(String name);
}

class Xiaohong{
   private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Xiaohua extends Act {
    public void giveGifts(String name) {
        System.out.println("给" + name + "送礼物");
    }
}

/**
 * 小明继承Act的原因是小明也要有送礼物的动作（代理）
 * 但小明送礼物的动作（即giveGifts方法）需要重写为调用小华送礼物的动作（即真实的动作）
 */
class Xiaoming extends Act {
    public void giveGifts(String name) {
        Xiaohua xiaohua = new Xiaohua();
        xiaohua.giveGifts(name);
    }
}