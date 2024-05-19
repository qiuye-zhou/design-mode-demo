package 行为型设计模式.ChainOfResponsibility;
// 责任链模式

abstract class Handler {
    protected Handler next;

    public void setNext(Handler handler) {
        this.next = handler;
    }

    public abstract void HandlerRequest(int request);
}

class FuDaoYuan extends Handler {
    @Override
    public void HandlerRequest(int request) {
        if (request <= 7) {
            System.out.println("辅导员审批通过");
        } else {
            if (next != null) {
                next.HandlerRequest(request);
            } else {
                System.out.println("无法审批");
            }
        }
    }
}

class YuanZhang extends Handler {
    @Override
    public void HandlerRequest(int request) {
        if (request <= 15) {
            System.out.println("院长审批通过");
        } else {
            if (next != null) {
                next.HandlerRequest(request);
            } else {
                System.out.println("无法审批");
            }
        }
    }
}

class XiaoZhang extends Handler {
    @Override
    public void HandlerRequest(int request) {
        if (request <= 30) {
            System.out.println("校长审批通过");
        } else {
            if (next != null) {
                next.HandlerRequest(request);
            } else {
                System.out.println("无法审批");
            }
        }
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Handler fHandler = new FuDaoYuan();
        Handler yHandler = new YuanZhang();
        Handler xHandler = new XiaoZhang();

        fHandler.setNext(yHandler);
        yHandler.setNext(xHandler);

        fHandler.HandlerRequest(3);
        fHandler.HandlerRequest(8);
        fHandler.HandlerRequest(20);
        fHandler.HandlerRequest(200);
    }
}
