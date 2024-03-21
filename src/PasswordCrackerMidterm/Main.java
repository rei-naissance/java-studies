package PasswordCrackerMidterm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final char[] vowels = {'a','e','i','o','u'};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password: ");
        PasswordCracker.password = scanner.nextLine();

        int ctr = 1;

        ArrayList<Thread> threads = new ArrayList<>(); // arraylist for checker threads
        for(int i=0; i < PasswordCracker.password.length(); i++){ // iterate (password length) number of times
            for(int j=0; j < 5; j++){ // iterate through VOWELS array
                PasswordCracker c = new PasswordCracker(vowels[j], i, ctr);
                ctr++;
                Thread thread = new Thread(c);   // make new thread from checker
                threads.add(thread);      // add thread to array list
                thread.start();                  // start the thread
            }
        }
        for( Thread t : threads){
            try {
                t.join();
            } catch (InterruptedException e) {}
        }
        // ^^^^ wait for all threads to finish
    }

}
