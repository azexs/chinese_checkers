package Server;

import Server.AbstractBoard.AbstractBoard;

import java.util.List;


public class Game {

    int connectedPlayers;
    int totalplayers;
    Player[] players;
    Player currentPlayer;
    AbstractBoard board;
    Field[][] boardd;
    Rules rules;



    public Game(int players) {
        this.players = new Player[players];
        totalplayers = players;
        connectedPlayers = 0;
        board = new AbstractBoard(players);
        rules = new Rules(this);
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
            if (f.winSide == winSide) return true;
        }

        return false;

    }

    public boolean nextPlayer() {
        int curid = 2137;

        for (int i = 0; i < totalplayers; i++) {
            if (players[i].equals(currentPlayer)) {
                if (i == totalplayers - 1) curid = 0;
                else curid = i + 1;
                break;
            }
        }

        for (int j = curid; j < totalplayers; j++) {

            if (!players[j].win) {
                currentPlayer = players[j];
                return true;
            }

            if (j == totalplayers - 1) {
                for (int k = 0; k < curid; k++) {
                    if (!players[k].win) {
                        currentPlayer = players[k];
                        return true;
                    }
                }
            }


        }

        return false;
    }


}