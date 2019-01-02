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
    Server server;
    private int id;


    public Player(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    private void sendToAllPlayers(String msg) {

        for (Player p : server.connectedClients) {
            p.out.println(msg);
        }

    }

    private void sendToAllGamePlayers(String msg) {

        for (Player p : game.players) {
            p.out.println(msg);
        }

    }


    public void run() {
        try {

            out.println("HELLO " + server.games.size());

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

                } else if (input.startsWith("JOIN")) {
                    input = input.substring(4);
                    System.out.println(input);
                    game = server.games.get(Integer.parseInt(input));
                    game.players[game.connectedPlayers] = this;
                    id = game.connectedPlayers;
                    game.connectedPlayers++;

                    out.println("JOINED" + id + "" + game.totalplayers);

                    if (game.connectedPlayers == game.totalplayers) {
                        game.currentPlayer = game.players[0];
                        sendToAllPlayers("START");
                        game.currentPlayer.out.println("YOURTURN");
                    }


                } else if (input.startsWith("CREATEGAME")) {
                    int size = Integer.parseInt(input.substring(10, 11));
                    System.out.println(size);
                    server.games.add(new Game(size));
                    sendToAllPlayers("CREATED");

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
