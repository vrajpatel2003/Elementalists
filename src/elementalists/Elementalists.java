/**
 * The main game class. It includes the GUI to the main game screen, as well as most of the logic related to the
 * gameplay.
 *
 * https://github.com/vrajpatel2003/Elementalists
 *
 * Created by Ayush Vora, Neil Patel, Vicky Patel, and Vraj Patel
 * For Mr. Keway So (vmso) for the final project (4.3) of ICS4U (Computer Science)
 *
 * @author  Ayush Vora, Neil Patel, Vicky Patel, Vraj Patel
 * @version 1.0
 * @since   2020-11-12
 * @filename Elementalists.java
 */

package elementalists;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
public class Elementalists {
    private JPanel jPanel;
    private JLabel p2Fire1;
    private JLabel p2Fire2;
    private JLabel p2Fire3;
    private JLabel p2Water1;
    private JLabel p2Ice1;
    private JLabel p2Water2;
    private JLabel p2Water3;
    private JLabel p2Ice2;
    private JLabel p2Ice3;
    private JLabel player1Icon;
    private JLabel player2Icon;
    private JButton p1Card1;
    private JButton p1Card2;
    private JButton p1Card3;
    private JButton p1Card4;
    private JButton p1Card5;
    private JButton p2Card1;
    private JButton p2Card2;
    private JButton p2Card3;
    private JButton p2Card4;
    private JButton p2Card5;
    private JLabel p1Fire1;
    private JLabel p1Fire2;
    private JLabel p1Fire3;
    private JLabel p1Water1;
    private JLabel p1Water2;
    private JLabel p1Water3;
    private JLabel p1Ice2;
    private JLabel p1Ice3;
    private JLabel p1Ice1;
    private JLabel action;
    String firePath = "./src/elementalists.img/cards/Fire/";
    String waterPath = "./src/elementalists.img/cards/Water/";
    String icePath = "./src/elementalists.img/cards/Ice/";
    String attack1 = "./src/elementalists.img/player1/";
    String attack2 = "./src/elementalists.img/player2/";
    ImageIcon cardback = new ImageIcon("./src/elementalists.img/cards/cardback.png");
    ImageIcon[] imageIcons = new ImageIcon[30];
    ArrayList<Integer> player1;
    ArrayList<Integer> player2;
    boolean canClick = true;
    int p1FireWins = 0;
    int p1WaterWins = 0;
    int p1IceWins = 0;
    int p2FireWins = 0;
    int p2WaterWins = 0;
    int p2IceWins = 0;
    Timer resetRoundTimer = new Timer(2000, new ActionListener() {
        @Override
        /**
         * After 2 seconds, this method is resets the player icons to idle and flips the cards back over.
         *
         * @param e Looks for the start of timer.
         */
        public void actionPerformed(ActionEvent e) {
            canClick = true;
            player1Icon.setIcon(new ImageIcon(attack1 + "/blueIdle.gif"));
            player2Icon.setIcon(new ImageIcon(attack2 + "/redIdle.gif"));
            p2Card1.setIcon(new ImageIcon("./src/elementalists.img/cards/cardback.png"));
            p2Card2.setIcon(new ImageIcon("./src/elementalists.img/cards/cardback.png"));
            p2Card3.setIcon(new ImageIcon("./src/elementalists.img/cards/cardback.png"));
            p2Card4.setIcon(new ImageIcon("./src/elementalists.img/cards/cardback.png"));
            p2Card5.setIcon(new ImageIcon("./src/elementalists.img/cards/cardback.png"));
            resetRoundTimer.stop();
        }
    });
    Timer addCards = new Timer(2000, new ActionListener() {
        @Override
        /**
         * After 2 seconds, this method adds the new card drawn by the player into their hand. If there are no more
         * cards in the player's hand, the card displayed will only be the card back.
         *
         * @param e Looks for the start of timer.
         */
        public void actionPerformed(ActionEvent e) {
            int a = player1.size();

            p1Card1.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
            p1Card2.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
            p1Card3.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
            p1Card4.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
            p1Card5.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));

            if (a > 1) p1Card1.setIcon(imageIcons[player1.get(0)]);
            if (a > 2) p1Card2.setIcon(imageIcons[player1.get(1)]);
            if (a > 3) p1Card3.setIcon(imageIcons[player1.get(2)]);
            if (a > 4) p1Card4.setIcon(imageIcons[player1.get(3)]);
            if (a > 5) p1Card5.setIcon(imageIcons[player1.get(4)]);

            p1Card1.setEnabled(true);
            p1Card2.setEnabled(true);
            p1Card3.setEnabled(true);
            p1Card4.setEnabled(true);
            p1Card5.setEnabled(true);
            addCards.stop();
        }
    });
    Timer toWinnerScreen = new Timer(2000, new ActionListener() {
        /**
         * After 2 seconds, this method opens the winner screen.
         *
         * @param e Looks for the start of the timer.
         */
        public void actionPerformed(ActionEvent e) {
            StartMenu.frame.setContentPane(new WinnerScreen().getJPanel());
            StartMenu.frame.pack();
            StartMenu.frame.setLocationRelativeTo(null);
            toWinnerScreen.stop();
        }
    });
    Timer toLoserScreen = new Timer(2000, new ActionListener() {
        /**
         * After 2 seconds, this method opens the loser screen.
         *
         * @param e Looks for the start of the timer.
         */
        public void actionPerformed(ActionEvent e) {
            StartMenu.frame.setContentPane(new LoserScreen().getJPanel());
            StartMenu.frame.pack();
            StartMenu.frame.setLocationRelativeTo(null);
            toLoserScreen.stop();
        }
    });

    /**
     * Constructor method for Elementalists class. Within this method, the array of image icons is defined and
     * constructed, the cards are randomized, the hand is displayed, and the methods on button click are called.
     */
    public Elementalists() {
        for (int i = 0; i < imageIcons.length; i++) {
            if (i < 10) {
                imageIcons[i] = new ImageIcon(firePath + "Fire" + (i + 1) + ".png");
            } else if (i < 20) {
                imageIcons[i] = new ImageIcon(waterPath + "Water" + (i - 9) + ".png");
            } else {
                imageIcons[i] = new ImageIcon(icePath + "Ice" + (i - 19) + ".png");
            }
        }

        player1 = randomizeCards();
        player2 = randomizeCards();
        p1Card1.setIcon(imageIcons[player1.get(0)]);
        p1Card2.setIcon(imageIcons[player1.get(1)]);
        p1Card3.setIcon(imageIcons[player1.get(2)]);
        p1Card4.setIcon(imageIcons[player1.get(3)]);
        p1Card5.setIcon(imageIcons[player1.get(4)]);

        /**
         * Method for when a card within the player's hand is selected. Nothing will run if canClick = false.
         * When run, the other card options will be greyed out to show off what card was selected, as well as
         * not allowing the player to click again. Then it will compare the cards and shuffle them. All card
         * buttons do the same thing, but for different cards.
         *
         * @param e Looks for button click.
         * @return Nothing.
         */
        p1Card1.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (canClick) {
                    canClick = false;
                    p1Card2.setEnabled(false);
                    p1Card3.setEnabled(false);
                    p1Card4.setEnabled(false);
                    p1Card5.setEnabled(false);
                    compareCards(player1.get(0), getPlayer2int());
                    shuffleCards(0);
                }
            }
        });
        p1Card2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (canClick) {
                    canClick = false;
                    p1Card1.setEnabled(false);
                    p1Card3.setEnabled(false);
                    p1Card4.setEnabled(false);
                    p1Card5.setEnabled(false);
                    compareCards(player1.get(1), getPlayer2int());
                    shuffleCards(1);
                }
            }
        });
        p1Card3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (canClick) {
                    canClick = false;
                    p1Card1.setEnabled(false);
                    p1Card2.setEnabled(false);
                    p1Card4.setEnabled(false);
                    p1Card5.setEnabled(false);
                    compareCards(player1.get(2), getPlayer2int());
                    shuffleCards(2);
                }
            }
        });
        p1Card4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (canClick) {
                    canClick = false;
                    p1Card1.setEnabled(false);
                    p1Card2.setEnabled(false);
                    p1Card3.setEnabled(false);
                    p1Card5.setEnabled(false);
                    compareCards(player1.get(3), getPlayer2int());
                    shuffleCards(3);
                }
            }
        });
        p1Card5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (canClick) {
                    canClick = false;
                    p1Card1.setEnabled(false);
                    p1Card2.setEnabled(false);
                    p1Card3.setEnabled(false);
                    p1Card4.setEnabled(false);
                    compareCards(player1.get(4), getPlayer2int());
                    shuffleCards(4);
                }
            }
        });
    }

    /**
     * Gets a random card for player 2. Also reveals player 2's card at a random card position.
     * @return Player 2's card ID.
     */
    private int getPlayer2int() {
        int player2int = player2.get(0);
        int randomCard = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        if (randomCard == 1) p2Card1.setIcon(imageIcons[player2.get(0)]);
        else if (randomCard == 2) p2Card2.setIcon(imageIcons[player2.get(0)]);
        else if (randomCard == 3) p2Card3.setIcon(imageIcons[player2.get(0)]);
        else if (randomCard == 4) p2Card4.setIcon(imageIcons[player2.get(0)]);
        else if (randomCard == 5) p2Card5.setIcon(imageIcons[player2.get(0)]);
        return player2int;
    }

    /**
     * First, this method will select a card for player 2 to play. Then it will determine the winner, and do actions
     * based on the winner. Then the round will reset and player 2's card will be discarded.
     *
     * @param player1int Player 1's card ID (0>x>10 -> fire, 10>x>20 -> water, 20>x>30 -> ice, x%10 -> value).
     * @param player2int Player 2's card ID.
     */
    public void compareCards(int player1int, int player2int) {

        ImageIcon blueAttack = new ImageIcon(attack1 + "blueAttack.gif");
        ImageIcon redDamage = new ImageIcon(attack2 + "redDamage.gif");
        ImageIcon blueDamage = new ImageIcon(attack1 + "blueDamage.gif");
        ImageIcon redAttack = new ImageIcon(attack2 + "redAttack.gif");

        if (player1int >= 0 && player1int <= 9) {
            if (player2int >= 10 && player2int <= 19) {
                action.setText("Enemy attacked with a water attack!");
                player1Icon.setIcon(blueDamage);
                player2Icon.setIcon(redAttack);
                p2WaterWins++;
                checkWinner();
            } else if (player2int >= 20 && player2int <= 29) {
                action.setText("You attacked with a fire attack!");
                player1Icon.setIcon(blueAttack);
                player2Icon.setIcon(redDamage);
                p1FireWins++;
                checkWinner();
            } else if (player2int >= 0 && player2int <= 9) {
                if (player1int > player2int) {
                    action.setText("You attacked with a stronger attack!");
                    player1Icon.setIcon(blueAttack);
                    player2Icon.setIcon(redDamage);
                    p1FireWins++;
                    checkWinner();
                } else if (player1int < player2int) {
                    action.setText("Enemy attacked with a stronger attack!");
                    player1Icon.setIcon(blueDamage);
                    player2Icon.setIcon(redAttack);
                    p2FireWins++;
                    checkWinner();
                } else {
                    action.setText("Both you and the enemy fizzled!");
                }
            }
        }
        else if (player1int >= 10 && player1int <= 19) {
            if (player2int >= 0 && player2int <= 9) {
                action.setText("You attacked with a water attack!");
                player1Icon.setIcon(blueAttack);
                player2Icon.setIcon(redDamage);
                p1WaterWins++;
                checkWinner();
            }
            else if (player2int >= 20 && player2int <= 29) {
                action.setText("Enemy attacked with a ice attack!");
                player1Icon.setIcon(blueDamage);
                player2Icon.setIcon(redAttack);
                p2IceWins++;
                checkWinner();
            }
            else if (player2int >= 10 && player2int <= 19) {
                if (player1int > player2int) {
                    action.setText("You attacked with a stronger attack!");
                    player1Icon.setIcon(blueAttack);
                    player2Icon.setIcon(redDamage);
                    p1WaterWins++;
                    checkWinner();
                }
                else if (player1int < player2int) {
                    action.setText("Enemy attacked with a stronger attack!");
                    player1Icon.setIcon(blueDamage);
                    player2Icon.setIcon(redAttack);
                    p2WaterWins++;
                    checkWinner();
                }
                else {
                    action.setText("Both you and the enemy fizzled!");
                }
            }
        }
        else if (player1int >= 20 && player1int <= 29) {
            if (player2int >= 0 && player2int <= 9) {
                action.setText("Enemy attacked with a fire attack!");
                player1Icon.setIcon(blueDamage);
                player2Icon.setIcon(redAttack);
                p2FireWins++;
                checkWinner();
            }
            else if (player2int >= 10 && player2int <= 19) {
                action.setText("You attacked with an ice attack!");
                player1Icon.setIcon(blueAttack);
                player2Icon.setIcon(redDamage);
                p1IceWins++;
                checkWinner();
            }
            else if (player2int >= 20 && player2int <= 29) {
                if (player1int > player2int) {
                    action.setText("You attacked with a stronger attack!");
                    player1Icon.setIcon(blueAttack);
                    player2Icon.setIcon(redDamage);
                    p1IceWins++;
                    checkWinner();
                } else if (player1int < player2int) {
                    action.setText("Enemy attacked with a stronger attack!");
                    player1Icon.setIcon(blueDamage);
                    player2Icon.setIcon(redAttack);
                    p2IceWins++;
                    checkWinner();
                } else {
                    action.setText("Both you and the enemy fizzled!");
                }
            }
        }

        resetRoundTimer.start();
        player2.remove(0);
    }

    /**
     * Determines if someone withs the game. If someone wins, the user will be informed, and the winner/loser
     * screen will be launched.
     */
    public void checkWinner() {
        if (p1FireWins == 3) {
            p1Fire1.setEnabled(true);
            p1Fire2.setEnabled(true);
            p1Fire3.setEnabled(true);
        }
        else if (p1FireWins == 2) {
            p1Fire1.setEnabled(true);
            p1Fire2.setEnabled(true);
        }
        else if (p1FireWins == 1) {
            p1Fire1.setEnabled(true);
        }
        if (p1WaterWins == 3) {
            p1Water1.setEnabled(true);
            p1Water2.setEnabled(true);
            p1Water3.setEnabled(true);
        }
        else if (p1WaterWins == 2) {
            p1Water1.setEnabled(true);
            p1Water2.setEnabled(true);
        }
        else if (p1WaterWins == 1) {
            p1Water1.setEnabled(true);
        }
        if (p1IceWins == 3) {
            p1Ice1.setEnabled(true);
            p1Ice2.setEnabled(true);
            p1Ice3.setEnabled(true);
        }
        else if (p1IceWins == 2) {
            p1Ice1.setEnabled(true);
            p1Ice2.setEnabled(true);
        }
        else if (p1IceWins == 1) {
            p1Ice1.setEnabled(true);
        }
        if (p2FireWins == 3) {
            p2Fire1.setEnabled(true);
            p2Fire2.setEnabled(true);
            p2Fire3.setEnabled(true);
        }
        else if (p2FireWins == 2) {
            p2Fire1.setEnabled(true);
            p2Fire2.setEnabled(true);
        }
        else if (p2FireWins == 1) {
            p2Fire1.setEnabled(true);
        }
        if (p2WaterWins == 3) {
            p2Water1.setEnabled(true);
            p2Water2.setEnabled(true);
            p2Water3.setEnabled(true);
        }
        else if (p2WaterWins == 2) {
            p2Water1.setEnabled(true);
            p2Water2.setEnabled(true);
        }
        else if (p2WaterWins == 1) {
            p2Water1.setEnabled(true);
        }
        if (p2IceWins == 3) {
            p2Ice1.setEnabled(true);
            p2Ice2.setEnabled(true);
            p2Ice3.setEnabled(true);
        }
        else if (p2IceWins == 2) {
            p2Ice1.setEnabled(true);
            p2Ice2.setEnabled(true);
        }
        else if (p2IceWins == 1) {
            p2Ice1.setEnabled(true);
        }

        if (p1FireWins == 3 || p1WaterWins == 3 || p1IceWins == 3 || (p1FireWins >= 1 && p1WaterWins >= 1 && p1IceWins >= 1)) {
            action.setText("You won the game!!! :)");
            toWinnerScreen.start();
        }
        if (p2FireWins == 3 || p2WaterWins == 3 || p2IceWins == 3 || (p2FireWins >= 1 && p2WaterWins >= 1 && p2IceWins >= 1)) {
            action.setText("You lost the game... :(");
            toLoserScreen.start();
        }
    }

    /**
     * Removes a card from player 1's deck and starts the addCards timer.
     *
     * @param remove determines the card to remove from player 1's deck.
     */
    public void shuffleCards(int remove) {
        player1.remove(remove);
        addCards.start();
    }

    /**
     * Randomizes player 1's deck from an array from 0-29.
     *
     * @return Randomized player 1 deck.
     */
    public static ArrayList<Integer> randomizeCards() {
        ArrayList<Integer> cardPool = new ArrayList<Integer>();
        for (int i = 0; i < 30; i++) {
            cardPool.add(i);
        }
        Collections.shuffle(cardPool);
        return cardPool;
    }

    /**
     * Returns current jPanel. Is used for switching between different screens.
     *
     * @return the current jPanel.
     */
    public JPanel getJPanel() {
        return jPanel;
    }

    /**
     * Full-screens the current window.
     * src: https://alvinalexander.com/blog/post/jfc-swing/how-set-jframe-size-fill-entire-screen-maximize/
     *
     * @param aFrame The frame that should be full-screened.
     */
    private static void fullScreen(JFrame aFrame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        aFrame.setSize(screenSize.width, screenSize.height);
    }

    /**
     * Main method. Opens the Elementalists frame to play the game.
     *
     * @param args Needed for main methods.
     * @deprecated
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("MyGameForm");
        frame.setContentPane(new Elementalists().jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fullScreen(frame);
        frame.setLocationRelativeTo(null);

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
        jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());
        jPanel.setBackground(new Color(-4149));
        jPanel.setEnabled(false);
        jPanel.setForeground(new Color(-4149));
        p2Fire1 = new JLabel();
        p2Fire1.setAlignmentY(0.0f);
        p2Fire1.setEnabled(false);
        p2Fire1.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/icons/FireIcon.png")));
        p2Fire1.setMaximumSize(new Dimension(30, 30));
        p2Fire1.setMinimumSize(new Dimension(0, 0));
        p2Fire1.setPreferredSize(new Dimension(30, 30));
        p2Fire1.setText("");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 0, 0, 0);
        jPanel.add(p2Fire1, gbc);
        p2Fire2 = new JLabel();
        p2Fire2.setAlignmentY(0.0f);
        p2Fire2.setEnabled(false);
        p2Fire2.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/icons/FireIcon.png")));
        p2Fire2.setMaximumSize(new Dimension(30, 30));
        p2Fire2.setMinimumSize(new Dimension(0, 0));
        p2Fire2.setPreferredSize(new Dimension(30, 30));
        p2Fire2.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 0, 0);
        jPanel.add(p2Fire2, gbc);
        p2Fire3 = new JLabel();
        p2Fire3.setAlignmentY(0.0f);
        p2Fire3.setEnabled(false);
        p2Fire3.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/icons/FireIcon.png")));
        p2Fire3.setMaximumSize(new Dimension(30, 30));
        p2Fire3.setMinimumSize(new Dimension(0, 0));
        p2Fire3.setPreferredSize(new Dimension(30, 30));
        p2Fire3.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 9;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 0, 0, 0);
        jPanel.add(p2Fire3, gbc);
        p2Water1 = new JLabel();
        p2Water1.setAlignmentY(0.0f);
        p2Water1.setEnabled(false);
        p2Water1.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/icons/WaterIcon.png")));
        p2Water1.setMaximumSize(new Dimension(30, 30));
        p2Water1.setMinimumSize(new Dimension(0, 0));
        p2Water1.setPreferredSize(new Dimension(30, 30));
        p2Water1.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 0, 0, 0);
        jPanel.add(p2Water1, gbc);
        p2Water2 = new JLabel();
        p2Water2.setAlignmentY(0.0f);
        p2Water2.setEnabled(false);
        p2Water2.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/icons/WaterIcon.png")));
        p2Water2.setMaximumSize(new Dimension(30, 30));
        p2Water2.setMinimumSize(new Dimension(0, 0));
        p2Water2.setPreferredSize(new Dimension(30, 30));
        p2Water2.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 2;
        gbc.insets = new Insets(5, 0, 0, 0);
        jPanel.add(p2Water2, gbc);
        p2Water3 = new JLabel();
        p2Water3.setAlignmentY(0.0f);
        p2Water3.setEnabled(false);
        p2Water3.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/icons/WaterIcon.png")));
        p2Water3.setMaximumSize(new Dimension(30, 30));
        p2Water3.setMinimumSize(new Dimension(0, 0));
        p2Water3.setPreferredSize(new Dimension(30, 30));
        p2Water3.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 9;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 0, 0, 0);
        jPanel.add(p2Water3, gbc);
        p2Ice2 = new JLabel();
        p2Ice2.setAlignmentY(0.0f);
        p2Ice2.setEnabled(false);
        p2Ice2.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/icons/IceIcon.png")));
        p2Ice2.setMaximumSize(new Dimension(30, 30));
        p2Ice2.setMinimumSize(new Dimension(0, 0));
        p2Ice2.setPreferredSize(new Dimension(30, 30));
        p2Ice2.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 3;
        gbc.insets = new Insets(5, 0, 0, 0);
        jPanel.add(p2Ice2, gbc);
        p2Ice3 = new JLabel();
        p2Ice3.setAlignmentY(0.0f);
        p2Ice3.setEnabled(false);
        p2Ice3.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/icons/IceIcon.png")));
        p2Ice3.setMaximumSize(new Dimension(30, 30));
        p2Ice3.setMinimumSize(new Dimension(0, 0));
        p2Ice3.setPreferredSize(new Dimension(30, 30));
        p2Ice3.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 9;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 0, 0, 0);
        jPanel.add(p2Ice3, gbc);
        p2Card1 = new JButton();
        p2Card1.setAlignmentY(0.0f);
        p2Card1.setAutoscrolls(false);
        p2Card1.setBackground(new Color(-16777216));
        p2Card1.setBorderPainted(false);
        p2Card1.setForeground(new Color(-16777216));
        p2Card1.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
        p2Card1.setIconTextGap(0);
        p2Card1.setMaximumSize(new Dimension(100, 160));
        p2Card1.setMinimumSize(new Dimension(100, 160));
        p2Card1.setPreferredSize(new Dimension(100, 160));
        p2Card1.setText("");
        p2Card1.setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 15, 10, 5);
        jPanel.add(p2Card1, gbc);
        p2Card5 = new JButton();
        p2Card5.setAlignmentY(0.0f);
        p2Card5.setAutoscrolls(false);
        p2Card5.setBackground(new Color(-16777216));
        p2Card5.setBorderPainted(false);
        p2Card5.setForeground(new Color(-16777216));
        p2Card5.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
        p2Card5.setIconTextGap(0);
        p2Card5.setMaximumSize(new Dimension(100, 160));
        p2Card5.setMinimumSize(new Dimension(100, 160));
        p2Card5.setPreferredSize(new Dimension(100, 160));
        p2Card5.setText("");
        p2Card5.setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 9;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 5, 10, 10);
        jPanel.add(p2Card5, gbc);
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Papyrus", -1, 48, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-7921800));
        label1.setText("Elementalists");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.insets = new Insets(25, 0, 0, 0);
        jPanel.add(label1, gbc);
        p2Ice1 = new JLabel();
        p2Ice1.setAlignmentY(0.0f);
        p2Ice1.setEnabled(false);
        p2Ice1.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/icons/IceIcon.png")));
        p2Ice1.setMaximumSize(new Dimension(30, 30));
        p2Ice1.setMinimumSize(new Dimension(0, 0));
        p2Ice1.setPreferredSize(new Dimension(30, 30));
        p2Ice1.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 0, 0, 0);
        jPanel.add(p2Ice1, gbc);
        player2Icon = new JLabel();
        player2Icon.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/player2/redIdle.gif")));
        player2Icon.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 4;
        gbc.gridwidth = 5;
        gbc.insets = new Insets(30, 0, 0, 0);
        jPanel.add(player2Icon, gbc);
        action = new JLabel();
        Font actionFont = this.$$$getFont$$$("Arial", -1, 20, action.getFont());
        if (actionFont != null) action.setFont(actionFont);
        action.setForeground(new Color(-16777216));
        action.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.gridheight = 3;
        jPanel.add(action, gbc);
        player1Icon = new JLabel();
        player1Icon.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/player1/blueIdle.gif")));
        player1Icon.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 5;
        gbc.insets = new Insets(30, 0, 0, 0);
        jPanel.add(player1Icon, gbc);
        p1Card1 = new JButton();
        p1Card1.setAlignmentY(0.0f);
        p1Card1.setAutoscrolls(false);
        p1Card1.setBackground(new Color(-16777216));
        p1Card1.setBorderPainted(false);
        p1Card1.setForeground(new Color(-16777216));
        p1Card1.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
        p1Card1.setIconTextGap(0);
        p1Card1.setMaximumSize(new Dimension(100, 160));
        p1Card1.setMinimumSize(new Dimension(100, 160));
        p1Card1.setPreferredSize(new Dimension(100, 160));
        p1Card1.setText("");
        p1Card1.setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 5);
        jPanel.add(p1Card1, gbc);
        p1Card2 = new JButton();
        p1Card2.setAlignmentY(0.0f);
        p1Card2.setAutoscrolls(false);
        p1Card2.setBackground(new Color(-16777216));
        p1Card2.setBorderPainted(false);
        p1Card2.setForeground(new Color(-16777216));
        p1Card2.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
        p1Card2.setIconTextGap(0);
        p1Card2.setMaximumSize(new Dimension(100, 160));
        p1Card2.setMinimumSize(new Dimension(100, 160));
        p1Card2.setPreferredSize(new Dimension(100, 160));
        p1Card2.setText("");
        p1Card2.setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 5, 10, 5);
        jPanel.add(p1Card2, gbc);
        p1Card3 = new JButton();
        p1Card3.setAlignmentY(0.0f);
        p1Card3.setAutoscrolls(false);
        p1Card3.setBackground(new Color(-16777216));
        p1Card3.setBorderPainted(false);
        p1Card3.setForeground(new Color(-16777216));
        p1Card3.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
        p1Card3.setIconTextGap(0);
        p1Card3.setMaximumSize(new Dimension(100, 160));
        p1Card3.setMinimumSize(new Dimension(100, 160));
        p1Card3.setPreferredSize(new Dimension(100, 160));
        p1Card3.setText("");
        p1Card3.setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 5, 10, 5);
        jPanel.add(p1Card3, gbc);
        p1Card4 = new JButton();
        p1Card4.setAlignmentY(0.0f);
        p1Card4.setAutoscrolls(false);
        p1Card4.setBackground(new Color(-16777216));
        p1Card4.setBorderPainted(false);
        p1Card4.setForeground(new Color(-16777216));
        p1Card4.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
        p1Card4.setIconTextGap(0);
        p1Card4.setMaximumSize(new Dimension(100, 160));
        p1Card4.setMinimumSize(new Dimension(100, 160));
        p1Card4.setPreferredSize(new Dimension(100, 160));
        p1Card4.setText("");
        p1Card4.setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 5, 10, 5);
        jPanel.add(p1Card4, gbc);
        p1Card5 = new JButton();
        p1Card5.setAlignmentY(0.0f);
        p1Card5.setAutoscrolls(false);
        p1Card5.setBackground(new Color(-16777216));
        p1Card5.setBorderPainted(false);
        p1Card5.setForeground(new Color(-16777216));
        p1Card5.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
        p1Card5.setIconTextGap(0);
        p1Card5.setMaximumSize(new Dimension(100, 160));
        p1Card5.setMinimumSize(new Dimension(100, 160));
        p1Card5.setPreferredSize(new Dimension(100, 160));
        p1Card5.setText("");
        p1Card5.setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 5, 10, 15);
        jPanel.add(p1Card5, gbc);
        p1Fire1 = new JLabel();
        p1Fire1.setAlignmentY(0.0f);
        p1Fire1.setDoubleBuffered(true);
        p1Fire1.setEnabled(false);
        p1Fire1.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/icons/FireIcon.png")));
        p1Fire1.setMaximumSize(new Dimension(30, 30));
        p1Fire1.setMinimumSize(new Dimension(0, 0));
        p1Fire1.setPreferredSize(new Dimension(30, 30));
        p1Fire1.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 0, 0, 0);
        jPanel.add(p1Fire1, gbc);
        p1Fire2 = new JLabel();
        p1Fire2.setAlignmentY(0.0f);
        p1Fire2.setEnabled(false);
        p1Fire2.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/icons/FireIcon.png")));
        p1Fire2.setMaximumSize(new Dimension(30, 30));
        p1Fire2.setMinimumSize(new Dimension(0, 0));
        p1Fire2.setPreferredSize(new Dimension(30, 30));
        p1Fire2.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 0, 0);
        jPanel.add(p1Fire2, gbc);
        p1Fire3 = new JLabel();
        p1Fire3.setAlignmentY(0.0f);
        p1Fire3.setEnabled(false);
        p1Fire3.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/icons/FireIcon.png")));
        p1Fire3.setMaximumSize(new Dimension(30, 30));
        p1Fire3.setMinimumSize(new Dimension(0, 0));
        p1Fire3.setPreferredSize(new Dimension(30, 30));
        p1Fire3.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 0, 0, 0);
        jPanel.add(p1Fire3, gbc);
        p1Water1 = new JLabel();
        p1Water1.setAlignmentY(0.0f);
        p1Water1.setEnabled(false);
        p1Water1.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/icons/WaterIcon.png")));
        p1Water1.setMaximumSize(new Dimension(30, 30));
        p1Water1.setMinimumSize(new Dimension(0, 0));
        p1Water1.setPreferredSize(new Dimension(30, 30));
        p1Water1.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 0, 0, 0);
        jPanel.add(p1Water1, gbc);
        p1Water2 = new JLabel();
        p1Water2.setAlignmentY(0.0f);
        p1Water2.setEnabled(false);
        p1Water2.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/icons/WaterIcon.png")));
        p1Water2.setMaximumSize(new Dimension(30, 30));
        p1Water2.setMinimumSize(new Dimension(0, 0));
        p1Water2.setPreferredSize(new Dimension(30, 30));
        p1Water2.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(5, 0, 0, 0);
        jPanel.add(p1Water2, gbc);
        p1Water3 = new JLabel();
        p1Water3.setAlignmentY(0.0f);
        p1Water3.setEnabled(false);
        p1Water3.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/icons/WaterIcon.png")));
        p1Water3.setMaximumSize(new Dimension(30, 30));
        p1Water3.setMinimumSize(new Dimension(0, 0));
        p1Water3.setPreferredSize(new Dimension(30, 30));
        p1Water3.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 0, 0, 0);
        jPanel.add(p1Water3, gbc);
        p1Ice2 = new JLabel();
        p1Ice2.setAlignmentY(0.0f);
        p1Ice2.setEnabled(false);
        p1Ice2.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/icons/IceIcon.png")));
        p1Ice2.setMaximumSize(new Dimension(30, 30));
        p1Ice2.setMinimumSize(new Dimension(0, 0));
        p1Ice2.setPreferredSize(new Dimension(30, 30));
        p1Ice2.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(5, 0, 0, 0);
        jPanel.add(p1Ice2, gbc);
        p1Ice3 = new JLabel();
        p1Ice3.setAlignmentY(0.0f);
        p1Ice3.setEnabled(false);
        p1Ice3.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/icons/IceIcon.png")));
        p1Ice3.setMaximumSize(new Dimension(30, 30));
        p1Ice3.setMinimumSize(new Dimension(0, 0));
        p1Ice3.setPreferredSize(new Dimension(30, 30));
        p1Ice3.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 0, 0, 0);
        jPanel.add(p1Ice3, gbc);
        p1Ice1 = new JLabel();
        p1Ice1.setAlignmentY(0.0f);
        p1Ice1.setEnabled(false);
        p1Ice1.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/icons/IceIcon.png")));
        p1Ice1.setMaximumSize(new Dimension(30, 30));
        p1Ice1.setMinimumSize(new Dimension(0, 0));
        p1Ice1.setPreferredSize(new Dimension(30, 30));
        p1Ice1.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 0, 0, 0);
        jPanel.add(p1Ice1, gbc);
        p2Card3 = new JButton();
        p2Card3.setAlignmentY(0.0f);
        p2Card3.setAutoscrolls(false);
        p2Card3.setBackground(new Color(-16777216));
        p2Card3.setBorderPainted(false);
        p2Card3.setForeground(new Color(-16777216));
        p2Card3.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
        p2Card3.setIconTextGap(0);
        p2Card3.setMaximumSize(new Dimension(100, 160));
        p2Card3.setMinimumSize(new Dimension(100, 160));
        p2Card3.setPreferredSize(new Dimension(100, 160));
        p2Card3.setText("");
        p2Card3.setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 5, 10, 5);
        jPanel.add(p2Card3, gbc);
        p2Card2 = new JButton();
        p2Card2.setAlignmentY(0.0f);
        p2Card2.setAutoscrolls(false);
        p2Card2.setBackground(new Color(-16777216));
        p2Card2.setBorderPainted(false);
        p2Card2.setForeground(new Color(-16777216));
        p2Card2.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
        p2Card2.setIconTextGap(0);
        p2Card2.setMaximumSize(new Dimension(100, 160));
        p2Card2.setMinimumSize(new Dimension(100, 160));
        p2Card2.setPreferredSize(new Dimension(100, 160));
        p2Card2.setText("");
        p2Card2.setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 5, 10, 5);
        jPanel.add(p2Card2, gbc);
        p2Card4 = new JButton();
        p2Card4.setAlignmentY(0.0f);
        p2Card4.setAutoscrolls(false);
        p2Card4.setBackground(new Color(-16777216));
        p2Card4.setBorderPainted(false);
        p2Card4.setForeground(new Color(-16777216));
        p2Card4.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
        p2Card4.setIconTextGap(0);
        p2Card4.setMaximumSize(new Dimension(100, 160));
        p2Card4.setMinimumSize(new Dimension(100, 160));
        p2Card4.setPreferredSize(new Dimension(100, 160));
        p2Card4.setText("");
        p2Card4.setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 5, 10, 5);
        jPanel.add(p2Card4, gbc);
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
        return jPanel;
    }

}
