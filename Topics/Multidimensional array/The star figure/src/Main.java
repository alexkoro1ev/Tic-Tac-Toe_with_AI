import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] matrix = new char[n][n];
        int c = n / 2;

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (i == k || i == c || k == c || i == n - k - 1) {
                    matrix[i][k] = '*';
                } else {
                    matrix[i][k] = '.';
                }
                System.out.print(matrix[i][k] + " ");
            }
            System.out.println();
        }
    }
}