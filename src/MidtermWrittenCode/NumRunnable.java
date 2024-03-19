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
        synchronized (Main.list) {
            for (int i = start; i <= end; i++) {
                if(i % 1000 == 0) {
                    Main.list.add(i);
                }
            }
        }
    }
}
