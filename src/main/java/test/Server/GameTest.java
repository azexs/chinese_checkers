package test.Server;

import static org.junit.Assert.*;

import org.junit.Before;

import Server.*;

import org.junit.Test;

public class GameTest {
	private Game game;

	@Before
	public void init() {
		game = new Game(6,5);
		Player player = new Player(0, game.board.getBoard());
        game.players[game.connectedPlayers] = player;
        game.connectedPlayers++;
		game.currentPlayer = game.players[0];
		for (int i = 0; i < 10; ++i) {
			if (player == game.currentPlayer) continue;
			game.playBot(null);
		}
	}
	
	@Test
	public void fieldIntegrityTest() {
		int count = 0;
		for (Field[] f : game.boardd) {
			for (Field ff : f) {
				if (ff != null && ff.getIsPawn() == 1) {
					++count;
				}
			}
		}
		assertEquals(count, 10 * 6);
	}
	

}
