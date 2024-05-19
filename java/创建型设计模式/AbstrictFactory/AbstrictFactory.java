package 创建型设计模式.AbstrictFactory;
// 抽象工厂模式

interface ProductA {
	public void info();
};

class ProductA1 implements ProductA {
    @Override
	public void info() {
		System.out.println("Product  A1");
	}
};

class ProductA2 implements ProductA {
    @Override
	public void info() {
		System.out.println("Product  A2");
	}
};

interface ProductB {
	public void info();
};

class ProductB1 implements ProductB {
    @Override
	public void info() {
		System.out.println("Product  B1");
	}
};

class ProductB2 implements ProductB {
    @Override
	public void info() {
		System.out.println("Product  B2");
	}
};

interface Factory {
	public ProductA createProductA();
    public ProductB createProductB();
};

class Factory1 implements Factory {
	@Override
	public ProductA createProductA() {
		return new ProductA1();
	}

    @Override
    public ProductB createProductB() {
        return new ProductB1();
    }
};

class Factory2 implements Factory {
	@Override
	public ProductA createProductA() {
		return new ProductA2();
	}

    @Override
    public ProductB createProductB() {
        return new ProductB2();
    }
};

public class AbstrictFactory {
    public static void main(String[] args) {
		Factory factorya1 = new Factory1();
		ProductA Producta = factorya1.createProductA();
		Producta.info();

        Factory factorya2 = new Factory2();
		ProductA Producta2 = factorya2.createProductA();
		Producta2.info();

		Factory factoryb1 = new Factory2(); 
		ProductB Productb1 = factoryb1.createProductB();
		Productb1.info();

        Factory factoryb2 = new Factory2(); 
		ProductB Productb2 = factoryb2.createProductB();
		Productb2.info();
	}
}
