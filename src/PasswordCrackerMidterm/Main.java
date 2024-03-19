package PasswordCrackerMidterm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Thread> trd = new ArrayList<>();
    static boolean found = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String pass = sc.nextLine();

        int threadSize = pass.length() * 5;

        Thread[] threads = new Thread[threadSize];

        for(int i = 0; i < pass.length(); i++) {
            threads[i] = new Thread(new PasswordCracker(pass, 'a', i));
        }

        for(int i = pass.length(); i < pass.length()*2; i++) {
            threads[i] = new Thread(new PasswordCracker(pass, 'e', i-pass.length()));
        }

        for(int i = pass.length()*2; i < pass.length()*3; i++) {
            threads[i] = new Thread(new PasswordCracker(pass, 'i', i-pass.length()*2));
        }

        for(int i = pass.length()*3; i < pass.length()*4; i++) {
            threads[i] = new Thread(new PasswordCracker(pass, 'o', i-pass.length()*3));
        }

        for(int i = pass.length()*4; i < pass.length()*5; i++) {
            threads[i] = new Thread(new PasswordCracker(pass, 'u', i-pass.length()*4));
        }

        for (Thread t : threads) {
            t.start();
        }

        try {
            for (Thread t : threads ) {
                t.join();
            }
        } catch (InterruptedException e) {}

    }
}
