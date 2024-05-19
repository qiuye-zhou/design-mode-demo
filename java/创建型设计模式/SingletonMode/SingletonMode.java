package 创建型设计模式.SingletonMode;
// 单例模式

class Singleton {
    private int number = 2024;
    public void setNumber(int num) {
        this.number = num;
    }
    public int getNumber() {
        return this.number;
    }
    private static Singleton instance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return instance;
    }
}

public class SingletonMode {
    public static void main(String[] args) {
        // Singleton singleton = new Singleton(); //The constructor Singleton() is not visible

        //singleton1 singleton2 是同一个实例
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        singleton1.setNumber(10);
        System.out.println(singleton2.getNumber());
    }
}
