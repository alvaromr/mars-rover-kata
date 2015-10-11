package grid;

public class Coordinates {
    private int x;
    private int y;
    private Grid grid;

    public Coordinates(int x, int y, Grid grid) {
        this.x = x;
        this.y = y;
        this.grid = grid;
    }

    private int incrementValue(int value, int maxValue) {
        return value + 1 < maxValue ? value + 1 : 0;
    }

    private int decrementValue(int value, int maxValue) {
        return value > 0 ? value - 1 : maxValue - 1;
    }

    public void incrementX() {
        this.x = incrementValue(this.x, grid.MAX_X);
    }

    public void incrementY() {
        this.y = incrementValue(this.y, grid.MAX_Y);
    }

    public void decrementX() {
        this.x = decrementValue(this.x, grid.MAX_X);
    }

    public void decrementY() {
        this.y = decrementValue(this.y, grid.MAX_Y);
    }

    public boolean isFree(){
        return !this.grid.containsObstacle(this);
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Coordinates other = (Coordinates) o;

        return this.x == other.x && y == other.y && this.grid == other.grid;
    }

    @Override
    public String toString() {
        return String.format("%d,%d", this.x, this.y);
    }
}
