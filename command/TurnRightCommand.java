package command;

import position.Position;

public class TurnRightCommand implements Command {

    private final Position position;

    public TurnRightCommand(Position position) {
        this.position = position;
    }

    @Override
    public boolean execute() {
        this.position.turnRight();
        return true;
    }

    @Override
    public void undo() {
        this.position.turnLeft();
    }
}
