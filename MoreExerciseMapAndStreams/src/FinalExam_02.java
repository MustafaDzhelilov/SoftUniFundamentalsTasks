import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinalExam_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());


        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String valid ="";
            String command = "";

            String regex = "([!])(?<command>[A-Z][a-z]{2,})\\1:[\\[](?<message>[A-Za-z]{8,})[\\]]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()){
                valid = matcher.group("message");
                command = matcher.group("command");
            }
            if(!valid.isEmpty()){
                int sum = 0;
                System.out.print(command+": " );
                for (int j = 0; j < valid.length(); j++) {
                    sum = valid.charAt(j);
                    System.out.print(sum + " ");
                }
                System.out.println();
            }else{
                System.out.println("The message is invalid");
            }
        }

    }
}
