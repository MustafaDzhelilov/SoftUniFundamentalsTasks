import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HereosOfCodes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, Integer> hp = new TreeMap<>();
        Map<String, Integer> mp = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String []hero = sc.nextLine().split(" ");
            String heroName = hero[0];
            int hpHereos = Integer.parseInt(hero[1]);
            int mpHereos = Integer.parseInt(hero[2]);

            hp.put(heroName, hpHereos);
            mp.put(heroName, mpHereos);
        }

        String command = sc.nextLine();

        while (!command.equals("End")){
            String [] tokens = command.split(" - ");
            String commandName = tokens[0];
            String hero = tokens[1];

            switch (commandName){
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];

                    int currentMp = mp.get(hero);
                    if(currentMp >= mpNeeded){
                        int leftMp = currentMp - mpNeeded;
                        mp.put(hero, leftMp);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",hero, spellName, mp.get(hero));
                    }else{
                        System.out.printf("%s does not have enough MP to cast %s!%n",hero, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    int currentHp = hp.get(hero) -damage;

                    if(currentHp > 0){
                        hp.put(hero, currentHp);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", hero, damage, attacker, currentHp);
                    }else if (currentHp < 0){
                        hp.remove(hero);
                        mp.remove(hero);
                        System.out.printf("%s has been killed by %s!%n", hero, attacker);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(tokens[2]);
                    int currMp = mp.get(hero);
                    int increaseMp = currMp + amount;
                    if(increaseMp > 200){
                        increaseMp = 200;
                    }
                    mp.put(hero, increaseMp);
                    System.out.printf("%s recharged for %d MP!%n", hero, increaseMp - currMp);

                    break;
                case "Heal":
                    int amountHp = Integer.parseInt(tokens[2]);
                    int currHp = hp.get(hero);
                    int increaseHp = currHp + amountHp;
                    if(increaseHp > 100) {
                        increaseHp = 100;
                    }
                    hp.put(hero, increaseHp);
                    System.out.printf("%s healed for %d HP!%n", hero, increaseHp - currHp);

                    break;
            }
            command = sc.nextLine();
        }

        //"{hero name}
        // HP: {current HP}
        // MP: {current MP}
        // ..."

        hp.entrySet().stream()
                .sorted((h1, h2) -> Integer.compare(h2.getValue(), h1.getValue()))
                .forEach(hero ->{
                    String heroName = hero.getKey();
                    System.out.println(heroName);
                    System.out.println("  HP: " + hero.getValue());
                    System.out.println("  MP: " + mp.get(heroName));
                });
    }
}
