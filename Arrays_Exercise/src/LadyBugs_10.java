import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs_10 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int [] index = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] ladyBug = new int[n];


    }
}
