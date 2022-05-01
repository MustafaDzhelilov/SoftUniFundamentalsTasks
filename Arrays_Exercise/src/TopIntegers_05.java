import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] integers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i <= integers.length - 1 ; i++) {
            int number = integers[i];
            if(i == integers.length - 1){
                System.out.print(number);
                break;
            }
            boolean isBigger = false;
            for (int a = i + 1; a <= integers.length - 1 ; a++) {
                if(number > integers[a]){
                    isBigger = true;
                }else{
                    isBigger = false;
                    break;
                }
            }
            if(isBigger){
                System.out.print(number + " ");
            }
        }

    }
}
