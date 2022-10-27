// 被观察者模式
class Subject {
    private observerList: Observer[];

    constructor () {
        this.observerList = []
    }

    // 增加观察者到被观察者队列
    addObserver (observer: Observer) {
        this.observerList.push(observer)
    }

    // 从被观察者队列中删除需要删除的观察者
    removeObserver (observer: Observer) {
        const index = this.observerList.findIndex(ob => ob.name === observer.name)
        this.observerList.splice(index, 1)
    }

    // 触发更新，所有的被观察者都进行对应的更新
    notifyObserver (message: string) {
        const observers = this.observerList
        observers.forEach(ob => {
            ob.notified(message)
        })
    }
}

// 观察者
class Observer {
    public name: string;

    constructor (name: string, subject?: Subject) {
        this.name = name
        if (subject) {
            subject.addObserver(this)
        }
    }

    // 更新执行的方法
    notified (message: string) {
        console.log(`${this.name}--message: ${message}`)
    }
}

// 测试test
const subject = new Subject()
// 观察者主动申请加入被观察者的列表
const observerA = new Observer('observerA', subject)
const observerB = new Observer('observerB')

// 被观察者主动将观察者加入列表
subject.addObserver(observerB)

subject.notifyObserver('第一次发生变化')

// 删除一个观察者
subject.removeObserver(observerB)
subject.notifyObserver('删除observerB后进行第二次变化')

subject.addObserver(observerB)
subject.notifyObserver('最后又重新观察observerB后进行变化')