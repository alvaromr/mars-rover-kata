package command;

import position.Position;

public class TurnLeftCommand implements Command {

    private final Position position;

    public TurnLeftCommand(Position position) {
        this.position = position;
    }

    @Override
    public boolean execute() {
        this.position.turnLeft();
        return true;
    }

    @Override
    public void undo() {
        this.position.turnRight();
    }
}
