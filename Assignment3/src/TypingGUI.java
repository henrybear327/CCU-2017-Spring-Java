import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by henrybear327 on 5/19/17.
 */
public class TypingGUI implements KeyListener {

    private Container container;
    private JFrame frame;
    private JPanel panel;

    private JTextArea textArea;
    private String textAreaString;
    private String debugString;

    private JPanel keyboardPanel;

    private final int windowWidth = 1000;
    private final int windowHeight = 600;

    private final int keyWidth = 50 / 2;
    private final int keyHeight = 50;

    private Color originalColor;

    private HashMap<String, JButton> buttonMap;

    // https://www.themarysue.com/sentences-every-letter-pangram-holoalphabetic-sentence/
    private final int stringToCompareWithIndex;
    private final String[] stringToCompareWith = {
            "Sphinx of black quartz, judge my vow",
            "Jackdaws love my big sphinx of quartz",
            "Pack my box with five dozen liquor jugs",
            "The quick onyx goblin jumps over the lazy dwarf",
            "Cwm fjord bank glyphs vext quiz",
            "How razorback-jumping frogs can level six piqued gymnasts!",
            "Cozy lummox gives smart squid who asks for job pen",
            "Amazingly few discotheques provide jukeboxes",
            "Now fax quiz Jack!’ my brave ghost pled"
    };

    public TypingGUI() {
//        testBoxLayout();

        SecureRandom sr = new SecureRandom();
        stringToCompareWithIndex = sr.nextInt(stringToCompareWith.length);

        buttonMap = new HashMap<>();

        configure();

        configureInstructionLabel();

        addEmptyLabel();

        configureGetTextArea();

        addEmptyLabel();

        configureCompareWithLabel();

        addEmptyLabel();

        configureKeyboard();

        container.add(panel);
        frame.pack();
        panel.addKeyListener(this);
        panel.requestFocusInWindow();
        frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        textAreaString = "keyTyped: " + e.getKeyChar() + "\n";
//        System.out.println(textAreaString);
//        textArea.setText(textAreaString);
    }

    private String getKeyText(KeyEvent e, boolean needAction, boolean blocking) {
        int keyCode = e.getKeyCode();
        String text = "";

        switch (keyCode) {
            case KeyEvent.VK_UP:
                debugString = "up\n";
                text = "↑";
                if (needAction && blocking == false)
                    textAreaString += text;
                break;
            case KeyEvent.VK_DOWN:
                debugString = "down\n";
                text = "↓";
                if (needAction && blocking == false)
                    textAreaString += text;
                break;
            case KeyEvent.VK_LEFT:
                debugString = "left\n";
                text = "←";
                if (needAction && blocking == false)
                    textAreaString += text;
                break;
            case KeyEvent.VK_RIGHT:
                debugString = "right\n";
                text = "→";
                if (needAction && blocking == false)
                    textAreaString += text;
                break;
            case KeyEvent.VK_TAB:
                debugString = "tab\n";
                text = "Tab";
                break;
            case KeyEvent.VK_SPACE:
                debugString = "space\n";
                text = " ";
                if (needAction && blocking == false)
                    textAreaString += " ";
                break;
            case KeyEvent.VK_BACK_SPACE:
                debugString = "backspace\n";
                text = "Backspace";
                if (needAction && textAreaString.length() > 0)
                    textAreaString = textAreaString.substring(0, textAreaString.length() - 1);
                break;
            case KeyEvent.VK_SHIFT:
                debugString = "shift\n";
                text = "Shift";
                break;
            case KeyEvent.VK_ENTER:
                debugString = "enter\n";
                text = "Enter";
                if (needAction && blocking == false)
                    textAreaString += "\n";
                break;
            default:
                text = Character.toString(e.getKeyChar()).toUpperCase();
                debugString = "default " + e.getKeyChar() + "\n";
                if (needAction && blocking == false)
                    textAreaString += e.getKeyChar();
        }

        return text;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        boolean blocking = false;
        if (stringToCompareWith[stringToCompareWithIndex].length() <= textAreaString.length())
            blocking = true;
        String text = getKeyText(e, true, blocking);

        JButton currentlyPressed = buttonMap.getOrDefault(text, null);
        if (currentlyPressed == null)
            return;
        currentlyPressed.setBackground(Color.RED);

        System.out.print(debugString);
        textArea.setText(textAreaString);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String text = getKeyText(e, false, false);

        JButton currentlyPressed = buttonMap.getOrDefault(text, null);
        if (currentlyPressed == null)
            return;
        currentlyPressed.setBackground(originalColor);

        System.out.print(debugString);
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

        emptyLabel.setPreferredSize(new Dimension(windowWidth - 10, 10));
        emptyLabel.setMaximumSize(new Dimension(windowWidth - 10, 10));

        emptyLabelPanel.setPreferredSize(new Dimension(windowWidth - 10, 10));
        emptyLabelPanel.setMaximumSize(new Dimension(windowWidth - 10, 10));

        panel.add(emptyLabelPanel);
    }

