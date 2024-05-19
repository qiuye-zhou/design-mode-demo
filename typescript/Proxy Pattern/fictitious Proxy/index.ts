// 生成一张图片
class myImg {
    // 真实的img
    private imgNode = document.createElement('img')

    // 构造函数执行myImg的appendTo的方法
    constructor (where: HTMLElement) {
        this.appendTo(where)
    }

    //将真实img放入需要放的地方
    private appendTo (where: any) {
        where.appendChild(this.imgNode)
    }

    setSrc (src: string) {
        this.imgNode.src = src
    }
}

// 封装一个类，等待网络图片加载完成之前先设置一张loading菊花图，加载完成后将图片换成该显示的图片
class PreloadImg extends myImg {
    // 创建预加载图片的虚拟dom
    private img = new Image

    // 给父类传送放img的HTMLElement
    constructor (where: HTMLElement) {
        super(where)
    }

    setSrc (src: string) {
        // 给真的img设置loading图片
        super.setSrc('https://loading.jpg')
        this.img.src = src
        this.img.onload = () => {
            // 预加载完成给真的img设置预加载完成的src
            super.setSrc(src)
        }
    }
}

// 循环调用前一个类，插入图片的显示列表
class LoadImgList extends PreloadImg {
    constructor (list: string[], place: HTMLElement) {
        // 给父类传送放img的HTMLElement
        super(place)

        // 循环设置loading图片，并进行监听
        list.map((item) => {
            super.setSrc(item)
        })
    }
}

// 测试test
let place: HTMLElement = document.querySelector('div')![0]
let srcList: string[] = [
    'imglink1',
    'imglink2',
    'imglink3'
]

new LoadImgList(srcList, place)