package latchawait;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * date: 2017/03/16 13:47.
 * author: Yueqi Shi
 */
public class Latch {
    private Map<String, CountDownLatch> connectLatch = new ConcurrentHashMap<String, CountDownLatch>();

    public static void main(String[] args) {
        String serviceKeyStr = "testKey";
        Latch latch = new Latch();
        CountDownLatch value = latch.connectLatch.get(serviceKeyStr);
        if (value == null) {
            value = new CountDownLatch(1);
            latch.connectLatch.put(serviceKeyStr, value);
        }

        final CountDownLatch latchObj = value;

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latchObj.countDown();
            }
        }, "threadName");
        t.setDaemon(true);
        t.start();

        try {
            boolean res = latchObj.await(3000, TimeUnit.MILLISECONDS);
            if(res) {
                System.out.println("success end.");
            } else {
                System.out.println("fail end.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        latch.connectLatch.remove(serviceKeyStr);
    }
}
