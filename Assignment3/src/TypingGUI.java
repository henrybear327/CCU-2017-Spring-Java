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

        frame.setLayout(new GridLayout(1,1));

//        frame.setResizable(false);

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
        textAreaPanel.setLayout(new GridLayout(1,1));

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
        textAreaPanel.setLayout(new GridLayout(1,1));

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

    }

    private void testBoxLayout() {
        // http://progden-programming.blogspot.tw/2013/02/layout-boxlayout.html
        JFrame frame = new JFrame("BoxLayout-1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
