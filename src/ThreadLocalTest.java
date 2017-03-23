/**
 * Created by shiyueqi on 2016/8/17.
 */
public class ThreadLocalTest {

    // ��ͨ�������ڲ��า��ThreadLocal��initialValue()������ָ����ʼֵ
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        public Integer initialValue() {
            return 0;
        }
    };

    // �ڻ�ȡ��һ������ֵ
    public static int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void setNum(int num){
        seqNum.set(num);
    }

    public static int getNum() {
        return seqNum.get();
    }

    public static void main(String[] args) {
        ThreadLocalTest sn = new ThreadLocalTest();
        // �� 3���̹߳���sn�����Բ������к�
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
//        t1.start();
//        t2.start();
//        t3.start();

        TestClient2 t21 = new TestClient2();
        TestClient2 t22 = new TestClient2();
        TestClient2 t23 = new TestClient2();
        t21.start();
        t22.start();
        t23.start();
    }

    private static class TestClient extends Thread {
        private ThreadLocalTest sn;

        public TestClient(ThreadLocalTest sn) {
            this.sn = sn;
        }

        public void run() {
            for (int i = 0; i < 3; i++) {
                // ��ÿ���̴߳��3������ֵ
                System.out.println("thread[ name: " + Thread.currentThread().getName()
                        + ", id: " + Thread.currentThread().getId()
                        + ", str: " + Thread.currentThread().toString()
                        +"] --> sn["
                        + sn.getNextNum() + "]");
            }
        }
    }

    private static class TestClient2 extends Thread {

        public void run() {
            for (int i = 0; i < 3; i++) {
                // ��ÿ���̴߳��3������ֵ
                ThreadLocalTest.setNum(i);
                System.out.println("thread[ name: " + Thread.currentThread().getName()
                        + ", id: " + Thread.currentThread().getId()
                        + ", str: " + Thread.currentThread().toString()
                        +"] --> sn["
                        + ThreadLocalTest.getNum() + "]");

                System.out.println("thread[ name: " + Thread.currentThread().getName()
                        + ", id: " + Thread.currentThread().getId()
                        + ", str: " + Thread.currentThread().toString()
                        +"] --> sn["
                        + ThreadLocalTest.getNum() + "]");
            }
        }
    }
}
