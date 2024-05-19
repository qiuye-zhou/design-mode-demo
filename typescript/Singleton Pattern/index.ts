class Singleton {
    private static instance: Singleton
    private name: string
    
    //private 构造函数是私有的，外部不能使用
    private constructor (name: string) {
        this.name = name
    }

    // static 会将它挂载类上，而不是实例上
    static getInstance (name: string) {
        if (!this.instance) {
            this.instance = new Singleton(name)
        }
        return this.instance
    }
}

const a = Singleton.getInstance('a')
const b = Singleton.getInstance('b')
console.log(a, b);

console.log(a === b);