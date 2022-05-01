import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> input = Arrays.stream(sc.nextLine().split("\\s+"))
                        .collect(Collectors.toList());

        List<String> help = new ArrayList<>();

        String command = sc.nextLine();



        while(!command.equals("3:1")){

            String [] tokens = command.split("\\s+");

            switch (tokens[0]){
                case "merge":
                   /* if(Integer.parseInt(tokens[1]) < 0){
                        Integer.parseInt(tokens[1]) = 0;
                    }
                    if(Integer.parseInt(tokens[2]) > input.size() - 1){
                        Integer.parseInt(tokens[2]) = input.size() -1;
                    }*/
                    int startIndex = Integer.parseInt(tokens[1]);
                    for (int i = Integer.parseInt(tokens[1]); i < Integer.parseInt(tokens[2]) ; i++) {
                        String contact = input.get(startIndex) + input.get(startIndex + 1);
                        input.set(startIndex,contact);
                        input.remove(startIndex + 1);
                    }
                    break;
                case "divide":
                    break;
            }


            command = sc.nextLine();
        }
    }
}
