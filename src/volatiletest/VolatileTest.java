package volatiletest;

/**
 * Created by shiyueqi on 2016/7/20.
 */
public class VolatileTest {
    public static int count = 0;
    private static Test test;

    public synchronized static void inc() {

        //这里延迟1毫秒，使得结果明显
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

        //同时启动1000个线程，去进行i++计算，看看实际结果

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //VolatileTest.inc();
                    newInstance(count);
                }
            }).start();
        }

        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("result: Counter.count=" + VolatileTest.count);
    }
}
