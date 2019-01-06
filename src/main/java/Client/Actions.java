package Client;


import javafx.event.EventTarget;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;


class Actions {

    private Main main;
    private Pawn selectedPawn;
    private EventTarget target;
    private Pawn[][] board;
    private Button endTurn;

    Actions(Pawn[][] board, Main main, Button endTurn) {
        this.board = board;
        this.main = main;
        this.endTurn = endTurn;
    }

    void addListeners() {

        for (int i = 0; i < board.length; i++) {
            for (int y = 0; y < board[i].length; y++) {
                board[i][y].setOnMouseClicked(e -> {
                    target = e.getTarget();
                    Pawn pos = null;

                    if (target.getClass() == Pawn.class) {
                        pos = (Pawn) target;
                    }

                    if (selectedPawn != null) {
                        assert pos != null;
                        if (pos.getFill() == main.client.getColor()) {
                            selectedPawn.setStrokeWidth(0);
                            selectedPawn = pos;
                            selectedPawn.setStroke(Color.BLACK);
                            selectedPawn.setStrokeWidth(4);

                        } else if (pos.getFill() == main.colours.get(6)) {
                            selectedPawn.setStroke(main.colours.get(6));
                            selectedPawn.setStrokeWidth(0);
                            main.connector.out.println("MOVE" + " " + getPos(selectedPawn) + " " + getPos(pos));
                            selectedPawn = null;
                        }
                    } else {
                        assert pos != null;
                        if (pos.getFill() == main.client.getColor()) {
                            selectedPawn = pos;
                            selectedPawn.setStroke(Color.BLACK);
                            selectedPawn.setStrokeWidth(4);
                        }
                    }



                });
            }
        }


        endTurn.setOnAction(e -> main.connector.out.println("NEXTPLAYER"));


    }


    private String getPos(Pawn pawn) {
        String str = null;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != null && board[i][j].equals(pawn)) {
                    str = String.valueOf(i) + "." + String.valueOf(j);
                    break;
                }
            }
        }
        return str;
    }


}