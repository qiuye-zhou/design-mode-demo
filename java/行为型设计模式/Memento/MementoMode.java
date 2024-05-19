package 行为型设计模式.Memento;
// 备忘录模式

import java.util.*;

class Originator { // 原发器
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void setMemento(Memento memento) {
        state = memento.getState();
    }
}

class Memento { // 备忘录
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Caretaker { // 管理者
    private List<Memento> mementoList = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementoList.add(memento);
    }

    public Memento getMemento(int index) {
        return mementoList.get(index - 1);
    }

    public void showMemento() {
        int cnt = 1;
        for (Memento m : mementoList) {
            System.out.println("第" + cnt + "次备份, 状态为：" + m.getState());
        }
    }
}

public class MementoMode {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
    
        originator.setState("state1");
        Memento backup1 = originator.createMemento();
        caretaker.addMemento(backup1);

        System.out.println(originator.getState());

        originator.setState("state2");
        Memento backup2 = originator.createMemento();
        caretaker.addMemento(backup2);

        System.out.println(originator.getState());

        originator.setMemento(backup1);
        System.out.println("根据第1次备份还原后的状态为：" + originator.getState());

        caretaker.showMemento();
    }
}
