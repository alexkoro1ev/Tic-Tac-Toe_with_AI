import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long a = s.nextLong();
        long b = s.nextLong();
        int n = s.nextInt();
        int k = s.nextInt();

        int min = k + 1;
        long index = -1;
        for (long i = a; i <= b; i++) {
            int max = -1;
            Random ran = new Random(i);
            for (int j = 0; j < n; j++) {

                int num = ran.nextInt(k);
                max = Math.max(num, max);
            }
            if (max < min) {
                min = max;
                index = i;
            }
        }

        System.out.println(index);
        System.out.println(min);
    }
}