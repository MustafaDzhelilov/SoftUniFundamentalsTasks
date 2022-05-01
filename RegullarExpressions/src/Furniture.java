import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>[0-9]+.?[0-9]*)!(?<quantity>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        String input = sc.nextLine();

        double sum = 0;
        List<String> mebeli = new ArrayList<>();

        while (!input.equals("Purchase")){
            Matcher matcher = pattern.matcher(input);

            if(matcher.find()){
                String furniture = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                mebeli.add(furniture);
                sum += price * quantity;

            }
            input = sc.nextLine();
        }
        System.out.println("Bought furniture:");
        mebeli.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", sum);
    }
}
