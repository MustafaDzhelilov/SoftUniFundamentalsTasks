import java.util.Scanner;

public class FinalExamPavcho_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String command = sc.nextLine();

        while (!command.equals("Sign up")){
            String [] tokens = command.split(" ");
            String commandType = tokens[0];

            switch (commandType){
                case "Replace"://ok
                    String char1 = tokens[1];
                    while (input.contains(char1)) {
                        input = input.replace(char1, "*");
                    }
                    System.out.println(input);
                    break;
                case "Reverse"://ok
                    int start = Integer.parseInt(tokens[1]);
                    int end = Integer.parseInt(tokens[2]);
                    if(start >= 0 && end < input.length()){
                        StringBuilder reverse = new StringBuilder();
                        String substrictChange = input.substring(start,end+1);
                        reverse.append(substrictChange);
                        reverse.reverse();
                        System.out.println(reverse);
                    }
                    break;
                case "Case"://ok
                    String type = tokens[1];
                    if(type.equals("upper")){
                        input = input.toUpperCase();
                        System.out.println(input);
                    }else if(type.equals("lower")){
                        input = input.toLowerCase();
                        System.out.println(input);
                    }
                    break;
                case "Cut"://ok
                    String currentString = tokens[1];
                    if(input.contains(currentString)){
                        input = input.replaceFirst(currentString,"");
                        System.out.println(input);
                    }else{
                        System.out.printf("The word %s doesn't contain %s.%n",input, currentString);
                    }
                    break;
                case "Check":
                    String char2 = tokens[1];
                    if(input.contains(char2)){
                        System.out.println("Valid");
                    }else{
                        System.out.printf("Your username must contain %s.%n", char2);
                    }
                    break;
            }
            command = sc.nextLine();
        }
    }
}
