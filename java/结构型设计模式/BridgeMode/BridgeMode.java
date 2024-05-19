package 结构型设计模式.BridgeMode;
// 桥接模式

abstract class Product {
    private String name;
    protected Color color;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void Operation();
}

class Product1 extends Product {

    @Override
    public void Operation() {
        color.OperationImp(getName());
    }
    
}

interface Color {
    public void OperationImp(String name);
}

class Red implements Color {
    @Override
    public void OperationImp(String name) {
        System.out.println(name + ": red");
    }
}

class Blue implements Color {
    @Override
    public void OperationImp(String name) {
        System.out.println(name + ": Blue");
    }
}

public class BridgeMode {
    public static void main(String[] args) {
        Product producta = new Product1();
        producta.setName("productA");
        Color red = new Red();
        producta.setColor(red);
        producta.Operation();

        Product productb = new Product1();
        productb.setName("productB");
        Color bule = new Blue();
        productb.setColor(bule);
        productb.Operation();
    }
}
