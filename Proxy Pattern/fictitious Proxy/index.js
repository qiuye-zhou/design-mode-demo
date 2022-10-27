//未使用代理的图片预加载功能
let MyImage = (function () {
    let imgNode = document.createElement('img')
    document.body.appendChild(imgNode)
    //创建一个Image对象，用于加载需要设置的图片
    let img = new Image
    img.onload = function () {
        imgNode.src = img.src //监听到图片加载完了，设置src为加载完成后的图片
    }
    return {
        setSrc: function (src) {
            imgNode.src = 'https://xxxxxx.jpg' //设置为默认的loading图片
            img.src = src //把真正需要设置的图片src给Image对象的src属性
        }
    }
})()

MyImage.setSrc('https://aaaa.jpg')
//MyImage对象除了负责给img节点设置src外，还要负责预加载图片，违反了面向对象设计的原则——单一职责原则
//述过程loding则是耦合进MyImage对象里的，如果以后某个时候，我们不需要预加载显示loading这个功能了，就只能在MyImage对象里面改动代码

//使用代理模式
// 图片本地对象，负责往页面中创建一个img标签，并且提供一个对外的setSrc接口
let myImage = (function () {
    let imgNode = document.createElement('img')
    document.body.appendChild(imgNode)
    return {
        setSrc: function (src) {
            imgNode.src = src
        }
    }
})()

//代理对象  ，负责图片预加载功能
let proxyImage = (function () {
    let img = new Image
    img.onload = function () {
        myImage.setSrc(this.src) // 监听到图片加载完后，给被代理的图片本地对象设置src为加载完成后的图片
    }
    return {
        setSrc: function (src) {
            myImage.setSrc('https://xxxxxx.jpg') // 设置图片时，在图片未被真正加载好时，以这张图作为loading，提示用户图片正在加载
            img.src = src
        }
    }
})()

proxyImage.setSrc('https://aaaa.jpg')