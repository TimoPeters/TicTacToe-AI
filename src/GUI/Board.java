package GUI;

import javafx.scene.control.ComboBox;
import util.Mode;
import util.Player;
import util.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timo Peters on 21.11.2019.
 */
public class Board {

    private JFrame jFrame;
    private Draw draw;
    public static JButton[][] buttons = new JButton[3][3];
    private JButton reset;
    private Checkbox aiStarts;
    private JComboBox<String> modeBox;

    public static final Player DEFAULT_STARTING_PLAYER = Player.X;
    public static Mode currentMode = Mode.PVP;
    public static Player currentPlayer = DEFAULT_STARTING_PLAYER;
    public static Player winner = null;
    public static State[][] states = new State[3][3];

    public Board() {
        jFrame = new JFrame();
        jFrame.setSize(800, 700);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setTitle("TicTacToe-AI");

        createButtons();
        placeButtons();
        fillStates();

        reset = new JButton("Reset");
        reset.setBounds(675, 575, 100, 40);
        reset.setBackground(new Color(51, 102, 153));
        reset.setForeground(Color.WHITE);
        reset.setFocusPainted(false);
        reset.setVisible(true);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
        jFrame.add(reset);

        aiStarts = new Checkbox("AI Starts");
        aiStarts.setVisible(true);
        aiStarts.setBounds(25, 600, 100, 40);
        aiStarts.setState(true);
        jFrame.add(aiStarts);

        String[] modes = {"2 Players", "AI"};
        modeBox = new JComboBox<String>(modes);
        modeBox.setSelectedIndex(0);
        modeBox.setVisible(true);
        modeBox.setBounds(25, 575, 100, 20);
        modeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (modeBox.getSelectedIndex() == 0) {
                    if (isEmpty()) {
                        currentMode = Mode.PVP;
                        System.out.println(0 + ": " + modes[modeBox.getSelectedIndex()] + "\nmode: " + currentMode);
                    }
                } else if (modeBox.getSelectedIndex() == 1) {
                    if (isEmpty()) {
                        currentMode = Mode.PVB;
                        System.out.println(1 + ": " + modes[modeBox.getSelectedIndex()] + "\nmode: " + currentMode);
                    }
                }
            }
        });
        jFrame.add(modeBox);

        draw = new Draw(this);
        draw.setBounds(0, 0, 800, 600);
        draw.setVisible(true);
        jFrame.add(draw);

        jFrame.setVisible(true);
    }

    public static List<int[]> getEmptySpots() {
        List<int[]> returnList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (states[i][j] == State.EMPTY) {
                    returnList.add(new int[]{i, j});
                }
            }
        }

        return returnList;
    }

    public void reset() {
        currentPlayer = DEFAULT_STARTING_PLAYER;
        winner = null;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                states[i][j] = State.EMPTY;
            }
        }

        if (modeBox.getSelectedIndex() == 0) {
            if (isEmpty()) {
                currentMode = Mode.PVP;
            }
        } else if (modeBox.getSelectedIndex() == 1) {
            if (isEmpty()) {
                currentMode = Mode.PVB;
            }
        }
        System.out.println("Reset");
    }

    private void createButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setVisible(true);
                buttons[i][j].addActionListener(new ActionHandler(this));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].setContentAreaFilled(false);
                buttons[i][j].setBorder(null);
                jFrame.add(buttons[i][j]);
                buttons[i][j] = buttons[i][j];
                System.out.println("Created new JButton at: [" + i + "][" + j + "]");
            }
        }
    }

    private void placeButtons() {

        //Row 1
        buttons[0][0].setBounds(175, 50, 150, 150);
        buttons[0][1].setBounds(325, 50, 150, 150);
        buttons[0][2].setBounds(475, 50, 150, 150);

        //Row 2
        buttons[1][0].setBounds(175, 200, 150, 150);
        buttons[1][1].setBounds(325, 200, 150, 150);
        buttons[1][2].setBounds(475, 200, 150, 150);

        //Row 3
        buttons[2][0].setBounds(175, 350, 150, 150);
        buttons[2][1].setBounds(325, 350, 150, 150);
        buttons[2][2].setBounds(475, 350, 150, 150);
    }

    private void fillStates() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                states[i][j] = State.EMPTY;
            }
        }
    }

    private boolean isEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (states[i][j] == State.O || states[i][j] == State.X) {
                    return false;
                }
            }
        }
        return true;
    }

    public JButton[][] getButtons() {
        return buttons;
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player player) {
        this.winner = player;
        if (player != Player.DRAW) {
            System.out.println("Winner: " + player);
        } else {
            System.out.println("Draw");
        }
    }

    public State[][] getStates() {
        return states;
    }
}
