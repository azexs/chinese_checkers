package Client;

import javafx.scene.paint.Color;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClientTest {

    private Client client = new Client();

    @Test
    public void testgetset() {
        client.setColor(Color.OLIVE);
        assertEquals(Color.OLIVE, client.getColor());
    }
}