package Server.AbstractBoard;

import Server.Field;

public class AbstractBoard {

    private Field[][] board;

    private Board boardBuilder;

    private AbstractBoardAssembler boardAssembler;

    public AbstractBoard(int numberOfPlayers) {
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
        boardAssembler = new AbstractBoardAssembler();
        board = boardAssembler.getBoard(boardBuilder);
    }

    public Field[][] getBoard() {
        return board;
    }

    public Field getPawn(int x, int y) {
        return board[x][y];
    }

}
