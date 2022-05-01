import java.util.*;

public class discoveryPlant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, Integer> plant = new HashMap<>();
        Map<String, List<Double>> ratings = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("<->");
            String plantName = input[0];
            int plantRarity = Integer.parseInt(input[1]);
            plant.putIfAbsent(plantName, plantRarity);
            if (plant.containsKey(plantName)) {
                plant.put(plantName, plantRarity);
            }
        }

            String command = sc.nextLine();

            while (!command.equals("Exhibition")){
                String [] tokens = command.split(" | - ");
                String commandName = tokens[0].trim();
                String namePlant = tokens[1].trim();

                switch (commandName){
                    case "Rate:":
                        int raiting = Integer.parseInt(tokens[3]);

                        break;
                    case "Update:":
                        int newRarity = Integer.parseInt(tokens[3]);
                        break;
                    case "Reset:":
                        break;
                }


                command = sc.nextLine();
            }
            System.out.println();

    }
}
