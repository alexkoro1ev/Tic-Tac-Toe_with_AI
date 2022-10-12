import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                matrix[i][k] = sc.nextInt();
            }
        }

        int[][] resultArray = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                resultArray[j][matrix.length - i - 1] = matrix[i][j];
            }
        }

        for (int[] ints : resultArray) {
            for (int k = 0; k < resultArray[0].length; k++) {
                System.out.print(ints[k] + " ");
            }
            System.out.println();
        }
    }
}