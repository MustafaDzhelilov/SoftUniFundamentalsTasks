import java.util.Arrays;
import java.util.Scanner;

public class Retry_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sumEvenNumbers = 0;

        for (int i : array) {
            if(i % 2 == 0){
                sumEvenNumbers += i;
            }
        }
        System.out.println(sumEvenNumbers);
    }
}
