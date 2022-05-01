import java.util.Arrays;
import java.util.Scanner;

public class trainRetry_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] person = new int[n];

        for (int i = 0; i < n ; i++) {
            person[i] = Integer.parseInt(sc.nextLine());
        }
        for (int i : person) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(Arrays.stream(person).sum());
    }
}
