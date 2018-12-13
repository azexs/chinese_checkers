import java.io.IOException;
import java.net.ServerSocket;


public class Server {


    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(2137);
        try {
            while (true) {
                Game game = new Game(2);
                game.players[0] = new Player(listener.accept(), game);
                game.players[0].start();
                game.players[1] = new Player(listener.accept(), game);
                game.players[1].start();
            }
        } finally {
            listener.close();
        }
    }


}


