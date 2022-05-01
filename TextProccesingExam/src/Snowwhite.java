import java.util.*;

public class Snowwhite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> dwarfs = new LinkedHashMap<>();
        Map<String, Integer> count = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("Once upon a time")) {
            String[] temp = input.split(" <:> ");
            String name = temp[0];
            String color = temp[1];
            int physics = Integer.parseInt(temp[2]);

            String currentName = name + " " + color;


            if (!dwarfs.containsKey(currentName)) {
                dwarfs.putIfAbsent(currentName, 0);
                dwarfs.put(currentName, physics);
                count.putIfAbsent(color, 0);
                count.put(color, count.get(color) + 1);
            } else {
                if (dwarfs.get(currentName) < physics) {
                    dwarfs.put(currentName, physics);
                }
            }


            input = sc.nextLine();
        }

        dwarfs.entrySet().stream().sorted(
                (a, b) -> {
                    Integer first = a.getValue();
                    Integer second = b.getValue();

                    if (first.equals(second)) {
                        String firstKey = a.getKey();
                        String secondKey = b.getKey();

                        String firstColor = firstKey.split(" ")[1];
                        String secondColor = secondKey.split(" ")[1];

                        Integer firstCount = count.get(firstColor);
                        Integer secondCount = count.get(secondColor);

                        return Integer.compare(secondCount, firstCount);

                    }

                    return Integer.compare(second, first);
                }
        ).forEach(e -> {
            String[] colorAndName = e.getKey().split(" ");
            Integer physics = e.getValue();
            System.out.printf("(%s) %s <-> %d%n", colorAndName[1], colorAndName[0], physics);
        });







    }
}
