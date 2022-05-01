import java.util.Scanner;

public class HTML_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String title = sc.nextLine();
        String content = sc.nextLine();
        String comment = sc.nextLine();

        System.out.println("<h1>");
        System.out.println("  " + title);
        System.out.println("</h1>");
        System.out.println("<article>");
        System.out.println("  " + content);
        System.out.println("</article>");

        while (!comment.equals("end of comments")){

            System.out.println("<div>");
            System.out.println("  "+comment);
            System.out.println("</div>");

            comment = sc.nextLine();
        }
    }
}
