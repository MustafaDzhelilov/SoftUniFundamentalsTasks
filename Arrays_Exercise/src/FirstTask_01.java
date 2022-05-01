import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class FirstTask_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int [] array = new int[n];

        for (int i = 0; i <  n; i++) {
            array[i] = Integer.parseInt(sc.nextLine());
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(Arrays.stream(array).sum());
    }
}
