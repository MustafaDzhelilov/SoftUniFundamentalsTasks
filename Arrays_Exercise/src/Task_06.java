import java.util.Arrays;
import java.util.Scanner;

public class Task_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean isFound = false;
        for (int i = 0; i < array.length -1 ; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int left = 0; left <= i -1; left++) {
                leftSum += array[left];
            }
            for (int right = i + 1; right <= array.length -1 ; right++) {
                rightSum += array[right];
            }
            if(rightSum ==leftSum){
                System.out.println(i);
                isFound = true;
                break;
            }
        }
        if(!isFound){
            System.out.println("no");
        }
    }
}
