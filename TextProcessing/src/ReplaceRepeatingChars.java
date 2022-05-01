import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> input = Arrays.stream(sc.nextLine().split(""))
                        .collect(Collectors.toList());

        for (int i = 0; i < input.size(); i++) {
            if (i == input.size() - 1){
                break;
            }
            String symbol =  input.get(i);
            if(symbol.equals(input.get(i + 1))){
                input.remove(i + 1);
                i = -1 ;
            }
        }
        String toPrint = input.toString().replaceAll("[\\]\\[,]", "");
        toPrint = toPrint.replaceAll("\\s+","");
        System.out.println(toPrint);
    }
}
