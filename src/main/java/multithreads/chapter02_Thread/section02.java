package multithreads.chapter02_Thread;

/**
 * synchronized 关键字进一步理解, wait(), sleep(n), notify
 */
public class section02 {
    public static Object obj = new Object();
    public static void main(String[] args) {
        Thread thread2 = new Thread(new RunnableDemo2());
        thread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread1 = new Thread(new RunnableDemo1());
        thread1.start();

    }
}

class RunnableDemo1 implements Runnable {

    @Override
    public void run() {
        System.out.println("我是RunnableDemo111111111111111的run方法");
        synchronized (section02.obj){
            for (int i = 0; i < 1000; i ++) {
                System.out.println("111111111111111111111111111" + " ==>" + i);
                if (i == 500) {
                    section02.obj.notify();
                }
            }

        }
    }
}

class RunnableDemo2 implements Runnable {

    @Override
    public void run() {
        System.out.println("我是RunnableDemo222222222222222的run方法");
        synchronized (section02.obj){
            for (int i = 0; i < 1000; i ++) {
                System.out.println("22222222222222222222222222" + " ==>" + i);
                if (i == 501) {
                    try {

                        section02.obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}