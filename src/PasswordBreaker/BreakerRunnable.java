package PasswordBreaker;

public class BreakerRunnable implements Runnable {

    char start;
    String password;

    static boolean isFound = false;

    public BreakerRunnable(char start, String password) {
        this.start = start;
        this.password = password;
    }

    @Override
    public void run() {
        int len = password.length();
        String buffer = start + "a".repeat(len - 1);

        int i;
        String retain, reset;
        char itr;

        while (!buffer.equals(password) && !isFound) {
            System.out.println(buffer);
            for(i = len - 1; buffer.charAt(i) == 'z'; i--);
            retain = buffer.substring(0, i);
            itr = (char) (buffer.charAt(i) + 1);
            reset = "a".repeat(len - i - 1);
            buffer = retain + itr + reset;
            if (buffer.equals(password)) {
                isFound = true;
                System.out.println("Password found -> " + buffer);
            }
        }
    }
}
