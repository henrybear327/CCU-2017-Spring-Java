import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by henrybear327 on 6/11/17.
 */
public class Main {
    private static void solve(String input) {
        input = input.toLowerCase();
        String[] tmp = input.split(" ");

        // TODO: deal with punctuation


        TreeMap<String, Integer> cnt = new TreeMap<>();
        for(String i : tmp) {
            if(i.length() > 0) {
                int cur = cnt.getOrDefault(i, 0);
                cur += 1;
                cnt.put(i, cur);
            }
        }

//        for(Map.Entry<String, Integer> entry : cnt.entrySet()) {
        for(String i : tmp) {
            if(i.length() > 0) {
                if(cnt.containsKey(i) && cnt.get(i) > 1) {
                    // Words:  here:  repeat 2 times
                    System.out.println("Words:\t" + i + ":\t" + "repeats " + cnt.get(i) + " times");
                    cnt.remove(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        // here i am i am here friend
        Scanner sc = new Scanner(System.in);

        solve(sc.nextLine());
    }
}
