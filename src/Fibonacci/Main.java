package Fibonacci;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Thread[] threads;
    public static int[] sequence;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements to be displayed: ");
        int size = sc.nextInt();

        threads = new Thread[size];
        sequence = new int[size];

        for (int i = 0; i < size; i++) {
            threads[i] = new Thread(new FibRunnable(i));
        }

        threads[size - 1].start();

        try {
            threads[size - 1].join();
        } catch (InterruptedException e) {}

        System.out.println(Arrays.toString(sequence));
    }
}
