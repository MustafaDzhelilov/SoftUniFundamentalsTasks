import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Collect - {item}"
        //Drop - {item}"
        //Combine Items - {oldItem}:{newItem}"
        //Renew – {item}"

        List<String> collecting = Arrays.stream(sc.nextLine().split(", "))
                        .collect(Collectors.toList());

        String command = sc.nextLine();

        while (!command.equals("Craft!")){
            String [] tokens = command.split(" - ");
            switch (tokens[0]){
                case "Collect":
                    if(!collecting.contains(tokens[1])){
                        collecting.add(tokens[1]);
                    }
                    break;
                case "Drop":
                    if(!collecting.contains(tokens[1])){
                    }else{
                        collecting.remove(tokens[1]);
                    }
                    break;
                case "Combine Items":
                    String [] items = tokens[1].split(":");
                    String newItem = items[1];
                    String oldItem = items[0];
                    if(collecting.contains(items[0])){
                        int index = collecting.indexOf(items[0]);
                        collecting.add(index + 1,newItem);
                    }
                    break;
                case "Renew":
                    if(collecting.contains(tokens[1])){
                        int index = collecting.indexOf(tokens[1]);
                        collecting.add(collecting.size(),tokens[1] );
                        collecting.remove(index);
                    }
                    break;
            }
            command = sc.nextLine();
        }
        String toPrint = String.join(", ",collecting);
        System.out.println(toPrint);

    }
}
