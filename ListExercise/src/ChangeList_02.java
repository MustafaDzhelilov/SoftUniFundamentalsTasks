import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                        .map(Integer::parseInt).collect(Collectors.toList());

        String input = sc.nextLine();

        while (!input.equals("end")){

            String [] array = input.split("\\s+");

            switch (array[0]){
                case "Delete":
                    numbers.removeAll(Arrays.asList(Integer.parseInt(array[1])));
                    break;
                case "Insert":
                    numbers.add(Integer.parseInt(array[2]),Integer.parseInt(array[1]));
                    break;
            }
                input = sc.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
