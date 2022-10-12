import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int[][] matrix = new int[s][s];
        int c = 0;
        int j = 0;
        int p = 0;

        for (int i = 0; i < s; i++) {
            for (; j < s; j++) {
                matrix[i][j] = p;
                matrix[j][i] = p;
                p++;
            }
            j = ++c;
            p = 0;
        }

        for (int i = 0; i < s; i++) {
            for (int k = 0; k < s; k++) {
                System.out.print(matrix[i][k] + " ");
            }
            System.out.println();
        }

    }
}