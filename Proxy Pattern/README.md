### 代理模式Proxy Pattern(结构型模式)
控制客户端对对象的访问

代理模式就是设置一个中间代理来控制访问原目标对象，以达到增强原对象的功能和简化访问方式

代理模式的关键是，当客户不方便直接访问一个对象或者不满足需要时，提供一个替身对象来控制这个对象的访问，客户实际上访问的是替身对象

在ES6中，存在proxy构建函数能够让我们轻松使用代理模式：

```js
const proxy = new Proxy(target, handler);
```

##### 缓存代理
缓存代理可以为一些开销大的运算结果提供暂时的存储，在下次运算时，如果传递进来的参数跟之前一致，则可以直接返回前面存储的运算结果

##### 虚拟代理
虚拟代理把一些开销很大的对象，延迟到真正需要它的时候才去创建

常见的就是图片预加载功能

##### 使用场景
很多前端框架或者状态管理框架都使用代理模式，用与监听变量的变化

使用代理模式代理对象的访问的方式，一般又被称为拦截器，比如我们在项目中经常使用 Axios 的实例来进行 HTTP 的请求，使用拦截器 interceptor 可以提前对 请求前的数据 服务器返回的数据进行一些预处理

以及上述应用到的缓存代理和虚拟代理