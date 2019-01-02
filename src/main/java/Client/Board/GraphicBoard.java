package Client.Board;

import Client.Pawn;

public class GraphicBoard {

    private Pawn[][] board;

    private Board boardBuilder;

    private BoardAssembler graphicBoardAssembler;

    public GraphicBoard(int numberOfPlayers) {
        switch (numberOfPlayers) {
            case 2:
                boardBuilder = new TwoPlayersBoard();
                break;
            case 3:
                boardBuilder = new ThreePlayersBoard();
                break;
            case 4:
                boardBuilder = new FourPlayersBoard();
                break;
            case 6:
                boardBuilder = new SixPlayersBoard();
                break;

        }
        graphicBoardAssembler = new BoardAssembler();
        board = graphicBoardAssembler.getBoard(boardBuilder);
    }

    public Pawn[][] getBoard() {
        return board;
    }

    public Pawn getPawn(int x, int y) {
        return board[x][y];
    }
}
