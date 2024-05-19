//模拟抽象工厂
let AbstractFactory = function (subType, superType) {
    //判断抽象工厂中是否有该抽象类
    if (typeof AbstractFactory[superType] === 'function') {
        //缓存类
        function F () {}
        //继承父类属性和方法
        F.prototype = new AbstractFactory[superType]()
        //将子类的constructor指向父类
        subType.constructor = subType
        //子类原型继承父类
        subType.prototype = new F()
    } else {
        throw new Error('抽象类不存在')
    }
}
//AbstractFactory就是一个抽象工厂方法，该方法在参数中传递子类和父类，在方法体内部实现了子类对父类的继承