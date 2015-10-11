package grid;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    final int MAX_X;
    final int MAX_Y;

    private final List<Coordinates> obstacles;

    public Grid(int maxX, int maxY) {
        this.MAX_X = maxX;
        this.MAX_Y = maxY;
        obstacles = new ArrayList<>();
    }

    public void addObstacle(Coordinates coordinates){
        if(coordinates.getGrid() != this) {
            throw new IllegalArgumentException("Can't add an obstacle from other grid");
        }
        this.obstacles.add(coordinates);
    }

    public boolean containsObstacle(Coordinates obstacle){
        return this.obstacles.contains(obstacle);
    }
}
