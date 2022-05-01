import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String substring = sc.nextLine();
        String string = sc.nextLine();

        while(string.contains(substring)){
            string = string.replace(substring, "");
        }
        System.out.println(string);
    }
}
