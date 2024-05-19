package 行为型设计模式.Command;
// 命令模式

class Invoker { // 请求者
    private Command command;

    public void setCommand(Command command) { // 设置请求者 的 请求命令
        this.command = command;
    }

    public void call() { // 调用
        command.Execute();
    }
}

interface Command { // 命令接口
    public void Execute(); // 执行命令
}

class OnCommand implements Command { // 开机命令
    private Tv tv;

    public OnCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void Execute() {
        tv.OnAction();
    }
}

class OffCommand implements Command { // 关机命令
    private Tv tv;

    public OffCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void Execute() {
        tv.OffAction();
    }
}

class Tv { // 接收者 Receiver
    public void OnAction() {
        System.out.println("TV开机行为");
    }

    public void OffAction() {
        System.out.println("TV关机行为");
    }
}

public class CommandMode {
    public static void main(String[] args) {
        Tv tv = new Tv(); // 接收者

        Command onCommand = new OnCommand(tv); // 命令对象
        Command offCommand = new OffCommand(tv); // 命令对象

        Invoker invoker = new Invoker(); // 请求者

        invoker.setCommand(onCommand); // 给请求者设置命令
        invoker.call(); // 请求者去请求命令

        invoker.setCommand(offCommand);
        invoker.call();
    }
}
