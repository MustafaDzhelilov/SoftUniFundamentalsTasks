import java.util.Arrays;
import java.util.Scanner;

public class EqualSumRetry_06 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int [] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isFound = false;
        for (int index = 0; index < array.length - 1  ; index++) {
            
            int leftSum = 0;
            int rightSum = 0;

            for (int left = 0; left <= index -1  ; left++) {
                leftSum += array[left];
            }
            for (int right = index + 1; right <= array.length -1  ; right++) {
                rightSum += array[right];
            }

            if(leftSum == rightSum){
                System.out.println(index);
                isFound = true;
            }
        }
        if(!isFound){
            System.out.println("no");
        }
    }
}
