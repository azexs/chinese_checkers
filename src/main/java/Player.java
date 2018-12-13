import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Player extends Thread {
    Socket socket;
    Game game;


    public Player(Socket socket, Game game) {
        this.socket = socket;
        this.game = game;
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
                out.println("MOVE" + " " + pawnpos1[0] + " " + pawnpos1[1] + " " + pawnpos2[0] + " " + pawnpos2[1]);
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
