package position;

public class WestState implements DirectionState {

    private final Position position;

    public WestState(Position position) {
        this.position = position;
    }

    @Override
    public void moveForward() {
        this.position.decrementX();
    }

    @Override
    public void moveBackward() {
        this.position.incrementX();
    }

    @Override
    public void turnLeft() {
        this.position.setFacingState(this.position.getSouthState());
    }

    @Override
    public void turnRight() {
        this.position.setFacingState(this.position.getNorthState());
    }

    @Override
    public String toString() {
        return "W";
    }
}
