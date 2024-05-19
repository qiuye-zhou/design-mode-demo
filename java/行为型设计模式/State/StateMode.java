package 行为型设计模式.State;

// 状态模式

interface State {
    public void Handle(Context context);
}

class StateA implements State { // 有货

    @Override
    public void Handle(Context context) {
        int count = context.getCount();
        if (count >= 1) {
            System.out.println("购买成功");
            context.setCount(count - 1);

            if (context.getCount() == 0) {
                context.setState(new StateB());
            }
        }
    }
    
}

class StateB implements State { // 无货

    @Override
    public void Handle(Context context) {
        System.out.println("购买失败，无货");

        System.out.println("重新补货, 请重新购买");
        context.setCount(5);
        context.setState(new StateA());
    }
    
}

class Context { // 贩卖机
    private int count;
    private State state;

    public Context() {
        count = 3;
        state = new StateA();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void Request() { // 购买
        state.Handle(this);
    }
}

public class StateMode {
    public static void main(String[] args) {
        Context context = new Context();

        context.Request();
        context.Request();
        context.Request();
        context.Request(); // 无货，重新补货， 执行的是StateB的方法
        context.Request();
        context.Request();
    }
}
