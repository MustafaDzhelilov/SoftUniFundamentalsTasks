import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> participants = Arrays.stream(sc.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = sc.nextLine();

        String regexName = "[A-Za-z]+";
        String regexDigits = "[0-9]";
        Pattern pattern = Pattern.compile(regexName);
        Pattern pattern1 = Pattern.compile(regexDigits);

        Map<String, Integer> allCheck = new TreeMap<>();
        List<String> names = new ArrayList<>();
       StringBuilder name = new StringBuilder();
        String digits = "";
        String nameToString = "";

        while (!input.equals("end of race")){
            int sum = 0;

            Matcher matcher = pattern.matcher(input);
            Matcher matcher1 = pattern1.matcher(input);

            while(matcher.find()){
                name.append(matcher.group());
            }
            nameToString = name.toString();
            name.delete(0, name.length());
            while (matcher1.find()){
                digits = matcher1.group();
                sum += Integer.parseInt(digits);
            }

                if (participants.contains(nameToString)) {
                    if (!names.contains(nameToString)) {
                        allCheck.put(nameToString, sum);
                        names.add(nameToString);
                    } else if (names.contains(nameToString)) {
                        sum = allCheck.get(nameToString) + sum;
                        allCheck.put(nameToString, sum);
                    }
                }

            input = sc.nextLine();
        }
        List<String> firstThree = allCheck.entrySet().stream()
                    .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                    .limit(3)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

        System.out.println("1st place: " + firstThree.get(0));
        System.out.println("2nd place: " + firstThree.get(1));
        System.out.println("3rd place: " + firstThree.get(2));

    }
}
