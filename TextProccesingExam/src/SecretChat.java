import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String command = sc.nextLine();

        while (!command.equals("Reveal")){
            String[] tokens = command.split(":\\|:");

            String title = tokens[0];

            switch (title){
                case "InsertSpace":
                    StringBuilder help = new StringBuilder();
                    help.append(input);
                    help.insert(Integer.parseInt(tokens[1])," ");
                    input = help.toString();
                    System.out.println(input);
                    break;
                case "Reverse":
                    StringBuilder reverse = new StringBuilder();
                    String subs = tokens[1];
                    if(input.contains(subs)){
                        input = input.replace(subs, "");
                        StringBuilder help1 = new StringBuilder();
                        help1.append(input);
                        reverse.append(subs);
                        reverse.reverse();
                        subs = reverse.toString();
                        help1.append(subs);
                        input = help1.toString();

                        System.out.println(input);
                        break;
                    }else{
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String sub = tokens[1];
                    String forReplacement = tokens[2];
                    while (input.contains(sub)){
                        input =  input.replace(sub, forReplacement);
                    }
                    System.out.println(input);
                    break;

            }

            command = sc.nextLine();
        }
        System.out.println("You have a new text message: " + input);
    }
}
