package easydemo;

public class demo01 {
    public static void main(String[] args) {
        Cloth cloth = new Cloth();
        System.out.println("初始化衣服" + cloth);
        System.out.println("初始化衣服" + cloth.hashCode());
        final Choudan choudan = new Choudan();
        System.out.println("初始化臭蛋" + choudan);
        System.out.println("初始化臭蛋" + choudan.hashCode());
        choudan.setCloth(cloth);
        System.out.println("set了Cloth的臭蛋" + choudan);
        System.out.println("set了Cloth的臭蛋" + choudan.hashCode());
        cloth.setColor("red");
        System.out.println("set了color的Cloth" + cloth);
        System.out.println("set了color的Cloth" + cloth.hashCode());
        System.out.println("set了Cloth的Cloth的臭蛋" + choudan);
        System.out.println("set了Cloth的Cloth的臭蛋" + choudan.hashCode());

        String string = "我是开始";
        System.out.println(string.hashCode());
        string = "我被改变";
        System.out.println(string.hashCode());
    }
}



class Choudan {
    private Cloth cloth;

    public Cloth getCloth() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }
}

class Cloth {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}