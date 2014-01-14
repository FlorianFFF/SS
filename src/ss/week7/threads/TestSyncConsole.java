package ss.week7.threads;

public class TestSyncConsole implements Runnable {
    @Override
    public void run() {
        sum();
    }
    
    private synchronized void sum() {
        synchronized (this) {
            int int1 =
                SyncConsole.readInt(String.format("Thread %s: get number 1?\n",
                        Thread.currentThread().getName()));
            int int2 =
                SyncConsole.readInt(String.format("Thread %s: get number 2?\n",
                        Thread.currentThread().getName()));
            
            System.out.printf("Thread %s: %d + %d = %d\n", Thread
                    .currentThread().getName(), int1, int2, int1 + int2);
        }
    }
    
    public static void main(String[] args) {
        TestSyncConsole console = new TestSyncConsole();
        new Thread(console, "a").start();
        new Thread(console, "b").start();
        new Thread(console, "c").start();
        new Thread(console, "d").start();
        new Thread(console, "e").start();
    }
}
