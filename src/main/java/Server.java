import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {


    public static void main(String[] args) throws IOException {
        System.out.println("The capitalization server is running.");
        ServerSocket listener = new ServerSocket(2137);
        try {
            while (true) {
                new Player(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }




    private static class Player extends Thread {
        private Socket socket;


        public Player(Socket socket) {
            this.socket = socket;
        }


        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    String input = in.readLine();
                    if (input == null || input.equals(".")) {
                        break;
                    }
                    String[] separated = input.split(" ");
                    String[] pawnpos1 = separated[1].split("\\.");
                    String[] pawnpos2 = separated[2].split("\\.");
                    System.out.println("MOVE" + " " + pawnpos1[0] + " " + pawnpos1[1]  + " " + pawnpos2[0] + " " + pawnpos2[1]);
                    out.println("MOVE" + " " + pawnpos1[0] + " " + pawnpos1[1]  + " " + pawnpos2[0] + " " + pawnpos2[1]);
                }
            } catch (IOException e) {
                System.out.println("Error handling client# " + 15 + ": " + e);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Couldn't close a socket, what's going on?");
                }
                System.out.println("Connection with client# " + 15 + " closed");
            }
        }




    }

















}


