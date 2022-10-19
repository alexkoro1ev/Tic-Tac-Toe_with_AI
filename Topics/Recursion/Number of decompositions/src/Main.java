import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printAllNumberPartitions(sc.nextInt());
    }

    public static int[] getNextPartition(int[] partition) {
        if (partition.length == 1) {
            return null;
        }
        int minIndex = 0;
        for (int i = 0; i < partition.length - 1; i++) {
            if (partition[i] < partition[minIndex]) {
                minIndex = i;
            }
        }
        partition[minIndex] += 1;
        partition[partition.length - 1] -= 1;
        minIndex += 1;
        int partSum = 0;
        for (int i = minIndex; i < partition.length; i++) {
            partSum += partition[i];
        }
        int[] nextPartition = Arrays.copyOf(partition, minIndex + partSum);
        for (int i = minIndex; i < nextPartition.length; i++) {
            nextPartition[i] = 1;
        }
        return nextPartition;
    }

    public static void printAllNumberPartitions(int number) {
        int[] partition = new int[number];
        Arrays.fill(partition, 1);
        while (partition != null) {
            for (int i : partition) {
                System.out.print(i + " ");
            }
            System.out.println();
            partition = getNextPartition(partition);
        }
    }
}