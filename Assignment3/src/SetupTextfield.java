import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by henrybear327 on 5/19/17.
 */
public class SetupTextfield {
    private final JTextField textfield1;
    private final JTextField textfield2;
    private final JTextField textfield3;
    private final JPasswordField passwordField;

    public SetupTextfield() {
        JFrame frame = new JFrame();
        frame.setTitle("JTextfield and JPassword");
        frame.setLayout(new FlowLayout());

        textfield1 = new JTextField(10); // 10 columns
        frame.add(textfield1);

        textfield2 = new JTextField("Default text");
        frame.add(textfield2);

        textfield3 = new JTextField("Uneditable text", 21);
        textfield3.setEditable(false);
        frame.add(textfield3);

        passwordField = new JPasswordField("Hidden text");
        frame.add(passwordField);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setVisible(true);

        TextFieldHandler handler = new TextFieldHandler();
        textfield1.addActionListener(handler);
        textfield2.addActionListener(handler);
        textfield3.addActionListener(handler);
        passwordField.addActionListener(handler);
    }

    private class TextFieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = "";

            if (e.getSource() == textfield1)
                s = "text1: " + e.getActionCommand();
            else if (e.getSource() == textfield2)
                s = "text2: " + e.getActionCommand();
            else if (e.getSource() == textfield3)
                s = "text3: " + e.getActionCommand();
            else if (e.getSource() == passwordField) {
                JPasswordField pwd =
                        (JPasswordField) e.getSource();
                s = "password: " +
                        new String(pwd.getPassword());
            }

            JOptionPane.showMessageDialog(null, s/* + " " + e.toString()*/);
        }
    }
}
