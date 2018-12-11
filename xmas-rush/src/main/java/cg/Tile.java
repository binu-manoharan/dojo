package cg;

public class Tile {
    private int x, y;
    private boolean up, right, down, left;

    public Tile(int x, int y, boolean up, boolean right, boolean down, boolean left) {
        this.x = x;
        this.y = y;
        this.up = up;
        this.right = right;
        this.down = down;
        this.left = left;
    }

    @Override
    public String toString() {

        final StringBuilder directionString = new StringBuilder("|     |");
        if (up) {
            directionString.setCharAt(1, '^');
        }
        if (down) {
            directionString.setCharAt(3, 'v');
        }
        if (left) {
            directionString.setCharAt(4, '<');
        }
        if (right) {
            directionString.setCharAt(2, '>');
        }


        return directionString.toString();
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }
}
