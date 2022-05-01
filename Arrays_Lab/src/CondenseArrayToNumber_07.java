import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if(nums.length == 1){
            System.out.println(nums[0]);
            return;
        }

        for (int i = 0; i < nums.length -1  ; i++) {

            for (int j = 0; j < nums.length-1; j++) {

                nums[j] = nums[j] + nums[j + 1];
            }
        }
        System.out.println(nums[0]);
    }
}
