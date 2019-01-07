package Server;

import Client.Colours;
import javafx.scene.paint.Color;


public class Player {

    int id;
    Color color;
    Colours colours;
    Sides startSide;
    boolean win;
    boolean isBot;


    public Player(int id, Field[][] board) {
        this.id = id;
        this.colours = Colours.getInstance();
        this.color = colours.get(id);
        this.startSide = findSide(board);
        win = false;
        isBot = false;

    }

    public Sides findSide(Field[][] board) {

        for (Field[] f : board) {
            for (Field ff : f) {
                if (ff.color == this.color) {
                    return ff.startSide;
                }
            }
        }

        return null;

    }


}