import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;

public class Elementalists {
    private JPanel JPanel;
    private JButton button1;

    public static void HelloWorld() {
        System.out.println("only ayush's method now hehehe");
    }




    public static void HelloWorld2() {
        System.out.println("Hello World! -AYUSH");
        System.out.println("Hello World - AYUSH again");
        System.out.println("hello World - AYUSH Branch");
        System.out.println("Hello World - Vraj");
    }

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

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        JPanel = new JPanel();
        JPanel.setLayout(new GridBagLayout());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return JPanel;
    }
}
