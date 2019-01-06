package Client.Board;

import Client.Pawn;

public class BoardAssembler {

    public BoardAssembler() {

    }

    public Pawn[][] getBoard(Board BoardBuilder) {
        BoardBuilder.initializeBoard();
        BoardBuilder.setMainTriangle();
        BoardBuilder.setPlayers();
        return BoardBuilder.getBoard();
    }


}
