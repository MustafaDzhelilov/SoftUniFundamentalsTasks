import java.util.*;

public class plDiscovery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, Integer> plants = new HashMap<>();
        Map<String, List<Double>> ratings = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("<->");
            String plant = input[0];
            int rarity = Integer.parseInt(input[1]);

            plants.put(plant, rarity);
            ratings.put(plant, new ArrayList<>());

        }
        String command = sc.nextLine();


        while (!command.equals("Exhibition")) {
            String[] tokens = command.split("\\s+| - ");
            String commandName = tokens[0];
            String commandPlant = tokens[1];

                switch (commandName) {
                    case "Rate:":
                        double reiting = Double.parseDouble(tokens[3]);
                            ratings.get(commandPlant).add(reiting);
                            break;

                            case "Update:":
                                int newRarity = Integer.parseInt(tokens[3]);
                                plants.compute(commandPlant, (k, v) -> newRarity);
                                break;
                            case "Reset:":
                               ratings.remove(commandPlant);
                                break;
                    default:
                        System.out.println("error");

                }
                command = sc.nextLine();

            }
            System.out.println("Plants for the exhibition:");

            //{plant_name}; Rarity: {rarity}; Rating: {average_rating formatted to the 2nd digit}
            // by rarity descending then by  average in descending

            plants.entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue()
                            .thenComparingDouble(x -> ratings.get(x.getKey()).stream()
                                    .mapToDouble(Double::doubleValue)
                                    .average().orElse(0.0))
                            .reversed())
                    .forEach(e -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", e.getKey(), e.getValue(),
                            ratings.get(e.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));
        }
    }

