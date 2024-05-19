function Factoryjs (position) {
    function User (position, work) {
        this.position = position
        this.work = work
    }

    let work
    switch (position) {
        case 'hr':
            work = ['招聘', '员工信息管理']
            return new User(position, work)
            break;

        case 'coder':
            work = ['写代码', '修bug']
            return new User(position, work)
            break;
    
        case 'boos':
            work = ['开会', '审批文件', '喝茶']
            return new User(position, work)
            break;
        default:
            break;
    }
}
let coder = new Factoryjs('coder')
let boos = new Factoryjs('boos')

console.log(coder, boos);