package Client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    Client client;
    ServerConnector connector;
    StartWindow startWindow;
    GameWindow gameWindow;
    Stage primaryStage;
    Colours colours;

    public Main() throws IOException {
        client = new Client();
        connector = new ServerConnector(this);
        startWindow = new StartWindow(this);
        colours = Colours.getInstance();

    }


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        Scene scene = new Scene(startWindow.getView(), 550, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
        new Thread(connector).start();
    }

}