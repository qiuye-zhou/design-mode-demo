//负责计算结果
class Calc {
    //声明被保护的对象，可以在子类中访问，不能在实现对象中访问
    protected getResult (...args: number[]) {
        console.log('开始计算')
        
        return args.reduce((pur, cur) => {
            return pur * cur
        })
    }
}

//缓存接口
interface Caches {
    //声明任意key名为string类型的键名，值为number
    [propName: string]: number
}

//代理Calc类，缓存计算内容
class CacheCalc extends Calc {
    cache: Caches = {}
    constructor() {
        super()
    }

    getResult (...args: number[]) {
        let state = args.sort((a, b) => a - b)
        let key = state.join(",")

        if (key in this.cache) {//如果已经计算过则返回缓存结果
            return this.cache[key]
        } else {
            let result = super.getResult(...args) //调用父类得到计算结果
            this.cache[key] = result //缓存结果到缓存中
            return result
        }
    }
}

//测试test
let calcs: CacheCalc = new CacheCalc()

let res1: number = calcs.getResult(1,2,3,4,5)
let res2: number = calcs.getResult(1,3,4,5,2)

let res3: number = calcs.getResult(2,2,2)

console.log(res1, res2, res3)

//CacheCalc类代理了Calc类来事项缓存计算结果的功能，防止出现重复计算，这样可以再某一些计算密集型的场景下有效的节省计算资源，提高代码的性能