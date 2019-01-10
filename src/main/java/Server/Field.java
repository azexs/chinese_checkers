package Server;

import javafx.scene.paint.Color;

public class Field {

    int isPawn;
    Color color;
    Sides startSide;
    Sides winSide;

    int x;
    int y;

    public Field(int x, int y, int type) {
        this.x = x;
        this.y = y;
        setIsPawn(type);
    }


    public Field setPawn(int i) {
        setIsPawn(i);
        return this;
    }

    public Field setStartSide(Sides side) {
        startSide = side;
        if (startSide != null) winSide = startSide.getOppositeSide();
        return this;
    }

    public Field setColor(Color color) {
        this.color = color;
        return this;
    }


	public int getIsPawn() {
		return isPawn;
	}


	public void setIsPawn(int isPawn) {
		this.isPawn = isPawn;
	}


}