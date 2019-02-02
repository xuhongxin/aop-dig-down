package net.sf.cglib.samples.proxypattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import net.sf.cglib.samples.proxypattern.RealSubject;

/**
 * @author stone
 * @version 1.0.0
 * @since 1.0.0 (2018-09-18)
 */
public class JdkProxy implements InvocationHandler {

    private RealSubject realSubject;

    JdkProxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        System.out.println("before jdk dynamic proxy");
        Object result;
        try {
            result = method.invoke(this.realSubject, args);
        } catch (Exception ex) {
            System.out.println("ex: " + ex.getMessage());
            throw ex;
        } finally {
            System.out.println("after jdk dynamic proxy");
        }
        return result;
    }
}
