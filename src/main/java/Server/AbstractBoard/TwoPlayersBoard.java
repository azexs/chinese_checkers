package Server.AbstractBoard;

public class TwoPlayersBoard extends BoardCore {

    public void setPlayers() {

        //sets player 1
        board[6][0].setColor(colours.get(0)).setPawn(1);
        board[5][1].setColor(colours.get(0)).setPawn(1);
        board[6][1].setColor(colours.get(0)).setPawn(1);
        board[5][2].setColor(colours.get(0)).setPawn(1);
        board[6][2].setColor(colours.get(0)).setPawn(1);
        board[7][2].setColor(colours.get(0)).setPawn(1);
        board[4][3].setColor(colours.get(0)).setPawn(1);
        board[5][3].setColor(colours.get(0)).setPawn(1);
        board[6][3].setColor(colours.get(0)).setPawn(1);
        board[7][3].setColor(colours.get(0)).setPawn(1);


        //sets player 2
        board[10][7].setColor(colours.get(6)).setPawn(0);
        board[10][6].setColor(colours.get(6)).setPawn(0);
        board[11][6].setColor(colours.get(6)).setPawn(0);
        board[9][5].setColor(colours.get(6)).setPawn(0);
        board[10][5].setColor(colours.get(6)).setPawn(0);
        board[11][5].setColor(colours.get(6)).setPawn(0);
        board[9][4].setColor(colours.get(6)).setPawn(0);
        board[10][4].setColor(colours.get(6)).setPawn(0);
        board[11][4].setColor(colours.get(6)).setPawn(0);
        board[12][4].setColor(colours.get(6)).setPawn(0);


        //sets player 3
        board[10][9].setColor(colours.get(6)).setPawn(0);
        board[10][10].setColor(colours.get(6)).setPawn(0);
        board[11][10].setColor(colours.get(6)).setPawn(0);
        board[9][11].setColor(colours.get(6)).setPawn(0);
        board[10][11].setColor(colours.get(6)).setPawn(0);
        board[11][11].setColor(colours.get(6)).setPawn(0);
        board[9][12].setColor(colours.get(6)).setPawn(0);
        board[10][12].setColor(colours.get(6)).setPawn(0);
        board[11][12].setColor(colours.get(6)).setPawn(0);
        board[12][12].setColor(colours.get(6)).setPawn(0);

        //sets player 4 as red
        board[4][13].setColor(colours.get(1)).setPawn(1);
        board[5][13].setColor(colours.get(1)).setPawn(1);
        board[6][13].setColor(colours.get(1)).setPawn(1);
        board[7][13].setColor(colours.get(1)).setPawn(1);
        board[7][14].setColor(colours.get(1)).setPawn(1);
        board[5][14].setColor(colours.get(1)).setPawn(1);
        board[6][14].setColor(colours.get(1)).setPawn(1);
        board[5][15].setColor(colours.get(1)).setPawn(1);
        board[6][15].setColor(colours.get(1)).setPawn(1);
        board[6][16].setColor(colours.get(1)).setPawn(1);

        //sets payer 5
        board[0][12].setColor(colours.get(6)).setPawn(0);
        board[1][12].setColor(colours.get(6)).setPawn(0);
        board[2][12].setColor(colours.get(6)).setPawn(0);
        board[3][12].setColor(colours.get(6)).setPawn(0);
        board[0][11].setColor(colours.get(6)).setPawn(0);
        board[1][11].setColor(colours.get(6)).setPawn(0);
        board[2][11].setColor(colours.get(6)).setPawn(0);
        board[1][10].setColor(colours.get(6)).setPawn(0);
        board[2][10].setColor(colours.get(6)).setPawn(0);
        board[1][9].setColor(colours.get(6)).setPawn(0);

        //sets player 6
        board[0][4].setColor(colours.get(6)).setPawn(0);
        board[1][4].setColor(colours.get(6)).setPawn(0);
        board[2][4].setColor(colours.get(6)).setPawn(0);
        board[3][4].setColor(colours.get(6)).setPawn(0);
        board[0][5].setColor(colours.get(6)).setPawn(0);
        board[1][5].setColor(colours.get(6)).setPawn(0);
        board[2][5].setColor(colours.get(6)).setPawn(0);
        board[1][6].setColor(colours.get(6)).setPawn(0);
        board[2][6].setColor(colours.get(6)).setPawn(0);
        board[1][7].setColor(colours.get(6)).setPawn(0);
    }


}
