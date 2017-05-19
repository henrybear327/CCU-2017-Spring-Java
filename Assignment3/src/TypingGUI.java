import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by henrybear327 on 5/19/17.
 */
public class TypingGUI {
    private JFrame frame;
    private JPanel panel;

    private final int windowWidth = 800;
    private final int windowHeight = 600;

    public TypingGUI() {
        configureFrame();

        configureLayout();

        configureInstructionLabel();

        configureTextArea();

        frame.setVisible(true);
    }

    private void configureFrame() {
        frame = new JFrame();
        frame.setTitle("Typing Application");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(windowWidth, windowHeight);

        frame.setResizable(false);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
    }

    private void configureLayout() {
        frame.setContentPane(panel);
    }

    private void configureInstructionLabel() {
        JPanel instructionLabelPanel = new JPanel();

        instructionLabelPanel.add(Box.createVerticalStrut(10));

        JLabel instructionLabel = new JLabel();
        instructionLabel.setText("<html><body>Type some text using your keyboard. The keys you press will be highlighted and the text will be displayed.<br>Note: Clicking the buttons with your mouse will not perform any action.</body></html>");
        instructionLabelPanel.add(instructionLabel);

        instructionLabelPanel.add(Box.createVerticalStrut(10));

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH ;
        panel.add(instructionLabelPanel, c);
    }

    private void configureTextArea() {
        JPanel textAreaPanel = new JPanel();
        
        textAreaPanel.add(Box.createVerticalStrut(10));

        JTextArea textArea = new JTextArea(100, 100);
        textArea.setText("");
        textArea.setEnabled(false);
        textArea.setDisabledTextColor(Color.BLACK);

        textAreaPanel.add(Box.createVerticalStrut(10));

        textAreaPanel.add(textArea);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH ;
        panel.add(textAreaPanel, c);
    }
}
