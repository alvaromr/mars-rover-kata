package rover;

import command.*;
import grid.Grid;
import position.Position;

import java.util.HashMap;
import java.util.Map;

public class Rover {

    private final Position POSITION;

    private boolean lastCommandFailed;
    private final Map<Character, Command> commands;

    public Rover(int initialX, int initialY, Grid grid){
        this.POSITION = new Position(initialX, initialY, grid);

        this.commands = new HashMap<>();
        this.commands.put('F', new MoveForwardCommand(this.POSITION));
        this.commands.put('B', new MoveBackwardCommand(this.POSITION));
        this.commands.put('L', new TurnLeftCommand(this.POSITION));
        this.commands.put('R', new TurnRightCommand(this.POSITION));

        this.lastCommandFailed = false;
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", this.POSITION, this.lastCommandFailed ? "OBSTACLE" : "OK");
    }

    public String receiveCommands(String commands) {
        this.lastCommandFailed = false;
        for (char commandCode : commands.toCharArray()) {
            Command command = getCommandByCode(commandCode);
            this.lastCommandFailed = !command.execute();
            if(this.lastCommandFailed){
                command.undo();
                break;
            }
        }
        return this.toString();
    }

    private Command getCommandByCode(char commandCode) {
        Command command = commands.get(commandCode);
        return command == null ? new NoCommand() : command;
    }

}
