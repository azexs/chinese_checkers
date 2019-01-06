package Client.Board;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BoardAssemblerTest {

    @Test
    public void getBoard() {
        assertNotNull(new BoardAssembler().getBoard(new TwoPlayersBoard()));
        assertNotNull(new BoardAssembler().getBoard(new ThreePlayersBoard()));
        assertNotNull(new BoardAssembler().getBoard(new FourPlayersBoard()));
        assertNotNull(new BoardAssembler().getBoard(new SixPlayersBoard()));
    }
}