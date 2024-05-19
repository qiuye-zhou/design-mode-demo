package 创建型设计模式.SimpleFactory;
// 简单工厂模式

abstract class Product {
	public abstract void info();
};

class ProductA extends Product {
    @Override
	public void info() {
		System.out.println("Product  A");
	}
};

class ProductB extends Product {
    @Override
	public void info() {
		System.out.println("Product  B");
	}
};

class Factory {
	public static Product createProduct(String type) {
		Product product = null;
		switch (type) {
			case "A":
			product = new ProductA();
				break;
			case "B":
			product = new ProductB();
				break;
			default:
			System.out.println("不存在该产品");
				break;
		}
		return product;
	}
};

public class SimpleFactory {
	public static void main(String[] args) {
		Product Producta = Factory.createProduct("A");
		Producta.info();

		Product Productb = Factory.createProduct("B");
		Productb.info();
	}
}