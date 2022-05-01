import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exam_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> input = Arrays.stream(sc.nextLine().split("\\|"))
                        .collect(Collectors.toList());

        String command = sc.nextLine();

        while (!command.equals("Done")){
            String [] tokens = command.split(" ");
            String indexZero = tokens[0];
            switch (indexZero){
                case "Move":
                    String side = tokens[1];
                    int currentIndex = Integer.parseInt(tokens[2]);
                    if(side.equals("Right")){
                        if(!(currentIndex < 0) && !(currentIndex >= input.size())){
                            if(currentIndex + 1 < input.size()){
                                String currentString = input.get(currentIndex);
                                input.remove(currentIndex);
                                input.add(currentIndex + 1,currentString);
                            }
                        }

                    }else if(side.equals("Left")){
                        if(!(currentIndex < 0) && !(currentIndex >= input.size())){
                            if(currentIndex -1 >= 0){
                                String current = input.get(currentIndex);
                                input.remove(currentIndex);
                                input.add(currentIndex - 1,current);
                            }
                        }

                    }

                    break;
               case "Check":
                    List<String> help = new ArrayList<>();
                    String position = tokens[1];
                    if(position.equals("Even")){
                        for (int i = 0; i < input.size(); i++) {
                            if(i % 2 == 0){
                                String hp = input.get(i);
                                help.add(hp);
                            }
                        }
                        String toPrint = help.toString().replaceAll("[\\]\\[,]", "");
                        toPrint = toPrint.replaceAll("\\s+", " ");
                        System.out.println(toPrint);

                    }else if(position.equals("Odd")){
                        for (int i = 0; i < input.size(); i++) {
                            if(i % 2 != 0){
                                String hp = input.get(i);
                                help.add(hp);
                            }
                        }
                        String toPrint = help.toString().replaceAll("[\\]\\[,]", "");
                        toPrint = toPrint.replaceAll("\\s+", " ");
                        System.out.println(toPrint);
                    }

                    break;
            }

            command = sc.nextLine();
        }
        String toPrint = input.toString().replaceAll("[\\]\\[,]", "");
        toPrint = toPrint.replaceAll("\\s+", "");
        System.out.println("You crafted " + toPrint + "!");
    }
}
