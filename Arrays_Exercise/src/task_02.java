import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class task_02 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        String [] firstArray = sc.next().split(" ");
        String [] secondArray = sc.nextLine().split(" ");

        for (String second : secondArray) {
            for (String first : firstArray) {
                if(second.equals(first)){
                    System.out.print(second + " ");
                }
            }
        }

    }
}
