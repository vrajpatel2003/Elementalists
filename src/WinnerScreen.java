import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;

public class WinnerScreen {
    private JButton playAgainButton;
    private JButton quitGameButton;
    private JPanel victoryPanel;
    private JLabel lblRank;
    private JLabel rankUpMessage;
    static JFrame frame = new JFrame("You Won :)");

    public WinnerScreen() {
        rankCheck();
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartMenu.frame.setContentPane(new Elementalists().getJPanel());
                fullScreen(StartMenu.frame);
                StartMenu.frame.setLocationRelativeTo(null);
            }
        });
        quitGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public JPanel getJPanel() {
        return victoryPanel;
    }

    private static void fullScreen(JFrame aFrame) { // src = https://alvinalexander.com/blog/post/jfc-swing/how-set-jframe-size-fill-entire-screen-maximize/
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        aFrame.setSize(screenSize.width, screenSize.height);
    }

    public static void main(String[] args) {
        frame.setContentPane(new WinnerScreen().victoryPanel);
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

            if (fileLines.size() > 1) {
                fileLines.remove(0);

                lblRank.setText("Current Rank: " + fileLines.get(0));

                FileWriter writer = new FileWriter("src/currentRank.txt");
                for (int i = 0; i < fileLines.size(); i++) {
                    writer.write(fileLines.get(i) + "\n");
                }
                writer.close();
            } else {
                lblRank.setText("Current Rank: " + fileLines.get(0));
            }

            if (fileLines.get(0).equals("Grandmaster")) {
                rankUpMessage.setText("Congratulations! You are now the ultimate wizard.");
            }

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
        victoryPanel = new JPanel();
        victoryPanel.setLayout(new GridBagLayout());
        victoryPanel.setBackground(new Color(-4149));
        victoryPanel.setForeground(new Color(-4149));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Papyrus", -1, 48, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Congratulations! You won!");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(25, 25, 25, 25);
        victoryPanel.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setIcon(new ImageIcon(getClass().getResource("/img/player1/blueVictory.gif")));
        label2.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(25, 25, 25, 25);
        victoryPanel.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setIcon(new ImageIcon(getClass().getResource("/img/player2/redDefeat.gif")));
        label3.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(25, 25, 25, 25);
        victoryPanel.add(label3, gbc);
        rankUpMessage = new JLabel();
        rankUpMessage.setText("You have ranked up!");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(25, 25, 5, 25);
        victoryPanel.add(rankUpMessage, gbc);
        lblRank = new JLabel();
        lblRank.setText("You are now a [RANK]!");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 25, 25, 25);
        victoryPanel.add(lblRank, gbc);
        playAgainButton = new JButton();
        playAgainButton.setText("Play Again");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 250;
        gbc.insets = new Insets(25, 25, 25, 25);
        victoryPanel.add(playAgainButton, gbc);
        quitGameButton = new JButton();
        quitGameButton.setText("Quit Game");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 250;
        gbc.insets = new Insets(25, 25, 25, 25);
        victoryPanel.add(quitGameButton, gbc);
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
        return victoryPanel;
    }

}
