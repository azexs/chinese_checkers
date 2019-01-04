package Server.AbstractBoard;


import Server.Field;

public class AbstractBoardAssembler {

    public AbstractBoardAssembler() {
    }

    public Field[][] getBoard(Board BoardBuilder) {
        BoardBuilder.initializeBoard();
        BoardBuilder.setMainTriangle();
        BoardBuilder.setPlayers();
        BoardBuilder.setZones();
        return BoardBuilder.getBoard();
    }
}
