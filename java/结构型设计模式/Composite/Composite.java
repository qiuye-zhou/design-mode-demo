package 结构型设计模式.Composite;
// 组合模式

import java.util.*;

abstract class AbstractFile {
    protected String name;

    public void printName() {
        System.out.println(this.name);
    }

    public abstract boolean add(AbstractFile file);
    public abstract boolean remove(AbstractFile file);
    public abstract List<AbstractFile> getChildren();
}

class Folder extends AbstractFile {
    private List<AbstractFile> childList = new ArrayList<AbstractFile>();
    public Folder(String name) {
        this.name = name;
    }
    @Override
    public boolean add(AbstractFile file) {
        return childList.add(file);
    }
    @Override
    public boolean remove(AbstractFile file) {
        return childList.remove(file);
    }
    @Override
    public List<AbstractFile> getChildren() {
        return childList;
    }
}

class File extends AbstractFile {
    public File(String name) {
        this.name = name;
    }

    @Override
    public boolean add(AbstractFile file) {
        return false;
    }

    @Override
    public boolean remove(AbstractFile file) {
        return false;
    }

    @Override
    public List<AbstractFile> getChildren() {
        return null;
    }

}

public class Composite {
    public static void main(String[] args) {
        AbstractFile root = new Folder("root");
        AbstractFile folderA = new Folder("foldera");
        // folderA.printName();
        root.add(folderA);
        AbstractFile filea1 = new File("filea1");
        folderA.add(filea1);
        // System.out.println(folderA.add(filea1));

        AbstractFile fileA = new File("filea");
        // fileA.printName();
        root.add(fileA);

        printchildList(root);
    }

    static void printchildList(AbstractFile file) {
        file.printName();
        List<AbstractFile> childList = file.getChildren();
        if (childList == null) {
            return;
        }
        for (AbstractFile child : childList) {
            printchildList(child);
        }
    }
}
