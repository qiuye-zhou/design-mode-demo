package 行为型设计模式.Visitor;

import java.util.*;

// 访问者模式

interface Visitor {
    public void VisitStudent(Student student);
    public void VisitTeacher(Teacher teacher);
}

class Visit1 implements Visitor { // 访问者1
    private int stuageSun = 0;
    private int teaageSum = 0;

    public int getstuageSun() {
        return stuageSun;
    }

    public int getteaageSum() {
        return teaageSum;
    }

    @Override
    public void VisitStudent(Student student) {
        System.err.println("访问者1访问学生" + student.getname() + "Age: " + student.getage());
        stuageSun += student.getage();
    }

    @Override
    public void VisitTeacher(Teacher teacher) {
        System.err.println("访问者1访问老师" + teacher.getname() + "Age: " + teacher.getage());
        teaageSum += teacher.getage();
    }
    
}

class Visit2 implements Visitor { // 访问者2
    private int maxScore = -1;
    private int maxWorkYear = -1;

    public int getmaxScore() {
        return maxScore;
    }

    public int getmaxWorkYear() {
        return maxWorkYear;
    }

    @Override
    public void VisitStudent(Student student) {
        System.err.println("访问者2访问学生" + student.getname() + "Score: " + student.getscore());
        maxScore = Math.max(student.getscore(), maxScore);
    }

    @Override
    public void VisitTeacher(Teacher teacher) {
        System.err.println("访问者2访问老师" + teacher.getname() + "WorkYear: " + teacher.getworkYear());
        maxWorkYear = Math.max(teacher.getworkYear(), maxWorkYear);
    }
    
}

class PersonStructure {
    private List<Person> PersonList = new ArrayList<Person>();

    public PersonStructure() {
        PersonList.add(new Student("stuA", 20, 150));
        PersonList.add(new Student("stuB", 19, 110));
        PersonList.add(new Student("stuC", 21, 120));

        PersonList.add(new Teacher("teaA", 30, 10));
        PersonList.add(new Teacher("teaB", 40, 20));
    }

    public void Accept(Visitor visitor) {
        for (Person person : PersonList) {
            person.Accept(visitor);
        }
    }
}

abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getname() {
        return name;
    }

    public int getage() {
        return age;
    }

    public abstract void Accept(Visitor visitor);
}

class Student extends Person {
    private int score;
    public Student(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }

    public int getscore() {
        return score;
    }

    @Override
    public void Accept(Visitor visitor) {
        visitor.VisitStudent(this);
    }

}

class Teacher extends Person {
    private int workYear;
    public Teacher(String name, int age, int workYear) {
        super(name, age);
        this.workYear = workYear;
    }

    public int getworkYear() {
        return workYear;
    }

    @Override
    public void Accept(Visitor visitor) {
        visitor.VisitTeacher(this);
    }

}

public class VisitorMode {
    public static void main(String[] args) {
        PersonStructure structure = new PersonStructure();

        Visit1 visitor1 = new Visit1();
        structure.Accept(visitor1);
        System.out.println("学生ageSum: " + visitor1.getstuageSun()+ "老师ageSum: " + visitor1.getteaageSum());

        System.out.println("----");

        Visit2 visitor2 = new Visit2();
        structure.Accept(visitor2);
        System.out.println("学生maxScore: " + visitor2.getmaxScore()+ "老师maxWorkYear: " + visitor2.getmaxWorkYear());
    }
}
