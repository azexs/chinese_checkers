package Client;

import Client.Board.GraphicBoard;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GameWindow {


    GraphicBoard board;
    Pane pane;
    Scene scene;
    Main main;
    Label status;
    Actions actions;


    public GameWindow(Main main, int size) {
        this.main = main;
        pane = new Pane();
        board = new GraphicBoard(size);

        HBox hbox = new HBox(15);
        VBox vbox = new VBox();

        Button endTurn = new Button("END TURN");
        status = new Label("Waiting for players");
        Label label = new Label("You are");
        Circle circle = new Circle(7);
        circle.setFill(main.client.color);
        hbox.getChildren().addAll(endTurn, status, label, circle);

        setPositions();

        actions = new Actions(board.getBoard(), main, endTurn);
        actions.addListeners();

        vbox.getChildren().addAll(hbox, pane);
        scene = new Scene(vbox, 13 * 40, 17 * 40);

    }


    void setPositions() {
        for (int x = 0; x < 13; x++) {
            for (int y = 0; y < 17; y++) {
                if (board.getPawn(x, y).getFill() == Color.GREEN) {
                    if (y % 2 == 0) {

                        board.getPawn(x, y).relocate((x * 40), y * 40);
                        pane.getChildren().addAll(board.getPawn(x, y));
                    } else {

                        board.getPawn(x, y).relocate((x * 40) + 20, y * 40);


                        pane.getChildren().addAll(board.getPawn(x, y));
                    }
                }
                if (board.getPawn(x, y).getFill() == Color.RED) {
                    if (y % 2 == 0) {
                        board.getPawn(x, y).relocate(x * 40, y * 40);
                        pane.getChildren().addAll(board.getPawn(x, y));
                    } else {
                        board.getPawn(x, y).relocate((x * 40) + 20, y * 40);
                        pane.getChildren().addAll(board.getPawn(x, y));
                    }
                }
                if (board.getPawn(x, y).getFill() == Color.GREY) {
                    if (y % 2 == 0) {
                        board.getPawn(x, y).relocate(x * 40, y * 40);
                        pane.getChildren().addAll(board.getPawn(x, y));
                    } else {
                        board.getPawn(x, y).relocate((x * 40) + 20, y * 40);
                        pane.getChildren().addAll(board.getPawn(x, y));
                    }
                }
                if (board.getPawn(x, y).getFill() == Color.BLUE) {
                    if (y % 2 == 0) {

                        board.getPawn(x, y).relocate((x * 40), y * 40);
                        pane.getChildren().addAll(board.getPawn(x, y));
                    } else {

                        board.getPawn(x, y).relocate((x * 40) + 20, y * 40);


                        pane.getChildren().addAll(board.getPawn(x, y));
                    }
                }
                if (board.getPawn(x, y).getFill() == Color.YELLOW) {
                    if (y % 2 == 0) {

                        board.getPawn(x, y).relocate((x * 40), y * 40);
                        pane.getChildren().addAll(board.getPawn(x, y));
                    } else {

                        board.getPawn(x, y).relocate((x * 40) + 20, y * 40);


                        pane.getChildren().addAll(board.getPawn(x, y));
                    }
                }
                if (board.getPawn(x, y).getFill() == Color.ORANGE) {
                    if (y % 2 == 0) {

                        board.getPawn(x, y).relocate((x * 40), y * 40);
                        pane.getChildren().addAll(board.getPawn(x, y));
                    } else {

                        board.getPawn(x, y).relocate((x * 40) + 20, y * 40);


                        pane.getChildren().addAll(board.getPawn(x, y));
                    }
                }
                if (board.getPawn(x, y).getFill() == Color.VIOLET) {
                    if (y % 2 == 0) {

                        board.getPawn(x, y).relocate((x * 40), y * 40);
                        pane.getChildren().addAll(board.getPawn(x, y));
                    } else {

                        board.getPawn(x, y).relocate((x * 40) + 20, y * 40);


                        pane.getChildren().addAll(board.getPawn(x, y));
                    }
                }
            }
        }
    }

    public Scene getView() {
        return scene;
    }

}
