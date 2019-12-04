package GUI;

import AI.MiniMax;
import Game.GameLogic;
import util.Mode;
import util.Player;
import util.State;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Timo Peters on 21.11.2019.
 */
public class ActionHandler implements ActionListener {

    private Board board;
    private JButton[][] buttons;
    private State[][] states;

    public ActionHandler(Board board) {
        this.board = board;
        buttons = board.getButtons();
        states = board.getStates();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (board.getWinner() == null) {
            //Row 1
            if (e.getSource() == buttons[0][0]) {
                if (states[0][0] == State.EMPTY && board.getCurrentPlayer() == Player.X) {
                    states[0][0] = State.X;
                    board.setCurrentPlayer(Player.O);
                    System.out.println(states[0][0] + " placed at [0][0]");
                    if (Board.currentMode == Mode.PVB) {
                        MiniMax.aiMove();
                    }
                } else if (states[0][0] == State.EMPTY && board.getCurrentPlayer() == Player.O) {
                    states[0][0] = State.O;
                    board.setCurrentPlayer(Player.X);
                    System.out.println(states[0][0] + " placed at [0][0]");
                }
            }

            if (e.getSource() == buttons[0][1]) {
                if (states[0][1] == State.EMPTY && board.getCurrentPlayer() == Player.X) {
                    states[0][1] = State.X;
                    board.setCurrentPlayer(Player.O);
                    System.out.println(states[0][1] + " placed at [0][1]");
                    if (Board.currentMode == Mode.PVB) {
                        MiniMax.aiMove();
                    }
                } else if (states[0][1] == State.EMPTY && board.getCurrentPlayer() == Player.O) {
                    states[0][1] = State.O;
                    board.setCurrentPlayer(Player.X);
                    System.out.println(states[0][1] + " placed at [0][1]");
                }
            }

            if (e.getSource() == buttons[0][2]) {
                if (states[0][2] == State.EMPTY && board.getCurrentPlayer() == Player.X) {
                    states[0][2] = State.X;
                    board.setCurrentPlayer(Player.O);
                    System.out.println(states[0][2] + " placed at [0][2]");
                    if (Board.currentMode == Mode.PVB) {
                        MiniMax.aiMove();
                    }
                } else if (states[0][2] == State.EMPTY && board.getCurrentPlayer() == Player.O) {
                    states[0][2] = State.O;
                    board.setCurrentPlayer(Player.X);
                    System.out.println(states[0][2] + " placed at [0][2]");
                }
            }
            // Row 2
            if (e.getSource() == buttons[1][0]) {
                if (states[1][0] == State.EMPTY && board.getCurrentPlayer() == Player.X) {
                    states[1][0] = State.X;
                    board.setCurrentPlayer(Player.O);
                    System.out.println(states[1][0] + " placed at [1][0]");
                    if (Board.currentMode == Mode.PVB) {
                        MiniMax.aiMove();
                    }
                } else if (states[1][0] == State.EMPTY && board.getCurrentPlayer() == Player.O) {
                    states[1][0] = State.O;
                    board.setCurrentPlayer(Player.X);
                    System.out.println(states[1][0] + " placed at [1][0]");
                }
            }
            if (e.getSource() == buttons[1][1]) {
                if (states[1][1] == State.EMPTY && board.getCurrentPlayer() == Player.X) {
                    states[1][1] = State.X;
                    board.setCurrentPlayer(Player.O);
                    System.out.println(states[1][1] + " placed at [1][1]");
                    if (Board.currentMode == Mode.PVB) {
                        MiniMax.aiMove();
                    }
                } else if (states[1][1] == State.EMPTY && board.getCurrentPlayer() == Player.O) {
                    states[1][1] = State.O;
                    board.setCurrentPlayer(Player.X);
                    System.out.println(states[1][1] + " placed at [1][1]");
                }
            }
            if (e.getSource() == buttons[1][2]) {
                if (states[1][2] == State.EMPTY && board.getCurrentPlayer() == Player.X) {
                    states[1][2] = State.X;
                    board.setCurrentPlayer(Player.O);
                    System.out.println(states[1][2] + " placed at [1][2]");
                    if (Board.currentMode == Mode.PVB) {
                        MiniMax.aiMove();
                    }
                } else if (states[1][2] == State.EMPTY && board.getCurrentPlayer() == Player.O) {
                    states[1][2] = State.O;
                    board.setCurrentPlayer(Player.X);
                    System.out.println(states[1][2] + " placed at [1][2]");
                }
            }
            //Row 3
            if (e.getSource() == buttons[2][0]) {
                if (states[2][0] == State.EMPTY && board.getCurrentPlayer() == Player.X) {
                    states[2][0] = State.X;
                    board.setCurrentPlayer(Player.O);
                    System.out.println(states[2][0] + " placed at [2][0]");
                    if (Board.currentMode == Mode.PVB) {
                        MiniMax.aiMove();
                    }
                } else if (states[2][0] == State.EMPTY && board.getCurrentPlayer() == Player.O) {
                    states[2][0] = State.O;
                    board.setCurrentPlayer(Player.X);
                    System.out.println(states[2][0] + " placed at [2][0]");
                }
            }
            if (e.getSource() == buttons[2][1]) {
                if (states[2][1] == State.EMPTY && board.getCurrentPlayer() == Player.X) {
                    states[2][1] = State.X;
                    board.setCurrentPlayer(Player.O);
                    System.out.println(states[2][1] + " placed at [2][1]");
                    if (Board.currentMode == Mode.PVB) {
                        MiniMax.aiMove();
                    }
                } else if (states[2][1] == State.EMPTY && board.getCurrentPlayer() == Player.O) {
                    states[2][1] = State.O;
                    board.setCurrentPlayer(Player.X);
                    System.out.println(states[2][1] + " placed at [2][1]");
                }
            }
            if (e.getSource() == buttons[2][2]) {
                if (states[2][2] == State.EMPTY && board.getCurrentPlayer() == Player.X) {
                    states[2][2] = State.X;
                    board.setCurrentPlayer(Player.O);
                    System.out.println(states[2][2] + " placed at [2][2]");
                    if (Board.currentMode == Mode.PVB) {
                        MiniMax.aiMove();
                    }
                } else if (states[2][2] == State.EMPTY && board.getCurrentPlayer() == Player.O) {
                    states[2][2] = State.O;
                    board.setCurrentPlayer(Player.X);
                    System.out.println(states[2][2] + " placed at [2][2]");
                }
            }
        }

        GameLogic.checkWinner(board);
    }
}
