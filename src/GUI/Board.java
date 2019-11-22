package GUI;

import util.Player;
import util.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Timo Peters on 21.11.2019.
 */
public class Board {

    private JFrame jFrame;
    private Draw draw;
    private JButton[][] buttons = new JButton[3][3];
    private JButton reset;

    public static final Player DEFAULT_STARTING_PLAYER = Player.X;
    private Player currentPlayer = DEFAULT_STARTING_PLAYER;
    private Player winner = null;
    private State[][] states = new State[3][3];

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

        draw = new Draw(this);
        draw.setBounds(0, 0, 800, 600);
        draw.setVisible(true);
        jFrame.add(draw);

        jFrame.setVisible(true);
    }

    public void reset() {
        currentPlayer = DEFAULT_STARTING_PLAYER;
        winner = null;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                states[i][j] = State.EMPTY;
            }
        }
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
    }

    public State[][] getStates() {
        return states;
    }
}
