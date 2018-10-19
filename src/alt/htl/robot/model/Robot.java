package at.htl.robot.model;

public class Robot {

    private int y;
    private int x;
    private Direction direction = Direction.SOUTH;
    private boolean  mode;

    public Robot(int x, int y){
        setX(x);
        setY(y);
        setMode(false);
    }

    Robot() {

    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setMode(boolean mode) {
        this.mode = mode;
    }

    public boolean isMode() {
        return mode;
    }




    public void stepForward() {
        switch (this.direction) {
            case SOUTH: y++;
                break;
            case NORTH: y--;
                break;
            case EAST: x++;
                break;
            case WEST: x--;
                break;
        }
    }

    public void rotateLeft() {
        switch (this.direction) {
            case SOUTH: this.direction = Direction.EAST;
                break;
            case NORTH: this.direction = Direction.WEST;
                break;
            case EAST: this.direction = Direction.NORTH;
                break;
            case WEST: this.direction = Direction.SOUTH;
                break;
        }
    }

}
