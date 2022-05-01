import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] firstArray = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int [] secondArray = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        boolean isDiff = true;

        for (int i = 0; i < firstArray.length ; i++) {
                sum += firstArray[i];

                if(firstArray[i] != secondArray[i]){
                    System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                    isDiff = false;
                    break;
                }
        }
        if(isDiff){
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
