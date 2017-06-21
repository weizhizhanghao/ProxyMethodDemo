package android.test.mvp.com.proxydemo.jdkproxy;

/**
 * Created by HuangMei on 2017/6/21.
 */

public class RealSubject implements Subject{

    public RealSubject() {
    }

    @Override
    public void request() {
        System.out.print("real subject request");
    }
}
