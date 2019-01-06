package Client.Board;


public class FourPlayersBoard extends BoardBuilder {

    public void setPlayers() {
        //sets player 1
        board[6][0].setFill(colours.get(0));
        board[5][1].setFill(colours.get(0));
        board[6][1].setFill(colours.get(0));
        board[5][2].setFill(colours.get(0));
        board[6][2].setFill(colours.get(0));
        board[7][2].setFill(colours.get(0));
        board[4][3].setFill(colours.get(0));
        board[5][3].setFill(colours.get(0));
        board[6][3].setFill(colours.get(0));
        board[7][3].setFill(colours.get(0));


        //sets player 2
        board[10][7].setFill(colours.get(6));
        board[10][6].setFill(colours.get(6));
        board[11][6].setFill(colours.get(6));
        board[9][5].setFill(colours.get(6));
        board[10][5].setFill(colours.get(6));
        board[11][5].setFill(colours.get(6));
        board[9][4].setFill(colours.get(6));
        board[10][4].setFill(colours.get(6));
        board[11][4].setFill(colours.get(6));
        board[12][4].setFill(colours.get(6));


        //sets player 3
        board[10][9].setFill(colours.get(1));
        board[10][10].setFill(colours.get(1));
        board[11][10].setFill(colours.get(1));
        board[9][11].setFill(colours.get(1));
        board[10][11].setFill(colours.get(1));
        board[11][11].setFill(colours.get(1));
        board[9][12].setFill(colours.get(1));
        board[10][12].setFill(colours.get(1));
        board[11][12].setFill(colours.get(1));
        board[12][12].setFill(colours.get(1));

        //sets player 4 as red
        board[4][13].setFill(colours.get(2));
        board[5][13].setFill(colours.get(2));
        board[6][13].setFill(colours.get(2));
        board[7][13].setFill(colours.get(2));
        board[7][14].setFill(colours.get(2));
        board[5][14].setFill(colours.get(2));
        board[6][14].setFill(colours.get(2));
        board[5][15].setFill(colours.get(2));
        board[6][15].setFill(colours.get(2));
        board[6][16].setFill(colours.get(2));

        //sets payer 5
        board[0][12].setFill(colours.get(6));
        board[1][12].setFill(colours.get(6));
        board[2][12].setFill(colours.get(6));
        board[3][12].setFill(colours.get(6));
        board[0][11].setFill(colours.get(6));
        board[1][11].setFill(colours.get(6));
        board[2][11].setFill(colours.get(6));
        board[1][10].setFill(colours.get(6));
        board[2][10].setFill(colours.get(6));
        board[1][9].setFill(colours.get(6));

        //sets player 6
        board[0][4].setFill(colours.get(3));
        board[1][4].setFill(colours.get(3));
        board[2][4].setFill(colours.get(3));
        board[3][4].setFill(colours.get(3));
        board[0][5].setFill(colours.get(3));
        board[1][5].setFill(colours.get(3));
        board[2][5].setFill(colours.get(3));
        board[1][6].setFill(colours.get(3));
        board[2][6].setFill(colours.get(3));
        board[1][7].setFill(colours.get(3));

    }


}
