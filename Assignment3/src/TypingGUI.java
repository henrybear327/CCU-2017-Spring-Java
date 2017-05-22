import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by henrybear327 on 5/19/17.
 */
public class TypingGUI {

    private Container container;
    private JFrame frame;
    private JPanel panel;

    private JLabel scoreLabel;

    private final int windowWidth = 800;
    private final int windowHeight = 600;

    private final int keyWidth = 50 / 2;
    private final int keyHeight = 50;

    public TypingGUI() {
//        testBoxLayout();

        configure();

        configureInstructionLabel();

        addEmptyLabel();

        configureShowScore();

        addEmptyLabel();

        configurePrintTextArea();

        addEmptyLabel();

        configureGetTextArea();

        addEmptyLabel();

        configureKeyboard();

        container.add(panel);
        frame.setVisible(true);
    }

    private void configure() {
        frame = new JFrame();
        frame.setTitle("Typing Application");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(windowWidth, windowHeight);

        frame.setLayout(new GridLayout(1, 1));

        frame.setResizable(false);

        container = frame.getContentPane();
        container.setLayout(new GridLayout(0, 1));

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    }

    private void addEmptyLabel() {
        JPanel emptyLabelPanel = new JPanel();

        JLabel emptyLabel = new JLabel();
        emptyLabel.setText("<html><body><br></body></html>");
        emptyLabelPanel.add(emptyLabel);

        emptyLabel.setPreferredSize(new Dimension(windowWidth - 20, 10));
        emptyLabel.setMaximumSize(new Dimension(windowWidth - 20, 10));

        emptyLabelPanel.setPreferredSize(new Dimension(windowWidth, 10));
        emptyLabelPanel.setMaximumSize(new Dimension(windowWidth, 10));

        panel.add(emptyLabelPanel);
    }

    private void configureInstructionLabel() {
        JPanel instructionLabelPanel = new JPanel();

        JLabel instructionLabel = new JLabel();
        instructionLabel.setText("<html><body>Type some text using your keyboard. The keys you press will be highlighted and the text will be displayed.<br>Note: Clicking the buttons with your mouse will not perform any action.</body></html>");
        instructionLabelPanel.add(instructionLabel);

        instructionLabel.setPreferredSize(new Dimension(windowWidth - 20, 40));
        instructionLabel.setMaximumSize(new Dimension(windowWidth - 20, 40));

        instructionLabelPanel.setPreferredSize(new Dimension(windowWidth, 40));
        instructionLabelPanel.setMaximumSize(new Dimension(windowWidth, 40));

        panel.add(instructionLabelPanel);
    }

    private void configureShowScore() {
        scoreLabel = new JLabel();
        scoreLabel.setHorizontalAlignment(SwingConstants.LEFT);
        scoreLabel.setText("<html><body>Score label... TODO</body></html>");

        panel.add(scoreLabel);
    }

    private void configurePrintTextArea() {
        JPanel textAreaPanel = new JPanel();
        textAreaPanel.setLayout(new GridLayout(1, 1));

        JTextArea textArea = new JTextArea("1");
        textArea.setEnabled(false);
        textArea.setDisabledTextColor(Color.BLACK);

//        textArea.setPreferredSize(new Dimension(windowWidth - 20, 40));
//        textArea.setMaximumSize(new Dimension(windowWidth - 20, 40));
//
//        textAreaPanel.setPreferredSize(new Dimension(windowWidth, 60));
//        textAreaPanel.setMaximumSize(new Dimension(windowWidth, 60));

        textAreaPanel.add(textArea);

        panel.add(textAreaPanel);
    }

    private void configureGetTextArea() {
        JPanel textAreaPanel = new JPanel();
        textAreaPanel.setLayout(new GridLayout(1, 1));

        JTextArea textArea = new JTextArea("2");
        textArea.setEnabled(false);
        textArea.setDisabledTextColor(Color.BLACK);

//        textArea.setPreferredSize(new Dimension(windowWidth - 20, 40));
//        textArea.setMaximumSize(new Dimension(windowWidth - 20, 40));
//
//        textAreaPanel.setPreferredSize(new Dimension(windowWidth, 60));
//        textAreaPanel.setMaximumSize(new Dimension(windowWidth, 60));

        textAreaPanel.add(textArea);

        panel.add(textAreaPanel);
    }

