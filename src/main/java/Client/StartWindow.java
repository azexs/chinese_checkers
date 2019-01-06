package Client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class StartWindow {

    Pane view;
    int position;
    ListView<String> list;

    public StartWindow(Main main) throws IOException {

        list = new ListView<>();
        getGames(main);
        list.getSelectionModel().selectedItemProperty().addListener(
                (ov, old_val, new_val) -> {
                    position = list.getSelectionModel().getSelectedIndex();
                    System.out.println(position);
                });

        list.setPrefHeight(300);
        list.relocate(15, 15);


        view = new Pane();
        Button newGame = new Button("New Game");
        Button joinGame = new Button("Join game");
        newGame.relocate(400, 150);
        joinGame.relocate(400, 200);

        joinGame.setOnAction(event -> {
            main.connector.joinGame(position);
        });

        newGame.setOnAction(event -> {
            Stage stage1 = new Stage();

            VBox vbox = new VBox(15);
            vbox.setPadding(new Insets(30));

            Label label1 = new Label("Liczba graczy");
            Slider slider1 = new Slider(1, 6, 2);
            slider1.setShowTickMarks(true);
            slider1.setShowTickLabels(true);
            slider1.setMajorTickUnit(1);
            slider1.setMinorTickCount(0);
            slider1.setBlockIncrement(1);
            slider1.setSnapToTicks(true);


            Label label2 = new Label("Liczba botów");
            Slider slider2 = new Slider(0, 5, 0);
            slider2.setShowTickMarks(true);
            slider2.setShowTickLabels(true);
            slider2.setMajorTickUnit(1);
            slider2.setMinorTickCount(0);
            slider2.setBlockIncrement(1);
            slider2.setSnapToTicks(true);


            Button button = new Button("Create Game");

            button.setOnMouseClicked(e -> {

                main.connector.createGame(slider1.getValue());
                stage1.close();

            });

            vbox.getChildren().addAll(label1, slider1, label2, slider2, button);

            stage1.setTitle("Create Game");
            stage1.setScene(new Scene(vbox, 250, 250));
            stage1.show();

        });


        view.getChildren().addAll(list, newGame, joinGame);

    }

    void getGames(Main main) throws IOException {

        String start = main.connector.in.readLine();
        int k = Integer.parseInt(start.substring(6));
        ObservableList<String> data = FXCollections.observableArrayList();
        for (int i = 1; i <= k; i++) {
            data.add("Game " + i);
        }
        list.setItems(data);
    }

    public Parent getView() {
        return view;
    }


}







