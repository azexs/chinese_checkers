package Server;

import Server.AbstractBoard.AbstractBoard;

public class Game {

    Player[] players;
    int connectedPlayers;
    int totalplayers;
    AbstractBoard board;
    Rules rules;

    Player currentPlayer;

    public Game(int players) {
        this.players = new Player[players];
        totalplayers = players;
        connectedPlayers = 0;
        board = new AbstractBoard(players);
    }


    public void move(int pawnx, int pawny, int targetx, int targety) {

        Field pawn = board.getPawn(pawnx, pawny);
        Field target = board.getPawn(targetx, targety);


        rules.move(pawn, target);

    }


    public void checkWin(Player p) {


    }


}
