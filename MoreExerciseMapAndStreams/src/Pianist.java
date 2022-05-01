import java.util.*;

public class Pianist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //{piece}|{composer}|{key}
        //   key        pieces -> 0, composer -> 1
        Map<String, List<String>> all = new TreeMap<>();


        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String [] input = sc.nextLine().split("\\|");
            String piece = input[0];
            String composer = input[1];
            String key = input[2];

           all.putIfAbsent(piece, new ArrayList<>());
           all.get(piece).add(0, composer);
           all.get(piece).add(1, key);
        }

        String command = sc.nextLine();

        while (!command.equals("Stop")){
            String [] tokens = command.split("\\|");
            String commandType = tokens[0];
            String pieces = tokens[1];

            switch (commandType){
                case "Add":
                    String givenComposer = tokens[2];
                    String givenKey = tokens[3];
                    if(!all.containsKey(pieces)){
                        all.put(pieces, new ArrayList<>());
                        all.get(pieces).add(0, givenComposer);
                        all.get(pieces).add(1, givenKey);
                        System.out.printf("%s by %s in %s added to the collection!%n",pieces, givenComposer, givenKey);
                    }else {
                        System.out.printf("%s is already in the collection!%n",pieces);
                    }
                    break;
                case "Remove":
                    if(!all.containsKey(pieces)){
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",pieces);
                    }else{
                        all.remove(pieces);
                        System.out.printf("Successfully removed %s!%n",pieces);
                    }
                    break;
                case "ChangeKey":
                    String newKey = tokens[2];
                    if(all.containsKey(pieces)){
                        all.get(pieces).set(1, newKey);
                        System.out.printf("Changed the key of %s to %s!%n",pieces,newKey);
                    }else{
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",pieces);
                    }
                    break;
            }

            command = sc.nextLine();
        }
       // "{Piece} -> Composer: {composer}, Key: {key}
        all.entrySet()
                .forEach(a -> {
                    System.out.printf("%s -> Composer: %s, Key: %s%n",a.getKey(), a.getValue().get(0), a.getValue().get(1));
                });
    }
}
