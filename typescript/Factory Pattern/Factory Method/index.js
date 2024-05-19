//工厂方法
function Factoryjs (position) {
    if (this instanceof Factoryjs) {
        var a = new this[position]()
        return a
    } else {
        return new Factoryjs(position)
    }
}

//工厂方法函数的原型中设置所有对象的构造函数
Factoryjs.prototype = {
    'coder': function () {
        this.positionName = 'coder'
        this.work = ['写代码', '修bug']
    },
    'hr': function () {
        this.positionName = 'hr'
        this.work = ['招聘', '员工信息管理']
    },
    'boos': function () {
        this.positionName = 'boos'
        this.work = ['开会', '审批文件', '喝茶']
    },
}

let coder = new Factoryjs('coder')
console.log(coder);

let hr = new Factoryjs('hr')
console.log(hr)