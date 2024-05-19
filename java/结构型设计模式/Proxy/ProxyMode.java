package 结构型设计模式.Proxy;
// 代理模式

interface Subject {
    public void buy();
}

class Proxy implements Subject {
    protected RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void buy() {
        System.out.println("Proxy L 付钱前操作");
        realSubject.buy();
        System.out.println("Proxy R 付钱后操作");
    }
    
}

class RealSubject implements Subject {

    @Override
    public void buy() {
        System.out.println("RealSubject： 付钱");
    }
    
}

public class ProxyMode {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Proxy proxy = new Proxy(realSubject);

        proxy.buy();
    }
}
