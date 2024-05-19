package 行为型设计模式.Observer;

import java.util.*;

// 观察者模式

interface Subject { // 目标接口
    public void Attach(Observer observer); // 添加观察者
    public void Detach(Observer observer); // 删除观察者
    public void Notify(); // 状态改变后， 通知所有的观察者

    public void setState(String state); // 设置状态
    public String getState(); // 获取状态
}

class ContcreateSubject implements Subject {
    private String state;
    private String name;
    private List<Observer> observerlist;

    public ContcreateSubject(String name) {
        this.state = "未更新";
        this.name = name;
        observerlist = new ArrayList<Observer>();
    }

    @Override
    public void Attach(Observer observer) {
        observerlist.add(observer);
    }

    @Override
    public void Detach(Observer observer) {
        observerlist.remove(observer);
    }

    @Override
    public void Notify() {
        for (Observer observer : observerlist) {
            observer.update();
        }
    }

    @Override
    public void setState(String state) {
        this.state = state;

        System.out.println(name + "的状态发生变化为: " + state);
        Notify(); // 通知观察者更新状态
    }

    @Override
    public String getState() {
        return state;
    }
    
}

interface Observer { // 观察者接口
    public void update(); // 更新观察者的状态
}

class ContcreateObserver implements Observer {
    private String name;
    private String state;

    private Subject subject;

    public ContcreateObserver(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
        subject.Attach(this);
        state = subject.getState();
    }

    @Override
    public void update() {
        System.out.println(name + "收到通知");
        state = subject.getState(); // 观察者更新状态, 让观察者状态与更新状态之后的目标状态保持一致
        System.out.println(name + "更新状后为: " + state);
    }
    
}

public class ObserverMode {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Subject subject = new ContcreateSubject("subject");
        Observer observerA = new ContcreateObserver("observerA", subject);
        Observer observerB = new ContcreateObserver("observerB", subject);
        Observer observerC = new ContcreateObserver("observerC", subject);

        subject.setState("更新");

        System.out.println("-------");

        subject.setState("结束");
    }
}
