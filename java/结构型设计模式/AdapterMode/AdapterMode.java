package 结构型设计模式.AdapterMode;
// 适配器模式

class Target {// 目标接口
    public void Request() {
        System.out.print("普通请求: USB数据线");
    }
}

class Adapter extends Target {
    private Adaptee adaptee = new Adaptee();
    @Override
    public void Request() {
        this.adaptee.SpecificRequest();
    }
}

class Adaptee {
    public void SpecificRequest() {
        System.out.print("特殊请求: Type-c数据线");
    }
}

public class AdapterMode {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.Request();
    }
}
