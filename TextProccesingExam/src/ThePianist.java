import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());
        Map<String, List<String>> pieces = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String[] input = sc.nextLine().split("\\|");
            String onePiece = input[0];
            String composer = input[1];
            String key = input[2];

            pieces.put(onePiece,new ArrayList<>());
            pieces.get(onePiece).add(composer);
            pieces.get(onePiece).add(key);

        }
        String command = sc.nextLine();

        while (!command.equals("Stop")){
            String [] splitCommand = command.split("\\|");
            String typCommand = splitCommand[0];
            String piece = splitCommand[1];

            switch (typCommand){
                case "Add":
                    String composer = splitCommand[2];
                    String key = splitCommand[3];
                    if(pieces.containsKey(piece)){
                        System.out.println( piece +" is already in the collection!");
                    }else{
                        pieces.put(piece,new ArrayList<>());
                        pieces.get(piece).add(composer);
                        pieces.get(piece).add(key);
                        System.out.printf("%s by %s in %s added to the collection!%n",piece,composer,key);
                    }
                    break;
                case "Remove":
                    if (pieces.containsKey(piece)){
                        pieces.remove(piece);
                        System.out.printf("Successfully removed %s!%n",piece);
                    }else{
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = splitCommand[2];
                    if (pieces.containsKey(piece)){
                        pieces.get(piece).set(1,newKey);
                        System.out.printf("Changed the key of %s to %s!%n",piece,newKey);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                    }
                    break;
            }


            command = sc.nextLine();
        }
        pieces.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(kvp -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                        kvp.getKey(), kvp.getValue().get(0), kvp.getValue().get(1)));

    }
}
