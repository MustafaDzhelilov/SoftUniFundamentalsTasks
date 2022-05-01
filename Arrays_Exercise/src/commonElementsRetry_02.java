import java.util.Arrays;
import java.util.Scanner;

public class commonElementsRetry_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arrayFirst = sc.nextLine().split(" ");
        String[] arraySecond = sc.nextLine().split(" ");

        for (String s : arraySecond) {
            for (String s1 : arrayFirst) {
                if(s.equals(s1)){
                    System.out.print(s1 + " ");
                }
            }
        }
    }
}
