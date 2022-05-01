import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class lab011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Double> streamList = Arrays.stream(sc.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

        for (int i = 0; i < streamList.size() - 1; i++) {
            if (streamList.get(i).equals(streamList.get(i + 1))) {
                streamList.set(i, streamList.get(i) + streamList.get(i + 1));
                streamList.remove(i + 1);
                i = -1;
            }
        }
        /*System.out.println(streamList.toString().replaceAll("[\\[\\],]", ""));*/
        DecimalFormat decimalFormat = new DecimalFormat("0.#");
        for (Double number : streamList) {
            System.out.print(decimalFormat.format(number) + " ");
        }
    }
}
