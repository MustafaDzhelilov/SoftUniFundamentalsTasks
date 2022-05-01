import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> numbers = Arrays.stream(sc.nextLine().split("\\|"))
                        .collect(Collectors.toList());
        Collections.reverse(numbers);
        String toPrint = numbers.toString().replaceAll("[\\]\\[,]", "");
        toPrint = toPrint.replaceAll("\\s+"," ");
        System.out.println(toPrint);
    }
}
