package android.test.mvp.com.proxydemo;

import android.app.Activity;
import android.os.Bundle;
import android.test.mvp.com.proxydemo.cglibproxy.BookFacadeCglib;
import android.test.mvp.com.proxydemo.cglibproxy.BookFacadeClass;
import android.test.mvp.com.proxydemo.commonproxy.PersonImpl;
import android.test.mvp.com.proxydemo.commonproxy.PersonProxy;
import android.test.mvp.com.proxydemo.jdkproxy.DynamicSubject;
import android.test.mvp.com.proxydemo.jdkproxy.RealSubject;
import android.test.mvp.com.proxydemo.jdkproxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * ---------------------------------------------
         * 静态代理代理（缺点：代理类是被代理类都要实现一样的方法，导致代码重复）
         * ---------------------------------------------
         */
        PersonImpl person = new PersonImpl();
        PersonProxy personProxy = new PersonProxy(person);
        personProxy.born();
        personProxy.named();
        personProxy.grown();


        /**
         * ---------------------------------------------
         * JDK 动态代理（缺点：不能对没有实现接口的具体类进行代理）
         * ---------------------------------------------
         */
        RealSubject realSubject = new RealSubject();
        InvocationHandler invocationHandler = new DynamicSubject(realSubject);
        Class cls = realSubject.getClass();
        Subject subject = (Subject) Proxy.newProxyInstance(
                cls.getClassLoader(),
                cls.getInterfaces(),
                invocationHandler);
        subject.request();


        /**
         * ---------------------------------------------
         * CGLIB 动态代理（缺点：采用继承，不能对final修饰的类进行代理）
         * ---------------------------------------------
         */
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacadeClass facadeClass = (BookFacadeClass)cglib.getInstance(new BookFacadeClass());
        facadeClass.addBook();
    }
}
