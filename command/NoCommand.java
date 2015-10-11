package command;

public class NoCommand implements Command {

    @Override
    public boolean execute() {
        return true;
    }

    @Override
    public void undo() {    }
}
