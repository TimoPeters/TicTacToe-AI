package GUI;

import util.ImageLoader;
import util.Player;
import util.State;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Timo Peters on 21.11.2019.
 */
public class Draw extends JLabel {

    private Board board;
    private State[][] states;
    private static final long serialVersionUID = 1L;

    public Draw(Board board) {
        this.board = board;
        this.states = board.getStates();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setColor(Color.BLACK);

        //Vertical
        graphics.drawLine(325, 50, 325, 500);
        graphics.drawLine(475, 50, 475, 500);

        //Horizontal
        graphics.drawLine(175, 200, 625, 200);
        graphics.drawLine(175, 350, 625, 350);

        //Draw Player
        graphics.setColor(Color.BLACK);
        if (board.getCurrentPlayer() == Player.X) {
            graphics.drawString("Player: X", 25, 50);
        } else if (board.getCurrentPlayer() == Player.O) {
            graphics.drawString("Player: O", 25, 50);
        }

        //Draw Winner
        if (board.getWinner() == Player.X) {
            graphics.drawString("Winner: X", 25, 100);
        } else if (board.getWinner() == Player.O) {
            graphics.drawString("Winner: O", 25, 100);
        } else if (board.getWinner() == Player.DRAW) {
            graphics.drawString("Draw", 25, 100);
        }

        //Row 1
        if (states[0][0] == State.X) {
            graphics.drawImage(ImageLoader.imgX, 175, 50, 150, 150, null);
        } else if (states[0][0] == State.O) {
            graphics.drawImage(ImageLoader.imgO, 175, 50, 150, 150, null);
        }
        if (states[0][1] == State.X) {
            graphics.drawImage(ImageLoader.imgX, 325, 50, 150, 150, null);
        } else if (states[0][1] == State.O) {
            graphics.drawImage(ImageLoader.imgO, 325, 50, 150, 150, null);
        }
        if (states[0][2] == State.X) {
            graphics.drawImage(ImageLoader.imgX, 475, 50, 150, 150, null);
        } else if (states[0][2] == State.O) {
            graphics.drawImage(ImageLoader.imgO, 475, 50, 150, 150, null);
        }

        //Row 2
        if (states[1][0] == State.X) {
            graphics.drawImage(ImageLoader.imgX, 175, 200, 150, 150, null);
        } else if (states[1][0] == State.O) {
            graphics.drawImage(ImageLoader.imgO, 175, 200, 150, 150, null);
        }
        if (states[1][1] == State.X) {
            graphics.drawImage(ImageLoader.imgX, 325, 200, 150, 150, null);
        } else if (states[1][1] == State.O) {
            graphics.drawImage(ImageLoader.imgO, 325, 200, 150, 150, null);
        }
        if (states[1][2] == State.X) {
            graphics.drawImage(ImageLoader.imgX, 475, 200, 150, 150, null);
        } else if (states[1][2] == State.O) {
            graphics.drawImage(ImageLoader.imgO, 475, 200, 150, 150, null);
        }

        //Row 3
        if (states[2][0] == State.X) {
            graphics.drawImage(ImageLoader.imgX, 175, 350, 150, 150, null);
        } else if (states[2][0] == State.O) {
            graphics.drawImage(ImageLoader.imgO, 175, 350, 150, 150, null);
        }
        if (states[2][1] == State.X) {
            graphics.drawImage(ImageLoader.imgX, 325, 350, 150, 150, null);
        } else if (states[2][1] == State.O) {
            graphics.drawImage(ImageLoader.imgO, 325, 350, 150, 150, null);
        }
        if (states[2][2] == State.X) {
            graphics.drawImage(ImageLoader.imgX, 475, 350, 150, 150, null);
        } else if (states[2][2] == State.O) {
            graphics.drawImage(ImageLoader.imgO, 475, 350, 150, 150, null);
        }

        repaint();
    }
}
