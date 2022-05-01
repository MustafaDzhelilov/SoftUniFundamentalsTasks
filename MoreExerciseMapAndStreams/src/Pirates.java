import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<Integer>> citiesInfo = new TreeMap<>();

        String input = sc.nextLine();

        while (!input.equals("Sail")){
            String [] inputSplit = input.split("\\|\\|");
            String city = inputSplit[0];
            int citizen = Integer.parseInt(inputSplit[1]);
            int gold = Integer.parseInt(inputSplit[2]);

            if(citiesInfo.containsKey(city)){
                int crGold = citiesInfo.get(city).get(1);
                int crPeople = citiesInfo.get(city).get(0);
                citiesInfo.get(city).set(0, crPeople + citizen);
                citiesInfo.get(city).set(1, crGold + gold);
            }else{
                citiesInfo.put(city, new ArrayList<>());
                citiesInfo.get(city).add(0,citizen);
                citiesInfo.get(city).add(1, gold);
            }

            input = sc.nextLine();
        }

        String command = sc.nextLine();

        while (!command.equals("End")){
            String [] tokens = command.split("=>");
            String commandName = tokens[0];
            String town = tokens[1];

            switch (commandName){
                case "Plunder":
                    int people = Integer.parseInt(tokens[2]);
                    int golD = Integer.parseInt(tokens[3]);
                    int currentPeople = citiesInfo.get(town).get(0);
                    int currentGold = citiesInfo.get(town).get(1);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",town, golD, people);
                    if((currentPeople - people <= 0) || (currentGold - golD <= 0)){
                        citiesInfo.remove(town);
                        System.out.printf("%s has been wiped off the map!%n",town);
                    }else{
                        citiesInfo.get(town).set(0, currentPeople - people);
                        citiesInfo.get(town).set(1, currentGold - golD);
                    }
                    break;
                case "Prosper":
                    int givenGold = Integer.parseInt(tokens[2]);
                    if(givenGold < 0){
                        System.out.printf("Gold added cannot be a negative number!%n");
                        break;
                    }else{
                        int currentGoldAmount = citiesInfo.get(town).get(1);
                        currentGoldAmount = currentGoldAmount + givenGold;
                        citiesInfo.get(town).set(1,currentGoldAmount);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",givenGold,town,currentGoldAmount);
                    }
                    break;
            }

            command = sc.nextLine();
        }
        int count = citiesInfo.size();
        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",count);

        //{town1} -> Population: {people} citizens, Gold: {gold} kg

        citiesInfo.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().get(1).compareTo(a.getValue().get(1)))
                .forEach(pair -> {
                    System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",pair.getKey(), pair.getValue().get(0), pair.getValue().get(1));
                });
    }
}
