import javax.imageio.plugins.tiff.ExifInteroperabilityTagSet;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Urgent {item} - add the item at the start of the list
        //Unnecessary {item} - remove the item with the given name, only if it exists in the list. Otherwise skip this command.
        //Correct {oldItem} {newItem}
        //Rearrange {item}

        List<String> list = Arrays.stream(sc.nextLine().split("!"))
                        .collect(Collectors.toList());

        String command = sc.nextLine();

        while(!command.equals("Go Shopping!")){
            String [] tokens = command.split(" ");

            switch (tokens[0]){
                case "Urgent":
                    if(list.contains(tokens[1])){
                    }else{
                        list.remove(tokens[1]);
                        list.add(0,tokens[1]);
                    }
                    break;
                case "Unnecessary":
                    if(!list.contains(tokens[1])){
                    }else{
                        list.remove(tokens[1]);
                    }
                    break;
                case "Correct":
                    String oldItem = tokens[1];
                    String newItem = tokens[2];
                    int indexOfOldItem = list.indexOf(oldItem);
                    if(!list.contains(tokens[1])){
                    }else{
                        list.set(indexOfOldItem,newItem);
                    }
                    break;
                case "Rearrange":
                    if(list.contains(tokens[1])) {
                        String item = tokens[1];
                        list.remove(tokens[1]);
                        list.add(item);
                    }
                    break;
            }

            command = sc.nextLine();
        }
        String toPrint = String.join(", ",list);
        System.out.println(toPrint);

    }
}
