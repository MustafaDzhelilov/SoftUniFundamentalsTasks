package Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String title = input.split(", ")[0];
        String content = input.split(", ")[1];
        String author = input.split(", ")[2];
        int n = Integer.parseInt(sc.nextLine());


        Articels articles = new Articels (title, content, author);
    }
}
