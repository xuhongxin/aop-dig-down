package com.jiegeshe.proxy.pattern.sample.dynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import com.jiegeshe.proxy.pattern.sample.RealSubject;

/**
 * @author stone
 * @version 1.0.0
 * @since 1.0.0 (2018-09-18)
 */
public class CglibProxyClient {

    public static void main(String[] args) {

        // 创建一个类生成器 ClassGenerator
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new CglibProxy());

        // 创建动态代理类的实例
        RealSubject proxySubject = (RealSubject) enhancer.create();
        proxySubject.doSomething();
        System.out.println("----------------");
        proxySubject.hello("stone");
    }
}
