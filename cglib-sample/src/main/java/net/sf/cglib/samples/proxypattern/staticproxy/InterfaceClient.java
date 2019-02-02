package net.sf.cglib.samples.proxypattern.staticproxy;

import net.sf.cglib.samples.proxypattern.RealSubject;
import net.sf.cglib.samples.proxypattern.Subject;

/**
 * @author stone
 * @version 1.0.0
 * @since 1.0.0 (2018-09-17)
 */
public class InterfaceClient {

    public static void main(String[] args) {
        Subject proxySubject = new InterfaceStaticProxy(new RealSubject());
        proxySubject.doSomething();
        System.out.println("----------------");
        proxySubject.hello("stone");
    }
}
