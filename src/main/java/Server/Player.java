package Server;

import Client.Colours;
import javafx.scene.paint.Color;

import java.io.IOException;

public class Player {

    int id;
    Color color;
    Colours colours;


    public Player(int id) throws IOException {
        this.id = id;
        this.colours = new Colours();
        this.color = colours.get(id);

    }




}
