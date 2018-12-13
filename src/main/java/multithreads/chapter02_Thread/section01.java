package multithreads.chapter02_Thread;

/**
 * 新建线程的基本方式
 */
public class section01 {
    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        System.out.println(name);
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
//        try {
//            threadDemo.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new Thread(new RunnableDemo()).run();
    }
}

class ThreadDemo extends Thread {
    @Override
    public void run() {
        System.out.println("我已经完成了重要的工作");
        Thread.yield();
        System.out.println("我是ThreadDemo的run方法");
    }
}

class RunnableDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("我是RunnableDemo的run方法");
    }
}