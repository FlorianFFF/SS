package ss.week7.threads;

public class TestConsole extends Thread {
    public TestConsole(String name) {
        super(name);
    }
    
    @Override
    public void run() {
        sum();
    }
    
    private void sum() {
        int int1 = Console.readInt(String.format("Thread %s: get number 1?\n", getName()));
        int int2 = Console.readInt(String.format("Thread %s: get number 2?\n", getName()));
        
        System.out.printf("Thread %s: %d + %d = %d\n", getName(), int1, int2, int1 + int2);
    }
    
    public static void main(String[] args) {
        new TestConsole("A").start();
        new TestConsole("B").start();
        new TestConsole("C").start();
        new TestConsole("D").start();
    }
}
