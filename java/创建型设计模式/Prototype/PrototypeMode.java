package 创建型设计模式.Prototype;
// 原型模式

interface Prototype {
    public Object clone();
}

// Cloneable
class Product implements Prototype {
    private int id;
    private double price;
    public Product() {}
    public Product(int id, double price) {
        this.id = id;
        this.price = price;
    }
    public int getid() {
        return id;
    }
    public double getprice() {
        return price;
    }

    @Override
    public Object clone() {
        Product object = new Product();
        object.id = this.id;
        object.price = this.price;
        return object;
    }
}

public class PrototypeMode {
    public static void main(String[] args) {
        Product product1 = new Product(2024, 5.26);
        System.out.println(product1.getid() + " " + product1.getprice());

        Product product2 = (Product) product1.clone();
        System.out.println(product2.getid() + " " + product2.getprice());
    }
}
