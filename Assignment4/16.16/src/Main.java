import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by henrybear327 on 6/11/17.
 */
public class Main {
    private static boolean valid(char c) {
        return ('0' <= c && c <= '9') || ('a' <= c && c <= 'z');
    }

    private static void solve(String input) {
        input = input.toLowerCase();

        // TODO: deal with punctuation
        String filtered = "";
        for (int i = 0; i < input.length(); i++) {
            if (valid(input.charAt(i))) {
                filtered += input.charAt(i);
            } else {
                filtered += " ";
            }
        }

        String[] tmp = filtered.split(" ");

        TreeMap<String, Integer> cnt = new TreeMap<>();
        for (String i : tmp) {
            if (i.length() > 0) {
                int cur = cnt.getOrDefault(i, 0);
                cur += 1;
                cnt.put(i, cur);qqg
            }
        }

//        for(Map.Entry<String, Integer> entry : cnt.entrySet()) {
        for (String i : tmp) {
            if (i.length() > 0) {
                if (cnt.containsKey(i) && cnt.get(i) > 1) {
                    // Words:  here:  repeat 2 times
                    System.out.println("Words:\t" + i + ":\t" + "repeats " + cnt.get(i) + " times");
                    cnt.remove(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        // here i am i am here friend
        // here i! am  i am here friend
        Scanner sc = new Scanner(System.in);

        solve(sc.nextLine());
    }
}