    private void configureKeyboard() {
        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setLayout(new GridLayout(5, 1, 0, 0));

        String[][] keyBoardKeys = {
                {"~", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "Backspace"},
                {"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\"},
                {"Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", ";", "\"", "Enter"},
                {"Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "?", "^"},
                {" ", "<", "ˇ", ">"}
        };

        prepareKeyBoardRow1(keyboardPanel, keyBoardKeys);
        prepareKeyBoardRow2(keyboardPanel, keyBoardKeys);
        prepareKeyBoardRow3(keyboardPanel, keyBoardKeys);
        prepareKeyBoardRow4(keyboardPanel, keyBoardKeys);
        prepareKeyBoardRow5(keyboardPanel, keyBoardKeys);

        panel.add(keyboardPanel);
    }

    private JButton createButton(String text, int width) {
        JButton plainButton = new JButton(text);
        plainButton.setPreferredSize(new Dimension(width, keyHeight));

        return plainButton;
    }

    private void prepareKeyBoardRow1(JPanel keyboardPanel, String[][] keyBoardKeys) {
        JPanel row = new JPanel();
        row.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        for (int i = 0; i < keyBoardKeys[0].length; i++) {
            int width = keyWidth * 2;
            if (i == keyBoardKeys[0].length - 1)
                width = keyWidth * 6;
            row.add(createButton(keyBoardKeys[0][i], width));
        }

        keyboardPanel.add(row);
    }

    private void prepareKeyBoardRow2(JPanel keyboardPanel, String[][] keyBoardKeys) {
        JPanel row = new JPanel();
        row.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        for (int i = 0; i < keyBoardKeys[1].length; i++) {
            int width = keyWidth * 2;
            if (i == 0)
                width = keyWidth * 3;
            row.add(createButton(keyBoardKeys[1][i], width));
        }

        keyboardPanel.add(row);
    }

    private void prepareKeyBoardRow3(JPanel keyboardPanel, String[][] keyBoardKeys) {
        JPanel row = new JPanel();
        row.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        for (int i = 0; i < keyBoardKeys[2].length; i++) {
            int width = keyWidth * 2;
            if (i == 0)
                width = keyWidth * 3;
            else if (i == keyBoardKeys[2].length - 1)
                width = keyWidth * 4;
            row.add(createButton(keyBoardKeys[2][i], width));
        }

        keyboardPanel.add(row);
    }

    private void prepareKeyBoardRow4(JPanel keyboardPanel, String[][] keyBoardKeys) {
        JPanel row = new JPanel();
        row.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        for (int i = 0; i < keyBoardKeys[3].length; i++) {
            int width = keyWidth * 2;
            if (i == 0)
                width = keyWidth * 4;
            else if (i == keyBoardKeys[3].length - 1) {
                JLabel emptyLabel = new JLabel("      ");
                row.add(emptyLabel);
            }
            row.add(createButton(keyBoardKeys[3][i], width));
        }

        keyboardPanel.add(row);
    }

    private void prepareKeyBoardRow5(JPanel keyboardPanel, String[][] keyBoardKeys) {
        JPanel row = new JPanel();
        row.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        for (int i = 0; i < keyBoardKeys[4].length; i++) {
            int width = keyWidth * 2;
            if(i == 0) {
                JLabel emptyLabel = new JLabel("                                                  ");
                row.add(emptyLabel);

                width *= 6;
            } else if(i == 1) {
                JLabel emptyLabel = new JLabel("                   ");
                row.add(emptyLabel);
            }
            row.add(createButton(keyBoardKeys[4][i], width));
        }

        keyboardPanel.add(row);
    }

    private void testBoxLayout() {
        // http://progden-programming.blogspot.tw/2013/02/layout-boxlayout.html
        JFrame frame = new JFrame("BoxLayout-1");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.setLayout(new GridLayout(0, 1));

        JPanel panel = null;
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        cp.add(panel);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        cp.add(panel);

        frame.setVisible(true);
        frame.pack();
    }
}
