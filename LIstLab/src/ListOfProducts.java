import java.util.*;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n  = Integer.parseInt(sc.nextLine());

            List<String> input = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            String products = sc.nextLine();
           input.add(products);
        }
        Collections.sort(input);
        for (int j = 0; j < input.size(); j++) {
            System.out.println(j + 1+"." + input.get(j));
        }

    }
}
