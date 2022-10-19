import java.util.Scanner;

public class Main {

    public static long method(long n) {
        if (n == 0) {
            return 1;
        } else {
            return 2 * method(n - 1);
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        System.out.println(method(8));
    }
}
