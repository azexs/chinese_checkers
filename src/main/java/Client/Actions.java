package Client;


import javafx.event.EventTarget;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Actions {

    Main main;
    Pawn selectedPawn;
    EventTarget target;
    Pawn[][] board;
    Button endTurn;

    public Actions(Pawn[][] board, Main main, Button endTurn) {
        this.board = board;
        this.main = main;
        this.endTurn = endTurn;
    }

    public void addListeners() {

        for (int i = 0; i < board.length; i++) {
            for (int y = 0; y < board[i].length; y++) {
                board[i][y].setOnMouseClicked(e -> {
                    target = e.getTarget();
                    Pawn pos = null;

                    if (target.getClass() == Pawn.class) {
                        pos = (Pawn) target;
                    }

                    if (main.client.isPlayerRound) {
                        if (selectedPawn != null) {
                            if (pos.getFill() == main.client.color) {
                                selectedPawn.setStrokeWidth(0);
                                selectedPawn = pos;
                                selectedPawn.setStroke(Color.BLACK);
                                selectedPawn.setStrokeWidth(4);

                            } else if (pos.getFill() == Color.GREY) {
                                selectedPawn.setStroke(Color.GREY);
                                selectedPawn.setStrokeWidth(0);
                                main.connector.out.println("MOVE" + " " + getPos(selectedPawn) + " " + getPos(pos));
                                System.out.println("MOVE" + " " + getPos(selectedPawn) + " " + getPos(pos));
                                selectedPawn = null;
                            }
                        } else {
                            if (pos.getFill() == main.client.color) {
                                selectedPawn = pos;
                                selectedPawn.setStroke(Color.BLACK);
                                selectedPawn.setStrokeWidth(4);
                            }
                        }
                    }


                });
            }
        }


        endTurn.setOnAction(e -> {
            if (main.client.isPlayerRound) {
                main.connector.out.println("NEXTPLAYER");
            }
        });


    }


    String getPos(Circle pawn) {
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
