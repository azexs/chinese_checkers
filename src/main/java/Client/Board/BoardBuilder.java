package Client.Board;

import Client.Colours;
import Client.Pawn;

abstract class BoardBuilder implements Board {
    public Pawn[][] board;
    public Colours colours;

    BoardBuilder() {
        board = new Pawn[13][17];
        colours = Colours.getInstance();
    }

    public void initializeBoard() {
        for (int x = 0; x < 13; x++) {
            for (int y = 0; y < 17; y++) {
                board[x][y] = new Pawn();
            }
        }
    }

    public void setMainTriangle() {

        board[4][4].setFill(colours.get(6));
        board[5][4].setFill(colours.get(6));
        board[6][4].setFill(colours.get(6));
        board[7][4].setFill(colours.get(6));
        board[8][4].setFill(colours.get(6));
        board[3][5].setFill(colours.get(6));
        board[4][5].setFill(colours.get(6));
        board[5][5].setFill(colours.get(6));
        board[6][5].setFill(colours.get(6));
        board[7][5].setFill(colours.get(6));
        board[8][5].setFill(colours.get(6));
        board[3][6].setFill(colours.get(6));
        board[4][6].setFill(colours.get(6));
        board[5][6].setFill(colours.get(6));
        board[6][6].setFill(colours.get(6));
        board[7][6].setFill(colours.get(6));
        board[8][6].setFill(colours.get(6));
        board[9][6].setFill(colours.get(6));
        board[2][7].setFill(colours.get(6));
        board[3][7].setFill(colours.get(6));
        board[4][7].setFill(colours.get(6));
        board[5][7].setFill(colours.get(6));
        board[6][7].setFill(colours.get(6));
        board[7][7].setFill(colours.get(6));
        board[8][7].setFill(colours.get(6));
        board[9][7].setFill(colours.get(6));
        board[2][8].setFill(colours.get(6));
        board[3][8].setFill(colours.get(6));
        board[4][8].setFill(colours.get(6));
        board[5][8].setFill(colours.get(6));
        board[6][8].setFill(colours.get(6));
        board[7][8].setFill(colours.get(6));
        board[8][8].setFill(colours.get(6));
        board[9][8].setFill(colours.get(6));
        board[10][8].setFill(colours.get(6));
        board[2][9].setFill(colours.get(6));
        board[3][9].setFill(colours.get(6));
        board[4][9].setFill(colours.get(6));
        board[5][9].setFill(colours.get(6));
        board[6][9].setFill(colours.get(6));
        board[7][9].setFill(colours.get(6));
        board[8][9].setFill(colours.get(6));
        board[9][9].setFill(colours.get(6));
        board[3][10].setFill(colours.get(6));
        board[4][10].setFill(colours.get(6));
        board[5][10].setFill(colours.get(6));
        board[6][10].setFill(colours.get(6));
        board[7][10].setFill(colours.get(6));
        board[8][10].setFill(colours.get(6));
        board[9][10].setFill(colours.get(6));
        board[3][11].setFill(colours.get(6));
        board[4][11].setFill(colours.get(6));
        board[5][11].setFill(colours.get(6));
        board[6][11].setFill(colours.get(6));
        board[7][11].setFill(colours.get(6));
        board[8][11].setFill(colours.get(6));
        board[4][12].setFill(colours.get(6));
        board[5][12].setFill(colours.get(6));
        board[6][12].setFill(colours.get(6));
        board[7][12].setFill(colours.get(6));
        board[8][12].setFill(colours.get(6));


    }

    public Pawn[][] getBoard() {
        return board;
    }


}
