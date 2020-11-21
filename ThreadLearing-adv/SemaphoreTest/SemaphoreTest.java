package SemaphoreTest;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    //模拟餐厅有2个窗口，但是有20个人要吃饭。
    public static int count  = 20;
    public static int threadTotal  = 2;
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();

        Semaphore semaphore = new Semaphore(threadTotal); // 初始信号量为0
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(()-> {
                try {
                    Thread.sleep(50);
                    semaphore.acquire(1);
                    System.out.println("当前次饭线程："+Thread.currentThread().getName());
                    countDownLatch.countDown();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    semaphore.release(1);
                }
            });
            thread.start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"结束，所有人次饭完毕");
    }
}
