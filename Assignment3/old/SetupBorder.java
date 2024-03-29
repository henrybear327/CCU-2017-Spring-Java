import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class SetupBorder {
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;
    private int hgap;
    private int vgap;
    private JTextField tfield1, tfield2;
    private String[] data = {"One", "Two"};

    public SetupBorder() {
        hgap = 5;
        vgap = 5;
    }

    private void displayGUI() {
        JFrame frame = new JFrame("Border Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(
                BorderFactory.createEmptyBorder(hgap, hgap, hgap, hgap));
        contentPane.setLayout(new BorderLayout(hgap, vgap));

        topPanel = new JPanel();
        topPanel.setOpaque(true);
        topPanel.setBackground(Color.WHITE);
        topPanel.setBorder(
                BorderFactory.createTitledBorder("Top Panel"));
        tfield1 = new JTextField(10);
        tfield1.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(
                                EtchedBorder.RAISED, Color.GRAY
                                , Color.DARK_GRAY), "JTextField"));
        JPanel comboPanel = new JPanel();

        topPanel.add(tfield1);

        centerPanel = new JPanel();
        centerPanel.setOpaque(true);
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(
                BorderFactory.createTitledBorder("Center Panel"));
        tfield2 = new JTextField(10);
        tfield2.setBorder(
                BorderFactory.createLoweredBevelBorder());

        centerPanel.add(tfield2);

        bottomPanel = new JPanel();
        bottomPanel.setOpaque(true);
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setBorder(
                BorderFactory.createTitledBorder("Center Panel"));

        contentPane.add(topPanel, BorderLayout.PAGE_START);
        contentPane.add(centerPanel, BorderLayout.CENTER);
        contentPane.add(bottomPanel, BorderLayout.PAGE_END);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SetupBorder().displayGUI();
            }
        });
    }
}