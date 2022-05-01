import java.util.*;

public class NeedForSpeed2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, Integer> km = new TreeMap<>();
        Map<String, Integer> diesel = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String [] input = sc.nextLine().split("\\|");
            String car = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);
            km.put(car, mileage);
            diesel.put(car, fuel);
        }

        String command = sc.nextLine();

        while (!command.equals("Stop")){
            String [] tokens = command.split(" : ");
            String commandName = tokens[0];
            String carName = tokens[1];

            switch (commandName){
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int benzin = Integer.parseInt(tokens[3]);
                    int currentFuel = diesel.get(carName);

                    if(currentFuel >= benzin){
                        currentFuel = currentFuel -benzin;
                        int currentKm = km.get(carName);
                        currentKm = currentKm + distance;
                        diesel.put(carName, currentFuel);
                        km.put(carName, currentKm);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",carName, distance, benzin);
                    }else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    // Ако достигне 100 000 хил. км
                    int currentDistance = km.get(carName);
                    if((currentDistance) >= 100000){
                        System.out.printf("Time to sell the %s!%n",carName);
                        km.remove(carName);
                        diesel.remove(carName);
                    }
                    break;
                case "Refuel":
                    int benz = Integer.parseInt(tokens[2]);
                    int currentBenz = diesel.get(carName);

                    if((currentBenz + benz) > 75){
                        System.out.printf("%s refueled with %d liters%n",carName, 75 - currentBenz);
                        currentBenz = 75;
                        diesel.put(carName, currentBenz);
                    }else{
                        diesel.put(carName, currentBenz + benz);
                        System.out.printf("%s refueled with %d liters%n",carName, benz);
                    }
                    break;
                case "Revert":
                    int kilometars = Integer.parseInt(tokens[2]);
                    int currentKilometars = km.get(carName);
                    currentKilometars = currentKilometars - kilometars;

                    if(currentKilometars < 10000){
                        currentKilometars = 10000;
                        km.put(carName, currentKilometars);
                        break;
                    }
                    System.out.printf("%s mileage decreased by %d kilometers%n",carName, kilometars);
                    int revertKm = km.get(carName) - kilometars;
                    km.put(carName, revertKm);
                    break;

            }

            command = sc.nextLine();
        }
        //"{car} -> Mileage: {mileage} kms, Fuel in the tank: {fuel} lt."  -> by mileage

        km.entrySet().stream().sorted((h1, h2) -> Integer.compare(h2.getValue(), h1.getValue()))
                .forEach(car ->{
                    String nameCar = car.getKey();
                    System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", nameCar,car.getValue(),diesel.get(nameCar));
                });

    }
}
