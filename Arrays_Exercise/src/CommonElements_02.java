import java.util.Arrays;
import java.util.Scanner;

public class CommonElements_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String [] first = sc.nextLine().split(" ");
        String [] second = sc.nextLine().split(" ");

        for (String word2 : second) {
            for (String word : first) {
                if(word2.equals(word)){
                    System.out.print(word2 + " ");
                    break;
                }
            }
        }
    }
}
