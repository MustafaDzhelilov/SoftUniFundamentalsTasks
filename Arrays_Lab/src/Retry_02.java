import java.util.Scanner;

public class Retry_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n  = Integer.parseInt(sc.nextLine());

        int [] array = new int[n];

        for (int i = 0; i < n ; i++) {
            int numbers = Integer.parseInt(sc.nextLine());
            array[i] = numbers;
        }
        for (int i = array.length - 1; i >= 0 ; i--) {
            System.out.print(array[i] + " ");
        }
    }
}
