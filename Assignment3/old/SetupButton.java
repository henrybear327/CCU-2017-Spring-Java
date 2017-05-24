import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by henrybear327 on 5/19/17.
 */
public class SetupButton {
    private final JButton plainButton;
    private final JButton fancyButton;
    private final JFrame frame;

    public SetupButton() {
        frame = new JFrame();
        frame.setTitle("Button");
        frame.setLayout(new FlowLayout());

        plainButton = new JButton("Plain button");
        frame.add(plainButton);

        Icon java1 = new ImageIcon(getClass().getResource("Java_logo.png"));
        Icon java2 = new ImageIcon(getClass().getResource("keep-calm-and-java-sucks.png"));

        fancyButton = new JButton("Fancy button", java1);
        fancyButton.setRolloverIcon(java2);
        frame.add(fancyButton);

        ButtonHandler handler = new ButtonHandler();
        plainButton.addActionListener(handler);
        fancyButton.addActionListener(handler);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }


    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(SetupButton.this.frame, String.format("You pressed %s", event.getActionCommand()));
        }
    }
}
