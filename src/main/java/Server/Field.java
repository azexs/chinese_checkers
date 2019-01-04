package Server;

import javafx.scene.paint.Color;

public class Field {

    boolean isPawn;
    Color color;
    Sides startSide;
    Sides winSide;


    public Field() {
    }

    ;

    public Field(Color color, Sides start, boolean isPawn) {
        this.color = color;
        startSide = start;
        this.isPawn = isPawn;
        winSide = startSide.getOppositeSide();
    }

    public Field setPawn(boolean is) {
        isPawn = is;
        return this;
    }

    public Field setStartSide(Sides side) {
        startSide = side;
        //winSide=startSide.getOppositeSide();
        return this;
    }

    public Field setColor(Color color) {
        this.color = color;
        return this;
    }


}
