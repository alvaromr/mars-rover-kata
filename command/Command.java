package command;

public interface Command {
    boolean execute();
    void undo();
}
