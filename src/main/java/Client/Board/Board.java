package Client.Board;

import Client.Pawn;

public interface Board {

    Pawn[][] getBoard();

    void setPlayers();

    void initializeBoard();

    void setMainTriangle();
}
