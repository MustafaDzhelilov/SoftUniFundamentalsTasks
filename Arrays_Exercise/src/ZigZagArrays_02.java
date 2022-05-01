import java.util.Scanner;

public class ZigZagArrays_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String [] firstArray = new String[n];
        String [] secondArray = new String[n];

        for (int i = 0; i < n  ; i++) {
            String [] input = sc.nextLine().split(" ");

            if(((i + 1) % 2) == 0){
                secondArray[i] = input[0];
                firstArray[i] = input[1];
            }else{
                firstArray[i] = input[0];
                secondArray[i] = input[1];
            }
        }
        System.out.println(String.join(" ",firstArray));
        System.out.println(String.join(" ",secondArray));
    }
}
