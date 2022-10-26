//抽象产品类
import { Factory } from './../Simple Factory/index';
abstract class user {
    public abstract show(): void
    public abstract work(): void
}

//具体产品类
class UserCoder extends user {
    private static works: string[] = ['写代码', '修bug']

    public show(): void {
        console.log('coder');
    }

    public work(): void {
        console.log(UserCoder.works)
    }
}

class UserHr extends user {
    private static works: string[] = ['招聘', '员工信息管理']
    
    public show(): void {
        console.log('hr');
    }

    public work(): void {
        console.log(UserHr.works)
    }
}

class UserBoos extends user {
    private static works: string[] = ['开会', '审批文件', '喝茶']
    
    public show(): void {
        console.log('boos');
    }

    public work(): void {
        console.log(UserBoos.works)
    }
}

//抽象工厂类
abstract class UserFactory {
    public abstract createUser(): user | undefined
}

//具体工厂类
class CoderFactory extends UserFactory {
    public createUser (): user | undefined {
        try {
            return new UserCoder()
        } catch (error) {
            console.log(error)
        }
    }
}

class HrFactory extends UserFactory {
    public createUser (): user | undefined {
        try {
            return new UserHr()
        } catch (error) {
            console.log(error)
        }
    }
}

class BoosFactory extends UserFactory {
    public createUser (): user | undefined {
        try {
            return new UserBoos()
        } catch (error) {
            console.log(error)
        }
    }
}

//测试test
let coderfactory: CoderFactory = new CoderFactory()
let coder = coderfactory.createUser()
coder?.show()
coder?.work()

let hrfactory: HrFactory = new HrFactory()
let hr = hrfactory.createUser()
hr?.show()
hr?.work()