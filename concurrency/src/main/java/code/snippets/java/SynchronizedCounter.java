package code.snippets.java;


/**
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html
 * If count is an instance of SynchronizedCounter, then making these methods synchronized has two
 * effects:
 *
 * First, it is not possible for two invocations of synchronized methods on the same object to
 * interleave. When one thread is executing a synchronized method for an object, all other
 * threads that invoke synchronized methods for the same object block (suspend execution) until
 * the first thread is done with the object.
 * Second, when a synchronized method exits, it automatically establishes a happens-before
 * relationship with any subsequent invocation of a synchronized method for the same object. This
 * guarantees that changes to the state of the object are visible to all threads.
 * Note that constructors cannot be synchronized — using the synchronized keyword with a
 * constructor is a syntax error. Synchronizing constructors doesn't make sense, because only the
 * thread that creates an object should have access to it while it is being constructed.
 */
public class SynchronizedCounter {
    private int c = 0;

    public synchronized void increment() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }


    public static void main(String[] args) throws InterruptedException {
        SynchronizedCounter counter = new SynchronizedCounter();
        SynchronizedCounter counter2 = new SynchronizedCounter();
        long time = System.currentTimeMillis();
        Thread thread1 = new Thread(counter::increment);
        Thread thread2 = new Thread(counter2::increment);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.printf("消耗的时间 %d",System.currentTimeMillis() - time);
    }
}