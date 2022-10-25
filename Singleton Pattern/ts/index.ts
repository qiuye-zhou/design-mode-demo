class Singleton {
    private static instance: Singleton

    //private 构造函数是私有的，外部不能使用
    private constructor () {}

    // static 会将它挂载类上，而不是实例上
    static getInstance () {
        if (!this.instance) {
            this.instance = new Singleton()
        }
        return this.instance
    }
}

const a = Singleton.getInstance()
const b = Singleton.getInstance()
console.log(a,b);

console.log(a === b);