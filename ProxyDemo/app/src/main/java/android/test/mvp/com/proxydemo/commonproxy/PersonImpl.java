package android.test.mvp.com.proxydemo.commonproxy;

/**
 * Created by HuangMei on 2017/6/21.
 */

public class PersonImpl implements PersonInterface{

    @Override
    public void born() {
        System.out.print("我出生啦");
    }

    @Override
    public void named() {
        System.out.print("我有名字啦");
    }

    @Override
    public void grown() {
        System.out.print("我长大啦");
    }
}
