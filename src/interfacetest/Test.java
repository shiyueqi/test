package interfacetest;

/**
 * Created by shiyueqi on 2016/7/20.
 */
public class Test {
    public static void main(String[] args) {
        CommonTest commonTest = new CommonTest();
        int commonIndex = Common.COMMON_INDEX;
        System.out.println("Interface value : " + commonIndex);

        commonIndex = CommonTest.COMMON_INDEX;
        System.out.println("Interface Implements class value : " + commonIndex);

        commonIndex = commonTest.COMMON_INDEX;
        System.out.println("Interface Implements class instance value : " + commonIndex);
    }
}
