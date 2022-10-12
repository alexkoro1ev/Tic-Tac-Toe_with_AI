import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        long n = s.nextLong();
        double m = s.nextDouble();
        int seed = k - 1;

        while (seed != k) {
            Random ran = new Random(k);
            for (int i = 0; i < n; i++) {
                double num = ran.nextGaussian();
                if (num > m) {
                    break;
                }
                else if ( i == n - 1){
                    seed = k;
                    break;
                }
            }
            if (seed != k) {
                k++;
            }
        }

        System.out.println(seed);

    }
}