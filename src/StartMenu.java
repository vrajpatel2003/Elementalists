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
    static JFrame frame = new JFrame("MyForm");


    public StartMenu() {
        rankCheck();
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                JFrame game = new JFrame("MyForm");
                game.setContentPane(new Elementalists().getJPanel());
                game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                game.pack();
                game.setVisible(true);

            }
        });
    }

    public static void main(String[] args) {
        frame.setContentPane(new StartMenu().startMenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
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
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(25, 25, 25, 25);
        startMenu.add(startGameButton, gbc);
        lblRank = new JLabel();
        lblRank.setForeground(new Color(-16777216));
        lblRank.setText("Current Rank: Apprentice");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
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
        gbc.insets = new Insets(25, 25, 25, 25);
        startMenu.add(label1, gbc);
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
