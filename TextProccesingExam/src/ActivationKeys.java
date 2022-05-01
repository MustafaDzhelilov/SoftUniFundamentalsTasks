import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String key = sc.nextLine();

        String command = sc.nextLine();

        while (!command.equals("Generate")){
            String [] tokens = command.split(">>>");
            String titleOfCommand = tokens[0];

            switch (titleOfCommand){
                case "Contains":
                    String substring = tokens[1];
                    if(!key.contains(substring)){
                        System.out.println("Substring not found!");
                    }else{
                        System.out.println(key + " contains " + substring);
                    }
                    break;
                case "Flip":
                    String subs = "";
                    String change = "";
                    StringBuilder changes = new StringBuilder();
                    if(tokens[1].equals("Upper")){
                        subs = key.substring(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                        change = subs.toUpperCase();
                        changes.append(key);
                        changes.replace(Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),change);
                        key = changes.toString();
                        System.out.println(key);
                    }else if(tokens[1].equals("Lower")){
                        subs = key.substring(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                        change = subs.toLowerCase();
                        changes.append(key);
                        changes.replace(Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),change);
                        key = changes.toString();
                        System.out.println(key);
                    }
                    break;
                case "Slice":
                    String replace = key.substring(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    key =  key.replace(replace, "");
                    System.out.println(key);
                    break;
            }


            command = sc.nextLine();
        }
        System.out.println("Your activation key is: " + key);
    }
}
