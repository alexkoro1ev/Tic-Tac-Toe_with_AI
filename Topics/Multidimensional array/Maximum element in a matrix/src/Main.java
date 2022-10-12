import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        int min = Integer.MIN_VALUE;
        int[] ans = new int[2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > min) {
                    ans[0] = i;
                    ans[1] = j;
                    min = matrix[i][j];
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }
}
