package 行为型设计模式.Interpreter;

import java.util.*;

// 解释器模式

class Context {
    private String[] region = {"A部","B部","C部"};
    private String[] persions = {"开发人员","测试人员","调式人员"};

    private NonterminalExpress nonterminalExpress;

    public Context() {
        TerminalExperssion terminal1 = new TerminalExperssion(region);
        TerminalExperssion terminal2 = new TerminalExperssion(persions);
        nonterminalExpress = new NonterminalExpress(terminal1, terminal2);
    }

    public void check(String info) {
        if (nonterminalExpress.Interpreter(info)) {
            System.out.println("识别成功");
        } else {
            System.out.println("识别失败");
        }
    }
}

interface Expression {
    public boolean Interpreter(String info);
}

class NonterminalExpress implements Expression {
    private TerminalExperssion region;
    private TerminalExperssion persions;
    public NonterminalExpress(TerminalExperssion region, TerminalExperssion persions) {
        this.region = region;
        this.persions = persions;
    }

    @Override
    public boolean Interpreter(String info) {
        String[] str = info.split("的"); // 分隔的的两边
        return region.Interpreter(str[0]) && persions.Interpreter(str[1]);
    }
    
}

class TerminalExperssion implements Expression {
    private Set<String> set = new HashSet<>();

    public TerminalExperssion(String[] data) {
        for (String d : data) {
            set.add(d);
        }
    }

    @Override
    public boolean Interpreter(String info) {
        return set.contains(info);
    }
    
}

public class Interpreter {
    public static void main(String[] args) {
        Context context = new Context();

        context.check("A部的开发人员");
        context.check("C部的开发人员");

        context.check("A部的人员");
        context.check("A部人员");
    }
}
