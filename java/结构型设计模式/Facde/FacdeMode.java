package 结构型设计模式.Facde;
// 外观模式

class Facde {
    SubSystem1 subsystem1;
    SubSystem2 subsystem2;
    SubSystem3 subsystem3;

    public Facde() {
        subsystem1 = new SubSystem1();
        subsystem2 = new SubSystem2();
        subsystem3 = new SubSystem3();
    }

    public void methodA() {
        subsystem1.method1();
    }
    public void methodB() {
        subsystem2.method2();
    }
    public void methodC() {
        subsystem3.method3();
    }
}

class SubSystem1 {
    public void method1() {
        System.out.println("执行子系统1的功能");
    }
}

class SubSystem2 {
    public void method2() {
        System.out.println("执行子系统2的功能");
    }
}

class SubSystem3 {
    public void method3() {
        System.out.println("执行子系统3的功能");
    }
}

public class FacdeMode {
    public static void main(String[] args) {
        Facde facde = new Facde();
        facde.methodA();
        facde.methodB();
        facde.methodC();
    }
}
