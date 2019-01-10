package Server;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Bot {
	
	private class Move {
		public Field from, to;
		public Move(Field from, Field to) 
		{
			this.from = from;
			this.to = to;
		}
	}
	
	LinkedList<Move> moveHistory = new LinkedList<>();
	private int moveMemory;

    Game game;

    public Bot(Game game, int memLim) {
        this.game = game;
        moveMemory = memLim * 3;
    }

    public void playRound(ClientHandler gameConnector) {
        List<Field> botPawns = setPawns();

        double distance = -1000;
        Field startPawn = null;
        Field bestMove = null;
        Move chosenMove = null;

        for (Field f : botPawns) {
            List<Field> possibleMoves = new ArrayList<Field>();
            possibleMoves.addAll(game.rules.possibleJumps(f.x, f.y));
            possibleMoves.addAll(game.rules.possibleSingleMoves(f.x, f.y, 1));

            for (Field possible : possibleMoves) {
            	Move temp = new Move (f, possible);
            	if (checkInHistory(temp)) {
            		/*System.out.print("Skipped: (" + f.x + "," + f.y +
            				")(" + possible.x + "," + possible.y + ")\n");*/
            		continue;
            	}
                if (calcDistance(f.x, f.y, possible.x, possible.y) > distance) {
                    distance = calcDistance(f.x, f.y, possible.x, possible.y);
                    if (game.validMove(f.x, f.y, possible.x, possible.y)) {
                        startPawn = f;
                        bestMove = possible;
                        chosenMove = temp;
                    }
                }
            }
        }

        if (startPawn != null && bestMove != null) {
            if (game.validMove(startPawn.x, startPawn.y, bestMove.x, bestMove.y)) {
                game.move(startPawn.x, startPawn.y, bestMove.x, bestMove.y);
                addToHistory(chosenMove);
                /*System.out.print("(" + chosenMove.from.x + "," + chosenMove.from.y + "),(" +
                		chosenMove.to.x + "," + chosenMove.to.y + ")\n");*/
                gameConnector.sendToAllPlayersInGame("MOVE" + " " + bestMove.x + " " + bestMove.y + " " + startPawn.x + " " + startPawn.y);

                if (game.nextPlayer()) {
                    if (game.currentPlayer.isBot) game.playBot(gameConnector);
                }

            }
        } else {
            if (game.nextPlayer()) {
                if (game.currentPlayer.isBot) game.playBot(gameConnector);
            }

        }


    }


    double calcDistance(int pawnx, int pawny, int targetx, int targety) {

        return Math.sqrt(Math.pow(Math.abs(pawnx - targetx), 2) + Math.pow(Math.abs(pawny - targety), 2)) +
                Math.abs((game.currentPlayer.startSide.getOppositeSide().getCorner(game.board).y - pawny)) - Math.abs((game.currentPlayer.startSide.getOppositeSide().getCorner(game.board).y - targety)) +
                Math.abs((game.currentPlayer.startSide.getOppositeSide().getCorner(game.board).x - pawnx)) - Math.abs((game.currentPlayer.startSide.getOppositeSide().getCorner(game.board).x - targetx));
    }

    List<Field> setPawns() {
        List<Field> botPawns = new ArrayList<>();
        for (Field[] f : game.boardd) {
            for (Field ff : f) {
                if (game.currentPlayer.color == ff.color) botPawns.add(ff);
            }
        }

        return botPawns;


    }
    
    protected void addToHistory(Move chosenMove) {
    	/*System.out.print("(" + chosenMove.from.x + "," + chosenMove.from.y + "),(" +
        		chosenMove.to.x + "," + chosenMove.to.y + ")\n");*/
    	moveHistory.addFirst(chosenMove);
    	if (moveHistory.size() >= moveMemory) {
    		//System.out.print(moveHistory.size() + "\n");
    		moveHistory.removeLast();
    	}
    }
    
    protected boolean checkInHistory(Move chosenMove) {
    	for (Move f : moveHistory) {
    		if (chosenMove.from.x == f.from.x &&
    			chosenMove.from.y == f.from.y &&
    			chosenMove.to.x == f.to.x &&
    			chosenMove.to.y == f.to.y) {
    			return true;
    		}
    	}
    	return false;
    }


}