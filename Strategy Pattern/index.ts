interface Strategy {
    show(name: string): void
}

class eatStrategy implements Strategy {
    show(name: string): void {
        console.log(`${name}去吃饭了`)
    }
}

class sleepStrategy implements Strategy {
    show(name: string): void {
        console.log(`${name}去睡觉了`)
    }
}

class studyStrategy implements Strategy {
    show(name: string): void {
        console.log(`${name}去学习了`)
    }
}

class Behavior {
    name: string
    private strategy: Strategy | null

    constructor(name: string) {
        this.name = name
        this.strategy = null
    }

    setStrategy(strategy: Strategy) {
        this.strategy = strategy
    }

    show(): void {
        return this.strategy?.show(this.name)
    }
}

//测试test
const behavior = new Behavior('小明')

behavior.setStrategy(new studyStrategy())
console.log(behavior)
behavior.show()

behavior.setStrategy(new sleepStrategy())
behavior.show()

const behaviortwo = new Behavior('小白')

behaviortwo.setStrategy(new studyStrategy())

console.log(behaviortwo)
behaviortwo.show()

behaviortwo.setStrategy(new sleepStrategy())
behaviortwo.show()

//策略模式将具体实现的策略抽到外部专门的策略对象中去实现，这样扩展起来就很方便
//策略的分发用setStrategy来抽取，减少冗余代码和不需要的判断