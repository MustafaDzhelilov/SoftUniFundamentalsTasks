import java.util.Arrays;
import java.util.Scanner;

public class RotationArraysRetry_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rotation = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < rotation; i++) {
            int firstNumber = array[0];
            for (int j = 0; j < array.length - 1 ; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = firstNumber;
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
