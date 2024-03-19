package PasswordCrackerMidterm;

public class PasswordCracker implements Runnable {
    private char vowel;
    private StringBuilder atk;
    private String pass;

    private int position;
    private int len;

    public PasswordCracker(String pass, char vowel,  int position) {
        this.pass = pass;
        this.vowel = vowel;
        this.position = position;

        len = pass.length();
        atk = new StringBuilder();
    }

    @Override
    public synchronized void run() {
        int ctr = 0;

        while(!atk.toString().equals(pass) && !Main.found) {
            ctr++;
            int[] res = new int[len];
            int tmp = ctr;

            for(int i = len-1, j = 0; i >= 0; i--, j++) {
                res[j] = tmp / (int) Math.pow(26, i);
                tmp  = tmp % (int) Math.pow(26, i);
            }

            atk = new StringBuilder();
            for(int i = 1; i < len; i++) {
                atk.append((char)('a'+res[i]));
            }
            atk.insert(position, vowel);

            if(Main.found == true){
                break;
            }else{
                System.out.println("THREAD: " + vowel + "[" + position + "]" + " = " + atk);
            }
        }

        if(atk.toString().equals(pass)) {
            System.out.println("-----------------------------------------------------------\n" + "Your password is: " + atk +  "\n------------------------------------------------------------");
            Main.found = true;
        }
    }
}
