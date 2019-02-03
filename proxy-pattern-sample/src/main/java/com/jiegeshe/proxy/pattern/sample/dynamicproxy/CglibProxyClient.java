package com.jiegeshe.proxy.pattern.sample.dynamicproxy;

import com.jiegeshe.proxy.pattern.sample.RealSubject;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author stone
 * @version 1.0.0
 * @since 1.0.0 (2018-09-18)
 */
public class CglibProxyClient {

    public static void main(String[] args) {

        // 输出 cglib代理 动态生成的 .class字节码 到 com.sun.proxy 路径下
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
            System.getProperty("user.dir") + "/proxy-pattern-sample/src/main/java");

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
