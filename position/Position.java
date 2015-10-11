package position;

import grid.Coordinates;
import grid.Grid;

public class Position {

    private final DirectionState NORTH_STATE;
    private final DirectionState EAST_STATE;
    private final DirectionState SOUTH_STATE;
    private final DirectionState WEST_STATE;

    private DirectionState facingState;
    private final Coordinates coordinates;

    public Position(int initialX, int initialY, Grid grid) {
        this.NORTH_STATE = new NorthState(this);
        this.EAST_STATE = new EastState(this);
        this.SOUTH_STATE = new SouthState(this);
        this.WEST_STATE = new WestState(this);

        this.facingState = this.NORTH_STATE;
        this.coordinates = new Coordinates(initialX, initialY, grid);
    }

    public void turnRight() {
        this.facingState.turnRight();
    }

    public void turnLeft() {
        this.facingState.turnLeft();
    }

    public boolean moveForward() {
        this.facingState.moveForward();
        return this.coordinates.isFree();
    }

    public boolean moveBackward() {
        this.facingState.moveBackward();
        return this.coordinates.isFree();
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", this.coordinates, this.facingState);
    }

    void incrementX(){
        this.coordinates.incrementX();
    }

    void incrementY(){
        this.coordinates.incrementY();
    }

    void decrementX(){
        this.coordinates.decrementX();
    }

    void decrementY(){
        this.coordinates.decrementY();
    }

    void setFacingState(DirectionState facingState) {
        this.facingState = facingState;
    }

    DirectionState getNorthState() {
        return this.NORTH_STATE;
    }

    DirectionState getEastState() {
        return this.EAST_STATE;
    }

    DirectionState getSouthState() {
        return this.SOUTH_STATE;
    }

    DirectionState getWestState() {
        return this.WEST_STATE;
    }
}
