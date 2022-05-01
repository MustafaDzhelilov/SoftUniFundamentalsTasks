import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                        .map(Integer::parseInt).collect(Collectors.toList());

        String specialBombNumber = sc.nextLine();

        String [] tokens = specialBombNumber.split("\\s+");

        int indexOfBomb = numbers.indexOf(Integer.parseInt(tokens[0])); // index of bomb number

        for (int i = 1; i <= Integer.parseInt(tokens[1]); i++) {
            if( indexOfBomb - i < 0){

            }else {
                numbers.remove(indexOfBomb - i);
            }
        }
        indexOfBomb = numbers.indexOf(Integer.parseInt(tokens[0]));
            int count = 0;
        for (int i = 1; i <= Integer.parseInt(tokens[1]); i++) {
            count++;
            if(count > Integer.parseInt(tokens[1])){
                continue;
            }
            if(indexOfBomb + i > numbers.size() - 1){
            }else {
                numbers.remove(indexOfBomb + i);
                i= 0;
            }
        }
        numbers.remove(indexOfBomb);
        // if sequence have a two bomb numbers
        if(numbers.contains(Integer.parseInt(tokens[0]))){
            indexOfBomb = numbers.indexOf(Integer.parseInt(tokens[0]));
            for (int i = 1; i <= Integer.parseInt(tokens[1]); i++) {
                if( indexOfBomb - i < 0){

                }else {
                    numbers.remove(indexOfBomb - i);
                }
            }

            indexOfBomb = numbers.indexOf(Integer.parseInt(tokens[0]));
            int c = 0;
            for (int i = 1; i <= Integer.parseInt(tokens[1]); i++) {
                c++;
                if(c > Integer.parseInt(tokens[1])){
                    continue;
                }
                if(indexOfBomb + i > numbers.size()){

                }else {
                    numbers.remove(indexOfBomb + i);
                    i = 0;
                }
            }
            numbers.remove(indexOfBomb);
        }

        int sum = 0;
        for (Integer token : numbers) {
            sum +=token;
        }
        System.out.println(sum);

    }
}
