/**
 * Created by henrybear327 on 5/17/17.
 */
public class Main {
    private static void setupTestingGUI() {
        new SetupDialog();
        new SetupLabelAndIcon();
        new SetupTextfield();
        new SetupButton();
        new SetupKey();
    }

    public static void main(String[] args) {
        System.out.println("The Typing tutor has been started. Now loading TypingGUI...");
        // setupTestingGUI();
        new TypingGUI();
    }
}
