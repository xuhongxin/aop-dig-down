package net.sf.cglib.samples.proxypattern.dynamicproxy;

import java.lang.reflect.Proxy;

import net.sf.cglib.samples.proxypattern.RealSubject;
import net.sf.cglib.samples.proxypattern.Subject;

/**
 * @author stone
 * @version 1.0.0
 * @since 1.0.0 (2018-09-18)
 */
public class JdkProxyClient {

    public static void main(String[] args) {

        // 输出 jdk代理 动态生成的 .class字节码 到 com.sun.proxy 路径下
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // 创建动态代理类的实例
        Subject proxySubject = (Subject) Proxy.newProxyInstance(
                JdkProxyClient.class.getClassLoader(),
                new Class[] { Subject.class },
                new JdkProxy(new RealSubject()));
        proxySubject.doSomething();
        System.out.println("----------------");
        proxySubject.hello("stone");
    }
}
