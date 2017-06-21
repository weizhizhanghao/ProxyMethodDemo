package android.test.mvp.com.proxydemo.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by HuangMei on 2017/6/21.
 */

public class DynamicSubject implements InvocationHandler {

    private Object sub;

    public DynamicSubject(Object sub) {
        this.sub = sub;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print("事务执行前");
        method.invoke(proxy, args);
        System.out.print("事务执行后");
        return null;
    }
}
