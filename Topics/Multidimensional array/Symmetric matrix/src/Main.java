import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] m = new int[size][size];
        boolean isSymmetric = true;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                m[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (m[i][j] != m[j][i]) {
                    isSymmetric = false;
                }
            }
        }

        System.out.println(isSymmetric ? "YES" : "NO");
    }
}