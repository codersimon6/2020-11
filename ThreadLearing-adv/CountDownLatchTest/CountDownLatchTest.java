package CountDownLatchTest;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[10];
        CountDownLatch countDownLatch = new CountDownLatch(10);  //给定初始值
        for (int i = 0; i < 10; i++) {
            final int j = i;  //(匿名)内部类只能访问final变量 
            threads[i] =  new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(j);
                    countDownLatch.countDown(); //运行一次-1;
                }
            });
        }
        //所有线程运行结束再打印
        /**
         * 方式1：活跃线程数>1，main线程让步
         */
        while (Thread.activeCount() > 1){
            Thread.yield();
        }
        /**
         * 方式2：join()
         */
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }

        /**
         * 方式3：CountDownLatch
         */
        countDownLatch.await(); //当前线程阻塞等待，直到CountDownLatch为0
        System.out.println("所有线程运行结束");
    }
}
