package Client;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PawnTest {

    @Test
    public void ispawncreated() {
        Pawn testPawn = new Pawn();
        assertTrue(testPawn.getRadius() > 1);
    }

}