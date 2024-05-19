package 行为型设计模式.TemplateMethod;

// 模板方法模式

abstract class Person {
    public void TemplateMethod() {
        System.out.println("上课 去教室");
        PrimitiveOperation1();
        System.err.println("下课 离开教室");
        PrimitiveOperation2();
    };

    public abstract void PrimitiveOperation1(); // 原语操作1 上课过程 学生听课 老师讲课
    public abstract void PrimitiveOperation2(); // 原语操作2 作业 学生写作业 老师改作业
}

class Student extends Person {

    @Override
    public void PrimitiveOperation1() {
        System.err.println("学生听课");
    }

    @Override
    public void PrimitiveOperation2() {
        System.err.println("学生写作业");
    }

}

class Teacher extends Person {

    @Override
    public void PrimitiveOperation1() {
        System.err.println("老师讲课");
    }

    @Override
    public void PrimitiveOperation2() {
        System.err.println("老师改作业");
    }
    
}

public class TemplateMethod {
    public static void main(String[] args) {
        Person student = new Student();
        Person teacher = new Teacher();

        student.TemplateMethod();
        System.err.println("----------");
        teacher.TemplateMethod();
    }
}
