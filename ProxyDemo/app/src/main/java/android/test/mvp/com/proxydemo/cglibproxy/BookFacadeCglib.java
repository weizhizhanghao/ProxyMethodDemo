package android.test.mvp.com.proxydemo.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by HuangMei on 2017/6/21.
 */

public class BookFacadeCglib implements MethodInterceptor {
    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调
        enhancer.setCallback(this);
        //创建代理
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.print("事务开始");
        methodProxy.invokeSuper(o, objects);
        System.out.print("事务结束");
        return null;
    }
}
