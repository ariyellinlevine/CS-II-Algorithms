package Project2;

import java.util.Arrays;
import java.util.Scanner;

public class Permutations {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        String[] strings = input.split(" ");
        int k = Integer.valueOf(strings[0]);

        strings = Arrays.copyOfRange(strings, 1, strings.length);
        if (k > strings.length) {
            throw new Error("k must be less than or equal to total number of inputs");
        }

        RandomizedQueue randQ = new RandomizedQueue();
        for (String s : strings) {
            randQ.add(Integer.valueOf(s));
        }
        int counter = 0;
        for (Integer integer : randQ) {
            if (counter == k) {
                break;
            }
            System.out.println(integer);
            counter++;
        }
    }
}
