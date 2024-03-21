package Fibonacci;

public class FibRunnable implements Runnable {
    int num;

    public FibRunnable(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        try {
            if (num == 0) {
                Main.sequence[0] = 0;
            } else if (num == 1) {
                Main.sequence[1] = 1;
                Main.threads[num - 1].start();
                synchronized (Main.threads[num - 1]) {
                    Main.threads[num - 1].join();
                }
            } else {
                Main.threads[num - 1].start();
                synchronized (Main.threads[num - 1]) {
                    Main.threads[num - 1].join();
                }
                Main.sequence[num] = Main.sequence[num - 1] + Main.sequence[num - 2];
            }
        } catch (InterruptedException e) {}
    }
}
