package 行为型设计模式.Strategy;

// 策略模式

interface Strategy {
    public void TwoNumberOperation(int a, int b);
}

class AddStrategy implements Strategy {

    @Override
    public void TwoNumberOperation(int a, int b) {
        System.out.println(a + b);
    }
    
}

class SubtractionStrategy implements Strategy {

    @Override
    public void TwoNumberOperation(int a, int b) {
        System.out.println(a - b);
    }
    
}

class MultiplyStrategy implements Strategy {

    @Override
    public void TwoNumberOperation(int a, int b) {
        System.out.println(a * b);
    }
    
}

class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void Operation(int a, int b) {
        strategy.TwoNumberOperation(a, b);
    }
}

public class StrategyMode {
    public static void main(String[] args) {
        Strategy strategyadd = new AddStrategy();
        Strategy strategysub = new SubtractionStrategy();
        Strategy strategymul = new MultiplyStrategy();

        Context context = new Context(strategyadd);

        context.Operation(10, 2);

        context = new Context(strategysub);
        context.Operation(10, 2);

        context = new Context(strategymul);
        context.Operation(10, 2);
    }
}
