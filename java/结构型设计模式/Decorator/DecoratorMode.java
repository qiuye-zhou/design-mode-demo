package 结构型设计模式.Decorator;
// 装饰器模式

abstract class Person {
    protected String name;
    public abstract void Operation();
}

class Student extends Person {
    public Student(String name) {
        this.name = name;
    }
    @Override
    public void Operation() {
        System.out.print(name + "的职责: 学习");
    }
}

abstract class Decorator extends Person {
    protected Person person;
}

class ConcreateDecoratorA extends Decorator {
    public ConcreateDecoratorA(Person person) {
        this.person = person;
    }

    @Override
    public void Operation() {// 职责
        person.Operation();// 执行原有的职责
        System.out.print(" 写作业");//添加的额外的职责
    }
}

class ConcreateDecoratorB extends Decorator {
    public ConcreateDecoratorB(Person person) {
        this.person = person;
    }

    @Override
    public void Operation() {// 职责
        person.Operation();// 执行原有的职责
        System.out.print(" 考试");//添加的额外的职责
    }
}

public class DecoratorMode {
    public static void main(String[] args) {
        Person student1 = new Student("aa1");
        student1.Operation();
        System.out.println("\n----");

        student1 = new ConcreateDecoratorA(student1);
        student1.Operation();

        System.out.println("\n----");

        student1 = new ConcreateDecoratorB(student1);

        student1.Operation();

        System.out.println("\n----");

        Person student2 = new ConcreateDecoratorA(new ConcreateDecoratorB(new Student("student2")));
        student2.Operation();
    }
}
