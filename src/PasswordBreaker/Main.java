package PasswordBreaker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password to break in: ");
        String password = scanner.nextLine();

        int len = password.length();
        Thread[] threads = new Thread[26];

        char startingLetter = 'a';
        for (int i = 0; i < 26; i++) {
            threads[i] = new Thread(new BreakerRunnable(startingLetter, password));
            startingLetter = (char) (startingLetter + 1);
        }

        for (Thread thrd : threads) thrd.start();
    }
}
