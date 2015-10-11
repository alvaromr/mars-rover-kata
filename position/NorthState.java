package position;

public class NorthState implements DirectionState {

    private final Position position;

    public NorthState(Position position) {
        this.position = position;
    }

    @Override
    public void moveForward() {
        this.position.incrementY();
    }

    @Override
    public void moveBackward() {
        this.position.decrementY();
    }

    @Override
    public void turnLeft() {
        this.position.setFacingState(this.position.getWestState());
    }

    @Override
    public void turnRight() {
        this.position.setFacingState(this.position.getEastState());
    }

    @Override
    public String toString() {
        return "N";
    }
}
