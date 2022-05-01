import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvance_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        while(true){

            String line = sc.nextLine();

            if(line.equals("end")){
                break;
            }

            String [] token = line.split("\\s+");

            switch (token[0]){
                case "Contains":
                    if(numbers.contains(Integer.parseInt(token[1]))) {
                        System.out.println("Yes");
                    }else{
                        System.out.println("No such number");
                    }
                    break;

                case "Print":
                    if(token[1].equals("even")){
                        for (int i = 0; i < numbers.size(); i++) {
                            int number = numbers.get(i);
                            if(number % 2 == 0){
                                System.out.print(number + " ");
                            }
                        }

                    }else if(token[1].equals("odd")){
                        System.out.println();
                        for (int i = 0; i < numbers.size(); i++) {
                            int number = numbers.get(i);
                            if(number % 2 == 1){
                                System.out.print(number + " ");
                            }
                        }

                    }
                    break;

                case "Get":
                    System.out.println();
                    int sum =0;
                    for (int i = 0; i < numbers.size() ; i++) {
                        int result = numbers.get(i);
                        sum += result;
                    }
                    System.out.println(sum);
                    break;

                case "Filter":
                    if(token[1].equals(">=")){
                        for (int i = 0; i < numbers.size(); i++) {
                            int number = numbers.get(i);
                            if(number >= Integer.parseInt(token[2])){
                                System.out.print(number + " ");
                            }

                        }

                    }else if(token[1].equals(">")){
                        System.out.println();
                        for (int i = 0; i < numbers.size(); i++) {
                            int number = numbers.get(i);
                            if(number > Integer.parseInt(token[2])){
                                System.out.print(number + " ");
                            }

                        }

                    }else if(token[1].equals("<")){
                        System.out.println();
                        for (int i = 0; i < numbers.size(); i++) {
                            int number = numbers.get(i);
                            if(number < Integer.parseInt(token[2])){
                                System.out.print(number + " ");
                            }

                        }

                    }else if(token[1].equals("<=")) {
                        System.out.println();
                        for (int i = 0; i < numbers.size(); i++) {
                            int number = numbers.get(i);
                            if(number <= Integer.parseInt(token[2])){
                                System.out.print(number + " ");
                            }

                        }

                    }
            }

        }

    }
}

