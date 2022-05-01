import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int rotation = Integer.parseInt(sc.nextLine());

        for (int rotations = 1; rotations <= rotation ; rotations++) {
            int firstNumber = array[0];
            for (int index = 0; index < array.length - 1  ; index++) {
                array[index] = array[index + 1];
            }
            array[array.length - 1] = firstNumber;
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
