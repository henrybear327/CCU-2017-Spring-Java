import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by henrybear327 on 6/11/17.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter a line of text: ");
        String input = sc.nextLine();
        String[] splited = input.split(" ");

        TreeSet<String> res = new TreeSet<>();
        for(String i : splited) {
            if(i.length() > 0 && res.contains(i) == false) {
                res.add(i);
                System.out.println("Added " + i + " into the TreeSet");
            }
        }

        for(String i : res) {
            System.out.println(i);
        }
    }
}
