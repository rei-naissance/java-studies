package Fibonacci;

public class FibRunnable implements Runnable {
    int n;

    public FibRunnable(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        try {
            if (n == 0) {
                Main.sequence[0] = 0;
            } else if (n == 1) {
                Main.sequence[1] = 1;
                Main.threads[n - 1].start();
                synchronized (Main.threads[n - 1]) {
                    Main.threads[n - 1].join();
                }
            } else {
                Main.threads[n - 1].start();
                synchronized (Main.threads[n - 1]) {
                    Main.threads[n - 1].join();
                }
                Main.sequence[n] = Main.sequence[n - 1] + Main.sequence[n - 2];
            }
        } catch (InterruptedException e) {}
    }
}
