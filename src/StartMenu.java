import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;

public class StartMenu {
    private JButton startGameButton;
    private JPanel startMenu;
    private JLabel lblRank;
    public static JFrame frame = new JFrame("Elementalists");


    public StartMenu() {
        rankCheck();
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Elementalists().getJPanel());
                fullScreen(frame);
                frame.setLocationRelativeTo(null);
            }
        });
    }

    private static void fullScreen(JFrame aFrame) { // src = https://alvinalexander.com/blog/post/jfc-swing/how-set-jframe-size-fill-entire-screen-maximize/
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        aFrame.setSize(screenSize.width, screenSize.height);
    }

    public static void main(String[] args) {
        frame.setContentPane(new StartMenu().startMenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void rankCheck() {
        BufferedReader br = null;
        ArrayList<String> fileLines = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader("src/currentRank.txt"));

            String newLine;

            while ((newLine = br.readLine()) != null) {
                fileLines.add(newLine);
            }

            lblRank.setText("Current Rank: " + fileLines.get(0));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
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
        startMenu = new JPanel();
        startMenu.setLayout(new GridBagLayout());
        startMenu.setBackground(new Color(-4149));
        startMenu.setForeground(new Color(-4149));
        startGameButton = new JButton();
        Font startGameButtonFont = this.$$$getFont$$$("Papyrus", -1, 16, startGameButton.getFont());
        if (startGameButtonFont != null) startGameButton.setFont(startGameButtonFont);
        startGameButton.setText("Start Game!");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(50, 50, 25, 50);
        startMenu.add(startGameButton, gbc);
        lblRank = new JLabel();
        lblRank.setForeground(new Color(-16777216));
        lblRank.setText("Current Rank: Apprentice");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(25, 25, 25, 25);
        startMenu.add(lblRank, gbc);
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Papyrus", -1, 72, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-7921800));
        label1.setText("Elementalists");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(25, 25, 25, 25);
        startMenu.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setForeground(new Color(-16777216));
        label2.setHorizontalAlignment(2);
        label2.setText("1.    The three elements. Fire, water and ice.");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 50, 0, 50);
        startMenu.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setForeground(new Color(-16777216));
        label3.setHorizontalAlignment(2);
        label3.setText("2.    Wizards have transformed each element into spells.");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 50, 0, 50);
        startMenu.add(label3, gbc);
        final JLabel label4 = new JLabel();
        label4.setForeground(new Color(-16777216));
        label4.setHorizontalAlignment(2);
        label4.setText("3.    Fire beats ice. Ice beats water. Water beats fire.");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 50, 0, 50);
        startMenu.add(label4, gbc);
        final JLabel label5 = new JLabel();
        label5.setForeground(new Color(-16777216));
        label5.setHorizontalAlignment(2);
        label5.setText("4.    Each type has 10 different spells, with a higher number being stronger.");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 50, 0, 50);
        startMenu.add(label5, gbc);
        final JLabel label6 = new JLabel();
        label6.setForeground(new Color(-16777216));
        label6.setHorizontalAlignment(2);
        label6.setText("5.    You are given 30 spells, but you can only choose from five at a time.");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 50, 0, 50);
        startMenu.add(label6, gbc);
        final JLabel label7 = new JLabel();
        label7.setForeground(new Color(-16777216));
        label7.setHorizontalAlignment(2);
        label7.setText("6.    If both wizards cast the same element, the stronger spell wins.");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 50, 0, 50);
        startMenu.add(label7, gbc);
        final JLabel label8 = new JLabel();
        label8.setForeground(new Color(-16777216));
        label8.setHorizontalAlignment(2);
        label8.setText("7.    When two of the same spells are casted, they will be cancelled out.");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 50, 0, 50);
        startMenu.add(label8, gbc);
        final JLabel label9 = new JLabel();
        label9.setForeground(new Color(-16777216));
        label9.setHorizontalAlignment(2);
        label9.setText("8.    Try to beat the red wizard!");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 50, 0, 50);
        startMenu.add(label9, gbc);
        final JLabel label10 = new JLabel();
        label10.setIcon(new ImageIcon(getClass().getResource("/img/icons/FireIcon.png")));
        label10.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 125, 25, 50);
        startMenu.add(label10, gbc);
        final JLabel label11 = new JLabel();
        label11.setIcon(new ImageIcon(getClass().getResource("/img/icons/WaterIcon.png")));
        label11.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 50, 25, 50);
        startMenu.add(label11, gbc);
        final JLabel label12 = new JLabel();
        label12.setIcon(new ImageIcon(getClass().getResource("/img/icons/IceIcon.png")));
        label12.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 50, 25, 125);
        startMenu.add(label12, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return startMenu;
    }

}
