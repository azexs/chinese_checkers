package Client;

import javafx.application.Application;
import javafx.event.EventTarget;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Application implements Runnable {

    Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    Color color;

    Pawn selectedPawn;
    GraphicBoard board;
    EventTarget target;
    Pane pane;

    public static void main(String[] args) {
        try {
            launch(args);
        } catch (Exception e) {
            System.out.println("Cannot lunch the board application: " + e.getMessage());
        }
    }

    public Client () throws IOException {
        socket = new Socket("localhost", 2137);
        in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

    }


    @Override
    public void start(Stage primaryStage) throws IOException {

        pane = new Pane();
        board = new GraphicBoard();


        for (int x = 0; x < 13; x++) {
            for (int y = 0; y < 17; y++) {
                if (board.getPawn(x, y).getFill() == Color.GREEN) {
                    if (y % 2 == 0) {

                        board.getPawn(x,y).relocate((x * 40) , y * 40);
                        pane.getChildren().addAll( board.getPawn(x,y));
                    } else {

                       board.getPawn(x,y).relocate((x * 40) + 20, y * 40);


                        pane.getChildren().addAll( board.getPawn(x,y));
                    }
                }
                if (board.getPawn(x, y).getFill() == Color.RED) {
                    if (y % 2 == 0) {
                         board.getPawn(x,y).relocate(x * 40, y * 40);
                        pane.getChildren().addAll( board.getPawn(x,y));
                    } else {
                         board.getPawn(x,y).relocate((x * 40) + 20, y * 40);
                        pane.getChildren().addAll( board.getPawn(x,y));
                    }
                }
                if (board.getPawn(x, y).getFill() == Color.GREY) {
                    if (y % 2 == 0) {
                         board.getPawn(x,y).relocate(x * 40, y * 40);
                        pane.getChildren().addAll( board.getPawn(x,y));
                    } else {
                         board.getPawn(x,y).relocate((x * 40) + 20, y * 40);
                        pane.getChildren().addAll( board.getPawn(x,y));
                    }
                }
            }
        }




        for (int i=0; i< board.board.length; i++)
        {
            for (int y=0; y< board.board[i].length; y++){
                 board.board[i][y]. setOnMouseClicked(e -> {
                    target = e.getTarget();
                    Pawn pos = null;

                    if (target.getClass() == Pawn.class) {
                        pos = (Pawn) target;
                    }

                    if (selectedPawn != null) {
                        selectedPawn.setStroke(Color.GRAY);
                        selectedPawn.setStrokeWidth(2);
                        out.println("MOVE" +" "+ getPos(selectedPawn) +" " +getPos(pos) );
                        System.out.println("MOVE" +" "+ getPos(selectedPawn) +" " +getPos(pos) );

                        selectedPawn = null;
                    } else {
                        selectedPawn = pos;
                            selectedPawn.setStroke(Color.YELLOW);
                            selectedPawn.setStrokeWidth(4);

                    }


                });
            }
        }

        Scene scene = new Scene(pane, 13 * 40, 17 * 40);
        primaryStage.setTitle("Chinese Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();

        Thread serverListener = new Thread(this);
        serverListener.start();



    }

    private String getPos (Circle pawn){
        String str = null;
        for (int i = 0; i < board.board.length; i++) {
            for (int j = 0; j < board.board[i].length; j++) {
                if (board.board[i][j] != null && board.board[i][j].equals(pawn)) {
                    str = String.valueOf(i) + "." + String.valueOf(j);
                    break;
                }
            }
        }
        return str;
    }


    public void run()  {
        String response;
        try {
            while (true) {
                response = in.readLine();
                if (response.startsWith("MOVE")) {

                    String[] split;
                    response=response.substring(5);
                    split=response.split(" ");
                    int par11 = 0, par12 = 0, par21=0, par22=0;
                    par11=Integer.parseInt(split[0]);    par12=Integer.parseInt(split[1]) ;   par21=Integer.parseInt(split[2])  ;  par22=Integer.parseInt(split[3]);

                    Pawn temPawn = board.getPawn(par11,par12);

                    board.getPawn(par21,par22).setFill(temPawn.getFill());
                    temPawn.setFill(Color.GREY);


                } else if (response.startsWith("OPPONENT_MOVED")) {
                    break;
                }
            }
            out.println("QUIT");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}





