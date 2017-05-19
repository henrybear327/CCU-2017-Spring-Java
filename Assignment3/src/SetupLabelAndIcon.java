import javax.swing.*;
import java.awt.*;

/**
 * Created by henrybear327 on 18/05/2017.
 */
public class SetupLabelAndIcon {
    private final JLabel label1;
    private final JLabel label2;
    private final JLabel label3;

    private final JFrame frame;

    public SetupLabelAndIcon() {
        // JFrame
        frame = new JFrame("Set windows title!");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        // JLabel 1
        label1 = new JLabel("Label1");
        label1.setToolTipText("Label1 tool tip");
        frame.add(label1);

        // JLabel 2 (icon)
        Icon picture = new ImageIcon(getClass().getResource("./Java_logo.png"));
        label2 = new JLabel("22222222222222", picture, SwingConstants.LEFT);
        frame.add(label2);

        // JLabel 3 (icon)
        label3 = new JLabel();
        label3.setText("lb3");
        label3.setIcon(picture);
        label3.setHorizontalTextPosition(SwingConstants.LEFT);
        label3.setVerticalTextPosition(SwingConstants.BOTTOM);
        label3.setToolTipText("Fuxk you");
        frame.add(label3);

        // final touch on JFrame
        frame.setVisible(true);
    }
}
