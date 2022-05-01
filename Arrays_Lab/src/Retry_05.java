import java.util.Arrays;
import java.util.Scanner;

public class Retry_05 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int oddSum = 0;
        int evenSum = 0;
        for (int i : array) {
            if(i % 2 == 0){
                evenSum += i;
            }else{
                oddSum += i;
            }
        }
        int dif = evenSum - oddSum;
        System.out.println(dif);
    }
}
