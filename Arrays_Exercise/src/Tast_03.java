import java.util.Scanner;

public class Tast_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] first = new String[n];
        String[] second = new String[n];

        for (int i = 0; i < n ; i++) {
            String[] input = sc.nextLine().split(" ");
            if((i + 1) % 2 == 0){
                second[i] = input[0];
                first[i] = input[1];
            }else{
                first[i] = input[0];
                second[i] = input[1];
            }
        }
        System.out.println(String.join(" ",first));
        System.out.println(String.join(" ",second));
    }
}
