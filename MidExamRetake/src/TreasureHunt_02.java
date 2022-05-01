import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> collection = Arrays.stream(sc.nextLine().split("\\|"))
                        .collect(Collectors.toList());

        String command = sc.nextLine();

        while (!command.equals("Yohoho!")){
            String [] tokens = command.split(" ");
            String zeroIndex = tokens[0];
            switch (zeroIndex){
                case "Loot":
                    /*for (int i = 1; i <= tokens.length -1; i++) {
                        boolean isTrue = false;
                        for ( int j = 0; j < collection.size(); j++) {
                            String currentItem = collection.get(j);
                            if(tokens[i].equals(currentItem)){
                                isTrue = true;
                                break;
                            }
                        }
                        if(!isTrue){
                            collection.add(0,tokens[i]);
                        }
                    }*/
                    for (int i = 1; i < tokens.length  ; i++) {
                        if(!collection.contains(tokens[i])){
                            collection.add(0,tokens[i]);
                        }
                    }

                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if(!(index < 0) && !(index >= collection.size())){
                        String currentItem = collection.get(index);
                        collection.remove(index);
                        collection.add(currentItem);
                }
                    break;
                case "Steal":
                    List<String> deletedItem = new ArrayList<>();
                    int index1 = Integer.parseInt(tokens[1]);
                    if(collection.size() - index1 == 0 || collection.size() - index1 > 0){
                        for (int i = 0; i < index1 ; i++) {
                            deletedItem.add(0,collection.get(collection.size() -1));
                            collection.remove((collection.size() -1));
                        }
                        String toPrint = deletedItem.toString().replaceAll("[\\]\\[,]", "");
                        toPrint = toPrint.replaceAll("\\s+", ", ");
                        System.out.println(toPrint);
                        break;
                    }else if(collection.size() - index1 < 0){
                        for (int i = 0; i < collection.size() ; i++) {
                            deletedItem.add(0,collection.get(collection.size() -1));
                            collection.remove((collection.size() -1));
                        }
                        String toPrint = deletedItem.toString().replaceAll("[\\]\\[,]", "");
                        toPrint = toPrint.replaceAll("\\s+", ", ");
                        System.out.println(toPrint);
                    }
                    break;
            }
            command = sc.nextLine();
        }
        if(collection.isEmpty()){
            System.out.println("Failed treasure hunt.");
        }else{
            int totalSizeOfLoot = 0;
            for (String s : collection) {
                totalSizeOfLoot += s.length();
            }
            double result = (double) totalSizeOfLoot / collection.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.",result);
        }
    }
}
