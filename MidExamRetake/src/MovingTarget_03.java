import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int currentIndexOfStrike = 0;

        String command = sc.nextLine();

        while (!command.equals("End")){
            String [] tokens = command.split(" ");

            switch (tokens[0]){
                case "Shoot":
                    if(Integer.parseInt(tokens[1]) > -1 && Integer.parseInt(tokens[1]) <= numbers.size()){
                        int numberAtIndex  = numbers.get(Integer.parseInt(tokens[1]));
                        numberAtIndex = numberAtIndex - Integer.parseInt(tokens[2]);
                        numbers.set(Integer.parseInt(tokens[1]),numberAtIndex);
                        int afterManipulation = numbers.get(Integer.parseInt(tokens[1]));
                        if(afterManipulation == 0 || afterManipulation < 0){
                            numbers.remove(Integer.parseInt(tokens[1]));
                        }
                    }
                    break;
                case "Add":
                    if(Integer.parseInt(tokens[1]) > -1 && Integer.parseInt(tokens[1]) < numbers.size()){
                        numbers.add(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]));
                    }else{
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    currentIndexOfStrike = numbers.get(Integer.parseInt(tokens[1]));
                    if(Integer.parseInt(tokens[1]) > -1 && Integer.parseInt(tokens[1]) <= numbers.size()){
                       if(Integer.parseInt(tokens[1]) - Integer.parseInt(tokens[2]) < 0
                               || Integer.parseInt(tokens[1]) - Integer.parseInt(tokens[2]) > numbers.size()){
                           System.out.println("Strike missed!");
                           break;
                    }else{
                           int before = numbers.get(Integer.parseInt(tokens[1]) - Integer.parseInt(tokens[2]));
                           int after = numbers.get(Integer.parseInt(tokens[1]) + Integer.parseInt(tokens[2]));
                           numbers.remove(Integer.valueOf(before));
                           numbers.remove(Integer.valueOf(after));
                           numbers.remove(Integer.valueOf(currentIndexOfStrike));
                       }

                       }

                    break;
            }
            command = sc.nextLine();
        }
        String toPrint = numbers.toString().replaceAll("[\\]\\[,]", "");
        toPrint = toPrint.replaceAll("\\s+","|");
        System.out.println(toPrint);

    }
}

