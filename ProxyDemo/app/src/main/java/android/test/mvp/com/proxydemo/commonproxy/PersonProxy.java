package android.test.mvp.com.proxydemo.commonproxy;

/**
 * Created by HuangMei on 2017/6/21.
 */

public class PersonProxy implements PersonInterface{

    private PersonImpl person;

    public PersonProxy(PersonImpl person) {
        this.person = person;
    }

    @Override
    public void born() {
        System.out.print("事务处理前");
        person.born();
        System.out.print("事务处理后");
    }

    @Override
    public void named() {
        System.out.print("事务处理前");
        person.named();
        System.out.print("事务处理后");
    }

    @Override
    public void grown() {
        System.out.print("事务处理前");
        person.named();
        System.out.print("事务处理后");
    }
}
