package AI;

import GUI.Board;
import util.Player;
import util.State;

import java.util.ArrayList;
import java.util.List;

/**
 * Based on: https://github.com/Cledersonbc/tic-tac-toe-minimax/blob/master/py_version/minimax.py
 */

public class MiniMax {
    private int human = -1;
    private int ai = 1;

    /**
     * AI function that choice the best move
     *
     * @param state:  current state of the board
     * @param depth:  node index in the tree (0 <= depth <= 9),
     *                but never nine in this case (see iaturn() function)
     * @param player: an human or a computer
     * @return a list with [the best row, best col, best score]
     */
    public int[] minimax(Board state, int depth, Player player) {
        int[] best = new int[3];
        int score[] = new int[3];

        if (player == Player.X) {
            best[0] = -1;
            best[0] = -1;
            best[2] = Integer.MIN_VALUE;
        } else if (player == Player.O) {
            best[0] = -1;
            best[0] = -1;
            best[2] = Integer.MAX_VALUE;
        }

        if (depth == 0 || state.getWinner() == null) {
            best[0] = -1;
            best[1] = -1;
            best[2] = evaluate(state);
            return best;
        }

        for (int[] cell : emptyCellsIndices(state)) {
            score = minimax(state, depth -1, state.getCurrentPlayer());
        }

        //ToDo

        return best;
    }

    /**
     * Each empty cell will be added into cells' list
     *
     * @param state: the state of the current board
     * @return: a list of empty cells
     */
    private List<int[]> emptyCellsIndices(Board state) {
        List<int[]> emptyCells = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state.getStates()[i][j] == State.EMPTY) {
                    int[] emptyCell = {i, j};
                    emptyCells.add(emptyCell);
                }
            }
        }
        return emptyCells;
    }

    /**
     * Function to heuristic evaluation of state.
     *
     * @param state: the state of the current board
     * @return: +1 if the computer wins; -1 if the human wins; 0 draw
     */
    private int evaluate(Board state) {
        int score;
        if (state.getWinner() == Player.X) {
            score = 1;
        } else if (state.getWinner() == Player.O) {
            score = -1;
        } else {
            score = 0;
        }
        return score;
    }
}
