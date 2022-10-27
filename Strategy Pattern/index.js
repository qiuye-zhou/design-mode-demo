//if代码实现
let calculation = function (num, level) {
    if (level === 'A') {
        return num * 4
    }
    if (level === 'B') {
        return num * 3
    }
    if (level === 'C') {
        return num * 2
    }
}

console.log(calculation(7000, 'A'))
console.log(calculation(6500, 'B'))
//函数内部包含过多if...else，并且后续改正的时候，需要在函数内部添加逻辑，违反了开放封闭原则

//使用策略模式
//先定义一系列算法，把它们一个个封装起来，将不变的部分和变化的部分隔开
//策略类
let Obj = {
    "A": function (num) {
        return num * 4
    },
    "B": function (num) {
        return num * 3
    },
    "C": function (num) {
        return num * 2
    }
}
//对应上下文通信类
let calculationx = function (num, level) {
    return Obj[level](num)
}
console.log(calculationx(7000, 'A'))

//表单验证例子
//策略规则
let strategys = {
    isNotEmpty: function (value, resMsg) {
        if (value === '') {
            return resMsg
        }
    },
    minLength: function (value, length, resMsg) {
        if (value.length < length) {
            return resMsg
        }
    },
    mobileFormat: function (value, resMsg) {
        if (!/(^1[3|5|8][0-9]{9}$)/.test(value)) {
            return resMsg
        }
    }
}
let Validator = function () {
    this.queue = [] //保存验证规则
}
Validator.prototype.add = function (dom, rule, resMsg) {
    let str = rule.split(':')
    this.queue.push(function () {
        let strategy = str.shift()
        str.unshift(dom.value)
        str.push(resMsg)
        return strategys[strategy].apply(dom, str)
    })
}
Validator.prototype.start = function () {
    for(let i = 0; validFun; validFun = this.queue[i++]) {
        let msg = validFun()
        if (msg) {
            return msg
        }
    }
}
//测试test
// var validateFunc = function(){
//     var validator = new Validator();
//     validator.add(Form.userName,'isNotEmpty','用户名不能为空');
//     validator.add(Form.password,'minLength:6','密码长度不能小于6位');
//     validator.add(Form.userName,'mobileFormat','手机号码格式不正确');

//     var resMsg = validator.start();
//     return resMsg;
// };
// var Form = document.getElementById("Form");
// Form.onsubmit = function(){
//     var resMsg = validateFunc();
//     if(resMsg){
//         alert(resMsg);
//         return false;
//     }
// }