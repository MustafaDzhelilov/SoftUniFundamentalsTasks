import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> plantRarity = new TreeMap<>();
        Map<String, List<Double>> plantReytings = new TreeMap<>();

        int n = Integer.parseInt(sc.nextLine());
        boolean isTrue = false;

        for (int i = 0; i < n; i++) {
            String [] input = sc.nextLine().split("<->");
            String plant = input[0];
            int rarity = Integer.parseInt(input[1]);

            if(!plantRarity.containsKey(plant)){
                plantRarity.put(plant, rarity);
                plantReytings.put(plant, new ArrayList<>());
            }else{
                plantRarity.put(plant,rarity);
            }
        }

        String command = sc.nextLine();

        while (!command.equals("Exhibition")){
            String [] tokens = command.split(" ");
            String commandType = tokens[0];
            String plantName = tokens[1];

            switch (commandType) {
                case "Rate:":
                        double reytings = Integer.parseInt(tokens[3]);
                        if (plantRarity.containsKey(plantName) && plantReytings.containsKey(plantName)) {
                            plantReytings.get(plantName).add(reytings);
                        }else{
                            System.out.println("error");
                            isTrue = true;
                            break;
                        }

                    break;
                case "Update:":

                        int newRarity = Integer.parseInt(tokens[3]);
                        if (plantRarity.containsKey(plantName)) {
                            plantRarity.put(plantName, newRarity);
                        }else{
                            System.out.println("error");
                            isTrue = true;
                            break;
                        }

                    break;
                case "Reset:":

                        if (plantRarity.containsKey(plantName) && plantReytings.containsKey(plantName)) {
                            plantReytings.remove(plantName);
                            plantReytings.put(plantName, new ArrayList<>());
                            plantReytings.get(plantName).add(0.0);
                        }else{
                            System.out.println("error");
                            isTrue = true;
                            break;
                        }

                    break;

                default:
                    System.out.println("error");
                    isTrue = true;
            }

            command = sc.nextLine();

        }
        if(!isTrue) {
            System.out.println("Plants for the exhibition:");


            //- {plant_name}; Rarity: {rarity}; Rating: {average_rating formatted to the 2nd digit}

            plantRarity.entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue()
                            .thenComparingDouble(x -> plantReytings.get(x.getKey()).stream()
                                    .mapToDouble(Double::doubleValue)
                                    .average().orElse(0.0))
                            .reversed())
                    .forEach(e -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", e.getKey(), e.getValue(),
                            plantReytings.get(e.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));

        }

    }
}
