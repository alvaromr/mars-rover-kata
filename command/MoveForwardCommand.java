package command;

import position.Position;

public class MoveForwardCommand implements Command {

    private final Position position;

    public MoveForwardCommand(Position position) {
        this.position = position;
    }

    @Override
    public boolean execute() {
        return this.position.moveForward();
    }

    @Override
    public void undo() {
        this.position.moveBackward();
    }


}
