/**
 * Created by henrybear327 on 5/17/17.
 */
public class Main {
    private static void setupGUI() {
        Chapter12 gui = new Chapter12();

        gui.setupDialog();
    }

    public static void main(String[] args) {
        System.out.println("The Typing tutor has been started. Now loading GUI...");
        setupGUI();
    }
}
