
import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       String input = sc.nextLine();

       String command = sc.nextLine();
        StringBuilder help = new StringBuilder();

       while (!command.equals("Travel")){
           String [] tokens = command.split(":");
           String commandName = tokens[0];


           switch (commandName){
               case "Add Stop":
                   int indexToInsert = Integer.parseInt(tokens[1]);
                   String newString = tokens[2];
                   if(indexToInsert >= 0 && indexToInsert <= input.length()){
                       help.append(input);
                       help.insert(indexToInsert, newString);
                       input = help.toString();
                       help.delete(0,help.length());
                   }
                   System.out.println(input);
                   break;
               case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                   if ((startIndex >= 0 && startIndex < input.length()) && (endIndex >= 0 && endIndex < input.length())) {
                       help.append(input);
                       help.delete(startIndex, endIndex + 1);
                       input = help.toString();
                       help.delete(0, help.length());
                   }
                   System.out.println(input);
                   break;
               case "Switch":
                   String oldString = tokens[1];
                   String newStr = tokens[2];
                   if (input.contains(oldString)){
                       input = input.replaceAll(oldString, newStr);
                   }
                   System.out.println(input);
                   break;
           }
           command = sc.nextLine();
       }
        System.out.println("Ready for world tour! Planned stops: "+ input);

    }
}