    private void configureInstructionLabel() {
        JPanel instructionLabelPanel = new JPanel();
        instructionLabelPanel.setLayout(new BoxLayout(instructionLabelPanel, BoxLayout.X_AXIS));

        JLabel instructionLabel = new JLabel();
        instructionLabel.setText("<html><body>Type some text using your keyboard. The keys you press will be highlighted and the text will be displayed.<br>Note: Clicking the buttons with your mouse will not perform any action.</body></html>");
        instructionLabel.setPreferredSize(new Dimension(windowWidth - 100, 40));
        instructionLabel.setMaximumSize(new Dimension(windowWidth - 100, 40));
        instructionLabelPanel.add(instructionLabel);

        JButton showAccuracyButton = new JButton("GetAccuracy");
        showAccuracyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cnt = 0;

                TreeMap<Character, Integer> wrongList = new TreeMap<>();
                for (int i = 0; i < stringToCompareWith[stringToCompareWithIndex].length() && i < textAreaString.length(); i++)
                    if (stringToCompareWith[stringToCompareWithIndex].charAt(i) == textAreaString.charAt(i)) {
                        cnt++;
                    } else {
                        int tmp = wrongList.getOrDefault(stringToCompareWith[stringToCompareWithIndex].charAt(i), 0);
                        tmp++;
                        wrongList.put(stringToCompareWith[stringToCompareWithIndex].charAt(i), tmp);
                    }

                String message = cnt + " / " + stringToCompareWith[stringToCompareWithIndex].length() + "\n";
                for (Map.Entry<Character, Integer> entry : wrongList.entrySet()) {
                    System.out.println(entry.getKey() + " " + entry.getValue());

                    message += "Key " + entry.getKey() + " has been typed wrongly for " + entry.getValue() + " time" + (entry.getValue() == 1 ? "\n" : "s\n");
                }

                JOptionPane.showMessageDialog(null, message);
                panel.requestFocusInWindow();
            }
        });
        instructionLabelPanel.add(showAccuracyButton);

        instructionLabelPanel.setPreferredSize(new Dimension(windowWidth - 10, 40));
        instructionLabelPanel.setMaximumSize(new Dimension(windowWidth - 10, 40));
        panel.add(instructionLabelPanel);
    }

    private void configureGetTextArea() {
        JPanel textAreaPanel = new JPanel();
        textAreaPanel.setLayout(new GridLayout(1, 1));

        textArea = new JTextArea("");
        textAreaString = "";
        textArea.setEnabled(false);
        textArea.setDisabledTextColor(Color.BLACK);

        textArea.setPreferredSize(new Dimension(windowWidth - 20, 200));
        textArea.setMaximumSize(new Dimension(windowWidth - 20, 200));

        textAreaPanel.setPreferredSize(new Dimension(windowWidth - 10, 200));
        textAreaPanel.setMaximumSize(new Dimension(windowWidth - 10, 200));

        textAreaPanel.add(textArea);

        panel.add(textAreaPanel);
    }

    private void configureCompareWithLabel() {
        JPanel compareWithLabelPanel = new JPanel();
        compareWithLabelPanel.setLayout(new BoxLayout(compareWithLabelPanel, BoxLayout.X_AXIS));

        JLabel compareWithLabel = new JLabel();
        compareWithLabel.setText("<html><body>Compare with: <span style=\"color: #ff0000\">" + stringToCompareWith[stringToCompareWithIndex] + "</span></body></html>");
        compareWithLabel.setPreferredSize(new Dimension(windowWidth - 10, 40));
        compareWithLabel.setMaximumSize(new Dimension(windowWidth - 10, 40));
        compareWithLabelPanel.add(compareWithLabel);

        compareWithLabelPanel.setSize(new Dimension(windowWidth - 10, 40));

        panel.add(compareWithLabelPanel);
    }

    private void configureKeyboard() {
        keyboardPanel = new JPanel();
        keyboardPanel.setLayout(new GridLayout(5, 1, 0, 0));

        String[][] keyBoardKeys = {
                {"~", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "=", "Backspace"},
                {"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\"},
                {"Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", ":", ";", "'", "\"", "Enter"},
                {"Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "/", "?", "↑"},
                {" ", "←", "↓", "→"}
        };

        prepareKeyBoardRow1(keyboardPanel, keyBoardKeys);
        prepareKeyBoardRow2(keyboardPanel, keyBoardKeys);
        prepareKeyBoardRow3(keyboardPanel, keyBoardKeys);
        prepareKeyBoardRow4(keyboardPanel, keyBoardKeys);
        prepareKeyBoardRow5(keyboardPanel, keyBoardKeys);

        keyboardPanel.setSize(new Dimension(windowWidth - 10, 300));
        keyboardPanel.setMaximumSize(new Dimension(windowWidth - 10, 300));

        panel.add(keyboardPanel);
    }

    private JButton createButton(String text, int width) {
        JButton plainButton;
        if (text.equalsIgnoreCase(" "))
            plainButton = new JButton("Space");
        else
            plainButton = new JButton(text);
        plainButton.setPreferredSize(new Dimension(width, keyHeight));

        originalColor = plainButton.getBackground();

        buttonMap.put(text, plainButton);

        return plainButton;
    }

    private JButton createButton(String text, String text2, int width) {
        JButton plainButton = new JButton(text + text2);
        plainButton.setPreferredSize(new Dimension(width, keyHeight));

        originalColor = plainButton.getBackground();

        buttonMap.put(text, plainButton);
        buttonMap.put(text2, plainButton);

        return plainButton;
    }

    private void prepareKeyBoardRow1(JPanel keyboardPanel, String[][] keyBoardKeys) {
        JPanel row = new JPanel();
        row.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        for (int i = 0; i < keyBoardKeys[0].length; i++) {
            int width = keyWidth * 2;
            if (i == keyBoardKeys[0].length - 3) {
                row.add(createButton(keyBoardKeys[0][i], keyBoardKeys[0][i + 1], width));
                i++;
                continue;
            }
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
            else if (i == keyBoardKeys[2].length - 5) {
                row.add(createButton(keyBoardKeys[2][i], keyBoardKeys[2][i + 1], width));
                i++;
                continue;
            } else if (i == keyBoardKeys[2].length - 3) {
                row.add(createButton(keyBoardKeys[2][i], keyBoardKeys[2][i + 1], width));
                i++;
                continue;
            } else if (i == keyBoardKeys[2].length - 1)
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
            } else if (i == keyBoardKeys[3].length - 3) {
                row.add(createButton(keyBoardKeys[3][i], keyBoardKeys[3][i + 1], width));
                i++;
                continue;
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
            if (i == 0) {
                JLabel emptyLabel = new JLabel("                                                  ");
                row.add(emptyLabel);

                width *= 6;
            } else if (i == 1) {
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
