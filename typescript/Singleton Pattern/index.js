function Singletonjs (name) {
    this.name = name
    this.instance = null
}

Singletonjs.prototype.getName = function () {
    console.log(this.name);
}

Singletonjs.getInstance = function (name) {
    if (!this.instance) {
        this.instance = new Singletonjs(name)
    }
    return this.instance
}

const aa = Singletonjs.getInstance('a')
const bb = Singletonjs.getInstance('b')
console.log(aa, bb)

console.log(aa === bb)

//闭包实现
//单例构造函数
function CreateSingletonclo (name) {
    this.name = name
    this.getName()
}

//获取实例的name
CreateSingletonclo.prototype.getName = function () {
    console.log(this.name)
}

//单例对象
const Singletonclo = (function () {
    var instance
    return function (name) {
        if (!instance) {
            instance = new CreateSingletonclo(name)
        }

        return instance
    }
}) ()

const aclo = new Singletonclo('aclo')
const bclo = new Singletonclo('bclo')

console.log(aclo, bclo)
console.log(aclo === bclo)