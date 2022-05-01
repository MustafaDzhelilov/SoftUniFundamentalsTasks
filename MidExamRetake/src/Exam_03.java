import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exam_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       List<String> messages = new ArrayList<>();

       String command = sc.nextLine();

       while (!command.equals("end")){
           String [] tokens = command.split(" ");
           String currentCommand = tokens[0];

           switch (currentCommand){
               case "Chat":
                   String currentMessages = tokens[1];
                   messages.add(currentMessages);
                   break;
               case "Delete":
                   String mess = tokens[1];
                   if(messages.contains(mess)){
                       messages.remove(mess);
                   }
                   break;
               case "Edit":
                   String current = tokens[1];
                   if(messages.contains(current)){
                       String newMessages = tokens[2];
                       int index = messages.indexOf(current);
                       messages.set(index,newMessages);

                   }
                   break;
               case "Pin":
                   String mes = tokens[1];
                   if(messages.contains(mes)){
                       messages.remove(mes);
                       messages.add(mes);
                   }
                   break;
               case "Spam":
                   for (int i = 1; i < tokens.length; i++) {
                       String n = tokens[i];
                       messages.add(n);
                   }
                   break;

           }

           command = sc.nextLine();
       }
        for (String message : messages) {
            System.out.println(message);
        }


    }
}
