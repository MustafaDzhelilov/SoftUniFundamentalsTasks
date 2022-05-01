import java.util.*;

public class Hereos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, List<Integer>> heroInfo = new TreeMap<>();

        //{hero name} {HP} {MP}

        for (int i = 0; i < n; i++) {
            String [] hero = sc.nextLine().split(" ");
            String name = hero[0];
            int hp = Integer.parseInt(hero[1]);
            int mp = Integer.parseInt(hero[2]);

            heroInfo.putIfAbsent(name, new ArrayList<>());
            heroInfo.get(name).add(0,hp);
            heroInfo.get(name).add(1,mp);
        }

        String command = sc.nextLine();

        while (!command.equals("End")){
            String [] tokens = command.split(" - ");
            String commandName = tokens[0];
            String commandHero = tokens[1];

            switch (commandName){
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    int currentMp = heroInfo.get(commandHero).get(1);

                    if(currentMp >= mpNeeded){
                        currentMp = currentMp -mpNeeded;
                        heroInfo.get(commandHero).set(1, currentMp);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",commandHero,spellName,currentMp);
                    }else{
                        System.out.printf("%s does not have enough MP to cast %s!%n",commandHero,spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    int currentHp = heroInfo.get(commandHero).get(0);
                    currentHp = currentHp - damage;
                    heroInfo.get(commandHero).set(0,currentHp);

                    if(currentHp > 0){
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",commandHero,damage,attacker,currentHp);
                    }else{
                        heroInfo.remove(commandHero);
                        System.out.printf("%s has been killed by %s!%n",commandHero,attacker);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(tokens[2]);
                    int currentAmount = heroInfo.get(commandHero).get(1);
                    int max = currentAmount + amount;

                    if(max >200){
                        max = 200;
                    }
                    heroInfo.get(commandHero).set(1,max);
                    System.out.printf("%s recharged for %d MP!%n",commandHero, max - currentAmount);
                    break;
                case "Heal":
                    int amountHp = Integer.parseInt(tokens[2]);
                    int currentAmountHp = heroInfo.get(commandHero).get(0);
                    int maX = currentAmountHp + amountHp;

                    if(maX > 100){
                        maX = 100;
                    }
                    heroInfo.get(commandHero).set(0,maX);
                    System.out.printf("%s healed for %d HP!%n",commandHero, maX - currentAmountHp);
                    break;
            }
            command = sc.nextLine();
        }
      //  "{hero name}
        // HP: {current HP}
        // MP: {current MP}

        heroInfo.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().get(0).compareTo(a.getValue().get(0)))
                .forEach(pair -> {
                    System.out.println(pair.getKey());
                    System.out.println("  HP: "+ pair.getValue().get(0));
                    System.out.println("  MP: "+ pair.getValue().get(1));
                });

    }
}
