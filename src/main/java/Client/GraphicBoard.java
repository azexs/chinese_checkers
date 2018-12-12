package Client;

import Client.Pawn;
import javafx.scene.paint.Color;


public class GraphicBoard  {

Pawn board[][] = new Pawn[13][17];

public GraphicBoard(){
for (int x = 0; x < 13; x++)
    {
        for (int y = 0; y < 17; y++)
        {
            board[x][y]= new Pawn(10);
        }
    }
    //sets player 1
    board[6][0].setFill(Color.GREEN);
    board[5][1].setFill(Color.GREEN);
    board[6][1].setFill(Color.GREEN);
    board[5][2].setFill(Color.GREEN);
    board[6][2].setFill(Color.GREEN);
    board[7][2].setFill(Color.GREEN);
    board[4][3].setFill(Color.GREEN);
    board[5][3].setFill(Color.GREEN);
    board[6][3].setFill(Color.GREEN);
    board[7][3].setFill(Color.GREEN);

    //sets player 3
    board[0][4].setFill(Color.GREY);
    board[1][4].setFill(Color.GREY);
    board[2][4].setFill(Color.GREY);
    board[3][4].setFill(Color.GREY);
    board[0][5].setFill(Color.GREY);
    board[1][5].setFill(Color.GREY);
    board[2][5].setFill(Color.GREY);
    board[1][6].setFill(Color.GREY);
    board[2][6].setFill(Color.GREY);
    board[1][7].setFill(Color.GREY);

    //sets player 5
    board[10][7].setFill(Color.GREY);
    board[10][6].setFill(Color.GREY);
    board[11][6].setFill(Color.GREY);
    board[9][5].setFill(Color.GREY);
    board[10][5].setFill(Color.GREY);
    board[11][5].setFill(Color.GREY);
    board[9][4].setFill(Color.GREY);
    board[10][4].setFill(Color.GREY);
    board[11][4].setFill(Color.GREY);
    board[12][4].setFill(Color.GREY);

    //sets payer 6
    board[0][12].setFill(Color.GREY);
    board[1][12].setFill(Color.GREY);
    board[2][12].setFill(Color.GREY);
    board[3][12].setFill(Color.GREY);
    board[0][11].setFill(Color.GREY);
    board[1][11].setFill(Color.GREY);
    board[2][11].setFill(Color.GREY);
    board[1][10].setFill(Color.GREY);
    board[2][10].setFill(Color.GREY);
    board[1][9].setFill(Color.GREY);

    //sets player 4
    board[10][9].setFill(Color.GREY);
    board[10][10].setFill(Color.GREY);
    board[11][10].setFill(Color.GREY);
    board[9][11].setFill(Color.GREY);
    board[10][11].setFill(Color.GREY);
    board[11][11].setFill(Color.GREY);
    board[9][12].setFill(Color.GREY);
    board[10][12].setFill(Color.GREY);
    board[11][12].setFill(Color.GREY);
    board[12][12].setFill(Color.GREY);

    //sets player 2 as red
    board[4][13].setFill(Color.RED);
    board[5][13].setFill(Color.RED);
    board[6][13].setFill(Color.RED);
    board[7][13].setFill(Color.RED);
    board[7][14].setFill(Color.RED);
    board[5][14].setFill(Color.RED);
    board[6][14].setFill(Color.RED);
    board[5][15].setFill(Color.RED);
    board[6][15].setFill(Color.RED);
    board[6][16].setFill(Color.RED);

    //sets the playable area to a
    board[4][4].setFill(Color.GREY);
    board[5][4].setFill(Color.GREY);
    board[6][4].setFill(Color.GREY);
    board[7][4].setFill(Color.GREY);
    board[8][4].setFill(Color.GREY);
    board[3][5].setFill(Color.GREY);
    board[4][5].setFill(Color.GREY);
    board[5][5].setFill(Color.GREY);
    board[6][5].setFill(Color.GREY);
    board[7][5].setFill(Color.GREY);
    board[8][5].setFill(Color.GREY);
    board[3][6].setFill(Color.GREY);
    board[4][6].setFill(Color.GREY);
    board[5][6].setFill(Color.GREY);
    board[6][6].setFill(Color.GREY);
    board[7][6].setFill(Color.GREY);
    board[8][6].setFill(Color.GREY);
    board[9][6].setFill(Color.GREY);
    board[2][7].setFill(Color.GREY);
    board[3][7].setFill(Color.GREY);
    board[4][7].setFill(Color.GREY);
    board[5][7].setFill(Color.GREY);
    board[6][7].setFill(Color.GREY);
    board[7][7].setFill(Color.GREY);
    board[8][7].setFill(Color.GREY);
    board[9][7].setFill(Color.GREY);
    board[2][8].setFill(Color.GREY);
    board[3][8].setFill(Color.GREY);
    board[4][8].setFill(Color.GREY);
    board[5][8].setFill(Color.GREY);
    board[6][8].setFill(Color.GREY);
    board[7][8].setFill(Color.GREY);
    board[8][8].setFill(Color.GREY);
    board[9][8].setFill(Color.GREY);
    board[10][8].setFill(Color.GREY);
    board[2][9].setFill(Color.GREY);
    board[3][9].setFill(Color.GREY);
    board[4][9].setFill(Color.GREY);
    board[5][9].setFill(Color.GREY);
    board[6][9].setFill(Color.GREY);
    board[7][9].setFill(Color.GREY);
    board[8][9].setFill(Color.GREY);
    board[9][9].setFill(Color.GREY);
    board[3][10].setFill(Color.GREY);
    board[4][10].setFill(Color.GREY);
    board[5][10].setFill(Color.GREY);
    board[6][10].setFill(Color.GREY);
    board[7][10].setFill(Color.GREY);
    board[8][10].setFill(Color.GREY);
    board[9][10].setFill(Color.GREY);
    board[3][11].setFill(Color.GREY);
    board[4][11].setFill(Color.GREY);
    board[5][11].setFill(Color.GREY);
    board[6][11].setFill(Color.GREY);
    board[7][11].setFill(Color.GREY);
    board[8][11].setFill(Color.GREY);
    board[4][12].setFill(Color.GREY);
    board[5][12].setFill(Color.GREY);
    board[6][12].setFill(Color.GREY);
    board[7][12].setFill(Color.GREY);
    board[8][12].setFill(Color.GREY);
}

public Pawn getPawn(int x, int y)
    {
        return board[x][y];
    }
}
