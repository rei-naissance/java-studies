package MidtermWrittenCode;

public class NumRunnable implements Runnable {

    private int start;
    private int end;

    public NumRunnable(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (i % 1000 == 0) {
                synchronized (Main.list) {
                    Main.list.add(i);
                }
            }
        }
    }
}
