package Fibonacci;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Thread[] threads;
    public static Integer[] sequence;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the Fibonacci sequence: ");
        int size = sc.nextInt();

        threads = new Thread[size];
        sequence = new Integer[size];

            for (int i = 0; i < size; i++) {
            threads[i] = new Thread(new FibRunnable(i));
        }

        threads[size - 1].start();

        try {
            threads[size - 1].join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Arrays.toString(sequence));
    }
}
