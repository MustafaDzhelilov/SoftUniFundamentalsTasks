import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());

        double average = 0;
        double sum = 0;
        int count = 0;
        List<Integer> numbersGreaterFromAverage = new ArrayList<>();


        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        average = sum / numbers.size();

        for (int j = 0; j < numbers.size(); j++) {
            int number = numbers.get(j);
            if(number > average) {
                count++;
                numbersGreaterFromAverage.add(number);
            }
        }
        if(numbersGreaterFromAverage.size() > 5) {
            while (numbersGreaterFromAverage.size() != 5) {
                int min = Collections.min(numbersGreaterFromAverage);
                numbersGreaterFromAverage.remove(Integer.valueOf(min));
            }
        }
        if(count == 0){
            System.out.println("No");
        }
        Collections.sort(numbersGreaterFromAverage,Collections.reverseOrder());
        String toPrint = numbersGreaterFromAverage.toString().replaceAll("[\\]\\[,]", "");
        toPrint = toPrint.replaceAll("\\s+"," ");
        System.out.println(toPrint);
    }
}
