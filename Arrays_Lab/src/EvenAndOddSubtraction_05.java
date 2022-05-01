import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] n = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int evenSum = 0;
        int oddSum = 0;

        for (int i : n) {
            if( i % 2 == 0){
                evenSum += i;
            }else{
                oddSum += i;
            }
        }
        int dif = evenSum - oddSum;
        System.out.println(dif);
    }
}
