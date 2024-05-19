package 行为型设计模式.Iterator;
// 迭代器模式

import java.util.*;

interface Iterator {
    public boolean hasNext();
    public Object next();
}

class BookIterator implements Iterator {
    private int index;
    private BookAggregate bookAggregate;

    public BookIterator(BookAggregate bookAggregate) {
        this.index = 0;
        this.bookAggregate = bookAggregate;
    }

    @Override
    public boolean hasNext() {
        return index < bookAggregate.getSize();
    }

    @Override
    public Object next() {
        Object obj = bookAggregate.get(index);
        index++;
        return obj;
    }
    
}

interface Aggregate {
    public Iterator CreateIterator();
}

class BookAggregate implements Aggregate {
    private List<Book> List = new ArrayList<>();

    public void add(Book book) {
        List.add(book);
    }

    public Book get(int index) {
        return List.get(index);
    }

    public int getSize() {
        return List.size();
    }

    @Override
    public Iterator CreateIterator() {
        return new BookIterator(this);
    }
    
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getname() {
        return name;
    }

    public double getprice() {
        return price;
    }
}

public class IteratorMode {
    public static void main(String[] args) {
        String[] books = {"数据结构","操作系统","计算机网络","计算机组成"};
        double[] prices = {10.1,12.1,13.5,12.8};

        BookAggregate bookAggregate = new BookAggregate();

        for (int i = 0; i < 4; i++) {
            bookAggregate.add(new Book(books[i], prices[i]));
        }
        System.out.println(bookAggregate.getSize());

        Iterator bookIterator = bookAggregate.CreateIterator();
        while (bookIterator.hasNext()) {
            Book book = (Book) bookIterator.next();
            System.out.println(book.getname() + " 价格: " + book.getprice());
        }
    }
}
