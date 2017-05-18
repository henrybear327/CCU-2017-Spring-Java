import javax.swing.*;

/**
 * Created by henrybear327 on 5/18/17.
 */
public class Chapter12 {
    public void setupDialog() {
        String text = JOptionPane.showInputDialog("Hey there, what's your name?");

        JOptionPane.showMessageDialog(null, "You entered " + text, "Title bar!", JOptionPane.WARNING_MESSAGE);
    }
}
