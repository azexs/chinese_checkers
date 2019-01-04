package Server.AbstractBoard;

import Server.Field;

public interface Board {
    Field[][] getBoard();

    void setPlayers();

    void initializeBoard();

    void setMainTriangle();

    void setZones();

}


