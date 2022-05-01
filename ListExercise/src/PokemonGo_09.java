import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonGo_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                        .map(Integer::parseInt).collect(Collectors.toList());

        int index = Integer.parseInt(sc.nextLine());

        int sum = 0;
        int deletedNumber = 0;

        while (!numbers.isEmpty()){
            if(index >= 0 && index <= numbers.size() - 1) {
                deletedNumber = numbers.get(index);
                numbers.remove(index);
                sum += deletedNumber;
                for (int i = 0; i < numbers.size(); i++) {
                    int eachNumber = numbers.get(i);
                    if(eachNumber > deletedNumber){
                        eachNumber = eachNumber - deletedNumber;
                        numbers.set(i,eachNumber);
                    }else if(eachNumber < deletedNumber){
                        eachNumber = eachNumber + deletedNumber;
                        numbers.set(i,eachNumber);
                    }else{
                        eachNumber = eachNumber + deletedNumber;
                        numbers.set(i,eachNumber);
                    }

                }


            }else if(index < 0){
                index = 0;
                deletedNumber = numbers.get(index);
                numbers.remove(index);
                sum += deletedNumber;
                int lastNumber = numbers.get(numbers.size() - 1);
                for (int i = 0; i < numbers.size(); i++) {
                    int eachNumber = numbers.get(i);
                    if(eachNumber > deletedNumber){
                        eachNumber = eachNumber - deletedNumber;
                        numbers.set(i,eachNumber);
                    }else if(eachNumber < deletedNumber){
                        eachNumber = eachNumber + deletedNumber;
                        numbers.set(i,eachNumber);
                    }else{
                        eachNumber = eachNumber + deletedNumber;
                        numbers.set(i,eachNumber);
                    }
                }
                numbers.add(0,lastNumber);

            }else if(index > numbers.size() -1){
                index = numbers.size() - 1;
                deletedNumber = numbers.get(index);
                numbers.remove(index);
                sum += deletedNumber;
                for (int i = 0; i < numbers.size(); i++) {
                    int eachNumber = numbers.get(i);
                    if(eachNumber > deletedNumber){
                        eachNumber = eachNumber - deletedNumber;
                        numbers.set(i,eachNumber);
                    }else if(eachNumber < deletedNumber){
                        eachNumber = eachNumber + deletedNumber;
                        numbers.set(i,eachNumber);
                    }else{
                        eachNumber = eachNumber + deletedNumber;
                        numbers.set(i,eachNumber);
                    }
                }
                numbers.add(numbers.get(0));
            }

            if(numbers.isEmpty()){
                break;
            }

            index = Integer.parseInt(sc.nextLine());
        }
        System.out.println(sum);
    }
}
