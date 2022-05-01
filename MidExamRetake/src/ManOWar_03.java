import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> pirateShip = Arrays.stream(sc.nextLine().split(">"))
                .collect(Collectors.toList());

        List<String> warShip = Arrays.stream(sc.nextLine().split(">"))
                .collect(Collectors.toList());

        int maxHealth = Integer.parseInt(sc.nextLine());

        double minHealth = maxHealth * 0.20;
        boolean isLos = false;

        String commands = sc.nextLine();


        while(!commands.equals("Retire")){
            String [] tokens = commands.split(" ");

            String indexZero = tokens[0];

            switch (indexZero){
                case "Fire":
                    int indexFirst = Integer.parseInt(tokens[1]);
                    int indexSecond = Integer.parseInt(tokens[2]);
                    if(!(indexFirst < 0) && !(indexFirst >= warShip.size())){
                        String currentNumber = warShip.get(indexFirst);
                        int number = Integer.parseInt(currentNumber);

                        if(!(number - indexSecond <= 0)){
                            number = number - indexSecond;
                            warShip.set(indexFirst,Integer.toString(number));
                        }else if(number - indexSecond == 0){
                            System.out.println("You won! The enemy ship has sunken.");
                            break;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    int damage = Integer.parseInt(tokens[3]);
                    if(!(startIndex < 0) && !(startIndex >= pirateShip.size()) &&
                            !(endIndex < 0) && !(endIndex >= pirateShip.size()))
                    for (int i = startIndex; i <= endIndex ; i++) {
                        String n = pirateShip.get(i);
                        int current = Integer.parseInt(n);
                        if(!(current - damage <= 0)){
                            current = current - damage;
                            pirateShip.set(i,Integer.toString(current));
                        }else{
                            System.out.println("You lost! The pirate ship has sunken.");
                            isLos = true;
                            break;
                        }
                    }

                    break;
                case "Repair":
                    int indexOne = Integer.parseInt(tokens[1]);
                    int indexTwo = Integer.parseInt(tokens[2]);
                    if(!(indexOne < 0) && !(indexOne >= pirateShip.size())){
                        String numberOfPirate = pirateShip.get(indexOne);
                        int ofPirate = Integer.parseInt(numberOfPirate);
                        if(!(ofPirate + indexTwo > maxHealth)){
                            ofPirate = ofPirate + indexTwo;
                            pirateShip.set(indexOne,Integer.toString(ofPirate));
                        }else{
                            pirateShip.set(indexOne,Integer.toString(maxHealth));
                        }
                    }
                    break;
                case "Status":
                    int count =0;
                    for (int i = 0; i < pirateShip.size(); i++) {
                        String element = pirateShip.get(i);
                        int elementToInt = Integer.parseInt(element);
                        if(elementToInt < minHealth){
                            count++;
                        }
                    }
                    System.out.println( count + " sections need repair.");
                    break;
            }

            commands = sc.nextLine();
        }
        int sum = 0;
        int sum1 = 0;
        for (String s : pirateShip) {
            sum +=Integer.parseInt(s);
        }
        for (String a : warShip) {
            sum1 += Integer.parseInt(a);
        }if(!isLos){
            System.out.println("Pirate ship status: " + sum );
            System.out.println("Warship status: " + sum1);
        }


        }

    }


