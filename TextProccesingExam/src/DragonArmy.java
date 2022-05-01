import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String,Map<String, List<Double>>> dragons = new LinkedHashMap<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String [] input = sc.nextLine().split(" ");
            String type = input[0];
            String name = input[1];
            double health = 250;
            double damage = 45;
            double armor = 10;

            if (!input[3].equals("null")) {
                health = Double.parseDouble(input[3]);
            }
            if (!input[2].equals("null")) {
                damage = Double.parseDouble(input[2]);
            }
            if (!input[4].equals("null")) {
                armor = Double.parseDouble(input[4]);
            }
            dragons.putIfAbsent(type, new TreeMap<>());
            double finalArmor = armor;
            double finalHealth = health;
            double finalDamage = damage;

            dragons.get(type).put(name, new ArrayList<>() {{
                add(0, finalDamage);
                add(1, finalHealth);
                add(2, finalArmor);
            }});

        }
        //"-{Name} -> damage: {damage}, health: {health}, armor: {armor}
        dragons.forEach((key1, value1) -> {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", key1,
                    value1.values().stream().map(doubles -> doubles.get(0)).mapToDouble(Double::doubleValue).average().orElseThrow(),
                    value1.values().stream().map(doubles -> doubles.get(1)).mapToDouble(Double::doubleValue).average().orElseThrow(),
                    value1.values().stream().map(doubles -> doubles.get(2)).mapToDouble(Double::doubleValue).average().orElseThrow());
            value1.forEach((key, value) -> System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n"
                    , key, value.get(0), value.get(1), value.get(2)));
        });

    }
}

