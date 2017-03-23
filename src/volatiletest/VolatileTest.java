package volatiletest;

/**
 * Created by shiyueqi on 2016/7/20.
 */
public class VolatileTest {
    public static int count = 0;
    private static Test test;

    public synchronized static void inc() {

        //�����ӳ�1���룬ʹ�ý������
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
        count++;
    }

    public static void newInstance(int count){
        if(test == null){
            synchronized (VolatileTest.class){
                if(test == null){
                    test = new Test();
                }
                System.out.println(count++);
            }
        }
    }

    public static void main(String[] args) {

        //ͬʱ����1000���̣߳�ȥ����i++���㣬����ʵ�ʽ��

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //VolatileTest.inc();
                    newInstance(count);
                }
            }).start();
        }

        //����ÿ�����е�ֵ���п��ܲ�ͬ,����Ϊ1000
        System.out.println("result: Counter.count=" + VolatileTest.count);
    }
}
