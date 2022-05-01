import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int maxCount = Integer.parseInt(sc.nextLine());

        String input = sc.nextLine();

        while (!input.equals("end")) {

            String[] tokens = input.split("\\s+");

            if (tokens[0].equals("Add")) {
                numbers.add(Integer.parseInt(tokens[1]));
            } else {
                for (int i = 0; i < numbers.size(); i++) {
                    int n = numbers.get(i);
                    if ((n + Integer.parseInt(tokens[0]) <= maxCount)) {
                        numbers.set(i, n + Integer.parseInt(tokens[0]));
                        break;
                    }
                }
            }
            input = sc.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}








