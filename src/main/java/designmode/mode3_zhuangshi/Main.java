package designmode.mode3_zhuangshi;

import java.util.ArrayList;
import java.util.List;

/**
 * 装饰模式: 动态地给对象添加额外的职能，比子类更灵活
 * 以人穿衣服为例 ps: 穿衣还要有顺序， 由内而外
 */
public class Main {
    public static void main(String[] args) {
        Cloth cloth = new Cloth(new Person("JackLi"));
        Tshirt jackLiTshirt = new Tshirt(cloth);
        jackLiTshirt.show();// NullPointException ??
        Skirt skirt = new Skirt(jackLiTshirt);
        System.out.println(skirt);
        skirt.show();
    }
}

/**
 * 衣服的子类： T恤
 * 这也是动态功能
 */
class Tshirt extends Cloth {
    private Cloth cloth;

    public Cloth getCloth() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }

    public Tshirt(Cloth cloth){
        this.cloth = cloth;
        cloth.getClothes().add("Tshirt");
    }

}

class Skirt extends Cloth {
    private Cloth cloth;

    public Cloth getCloth() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }

    public Skirt(Cloth cloth){
        this.cloth = cloth;
        cloth.getClothes().add("Skirt");
    }
}

/**
 * 人的一个装饰类：衣服
 * 这也是动态功能
 *
 */
class Cloth extends Person{

    public Cloth(){}

    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    // todo
    public Cloth(Person person) {
        this.person = person;
    }

    protected List<String> clothes = new ArrayList<>();

    public List<String> getClothes() {
        return clothes;
    }

    public void setClothes(List<String> clothes) {
        this.clothes = clothes;
    }

    // 衣服的展示
    public void show() {
        System.out.println("我是" + super.getName());//todo  着重看这里 为什么这里的person是null？？ 这里的name也是null
        System.out.println( ", 我穿了：" + this.getClothes());
        System.out.println( ", 我穿了：" + this.getClothes());
    }

}

class Person {

    public Person (){}

    public Person(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}