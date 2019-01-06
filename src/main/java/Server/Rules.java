package Server;

import Server.AbstractBoard.AbstractBoard;

import java.util.ArrayList;
import java.util.List;

public class Rules {

    List<Field> possibleMoves;
    Game game;

    public Rules(AbstractBoard board, Game game) {
        this.game = game;
        possibleMoves = new ArrayList<Field>();
    }


    boolean move(int pawnx, int pawny, int targetx, int targety) {
        Field target = game.boardd[targetx][targety];
        if (possibleMoves.contains(target)) {

            Field temp = game.boardd[pawnx][pawny];

            game.boardd[pawnx][pawny] = game.boardd[targetx][targety];
            game.boardd[pawnx][pawny].x = pawny;
            game.boardd[pawnx][pawny].y = pawny;

            game.boardd[targetx][targety] = temp;
            game.boardd[targetx][targety].x = targetx;
            game.boardd[targetx][targety].y = targety;


            // System.out.println(targetx +" " + targety + " " + game.boardd[targetx][targety].x + " " + game.boardd[targetx][targety].y);
            // System.out.println(pawnx + " " + pawny + " " + game.boardd[pawnx][pawny].x + " " + game.boardd[pawnx][pawny].y);


            possibleMoves.clear();
            return true;
        }
        possibleMoves.clear();
        return false;
    }

    public boolean trymove(int pawnx, int pawny, int targetx, int targety) {

        possibleMoves = possibleSingleMoves(pawnx, pawny, 1);
        if (move(pawnx, pawny, targetx, targety)) return true;
        possibleMoves = possibleJumps(pawnx, pawny);

        for (Field f : possibleMoves) {
            System.out.println("possible: " + f.x + " " + f.y);
        }

        if (move(pawnx, pawny, targetx, targety)) return true;


        return false;

    }


    List<Field> possibleSingleMoves(int pawnx, int pawny, int isPawn) {

        List<Field> fields = new ArrayList<Field>();


        boolean lol = false;
        if (isPawn == 1) lol = true;


        if (pawny % 2 == 0) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 1; j++) {
                    if (pawnx + j + 1 >= 0 && pawny + i >= 0) {
                        if (i == 0 && j == 0) {
                            if ((!(game.boardd[pawnx + j + 1][pawny + i].isPawn)) == lol)
                                fields.add(game.boardd[pawnx + j + 1][pawny + i]);
                        } else if ((!(game.boardd[pawnx + j][pawny + i].isPawn)) == lol)
                            fields.add(game.boardd[pawnx + j][pawny + i]);
                    }
                }

            }
        } else {
            for (int i = -1; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (pawnx + j - 1 >= 0 && pawny + i >= 0) {
                        if (i == 0 && j == 0) {
                            if ((!(game.boardd[pawnx + j - 1][pawny + i].isPawn)) == lol)
                                fields.add(game.boardd[pawnx + j - 1][pawny + i]);
                        } else if ((!(game.boardd[pawnx + j][pawny + i].isPawn)) == lol)
                            fields.add(game.boardd[pawnx + j][pawny + i]);
                    }
                }

            }
        }


        return fields;
    }


    List<Field> possibleJumps(int pawnx, int pawny) {

        List<Field> occupiedfields = possibleSingleMoves(pawnx, pawny, 0);


        for (Field f : occupiedfields) {

            System.out.println("don" + f.x + " " + f.y);


            if (pawny == f.y) {
                if ((pawnx - f.x) < 0) {
                    if (!(game.boardd[pawnx + 2][pawny].isPawn)) {
                        if (!possibleMoves.contains(game.boardd[pawnx + 2][pawny])) {
                            possibleMoves.add(game.boardd[pawnx + 2][pawny]);
                            possibleJumps(pawnx + 2, pawny);
                        }
                    }
                } else {
                    if (!(game.boardd[pawnx - 2][pawny].isPawn)) {
                        if (!possibleMoves.contains(game.boardd[pawnx + 2][pawny])) {
                            possibleMoves.add(game.boardd[pawnx - 2][pawny]);
                            possibleJumps(pawnx - 2, pawny);
                        }
                    }
                }
            }


            if (pawny - f.y == -1) {

                if (pawnx - f.x == 1) {
                    if (!(game.boardd[pawnx - 1][pawny + 2].isPawn)) {
                        if (!possibleMoves.contains(game.boardd[pawnx - 1][pawny + 2])) {
                            possibleMoves.add(game.boardd[pawnx - 1][pawny + 2]);
                            possibleJumps(pawnx - 1, pawny + 2);
                        }
                    }
                }

                if (pawnx == f.x) {
                    if (!(game.boardd[pawnx + 1][pawny + 2].isPawn)) {
                        if (!possibleMoves.contains(game.boardd[pawnx + 1][pawny + 2])) {
                            possibleMoves.add(game.boardd[pawnx + 1][pawny + 2]);
                            possibleJumps(pawnx + 1, pawny + 2);
                        }
                    }
                }

            }






        }

        return possibleMoves;
    }



}
