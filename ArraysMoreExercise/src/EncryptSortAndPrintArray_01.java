
import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int [] sumNumbers = new int[n];


        for (int i = 0; i < n; i++) {
            int sumVowel = 0;
            int sumConsonant = 0;
            String name1 = sc.nextLine();
            for (char j = 0; j < name1.length(); j++) {
                char symbol = name1.charAt(j);
                if (symbol == 65 || symbol == 69 || symbol == 73 || symbol == 79 || symbol == 85
                        || symbol == 97 || symbol == 101 ||
                        symbol == 105 || symbol == 111 || symbol == 117) {
                    sumVowel += symbol * name1.length();
                } else {
                    sumConsonant += symbol / name1.length();
                }
            }

                    int sum = sumVowel + sumConsonant;

                      sumNumbers[i] = sum;
                      sum = 0;

                }
        Arrays.sort(sumNumbers);
        for (int element : sumNumbers) {
            System.out.println(element);
        }

            }


        }


