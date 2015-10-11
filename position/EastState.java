package position;

public class EastState implements DirectionState {

    private final Position position;

    public EastState(Position position) {
        this.position = position;
    }

    @Override
    public void moveForward() {
        this.position.incrementX();
    }

    @Override
    public void moveBackward() {
        this.position.decrementX();
    }

    @Override
    public void turnLeft() {
        this.position.setFacingState(this.position.getNorthState());
    }

    @Override
    public void turnRight() {
        this.position.setFacingState(this.position.getSouthState());
    }

    @Override
    public String toString() {
        return "E";
    }
}
