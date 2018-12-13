import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Player extends Thread {
    Socket socket;
    Game game;
    BufferedReader in;
    PrintWriter out;


    public Player(Socket socket, Game game) throws IOException {
        this.socket = socket;
        this.game = game;
    }

    private void sendToAllPlayers(String msg) {

        for (Player p : game.players) {
            p.out.println(msg);
        }

    }


    public void run() {
        try {
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            game.connectedPlayers++;
            out.println("COLOR " + game.connectedPlayers);

            if (game.connectedPlayers == game.totalplayers) {
                game.currentPlayer = game.players[0];
                game.currentPlayer.out.println("YOURTURN");
            }


            while (true) {
                String input = "";
                input = in.readLine();
                if (input.startsWith("MOVE")) {
                    System.out.println(input);

                    String[] separated = input.split(" ");
                    String[] pawnpos1 = separated[1].split("\\.");
                    String[] pawnpos2 = separated[2].split("\\.");
                    sendToAllPlayers("MOVE" + " " + pawnpos1[0] + " " + pawnpos1[1] + " " + pawnpos2[0] + " " + pawnpos2[1]);

                } else if (input.startsWith("NEXTPLAYER")) {

                    game.currentPlayer.out.println("ENDROUND");

                    for (int i = 0; i < game.totalplayers; i++) {
                        if (game.players[i].equals(game.currentPlayer)) {

                            if (i == (game.totalplayers - 1)) {
                                game.currentPlayer = game.players[0];
                            } else {
                                game.currentPlayer = game.players[i + 1];
                            }

                            break;

                        }
                    }

                    game.currentPlayer.out.println("YOURTURN");

                }


            }
        } catch (IOException e) {
            //
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                //
            }
            //
        }
    }


}
