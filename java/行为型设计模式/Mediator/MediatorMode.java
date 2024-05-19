package 行为型设计模式.Mediator;
// 中介者模式

// import java.util.*;

abstract class Colleague {
    protected Mediator mediator;

}

class Colleague1 extends Colleague {
    public Colleague1(Mediator mediator) {
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    public void Notify(String message) {
        System.out.println("1收到消息: " + message);
    }

}
class Colleague2 extends Colleague {
    public Colleague2(Mediator mediator) {
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    public void Notify(String message) {
        System.out.println("2收到消息: " + message);
    }
}

abstract class Mediator {
    public abstract void sendMessage(String message, Colleague colleague);

}

class ConcreateMediator extends Mediator {
    // List<Colleague> list = new ArrayList<>();

    // public void add(Colleague colleague) {
    //     list.add(colleague);
    // }

    private Colleague1 colleague1;
    private Colleague2 colleague2;

    public void setcolleague1(Colleague1 colleague1) {
        this.colleague1 = colleague1;
    }
    public void setcolleague2(Colleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    @Override
    public void sendMessage(String message, Colleague colleague) {
        if (colleague == colleague1) { // 让2收到消息
            colleague2.Notify(message);
        } else { // 让1收到消息
            colleague1.Notify(message);
        }
    }
}

public class MediatorMode {
    public static void main(String[] args) {
        ConcreateMediator mediator = new ConcreateMediator();

        Colleague1 colleague1 = new Colleague1(mediator);
        Colleague2 colleague2 = new Colleague2(mediator);

        mediator.setcolleague1(colleague1);
        mediator.setcolleague2(colleague2);

        colleague1.sendMessage("1发送消息给2的消息");

        colleague2.sendMessage("2发送消息给1的消息");
    }
}
