package Server;

public enum Sides {

    TOP(0) {
        @Override
        public Sides getOppositeSide() {
            return BOTTOM;
        }

    },
    RIGHT_TOP(1) {
        @Override
        public Sides getOppositeSide() {
            return LEFT_BOTTOM;
        }

    },
    RIGHT_BOTTOM(2) {
        @Override
        public Sides getOppositeSide() {
            return LEFT_TOP;
        }

    },
    BOTTOM(3) {
        @Override
        public Sides getOppositeSide() {
            return TOP;
        }

    },
    LEFT_BOTTOM(4) {
        @Override
        public Sides getOppositeSide() {
            return RIGHT_TOP;
        }

    },
    LEFT_TOP(5) {
        @Override
        public Sides getOppositeSide() {
            return RIGHT_BOTTOM;
        }

    };


    private int num;

    Sides(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }


    public abstract Sides getOppositeSide();

}

