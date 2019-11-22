package Game;

import GUI.Board;
import util.Player;
import util.State;

/**
 * Created by Timo Peters on 21.11.2019.
 */
public class GameLogic {
    public static void checkWinner(Board board) {
        State[][] states = board.getStates();
        Player winner;

        //Horizontal
        if (states[0][0] == states[0][1] && states[0][0] == states[0][2]) {
            if (states[0][0] == State.X) {
                board.setWinner(Player.X);
            } else if (states[0][0] == State.O) {
                board.setWinner(Player.O);
            }
        }
        if (states[1][0] == states[1][1] && states[1][0] == states[1][2]) {
            if (states[1][0] == State.X) {
                board.setWinner(Player.X);
            } else if (states[1][0] == State.O) {
                board.setWinner(Player.O);
            }
        }
        if (states[2][0] == states[2][1] && states[2][0] == states[2][2]) {
            if (states[2][0] == State.X) {
                board.setWinner(Player.X);
            } else if (states[2][0] == State.O) {
                board.setWinner(Player.O);
            }
        }

        //Vertical
        if (states[0][0] == states[1][0] && states[0][0] == states[2][0]) {
            if (states[0][0] == State.X) {
                board.setWinner(Player.X);
            } else if (states[0][0] == State.O) {
                board.setWinner(Player.O);
            }
        }
        if (states[0][1] == states[1][1] && states[0][1] == states[2][1]) {
            if (states[0][1] == State.X) {
                board.setWinner(Player.X);
            } else if (states[0][1] == State.O) {
                board.setWinner(Player.O);
            }
        }
        if (states[0][2] == states[1][2] && states[0][2] == states[2][2]) {
            if (states[0][2] == State.X) {
                board.setWinner(Player.X);
            } else if (states[0][2] == State.O) {
                board.setWinner(Player.O);
            }
        }

        //Diagonal
        if (states[0][0] == states[1][1] && states[0][0] == states[2][2]) {
            if (states[0][0] == State.X) {
                board.setWinner(Player.X);
            } else if (states[0][0] == State.O) {
                board.setWinner(Player.O);
            }
        }
        if (states[0][2] == states[1][1] && states[0][2] == states[2][0]) {
            if (states[0][2] == State.X) {
                board.setWinner(Player.X);
            } else if (states[0][2] == State.O) {
                board.setWinner(Player.O);
            }
        }
    }
}
