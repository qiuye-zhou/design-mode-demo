type messagetype = {
    [propName: string]: string[]
}

type listenerstype = {
    [propName: string]: Function[]
}

interface PubSubs {
    message: messagetype
    listeners: listenerstype
    publish(type: string, content: string): void
    subscribe(type: string, cb: Function): void
    notify(type: string): void
}

// 发布-订阅中心
class PubSub implements PubSubs {
    message: messagetype
    listeners: listenerstype

    constructor () {
        this.message = {}
        this.listeners = {}
    }

    // 添加发布者
    publish (type: string, content: string): void {
        const existContent = this.message[type]

        if (!existContent) {
            this.message[type] = []
        }
        this.message[type].push(content)
    }

    // 添加订阅者
    subscribe (type: string, cb: Function): void {
        const existContent = this.listeners[type]

        if (!existContent) {
            this.listeners[type] = []
        }
        this.listeners[type].push(cb)
    }

    // 通知
    notify (type: string): void {
        const message = this.message[type]
        const subscribe = this.listeners[type] || []

        subscribe.forEach((cb: Function) => {
            cb(message)
        })

        // 下面这种方法，对应的订阅者执行订阅次数为对应类型信息的次数 不是我想的那样订阅者执行一次，输出所有订阅类型的信息
        // subscribe.forEach((cb: Function) => {
        //     message.forEach((e) => {
        //         cb(e)
        //     })
        // })
    }
}

interface Publishers {
    name: string
    context: PubSub
    publish(type: string, cb: string): void
}

interface Subscribes {
    name: string
    context: PubSub
    subscribe(type: string, cb: Function): void
}

// 发布者
class Publisher implements Publishers {
    name: string
    context: PubSub

    constructor (name: string, context: PubSub) {
        this.name = name
        this.context = context
    }

    publish (type: string, cb: string) {
        this.context.publish(type, cb)
    }
}

// 订阅者
class Subscribe implements Subscribes {
    name: string
    context: PubSub

    constructor (name: string, context: PubSub) {
        this.name = name
        this.context = context
    }

    subscribe(type: string, cb: Function) {
        this.context.subscribe(type, cb)
    }
}

// 测试test
const TypeA = 'typea'
const TypeB = 'typeb'
const TypeC = 'typec'

const pubsub = new PubSub()

// 创建一个publisherA发布者
const publisherA = new Publisher('publisherA', pubsub)
publisherA.publish(TypeA, '我是publisherA 发布的 TypeA 类型的消息')
publisherA.publish(TypeB, '我是publisherA 发布的 TypeB 类型的消息')

// 创建一个publisherB发布者
const publisherB = new Publisher('publisherB', pubsub)
publisherB.publish(TypeA, '我是publisherB 发布的 TypeA 类型的消息');

// 创建一个publisherC发布者
const publisherC = new Publisher('publisherC', pubsub);
publisherC.publish(TypeC, '我是publisherC 发布的 TypeC 类型的消息')

// 创建订阅者
const subscribeA = new Subscribe('subscribeA', pubsub)
// 设置
subscribeA.subscribe(TypeA, (res: any) => {
    console.log('subscribeA订阅TypeA的信息---:',res)
})

const subscriberB = new Subscribe('subscriberB', pubsub);
subscriberB.subscribe(TypeB, (res: any) => {
  console.log('subscriberB订阅TypeB的信息---:', res)
});

const subscriberC = new Subscribe('subscriberC', pubsub);
subscriberC.subscribe(TypeC, (res: any) => {
  console.log('subscriberC订阅TypeC的信息---:', res)
});

const subscriberD = new Subscribe('subscriberD', pubsub)
subscriberD.subscribe(TypeA, (res: any) => {
    console.log('subscriberD订阅TypeA的信息---:',res)
})

//通知
pubsub.notify(TypeA);
pubsub.notify(TypeB);
pubsub.notify(TypeC);