package 创建型设计模式.Build;
// 生成器模式

import java.util.*;

class Director {
    public void Construct(Builder builder) {
        builder.Buildpart();
    }
}

abstract class Builder {
    public abstract void Buildpart();
    public abstract Product getProduct();
}

class Builder1 extends Builder {
    Product product = new Product();

    @Override
    public void Buildpart() {
        product.add("A1 ");
        product.add("B1 ");
    }

    @Override
    public Product getProduct(){
        return product;
    }
}

class Builder2 extends Builder {
    Product product = new Product();

    @Override
    public void Buildpart() {
        product.add("A2 ");
        product.add("B2 ");
    }

    @Override
    public Product getProduct(){
        return product;
    }
}

class Product {
    List<String> parts = new ArrayList<String>();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.print("productlist: ");
        for (String p : parts) {
            System.out.print(p + "");
        }
        System.out.print("\n");
    }
}

public class BuilderMode {
    public static void main(String[] args) {
        Director director = new Director();

        Builder builder1 = new Builder1();
        director.Construct(builder1);
        Product product1 = builder1.getProduct();
        product1.show();

        Builder builder2 = new Builder2();
        director.Construct(builder2);
        Product product2 = builder2.getProduct();
        product2.show();
    }
}