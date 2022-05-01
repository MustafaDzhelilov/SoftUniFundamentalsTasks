import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, Integer> plants = new HashMap<>();
        Map<String, List<Double>> ratings = new HashMap<>();


        for (int i = 0; i < n; i++) {
            String [] command = sc.nextLine().split("<->");
            String plant = command[0];
            int rarity = Integer.parseInt(command[1]);
            plants.compute(plant, (k, v) -> rarity);
            ratings.putIfAbsent(plant, new ArrayList<>());
        }
        String input = sc.nextLine();

        while (!input.equals("Exhibition")){
            String [] splitInput = input.split("\\s+-");
            String typeCom = splitInput[0];
            String [] splitTypeCom = typeCom.split(" ");
            String com = splitTypeCom[0];
            String plantType = splitTypeCom[1];

            if(!plants.containsKey(plantType)){
                System.out.println("error");
                continue;
            }

            switch (com){
                case "Rate:":
                    double raiting = Double.parseDouble(splitInput[1].trim());
                    ratings.get(plantType).add(raiting);
                    break;
                case "Update:":
                    int newRarity = Integer.parseInt(splitInput[1].trim());
                    plants.compute(plantType, (k, v) -> newRarity);
                    break;
                case "Reset:":
                    ratings.get(plantType).clear();
                    break;
                default:
                    System.out.println("error");

            }
            input = sc.nextLine();
        }
        System.out.println("Plants for the exhibition:");
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
