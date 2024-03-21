package PasswordCrackerMidterm;

public class PasswordCracker implements Runnable{

    public static boolean found = false;
    public static String password;
    private final int constantChar;
    private final char vowel;
    private int id;
    public PasswordCracker(char vowel, int vowel_position, int id){
        this.vowel = vowel;
        this.constantChar = vowel_position;
        this.id = id;
    }

    public void run(){
        int len = password.length(); //
        String atk = "a".repeat(len-1);
        // idea is to have atk of length len-1 and insert our vowel only when checking
        // see check() function comments for example
        while (!found && !check(atk).equals(password)) { // slightly modified (?) version sa kato code sa pwchecker
            System.out.println("Thread " + id + ": " + check(atk));
            int i;
            for (i = atk.length() - 1; i >= 0 && atk.charAt(i) == 'z'; i--);
            if (i < 0) return;
            String retain = atk.substring(0, i);
            char changeChar = (char) (atk.charAt(i) + 1);
            String reset = "a".repeat(len - i - 2);
            atk = retain + changeChar + reset;
        }

        if (check(atk).equals(password)) { // we need an if statement to check if this thread actually found the password or if the above loop just stopped because pw has been found elsewhere
            found = true; // check global found variable to true
            System.out.println("Found match in Thread " + id + ": " + check(atk));
        }

    }

    private String check(String atk){
        return atk.substring(0, constantChar) + vowel + atk.substring(constantChar);
        // inserts vowel into atk string with proper position
        // example:  vowel='a', vowel_position=2 ,atk = "gwpo"
        // output = "gw" + 'a' + "po"
        //        = "gwapo"
    }
}