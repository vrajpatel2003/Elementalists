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
//    static JFrame frame = new JFrame("Elementalists");

    //REMOVE "/src" FROM ALL 3 PATHS BEFORE SUBMITTING
    String firePath = "./src/elementalists.img/cards/Fire/";
    String waterPath = "./src/elementalists.img/cards/Water/";
    String icePath = "./src/elementalists.img/cards/Ice/";
    String attack1 = "./src/elementalists.img/player1/";
    String attack2 = "./src/elementalists.img/player2/";
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
    Timer timer = new Timer(2000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            canClick = true;
            player1Icon.setIcon(new ImageIcon(attack1 + "/blueIdle.gif"));
            player2Icon.setIcon(new ImageIcon(attack2 + "/redIdle.gif"));
            p2Card1.setIcon(new ImageIcon("./src/elementalists.img/cards/cardback.png"));
            p2Card2.setIcon(new ImageIcon("./src/elementalists.img/cards/cardback.png"));
            p2Card3.setIcon(new ImageIcon("./src/elementalists.img/cards/cardback.png"));
            p2Card4.setIcon(new ImageIcon("./src/elementalists.img/cards/cardback.png"));
            p2Card5.setIcon(new ImageIcon("./src/elementalists.img/cards/cardback.png"));
            timer.stop();
        }
    });
    Timer timer2 = new Timer(2000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int a = player1.size();
            if (a > 5) {
                p1Card1.setIcon(imageIcons[player1.get(0)]);
                p1Card2.setIcon(imageIcons[player1.get(1)]);
                p1Card3.setIcon(imageIcons[player1.get(2)]);
                p1Card4.setIcon(imageIcons[player1.get(3)]);
                p1Card5.setIcon(imageIcons[player1.get(4)]);
            } else if (a == 5) {
                p1Card1.setIcon(imageIcons[player1.get(0)]);
                p1Card2.setIcon(imageIcons[player1.get(1)]);
                p1Card3.setIcon(imageIcons[player1.get(2)]);
                p1Card4.setIcon(imageIcons[player1.get(3)]);
                p1Card5.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
            } else if (a == 4) {
                p1Card1.setIcon(imageIcons[player1.get(0)]);
                p1Card2.setIcon(imageIcons[player1.get(1)]);
                p1Card3.setIcon(imageIcons[player1.get(2)]);
                p1Card4.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
                p1Card5.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
            } else if (a == 3) {
                p1Card1.setIcon(imageIcons[player1.get(0)]);
                p1Card2.setIcon(imageIcons[player1.get(1)]);
                p1Card3.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
                p1Card4.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
                p1Card5.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
            } else if (a == 2) {
                p1Card1.setIcon(imageIcons[player1.get(0)]);
                p1Card2.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
                p1Card3.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
                p1Card4.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
                p1Card5.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
            } else if (a == 1) {
                p1Card1.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
                p1Card2.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
                p1Card3.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
                p1Card4.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
                p1Card5.setIcon(new ImageIcon(getClass().getResource("/elementalists/img/cards/cardback.png")));
            }
            p1Card1.setEnabled(true);
            p1Card2.setEnabled(true);
            p1Card3.setEnabled(true);
            p1Card4.setEnabled(true);
            p1Card5.setEnabled(true);
            timer2.stop();
        }
    });

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


        p1Card1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (canClick) {
                        canClick = false;
                        p1Card2.setEnabled(false);
                        p1Card3.setEnabled(false);
                        p1Card4.setEnabled(false);
                        p1Card5.setEnabled(false);
                        compareCards(player1.get(0));
                        shuffleCards(0);
                    }
                } catch (IndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "game over");
                }
            }
        });
        p1Card2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (canClick) {
                        canClick = false;
                        p1Card1.setEnabled(false);
                        p1Card3.setEnabled(false);
                        p1Card4.setEnabled(false);
                        p1Card5.setEnabled(false);
                        compareCards(player1.get(1));
                        shuffleCards(1);
                    }
                } catch (IndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "game over");
                }
            }
        });
        p1Card3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (canClick) {
                        canClick = false;
                        p1Card1.setEnabled(false);
                        p1Card2.setEnabled(false);
                        p1Card4.setEnabled(false);
                        p1Card5.setEnabled(false);
                        compareCards(player1.get(2));
                        shuffleCards(2);
                    }
                } catch (IndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "game over");
                }
            }
        });
        p1Card4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (canClick) {
                        canClick = false;
                        p1Card1.setEnabled(false);
                        p1Card2.setEnabled(false);
                        p1Card3.setEnabled(false);
                        p1Card5.setEnabled(false);
                        compareCards(player1.get(3));
                        shuffleCards(3);
                    }
                } catch (IndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "game over");
                }
            }
        });
        p1Card5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (canClick) {
                        canClick = false;
                        p1Card1.setEnabled(false);
                        p1Card2.setEnabled(false);
                        p1Card3.setEnabled(false);
                        p1Card4.setEnabled(false);
                        compareCards(player1.get(4));
                        shuffleCards(4);
                    }
                } catch (IndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "game over");
                }
            }
        });
    }

    public void compareCards(int player1int) {

        ImageIcon blueAttack = new ImageIcon(attack1 + "blueAttack.gif");
        ImageIcon redDamage = new ImageIcon(attack2 + "redDamage.gif");
        ImageIcon blueDamage = new ImageIcon(attack1 + "blueDamage.gif");
        ImageIcon redAttack = new ImageIcon(attack2 + "redAttack.gif");
        ImageIcon cardBack = new ImageIcon("./src/elementalists.img/cards/cardback.png");

        int player2int = player2.get(0);
        int randomCard = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        if (randomCard == 1) p2Card1.setIcon(imageIcons[player2.get(0)]);
        else if (randomCard == 2) p2Card2.setIcon(imageIcons[player2.get(0)]);
        else if (randomCard == 3) p2Card3.setIcon(imageIcons[player2.get(0)]);
        else if (randomCard == 4) p2Card4.setIcon(imageIcons[player2.get(0)]);
        else if (randomCard == 5) p2Card5.setIcon(imageIcons[player2.get(0)]);

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
        } else if (player1int >= 10 && player1int <= 19) {
            if (player2int >= 0 && player2int <= 9) {
                action.setText("You attacked with a water attack!");
                player1Icon.setIcon(blueAttack);
                player2Icon.setIcon(redDamage);
                p1WaterWins++;
                checkWinner();
            } else if (player2int >= 20 && player2int <= 29) {
                action.setText("Enemy attacked with a ice attack!");
                player1Icon.setIcon(blueDamage);
                player2Icon.setIcon(redAttack);
                p2IceWins++;
                checkWinner();
            } else if (player2int >= 10 && player2int <= 19) {
                if (player1int > player2int) {
                    action.setText("You attacked with a stronger attack!");
                    player1Icon.setIcon(blueAttack);
                    player2Icon.setIcon(redDamage);
                    p1WaterWins++;
                    checkWinner();
                } else if (player1int < player2int) {
                    action.setText("Enemy attacked with a stronger attack!");
                    player1Icon.setIcon(blueDamage);
                    player2Icon.setIcon(redAttack);
                    p2WaterWins++;
                    checkWinner();
                } else {
                    action.setText("Both you and the enemy fizzled!");
                }
            }
        } else if (player1int >= 20 && player1int <= 29) {
            if (player2int >= 0 && player2int <= 9) {
                action.setText("Enemy attacked with a fire attack!");
                player1Icon.setIcon(blueDamage);
                player2Icon.setIcon(redAttack);
                p2FireWins++;
                checkWinner();
            } else if (player2int >= 10 && player2int <= 19) {
                action.setText("You attacked with an ice attack!");
                player1Icon.setIcon(blueAttack);
                player2Icon.setIcon(redDamage);
                p1IceWins++;
                checkWinner();
            } else if (player2int >= 20 && player2int <= 29) {
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
        timer.start();
        player2.remove(0);
    }

    Timer toWinnerScreen = new Timer(2000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.out.println("TIMER IS RUNNING");
            StartMenu.frame.setContentPane(new WinnerScreen().getJPanel());
            StartMenu.frame.pack();
            StartMenu.frame.setLocationRelativeTo(null);
            toWinnerScreen.stop();
        }
    });

    Timer toLoserScreen = new Timer(2000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.out.println("TIMER IS RUNNING");
            StartMenu.frame.setContentPane(new LoserScreen().getJPanel());
            StartMenu.frame.pack();
            StartMenu.frame.setLocationRelativeTo(null);
            toLoserScreen.stop();
        }
    });

    public void checkWinner() {
        if (p1FireWins == 3) {
            p1Fire1.setEnabled(true);
            p1Fire2.setEnabled(true);
            p1Fire3.setEnabled(true);
        } else if (p1FireWins == 2) {
            p1Fire1.setEnabled(true);
            p1Fire2.setEnabled(true);
        } else if (p1FireWins == 1) {
            p1Fire1.setEnabled(true);
        }
        if (p1WaterWins == 3) {
            p1Water1.setEnabled(true);
            p1Water2.setEnabled(true);
            p1Water3.setEnabled(true);
        } else if (p1WaterWins == 2) {
            p1Water1.setEnabled(true);
            p1Water2.setEnabled(true);
        } else if (p1WaterWins == 1) {
            p1Water1.setEnabled(true);
        }
        if (p1IceWins == 3) {
            p1Ice1.setEnabled(true);
            p1Ice2.setEnabled(true);
            p1Ice3.setEnabled(true);
        } else if (p1IceWins == 2) {
            p1Ice1.setEnabled(true);
            p1Ice2.setEnabled(true);
        } else if (p1IceWins == 1) {
            p1Ice1.setEnabled(true);
        }
        if (p2FireWins == 3) {
            p2Fire1.setEnabled(true);
            p2Fire2.setEnabled(true);
            p2Fire3.setEnabled(true);
        } else if (p2FireWins == 2) {
            p2Fire1.setEnabled(true);
            p2Fire2.setEnabled(true);
        } else if (p2FireWins == 1) {
            p2Fire1.setEnabled(true);
        }
        if (p2WaterWins == 3) {
            p2Water1.setEnabled(true);
            p2Water2.setEnabled(true);
            p2Water3.setEnabled(true);
        } else if (p2WaterWins == 2) {
            p2Water1.setEnabled(true);
            p2Water2.setEnabled(true);
        } else if (p2WaterWins == 1) {
            p2Water1.setEnabled(true);
        }
        if (p2IceWins == 3) {
            p2Ice1.setEnabled(true);
            p2Ice2.setEnabled(true);
            p2Ice3.setEnabled(true);
        } else if (p2IceWins == 2) {
            p2Ice1.setEnabled(true);
            p2Ice2.setEnabled(true);
        } else if (p2IceWins == 1) {
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

    public void shuffleCards(int remove) {
        player1.remove(remove);
        timer2.start();
    }

    public static ArrayList<Integer> randomizeCards() {
        ArrayList<Integer> cardPool = new ArrayList<Integer>();
        for (int i = 0; i < 30; i++) {
            cardPool.add(i);
        }
        Collections.shuffle(cardPool);
        return cardPool;
    }

    public JPanel getJPanel() {
        return jPanel;
    }

    private static void fullScreen(JFrame aFrame) { // src = https://alvinalexander.com/blog/post/jfc-swing/how-set-jframe-size-fill-entire-screen-maximize/
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        aFrame.setSize(screenSize.width, screenSize.height);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyGameForm");
        frame.setContentPane(new Elementalists().jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fullScreen(frame);
        //frame.pack();
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