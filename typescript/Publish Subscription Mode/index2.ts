interface EventsType {
    [propsName: string]: Function[]
}

interface EventdemoType {
    emit(type: string, ...args: any[]): void
    on(type: string, listener: Function): void
    once(type: string, listener: Function): void
    off(type: string, listener: Function): void
}

class Eventdemo implements EventdemoType {
    private events: EventsType = {}

    emit (type: string, ...args: any[]) {
        const listeners = this.events[type]
        for (const listen of listeners) {
            listen(...args)
        }
    }

    on (type: string, listener: Function) {
        this.events[type] = this.events[type] || []
        this.events[type].push(listener)
    }

    off (type: string, listener: Function) {
        this.events[type] = this.events[type] || []
        this.events[type] = this.events[type].filter((callback) => {
            return callback !== listener
        })
    }

    once (type: string, listener: Function) {
        const callback = (...args: any[]) => {
            this.off(type, callback)
            listener(...args)
        }

        // 回调执行 删除监听 执行一次监听函数
        this.on(type, callback)
    }
}

const eventdemo = new Eventdemo()

const callback1 = (x: { name: string }) => {
    console.log('event1', x.name)
}
const callback2 = (x: { name: string }) => {
    console.log('event2', x.name)
}

eventdemo.on('event1', callback1)
eventdemo.on('event2', callback2)

// once
const onceback = (x: { name: string }) => {
    console.log('onceback', x.name)
}

eventdemo.once('event1', onceback)
eventdemo.once('event2', onceback)

eventdemo.emit('event1', { name: '第一次更新event1' })

eventdemo.emit('event2', { name: '第一次更新event2' })

eventdemo.emit('event1', { name: '第二次更新event1' })

eventdemo.emit('event2', { name: '第二次更新event2' })
