import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int[][] array = new int[a1][a2];

        for (int i = 0; i < a1; i++) {
            for (int j = 0; j < a2; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        int i1 = scanner.nextInt();
        int i2 = scanner.nextInt();

        for (int[] n : array) {
            int temp = n[i2];
            n[i2] = n[i1];
            n[i1] = temp;
        }

        for (int i = 0; i < a1; i++) {
            for (int j = 0; j < a2; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}