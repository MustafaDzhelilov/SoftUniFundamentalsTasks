import java.util.Scanner;

public class PasswordResset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String command = sc.nextLine();

        while (!command.equals("Done")){
            String[] tokens = command.split(" ");

            String title = tokens[0];

            switch (title){
                case "TakeOdd":
                    StringBuilder helpToNewPass = new StringBuilder();
                    for (int i = 0; i < input.length(); i++) {
                        if(i % 2 != 0){
                            char symbol = input.charAt(i);
                            helpToNewPass.append(symbol);
                        }
                    }
                    input = helpToNewPass.toString();
                    System.out.println(input);
                    break;
                case "Cut":
                    int startingNumber = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    String substringInput = input.substring(startingNumber, (startingNumber + length));
                    input = input.replace(substringInput, "");
                    System.out.println(input);
                    break;
                case "Substitute":
                    String subs = tokens[1];
                    String forReplace = tokens[2];
                    if(input.contains(subs)){
                       input = input.replace(subs, forReplace);
                        System.out.println(input);
                    }else{
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            command = sc.nextLine();
        }
        System.out.print("Your password is: " + input);
    }
}
