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
    public int[] minmax(Board state, int depth, Player player) {
        int[] best = new int[3];

        if (player == Player.X) {
            best[0] = -1;
            best[0] = -1;
            best[2] = Integer.MIN_VALUE;
        } else if (player == Player.O) {
            best[0] = -1;
            best[0] = -1;
            best[2] = Integer.MAX_VALUE;
        }

        //ToDo

        return best;
    }

    private List<int[]> emptyCellsIndices(Board board) {
        List<int[]> emptyCells = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getStates()[i][j] == State.EMPTY) {
                    int[] emptyCell = {i, j};
                    emptyCells.add(emptyCell);
                }
            }
        }
        return emptyCells;
    }
}
