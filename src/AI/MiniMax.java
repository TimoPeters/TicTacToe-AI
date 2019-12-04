package AI;

import GUI.Board;
import util.Player;
import util.State;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * based on https://www.youtube.com/watch?v=T31hSWYW-dU
 */
public class MiniMax {

    public static State[][] states = Board.states.clone();

    public static int[] minimax(int depth, Player player) {
        int[] best = new int[2];
        if (player == Player.O) {
            best[0] = -1;
            best[1] = Integer.MIN_VALUE;
        } else {
            best[0] = -1;
            best[0] = Integer.MAX_VALUE;
        }

        if (depth == 0 || Board.winner != null) {
            int score = evaluate();
            return new int[]{-1, score};
        }

        List<int[]> emptySpots = Board.getEmptySpots();
        State entryState;
        int[] score;
        for (int[] index : emptySpots) {
            if (player == Player.O) {
                entryState = State.O;
            } else {
                entryState = State.X;
            }
            states[index[0]][index[1]] = entryState;

            if (player == Player.O) {
                score = minimax(depth - 1, Player.X);
            } else {
                score = minimax(depth - 1, Player.O);
            }

            refreshStates();

            if (player == Player.O) {
                if (best[1] < score[1]) {
                    best = score;
                } else {
                    if (best[1] > score[1]) {
                        best = score;
                    }
                }
            }
        }

        return best;
    }

    public static void aiMove() {
        int depth = Board.getEmptySpots().size();
        int[] move;
        if (depth == 0 || Board.winner != null) {
            return;
        }

        System.out.println("AI turn");
        move = minimax(depth, Player.O);

        switch (move[0]) {
            case 1:
                Board.states[0][0] = State.O;
            case 2:
                Board.states[0][1] = State.O;
            case 3:
                Board.states[0][2] = State.O;
            case 4:
                Board.states[1][0] = State.O;
            case 5:
                Board.states[1][1] = State.O;
            case 6:
                Board.states[1][2] = State.O;
            case 7:
                Board.states[2][0] = State.O;
            case 8:
                Board.states[2][1] = State.O;
            case 9:
                Board.states[2][2] = State.O;
        }
    }


    public static int evaluate() {
        // ToDo
        return ThreadLocalRandom.current().nextInt(1, 9 + 1);
    }

    public static void refreshStates() {
        states = Board.states.clone();
    }
}
