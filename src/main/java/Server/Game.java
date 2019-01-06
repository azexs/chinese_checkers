package Server;

import Server.AbstractBoard.AbstractBoard;

import java.util.List;

public class Game {

    Player[] players;
    int connectedPlayers;
    int totalplayers;
    AbstractBoard board;
    Rules rules;
    Field[][] boardd;

    Player currentPlayer;

    public Game(int players) {
        this.players = new Player[players];
        totalplayers = players;
        connectedPlayers = 0;
        board = new AbstractBoard(players);
        rules = new Rules(board, this);
        boardd = board.getBoard();
    }


    public boolean validMove(int pawnx, int pawny, int targetx, int targety) {

        Field pawn = boardd[pawnx][pawny];
        Field target = boardd[targetx][targety];
        List<Field> fields = currentPlayer.startSide.getOppositeSide().getArea(board);

        //Check if pawn is pawn and target is empty field, then check if 'main'  pawn is in opposite side, if so, target must be in oppostie side

        if ((pawn.isPawn || !target.isPawn) && (!fields.contains(pawn) || fields.contains(target))) {
            if (!rules.trymove(pawnx, pawny, targetx, targety)) {
                return false;
            }
        } else
            return false;

        return true;
    }


    public boolean checkWin(Player p) {
        Sides playerSide = p.startSide;
        Sides winSide = playerSide.getOppositeSide();

        for (Field f : winSide.getArea(board)) {
            if (f.winSide != winSide) return false;
        }

        return true;

    }


}
