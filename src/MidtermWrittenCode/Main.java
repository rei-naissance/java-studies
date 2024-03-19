package MidtermWrittenCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.ceil;

public class Main {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        int interval = (int) ceil(n / 5.0);
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new NumRunnable(i * interval + 1, interval * (i + 1)));
        }
        
        for (Thread thread : threads) {
            thread.start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {}

        System.out.println("Numbers divisible by 1000 from 1 to " + n + ": ");
        for (int i : list) {
            System.out.print(i + "\n");
        }
    }

}
