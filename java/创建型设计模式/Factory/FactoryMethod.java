package 创建型设计模式.Factory;
// 工厂模式

interface Product {
	public void info();
};

class ProductA implements Product {
    @Override
	public void info() {
		System.out.println("Product  A");
	}
};

class ProductB implements Product {
    @Override
	public void info() {
		System.out.println("Product  B");
	}
};

interface Factory {
	public Product createProduct();
};

class FactoryA implements Factory {
	@Override
	public Product createProduct() {
		return new ProductA();
	}
};

class FactoryB implements Factory {
	@Override
	public Product createProduct() {
		return new ProductB();
	}
};

public class FactoryMethod {
	public static void main(String[] args) {
		Factory factorya = new FactoryA();
		Product Producta = factorya.createProduct();
		Producta.info();

		Factory factoryb = new FactoryB(); 
		Product Productb = factoryb.createProduct();
		Productb.info();
	}
};