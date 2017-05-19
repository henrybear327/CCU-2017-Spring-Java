import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by henrybear327 on 5/19/17.
 */
public class SetupKey implements KeyListener {
    private String line1 = "";

    private final JTextArea textArea;

    private final JFrame frame;

    public SetupKey() {
        frame = new JFrame();
        frame.setTitle("Button");
        frame.setLayout(new FlowLayout());

        textArea = new JTextArea(10, 15);
        textArea.setText("Press any key on the key board");
        textArea.setEnabled(false);
        textArea.setDisabledTextColor(Color.BLACK);
        frame.add(textArea);

        frame.addKeyListener(this);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        line1 = String.format("keyPressed %s", KeyEvent.getKeyText(e.getKeyCode()));
//        textArea.setText(line1);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        line1 = String.format("keyReleased %s", KeyEvent.getKeyText(e.getKeyCode()));
//        textArea.setText(line1);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        line1 = String.format("keyTyped %s", e.getKeyChar());
        textArea.setText(line1);
    }
}
