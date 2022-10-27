let calc = function () {
    console.log('开始计算')
    let a = 1
    for (let i = 0; i < arguments.length; i++) {
        a *= arguments[i]
    }
    return a
}

let proxyCalc = (function () {
    var cache = {}
    return function () {
        // console.log(arguments)
        let args = Array.prototype.join.call(arguments, ",")
        if (args in cache) {
            return cache[args]
        }
        return (cache[args] = calc.apply(this, arguments))
    }
})()

//使用三次，只计算了两次，相同的计算第二次会返回缓存的结果,不会再去执行calc
console.log(
    proxyCalc(1,2,3,4,5),
    proxyCalc(2,3,4,5,6),
    proxyCalc(1,2,3,4,5),
    )
