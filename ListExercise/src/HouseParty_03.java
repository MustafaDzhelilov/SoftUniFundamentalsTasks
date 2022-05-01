import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HouseParty_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<String> guests = new ArrayList<>();
        int count= 0;
        for (int i = 0; i <= n; i++) {
            count++;
            if(count > n){
                for (String guest : guests) {
                    System.out.println(guest);
                }
                break;
            }
            String command = sc.nextLine();

            String [] tokens = command.split("\\s+");

            if(tokens[2].equals("going!")){
                if(guests.contains(tokens[0])){
                    System.out.printf("%s is already in the list!%n",tokens[0]);
                }else{
                    guests.add(tokens[0]);
                }
            }else if(tokens[2].equals("not")){
                if(guests.contains(tokens[0])){
                    guests.remove(tokens[0]);
                }else{
                    System.out.printf("%s is not in the list!%n",tokens[0]);
                }
            }

        }

    }
}
