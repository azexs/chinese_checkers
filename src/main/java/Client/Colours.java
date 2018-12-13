package Client;

import javafx.scene.paint.Color;

import java.util.HashMap;


public final class Colours extends HashMap<Integer, Color> {


    private static Colours instance;

    private Colours() {
        initialize();
    }

    public static Colours getInstance() {
        //Double-checked locking
        if (instance == null) {
            synchronized (Colours.class) {
                if (instance == null) {
                    instance = new Colours();
                }
            }
        }
        return instance;
    }

    private void initialize() {
        instance = this;
        instance.clear();
        instance.put(0, Color.GREY);
        instance.put(1, Color.GREEN);
        instance.put(2, Color.RED);
        instance.put(3, Color.BLUE);
        instance.put(4, Color.GREEN);
        instance.put(5, Color.WHITE);
        instance.put(6, Color.YELLOW);
    }


}