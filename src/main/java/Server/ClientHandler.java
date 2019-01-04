package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Optional;

public class ClientHandler extends Thread {

    Socket socket;
    BufferedReader in;
    PrintWriter out;
    Server server;
    Game game;
    Player player;


    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    private void sendToAllPlayers(String msg) {

        for (ClientHandler p : server.connectedClients) {
            p.out.println(msg);
        }

    }

    public void run() {
        try {

            out.println("HELLO " + server.games.size());

            while (true) {
                String input = in.readLine();

                if (input.startsWith("CREATEGAME")) {
                    int size = Integer.parseInt(input.substring(10, 11));
                    server.games.add(new Game(size));

                    sendToAllPlayers("CREATED");

                } else if (input.startsWith("JOIN")) {
                    input = input.substring(4);
                    game = server.games.get(Integer.parseInt(input));
                    player = new Player(game.connectedPlayers);
                    game.players[game.connectedPlayers] = player;
                    game.connectedPlayers++;

                    out.println("JOINED" + player.id + "" + game.totalplayers);

                    if (game.connectedPlayers == game.totalplayers) {
                        game.currentPlayer = game.players[0];
                        sendToAllPlayers("START");
                        Optional<ClientHandler> temp = server.connectedClients.stream().filter(p -> p.player == game.currentPlayer).findFirst();
                        if (temp.isPresent()) {
                            temp.get().out.println("YOURTURN");
                        }
                    }
                } else if (input.startsWith("MOVE")) {
                    if (this.player == game.currentPlayer) {
                        String[] separated = input.split(" ");
                        String[] pawnpos1 = separated[1].split("\\.");
                        String[] pawnpos2 = separated[2].split("\\.");
                        int pawnX = Integer.parseInt(pawnpos1[0]);
                        int pawnY = Integer.parseInt(pawnpos1[1]);
                        int targetX = Integer.parseInt(pawnpos1[0]);
                        int targetY = Integer.parseInt(pawnpos1[1]);

                        game.move(pawnX, pawnY, targetX, targetY);

                        sendToAllPlayers("MOVE" + " " + pawnpos1[0] + " " + pawnpos1[1] + " " + pawnpos2[0] + " " + pawnpos2[1]);
                    }


                } else if (input.startsWith("NEXTPLAYER")) {

                    out.println("ENDROUND");

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

                    Optional<ClientHandler> temp = server.connectedClients.stream().filter(p -> p.player == game.currentPlayer).findFirst();
                    if (temp.isPresent()) {
                        temp.get().out.println("YOURTURN");
                    }

                }


            }

        } catch (IOException e) {
            //
        }
    }


}
