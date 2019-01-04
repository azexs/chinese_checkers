package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;


public class Server {


    List<Game> games;

    List<ClientHandler> connectedClients;

    ServerSocket serverSocket;

    public Server() throws IOException {
        games = new ArrayList<>();
        connectedClients = new ArrayList<>();
        serverSocket = new ServerSocket(2137);
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
    }

    void start() throws IOException {
        while (true) {
            ClientHandler newClient = new ClientHandler(serverSocket.accept(), this);
            this.connectedClients.add(newClient);
            new Thread(newClient).start();
        }
    }


}


