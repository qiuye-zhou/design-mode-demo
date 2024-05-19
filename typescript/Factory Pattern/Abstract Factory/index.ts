//抽象产品类
//coder产品父类
abstract class Coder {
    public abstract show(): void
    public abstract work(): void
}

//hr产品父类
abstract class Hr {
    public abstract show(): void
    public abstract work(): void
}

//具体产品类
//具体Coder类
class CoderOne extends Coder {
    private static works: string[] = ['写代码one', '修bugone']
    public show():void {
        console.log('CoderOne')
    }

    public work(): void {
        console.log(CoderOne.works)
    }
}

class CoderTwo extends Coder {
    private static works: string[] = ['写代码two', '摸鱼two']
    public show():void {
        console.log('CoderTwo')
    }

    public work(): void {
        console.log(CoderTwo.works)
    }
}

//具体Hr类
class HrOne extends Hr {
    private static works: string[] = ['招聘one', '员工信息管理one']
    public show():void {
        console.log('HrOne')
    }

    public work(): void {
        console.log(HrOne.works)
    }
}

class HrTwo extends Hr {
    private static works: string[] = ['招聘two', '员工信息管理two']
    public show():void {
        console.log('HrTwo')
    }

    public work(): void {
        console.log(HrTwo.works)
    }
}

//抽象工厂类
abstract class Job {
    public abstract createCoder(): Coder | undefined
    public abstract CreateHr(): Hr | undefined
}

//具体工厂类
//Coder工厂
class OneFactory extends Job {
    public createCoder(): Coder | undefined {
        try {
            return new CoderOne()
        } catch (error) {
            console.log(error)
        }
    }
    public CreateHr(): Hr | undefined {
        try {
            return new HrOne
        } catch (error) {
            console.log(error)
        }
    }
}

class TwoFactory extends Job {
    public createCoder(): Coder | undefined {
        try {
            return new CoderTwo()
        } catch (error) {
            console.log(error)
        }
    }
    public CreateHr(): Hr | undefined {
        try {
            return new HrTwo
        } catch (error) {
            console.log(error)
        }
    }
}

//测试test
let factoryone: Job = new OneFactory()
let coderone = factoryone.createCoder()
let hrone = factoryone.CreateHr()
coderone?.work()
hrone?.work()

console.log(coderone, hrone)

let factorytwo: Job = new TwoFactory()
let codertwo = factorytwo.createCoder()
let hrtwo = factorytwo.CreateHr()
codertwo?.work()
hrtwo?.work()

console.log(codertwo, hrtwo)