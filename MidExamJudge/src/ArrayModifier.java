import java.util.*;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());

        String command = sc.nextLine();

        while (!command.equals("end")){
            String [] tokens = command.split(" ");
            switch (tokens[0]){
                case "swap":
                    int firstElement = Integer.parseInt(tokens[1]);
                    int secondElement = Integer.parseInt(tokens[2]);
                    int one = numbers.get(firstElement);
                    int two = numbers.get(secondElement);
                    numbers.set(firstElement,two);
                    numbers.set(secondElement,one);
                    break;
                case "multiply":
                    int fndex = Integer.parseInt(tokens[1]);
                    int sIndex = Integer.parseInt(tokens[2]);
                    int firstNumber = numbers.get(fndex);
                    int secondNumber = numbers.get(sIndex);
                    int sumBetweenThem = firstNumber * secondNumber;
                    numbers.set(fndex,sumBetweenThem);
                    break;
                case "decrease":
                    List<Integer> help = new ArrayList<>();
                    for (int i = 0; i < numbers.size(); i++) {
                        int n = numbers.get(i);
                        n = n - 1;
                        help.add(n);
                    }
                    numbers.removeAll(numbers);
                        for (int j = 0; j < help.size(); j++) {
                            int m = help.get(j);
                            numbers.add(m);
                        }
                        help.removeAll(help);
                    break;
            }
            command = sc.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
    }
}
