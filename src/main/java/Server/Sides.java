package Server;

import Server.AbstractBoard.AbstractBoard;

import java.util.ArrayList;
import java.util.List;

public enum Sides {

    TOP {
        @Override
        public Sides getOppositeSide() {
            return BOTTOM;
        }

        public List<Field> getArea(AbstractBoard board) {
            List<Field> area = new ArrayList<Field>();
            area.add(board.getPawn(6, 0));
            area.add(board.getPawn(5, 1));
            area.add(board.getPawn(6, 1));
            area.add(board.getPawn(5, 2));
            area.add(board.getPawn(6, 2));
            area.add(board.getPawn(7, 2));
            area.add(board.getPawn(4, 3));
            area.add(board.getPawn(5, 3));
            area.add(board.getPawn(6, 3));
            area.add(board.getPawn(7, 3));

            return area;
        }

    },
    RIGHT_TOP {
        @Override
        public Sides getOppositeSide() {
            return LEFT_BOTTOM;
        }

        public List<Field> getArea(AbstractBoard board) {
            List<Field> area = new ArrayList<Field>();
            area.add(board.getPawn(10, 7));
            area.add(board.getPawn(10, 6));
            area.add(board.getPawn(11, 6));
            area.add(board.getPawn(9, 5));
            area.add(board.getPawn(10, 5));
            area.add(board.getPawn(11, 5));
            area.add(board.getPawn(9, 4));
            area.add(board.getPawn(10, 4));
            area.add(board.getPawn(11, 4));
            area.add(board.getPawn(12, 4));

            return area;
        }

    },
    RIGHT_BOTTOM {
        @Override
        public Sides getOppositeSide() {
            return LEFT_TOP;
        }

        public List<Field> getArea(AbstractBoard board) {
            List<Field> area = new ArrayList<Field>();
            area.add(board.getPawn(10, 9));
            area.add(board.getPawn(10, 10));
            area.add(board.getPawn(11, 10));
            area.add(board.getPawn(9, 11));
            area.add(board.getPawn(10, 11));
            area.add(board.getPawn(11, 11));
            area.add(board.getPawn(9, 12));
            area.add(board.getPawn(10, 12));
            area.add(board.getPawn(11, 12));
            area.add(board.getPawn(12, 12));

            return area;
        }

    },
    BOTTOM {
        @Override
        public Sides getOppositeSide() {
            return TOP;
        }

        public List<Field> getArea(AbstractBoard board) {
            List<Field> area = new ArrayList<Field>();
            area.add(board.getPawn(4, 13));
            area.add(board.getPawn(5, 13));
            area.add(board.getPawn(6, 13));
            area.add(board.getPawn(7, 13));
            area.add(board.getPawn(7, 14));
            area.add(board.getPawn(6, 14));
            area.add(board.getPawn(5, 14));
            area.add(board.getPawn(5, 15));
            area.add(board.getPawn(6, 15));
            area.add(board.getPawn(6, 16));

            return area;
        }

    },
    LEFT_BOTTOM {
        @Override
        public Sides getOppositeSide() {
            return RIGHT_TOP;
        }

        public List<Field> getArea(AbstractBoard board) {
            List<Field> area = new ArrayList<Field>();
            area.add(board.getPawn(1, 9));
            area.add(board.getPawn(1, 10));
            area.add(board.getPawn(2, 10));
            area.add(board.getPawn(0, 11));
            area.add(board.getPawn(1, 11));
            area.add(board.getPawn(2, 11));
            area.add(board.getPawn(0, 12));
            area.add(board.getPawn(1, 12));
            area.add(board.getPawn(2, 12));
            area.add(board.getPawn(3, 12));

            return area;
        }

    },
    LEFT_TOP {
        @Override
        public Sides getOppositeSide() {
            return RIGHT_BOTTOM;
        }

        public List<Field> getArea(AbstractBoard board) {
            List<Field> area = new ArrayList<Field>();
            area.add(board.getPawn(1, 7));
            area.add(board.getPawn(1, 6));
            area.add(board.getPawn(2, 6));
            area.add(board.getPawn(0, 5));
            area.add(board.getPawn(1, 5));
            area.add(board.getPawn(2, 5));
            area.add(board.getPawn(0, 4));
            area.add(board.getPawn(1, 4));
            area.add(board.getPawn(2, 4));
            area.add(board.getPawn(3, 4));

            return area;
        }

    };



    public abstract Sides getOppositeSide();

    public abstract List<Field> getArea(AbstractBoard board);

}