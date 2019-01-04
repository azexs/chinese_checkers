package Server.AbstractBoard;

import Client.Colours;
import Server.Field;
import Server.Sides;

public abstract class BoardCore implements Board {
    public Field[][] board;
    Colours colours;

    public BoardCore() {
        board = new Field[13][17];
        colours = Colours.getInstance();
        initializeBoard();
        setMainTriangle();
        setZones();

    }

    public void initializeBoard() {
        for (int x = 0; x < 13; x++) {
            for (int y = 0; y < 17; y++) {
                board[x][y] = new Field();
            }
        }
    }

    public void setMainTriangle() {

        board[4][4].setColor(colours.get(6)).setPawn(false).setStartSide(null);
        board[5][4].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[6][4].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[7][4].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[8][4].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[3][5].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[4][5].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[5][5].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[6][5].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[7][5].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[8][5].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[3][6].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[4][6].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[5][6].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[6][6].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[7][6].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[8][6].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[9][6].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[2][7].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[3][7].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[4][7].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[5][7].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[6][7].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[7][7].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[8][7].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[9][7].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[2][8].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[3][8].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[4][8].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[5][8].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[6][8].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[7][8].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[8][8].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[9][8].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[10][8].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[2][9].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[3][9].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[4][9].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[5][9].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[6][9].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[7][9].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[8][9].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[9][9].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[3][10].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[4][10].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[5][10].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[6][10].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[7][10].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[8][10].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[9][10].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[3][11].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[4][11].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[5][11].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[6][11].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[7][11].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[8][11].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[4][12].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[5][12].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[6][12].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[7][12].setColor(colours.get(6)).setStartSide(null).setPawn(false);
        board[8][12].setColor(colours.get(6)).setStartSide(null).setPawn(false);


    }

    public void setZones() {

        board[6][0].setStartSide(Sides.TOP);
        board[5][1].setStartSide(Sides.TOP);
        board[6][1].setStartSide(Sides.TOP);
        board[5][2].setStartSide(Sides.TOP);
        board[6][2].setStartSide(Sides.TOP);
        board[7][2].setStartSide(Sides.TOP);
        board[4][3].setStartSide(Sides.TOP);
        board[5][3].setStartSide(Sides.TOP);
        board[6][3].setStartSide(Sides.TOP);
        board[7][3].setStartSide(Sides.TOP);

        board[10][7].setStartSide(Sides.RIGHT_TOP);
        board[10][6].setStartSide(Sides.RIGHT_TOP);
        board[11][6].setStartSide(Sides.RIGHT_TOP);
        board[9][5].setStartSide(Sides.RIGHT_TOP);
        board[10][5].setStartSide(Sides.RIGHT_TOP);
        board[11][5].setStartSide(Sides.RIGHT_TOP);
        board[9][4].setStartSide(Sides.RIGHT_TOP);
        board[10][4].setStartSide(Sides.RIGHT_TOP);
        board[11][4].setStartSide(Sides.RIGHT_TOP);
        board[12][4].setStartSide(Sides.RIGHT_TOP);

        board[10][9].setStartSide(Sides.RIGHT_BOTTOM);
        board[10][10].setStartSide(Sides.RIGHT_BOTTOM);
        board[11][10].setStartSide(Sides.RIGHT_BOTTOM);
        board[9][11].setStartSide(Sides.RIGHT_BOTTOM);
        board[10][11].setStartSide(Sides.RIGHT_BOTTOM);
        board[11][11].setStartSide(Sides.RIGHT_BOTTOM);
        board[9][12].setStartSide(Sides.RIGHT_BOTTOM);
        board[10][12].setStartSide(Sides.RIGHT_BOTTOM);
        board[11][12].setStartSide(Sides.RIGHT_BOTTOM);
        board[12][12].setStartSide(Sides.RIGHT_BOTTOM);

        board[4][13].setStartSide(Sides.BOTTOM);
        board[5][13].setStartSide(Sides.BOTTOM);
        board[6][13].setStartSide(Sides.BOTTOM);
        board[7][13].setStartSide(Sides.BOTTOM);
        board[7][14].setStartSide(Sides.BOTTOM);
        board[5][14].setStartSide(Sides.BOTTOM);
        board[6][14].setStartSide(Sides.BOTTOM);
        board[5][15].setStartSide(Sides.BOTTOM);
        board[6][15].setStartSide(Sides.BOTTOM);
        board[6][16].setStartSide(Sides.BOTTOM);

        board[0][12].setStartSide(Sides.LEFT_BOTTOM);
        board[1][12].setStartSide(Sides.LEFT_BOTTOM);
        board[2][12].setStartSide(Sides.LEFT_BOTTOM);
        board[3][12].setStartSide(Sides.LEFT_BOTTOM);
        board[0][11].setStartSide(Sides.LEFT_BOTTOM);
        board[1][11].setStartSide(Sides.LEFT_BOTTOM);
        board[2][11].setStartSide(Sides.LEFT_BOTTOM);
        board[1][10].setStartSide(Sides.LEFT_BOTTOM);
        board[2][10].setStartSide(Sides.LEFT_BOTTOM);
        board[1][9].setStartSide(Sides.LEFT_BOTTOM);


        board[0][4].setStartSide(Sides.LEFT_TOP);
        board[1][4].setStartSide(Sides.LEFT_TOP);
        board[2][4].setStartSide(Sides.LEFT_TOP);
        board[3][4].setStartSide(Sides.LEFT_TOP);
        board[0][5].setStartSide(Sides.LEFT_TOP);
        board[1][5].setStartSide(Sides.LEFT_TOP);
        board[2][5].setStartSide(Sides.LEFT_TOP);
        board[1][6].setStartSide(Sides.LEFT_TOP);
        board[2][6].setStartSide(Sides.LEFT_TOP);
        board[1][7].setStartSide(Sides.LEFT_TOP);

    }

    public Field[][] getBoard() {
        return board;
    }

}
