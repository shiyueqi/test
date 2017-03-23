package abstracttest;

/**
 * Created by shiyueqi on 2016/7/21.
 */
public abstract class AbstractTest {
    public static final int testIndex = 10;

    public static int testIndex2 = 100;

    public static int getIndex(){
        return testIndex;
    }

    public static int incIndex2(){
        return ++testIndex2;
    }

    public String getIndexStr(){
        return "hello world!";
    }

    public abstract int sonTest();
}
