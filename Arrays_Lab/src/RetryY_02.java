import java.util.Scanner;

public class RetryY_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = array[array.length -1 ]; j > i ; j--) {
                System.out.print(j + " ");
            }
        }
    }
}
