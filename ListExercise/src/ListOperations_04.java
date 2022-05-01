import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String commands = sc.nextLine();

        while (!commands.equals("End")){
            String [] tokens = commands.split("\\s+");
            switch (tokens[0]){
                case "Add":
                    numbers.add(Integer.parseInt(tokens[1]));
                    break;
                case "Insert":
                    if(Integer.parseInt(tokens[2]) > numbers.size() -1  || Integer.parseInt(tokens[2]) < 0){
                        System.out.println("Invalid index");
                    }else {
                        numbers.add(Integer.parseInt(tokens[2]),Integer.parseInt(tokens[1]));
                    }
                    break;
                case "Remove":
                    if(Integer.parseInt(tokens[1]) <= numbers.size() - 1){
                        numbers.remove(Integer.parseInt(tokens[1]));
                    }else{
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    if(tokens[1].equals("left")){
                        for (int i = 0; i < Integer.parseInt(tokens[2]); i++) {
                            numbers.add(numbers.get(0));
                            numbers.remove(numbers.get(0));
                        }
                    }else if(tokens[1].equals("right")){
                        for (int i = 0; i < Integer.parseInt(tokens[2]); i++) {
                            numbers.add(0,numbers.get(numbers.size() - 1));
                            numbers.remove(numbers.size() - 1);
                        }
                    }
                    break;
            }
            commands = sc.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}

