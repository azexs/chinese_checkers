package Client;

import javafx.application.Platform;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerConnector extends Thread {

    Socket socket;
    BufferedReader in;
    PrintWriter out;
    Main main;


    public ServerConnector(Main main) throws IOException {
        socket = new Socket("localhost", 2137);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        this.main = main;
    }

    void createGame(double value) {
        out.println("CREATEGAME" + value);

    }

    void joinGame(int position) {
        out.println("JOIN" + position);
    }


    public void run() {
        String response;
        try {
            while (true) {
                response = in.readLine();
                System.out.println(response);


                if (response.startsWith("MOVE")) {

                    String[] split;
                    response = response.substring(5);
                    split = response.split(" ");
                    int par11, par12, par21, par22;
                    par11 = Integer.parseInt(split[0]);
                    par12 = Integer.parseInt(split[1]);
                    par21 = Integer.parseInt(split[2]);
                    par22 = Integer.parseInt(split[3]);

                    Pawn temPawn = main.gameWindow.board.getPawn(par11, par12);

                    main.gameWindow.board.getPawn(par21, par22).setFill(temPawn.getFill());
                    temPawn.setFill(Color.GREY);

                    out.println("NEXTPLAYER");


                } else if (response.startsWith("YOURTURN")) {

                    Platform.runLater(() -> main.gameWindow.status.setText("Your Turn"));

                } else if (response.startsWith("ENDROUND")) {

                    Platform.runLater(() -> main.gameWindow.status.setText("Opponent Turn"));

                } else if (response.startsWith("START")) {
                    Platform.runLater(() -> main.gameWindow.status.setText("Opponent Turn"));

                } else if (response.startsWith("CREATED")) {
                    int q = main.startWindow.list.getItems().size() + 1;

                    Platform.runLater(() -> main.startWindow.list.getItems().add("Game " + q));

                } else if (response.startsWith("JOINED")) {
                    main.client.setColor(main.colours.get(Integer.parseInt(response.substring(6, 7))));
                    int size = Integer.parseInt(response.substring(7));
                    Platform.runLater(() -> {
                        GameWindow asd = new GameWindow(main, size);
                        main.gameWindow = asd;
                        main.primaryStage.setScene(asd.getView());

                    });

                } else if (response.startsWith("YOUWIN")) {
                    Platform.runLater(() -> main.gameWindow.status.setText("You win!"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}