import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MuOnline {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> numbers = Arrays.stream(sc.nextLine().split("\\|"))
                .collect(Collectors.toList());
        String [] tokens = new String[numbers.size()];
        int health = 100;
        int count = 0;
        int bitcoins = 0;

        for (int i = 0; i < numbers.size(); i++) {
            tokens[i] = numbers.get(i);
        }
        for (int i = 0; i < numbers.size(); i++) {
            count++;
            String[] items = tokens[i].split(" ");
            String command = items[0];
            int number = Integer.parseInt(items[1]);

           if(command.equals("potion")){
               if(number + health > 100){
                   int dif = 100 - health;
                   System.out.printf("You healed for %d hp.%n",dif);
               }else{
                   System.out.printf("You healed for %d hp.%n",number);
               }
               if(health + number > 100){
                   System.out.printf("Current health: %d hp.%n",100);
                   health = 100;
               }else{
                   health += number;
                   System.out.printf("Current health: %d hp.%n",health);
               }
           }else if(command.equals("chest")){
               bitcoins += number;
               System.out.printf("You found %d bitcoins.%n",number);
           }else {
                if(health - number <= 0){
                    health -= number;
                    System.out.printf("You died! Killed by %s.%n",command);
                    System.out.printf("Best room: %d",count);
                    break;
                }else{
                    if(health - number > 0){
                        System.out.printf("You slayed %s.%n",command);
                        health -= number;
                    }else{
                        System.out.printf("You died! Killed by %s.%n",command);
                        System.out.printf("Best room: %d",count);
                    }

                }
           }
        }
        if(health > 0) {
            System.out.printf("You've made it!%n");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d%n", health);
        }
    }
}
