import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String regex = "(\\||#)(?<item>[A-Za-z ]+)\\1(?<date>[\\d]{2,2}[\\/][\\d]{2,2}[\\/][\\d]{2,2})\\1(?<calories>[\\d]+)\\1";
        Pattern pattern = Pattern.compile(regex);
        String input = sc.nextLine();
        Matcher matcher = pattern.matcher(input);
        List<String> date = new ArrayList<>();
        List<String> items = new ArrayList<>();
        List<Integer> calories = new ArrayList<>();
        int sumOfAllCalories = 0;

        while (matcher.find()){
            items.add(matcher.group("item"));
            date.add(matcher.group("date"));
            calories.add(Integer.parseInt(matcher.group("calories")));
            sumOfAllCalories += Integer.parseInt(matcher.group("calories"));
        }
        int forDay = sumOfAllCalories / 2000;
        System.out.println("You have food to last you for: " + forDay + " days!");

        for (int i = 0; i < items.size(); i++) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n",items.get(i),date.get(i),calories.get(i));
        }


    }
}
