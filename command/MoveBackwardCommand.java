package command;

import position.Position;

public class MoveBackwardCommand implements Command {

    private final Position position;

    public MoveBackwardCommand(Position position) {
        this.position = position;
    }

    @Override
    public boolean execute() {
        return this.position.moveBackward();
    }

    @Override
    public void undo() {
        this.position.moveForward();
    }
}
