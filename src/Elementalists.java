import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;

public class Elementalists {
    private JPanel JPanel;
    private JButton button1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyForm");
        frame.setContentPane(new Elementalists().JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }
    private void $$$setupUI$$$() {
        JPanel = new JPanel();
        JPanel.setLayout(new GridBagLayout());
    }
    public JComponent $$$getRootComponent$$$() {
        return JPanel;
    }
}
