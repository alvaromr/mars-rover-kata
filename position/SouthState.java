package position;

public class SouthState implements DirectionState {

    private final Position position;

    public SouthState(Position position) {
        this.position = position;
    }

    @Override
    public void moveForward() {
        this.position.decrementY();
    }

    @Override
    public void moveBackward() {
        this.position.incrementY();
    }

    @Override
    public void turnLeft() {
        this.position.setFacingState(this.position.getEastState());
    }

    @Override
    public void turnRight() {
        this.position.setFacingState(this.position.getWestState());
    }

    @Override
    public String toString() {
        return "S";
    }
}
