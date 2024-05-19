package 结构型设计模式.Flyweight;
// 享元模式

import java.util.*;

class ShapeFactory {
    private Map<String, Shape> map = new HashMap<String, Shape>();

    public Shape getShape(String key) {
        if (!map.containsKey(key)) {
            System.out.println("创建了一个: "+ key + "的Circle");
            Shape shape = new Circle(key);
            map.put(key, shape);
        }
        return map.get(key);
    }
}

abstract class Shape {
    protected String color;

    public abstract void draw(int x, int y);
}

class Circle extends Shape {
    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("draw a color: " + color + " circle x: " + x + " y: " + y);
    }
    
}

public class FlyweightMode {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Random random = new Random();
        String[] colors = {"red", "bule", "green"};
        for (int i = 1; i <= 10; i++) {// 相同的只创建一次, 然后保存在工厂里面， 复用已经创建过的
            int x = random.nextInt(colors.length);
            Shape shape = factory.getShape(colors[x]);

            System.out.println("第" + i + "个Circle");
            shape.draw(random.nextInt(200), random.nextInt(100));
        }
    }
}



// class PieceFactory {
//     private Piece[] pieces = {new WhitePice(), new BlackPiece()};

//     public Piece getPiece(int key) {
//         if (key == 0) {
//             return pieces[0];
//         } else if (key == 1) {
//             return pieces[1];
//         } else {
//             return null;
//         }
//     }
// }

// abstract class Piece {
//     protected String color;

//     public abstract void draw(int x, int y);
// }

// class WhitePice extends Piece {
//     public WhitePice() {
//         this.color = "White";
//     }

//     @Override
//     public void draw(int x, int y) {
//         System.out.println("draw a color: " + color + " piece x: " + x + "y: " + y);
//     }
// }

// class BlackPiece extends Piece {
//     public BlackPiece() {
//         this.color = "Black";
//     }

//     @Override
//     public void draw(int x, int y) {
//         System.out.println("draw a color: " + color + " piece x: " + x + "y: " + y);
//     }
// }

// public class FlyweightMode {
//     public static void main(String[] args) {
//         PieceFactory piecefactory = new PieceFactory();
//         Piece whitepice1 = piecefactory.getPiece(0);
//         Piece whitepice2 = piecefactory.getPiece(0);
//         Piece whitepice3 = piecefactory.getPiece(0);
//         System.out.println(whitepice1);
//         System.out.println(whitepice2);
//         System.out.println(whitepice3);// 都是同一个对象
//     }
// }
