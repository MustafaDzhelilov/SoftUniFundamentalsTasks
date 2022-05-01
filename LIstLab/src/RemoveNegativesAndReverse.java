import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                        .map(Integer::parseInt).collect(Collectors.toList());

            numbers.removeIf(number -> number < 0);
            Collections.reverse(numbers);
            if(numbers.isEmpty()){
                System.out.println("empty");
            }else {
                System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
            }
    }
}
