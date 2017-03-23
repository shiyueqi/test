package abstracttest;

/**
 * Created by shiyueqi on 2016/7/21.
 */
public class SonTest extends AbstractTest {

    @Override
    public int sonTest() {
        return 0;
    }

    public static int getIndex2(){
        return AbstractTest.getIndex();
    }

    public static int getIndex3(){
        return AbstractTest.incIndex2();
    }

    public String getIndexStrSon(){
        return getIndexStr();
    }

    public static void main(String[] args) {
        int testIndex = AbstractTest.testIndex;
        System.out.println(testIndex);

        testIndex = AbstractTest.getIndex();
        System.out.println(testIndex);

        testIndex = AbstractTest.incIndex2();
        System.out.println(testIndex);

        SonTest sonTest = new SonTest();
        System.out.println(sonTest.getIndexStr());
    }
}
