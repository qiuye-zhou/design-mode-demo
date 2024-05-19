//abstract 声明一个抽象类，抽象类中的方法也必须是抽象方法，要用abstract声明，
//且抽象类不能被直接实例化，只能被子类继承，并且需要重新实现抽象类中的抽象方法
abstract class user  {
    public abstract show(): void
    public abstract work(): void
}

class UserCoder extends user {
    private static works: string[] = ['写代码', '修bug']

    public show(): void {
        console.log('coder');
    }

    public work(): void {
        console.log(UserCoder.works);
    }
}

class UserHr extends user {
    private static works: string[] = ['招聘', '员工信息管理']

    public show(): void {
        console.log('hr');
    }

    public work(): void {
        console.log(UserHr.works);
    }
}

class UserBoos extends user {
    private static works: string[] = ['开会', '审批文件', '喝茶']

    public show(): void {
        console.log('boos');
    }

    public work(): void {
        console.log(UserBoos.works);
    }
}

export class Factory {
    public static createUser(type: new () => user): user {
        let user: any

        try {
            user = new type()
        } catch (error) {
            console.log(error)
        }

        return user
    }
}

const coder = Factory.createUser(UserCoder)
const hr = Factory.createUser(UserHr)
const boos = Factory.createUser(UserBoos)

console.log(coder, hr, boos);

coder.show()
coder.work()

hr.show()
hr.work()

boos.show()
boos.work()