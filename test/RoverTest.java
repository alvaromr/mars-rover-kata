package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import grid.Coordinates;
import grid.Grid;
import rover.Rover;

public class RoverTest {

    private Rover rover1, rover2;
    private Rover rover3;

    @Before
    public void setUp() {
        Grid grid1 = new Grid(5, 5);
        rover1 = new Rover(0, 0, grid1);
        Grid grid2 = new Grid(6, 6);
        grid2.addObstacle(new Coordinates(0, 3, grid2));
        grid2.addObstacle(new Coordinates(3, 0, grid2));
        rover2 = new Rover(0, 0, grid2);
        Grid grid3 = new Grid(3, 3);
        grid3.addObstacle(new Coordinates(0, 1, grid3));
        grid3.addObstacle(new Coordinates(1, 0, grid3));
        grid3.addObstacle(new Coordinates(1, 2, grid3));
        grid3.addObstacle(new Coordinates(2, 1, grid3));
        rover3 = new Rover(1, 1, grid3);
    }

    @Test
    public void testUnknownCommand() {
        String result = rover1.receiveCommands("Q");
        assertEquals("(0,0,N)[OK]", result);
    }

    @Test
    public void testForwards1() {
        String result = rover1.receiveCommands("F");
        assertEquals("(0,1,N)[OK]", result);
    }

    @Test
    public void testForwards2() {
        String result = rover1.receiveCommands("FF");
        assertEquals("(0,2,N)[OK]", result);
    }

    @Test
    public void testBackwards1() {
        String result = rover1.receiveCommands("B");
        assertEquals("(0,4,N)[OK]", result);
    }

    @Test
    public void testBackwards2() {
        String result = rover1.receiveCommands("BB");
        assertEquals("(0,3,N)[OK]", result);
    }

    @Test
    public void testForwardsBackwards() {
        String result = rover1.receiveCommands("FB");
        assertEquals("(0,0,N)[OK]", result);
    }

    @Test
    public void testBackwardsForwards() {
        String result = rover1.receiveCommands("BF");
        assertEquals("(0,0,N)[OK]", result);
    }

    @Test
    public void testRight1() {
        String result = rover1.receiveCommands("R");
        assertEquals("(0,0,E)[OK]", result);
    }

    @Test
    public void testRight2() {
        String result = rover1.receiveCommands("RR");
        assertEquals("(0,0,S)[OK]", result);
    }

    @Test
    public void testRight3() {
        String result = rover1.receiveCommands("RRR");
        assertEquals("(0,0,W)[OK]", result);
    }

    @Test
    public void testRight4() {
        String result = rover1.receiveCommands("RRRR");
        assertEquals("(0,0,N)[OK]", result);
    }

    @Test
    public void testLeft1() {
        String result = rover1.receiveCommands("L");
        assertEquals("(0,0,W)[OK]", result);
    }

    @Test
    public void testLeft2() {
        String result = rover1.receiveCommands("LL");
        assertEquals("(0,0,S)[OK]", result);
    }

    @Test
    public void testLeft3() {
        String result = rover1.receiveCommands("LLL");
        assertEquals("(0,0,E)[OK]", result);
    }

    @Test
    public void testLeft4() {
        String result = rover1.receiveCommands("LLLL");
        assertEquals("(0,0,N)[OK]", result);
    }

    @Test
    public void testLeftRight() {
        String result = rover1.receiveCommands("LR");
        assertEquals("(0,0,N)[OK]", result);
    }

    @Test
    public void testRightLeft() {
        String result = rover1.receiveCommands("RL");
        assertEquals("(0,0,N)[OK]", result);
    }

    @Test
    public void testRightForward() {
        String result = rover1.receiveCommands("RF");
        assertEquals("(1,0,E)[OK]", result);
    }

    @Test
    public void testLeftForward() {
        String result = rover1.receiveCommands("LF");
        assertEquals("(4,0,W)[OK]", result);
    }

    @Test
    public void testTurnAroundForward1() {
        String result = rover1.receiveCommands("FRFRFRFR");
        assertEquals("(0,0,N)[OK]", result);
    }

    @Test
    public void testTurnAroundForward2() {
        String result = rover1.receiveCommands("FLFLFLFL");
        assertEquals("(0,0,N)[OK]", result);
    }

    @Test
    public void testTurnAroundBackward1() {
        String result = rover1.receiveCommands("BRBRBRBR");
        assertEquals("(0,0,N)[OK]", result);
    }

    @Test
    public void testTurnAroundBackward2() {
        String result = rover1.receiveCommands("BRBRBRBR");
        assertEquals("(0,0,N)[OK]", result);
    }

    @Test
    public void testHalfTurnAroundRightForward() {
        String result = rover1.receiveCommands("FRFR");
        assertEquals("(1,1,S)[OK]", result);
    }

    @Test
    public void testHalfTurnAroundLeftForward() {
        String result = rover1.receiveCommands("FLFL");
        assertEquals("(4,1,S)[OK]", result);
    }

    @Test
    public void testHalfTurnAroundRightBackward() {
        String result = rover1.receiveCommands("BRBR");
        assertEquals("(4,4,S)[OK]", result);
    }

    @Test
    public void testHalfTurnAroundLeftBackward() {
        String result = rover1.receiveCommands("BLBL");
        assertEquals("(1,4,S)[OK]", result);
    }

    @Test
    public void testObstaclesVerticalFailOnFirstForward() {
        String result = rover2.receiveCommands("FF");
        assertEquals("(0,2,N)[OK]", result);
        result = rover2.receiveCommands("F");
        assertEquals("(0,2,N)[OBSTACLE]", result);
    }

    @Test
    public void testObstaclesVerticalForward() {
        String result = rover2.receiveCommands("FFFF");
        assertEquals("(0,2,N)[OBSTACLE]", result);
    }

    @Test
    public void testObstaclesVerticalForwardAndRecoverBackward() {
        String result = rover2.receiveCommands("FFFF");
        assertEquals("(0,2,N)[OBSTACLE]", result);
        result = rover2.receiveCommands("B");
        assertEquals("(0,1,N)[OK]", result);
    }

    @Test
    public void testObstaclesVerticalForwardAndRecoverTurning() {
        String result = rover2.receiveCommands("FFF");
        assertEquals("(0,2,N)[OBSTACLE]", result);
        result = rover2.receiveCommands("RF");
        assertEquals("(1,2,E)[OK]", result);
    }

    @Test
    public void testObstaclesVerticalFailOnFirstBackward() {
        String result = rover2.receiveCommands("BB");
        assertEquals("(0,4,N)[OK]", result);
        result = rover2.receiveCommands("B");
        assertEquals("(0,4,N)[OBSTACLE]", result);
    }

    @Test
    public void testObstaclesVerticalBackward() {
        String result = rover2.receiveCommands("BBBBB");
        assertEquals("(0,4,N)[OBSTACLE]", result);
    }

    @Test
    public void testObstaclesVerticalBackwardAndRecoverForward() {
        String result = rover2.receiveCommands("BBBBB");
        assertEquals("(0,4,N)[OBSTACLE]", result);
        result = rover2.receiveCommands("F");
        assertEquals("(0,5,N)[OK]", result);
    }

    @Test
    public void testObstaclesVerticalBackwardAndRecoverTurning() {
        String result = rover2.receiveCommands("BBBBB");
        assertEquals("(0,4,N)[OBSTACLE]", result);
        result = rover2.receiveCommands("RF");
        assertEquals("(1,4,E)[OK]", result);
    }

    @Test
    public void testObstaclesHorizontalFailOnFirstForward() {
        String result = rover2.receiveCommands("RFF");
        assertEquals("(2,0,E)[OK]", result);
        result = rover2.receiveCommands("F");
        assertEquals("(2,0,E)[OBSTACLE]", result);
    }

    @Test
    public void testObstaclesHorizontalForward() {
        String result = rover2.receiveCommands("RFFFF");
        assertEquals("(2,0,E)[OBSTACLE]", result);
    }

    @Test
    public void testObstaclesHorizontalForwardAndRecoverBackward() {
        String result = rover2.receiveCommands("RFFFF");
        assertEquals("(2,0,E)[OBSTACLE]", result);
        result = rover2.receiveCommands("B");
        assertEquals("(1,0,E)[OK]", result);
    }

    @Test
    public void testObstaclesHorizontalForwardAndRecoverTurning() {
        String result = rover2.receiveCommands("RFFF");
        assertEquals("(2,0,E)[OBSTACLE]", result);
        result = rover2.receiveCommands("LF");
        assertEquals("(2,1,N)[OK]", result);
    }

    @Test
    public void testObstaclesHorizontalFailOnFirstBackward() {
        String result = rover2.receiveCommands("RBB");
        assertEquals("(4,0,E)[OK]", result);
        result = rover2.receiveCommands("B");
        assertEquals("(4,0,E)[OBSTACLE]", result);
    }

    @Test
    public void testObstaclesHorizontalBackward() {
        String result = rover2.receiveCommands("RBBBBB");
        assertEquals("(4,0,E)[OBSTACLE]", result);
    }

    @Test
    public void testObstaclesHorizontalBackwardAndRecoverForward() {
        String result = rover2.receiveCommands("RBBBBB");
        assertEquals("(4,0,E)[OBSTACLE]", result);
        result = rover2.receiveCommands("F");
        assertEquals("(5,0,E)[OK]", result);
    }

    @Test
    public void testObstaclesHorizontalBackwardAndRecoverTurning() {
        String result = rover2.receiveCommands("RBBBBB");
        assertEquals("(4,0,E)[OBSTACLE]", result);
        result = rover2.receiveCommands("LF");
        assertEquals("(4,1,N)[OK]", result);
    }

    @Test
    public void testCantMove(){
        String result = rover3.receiveCommands("F");
        assertEquals("(1,1,N)[OBSTACLE]", result);
        result = rover3.receiveCommands("B");
        assertEquals("(1,1,N)[OBSTACLE]", result);
        result = rover3.receiveCommands("RF");
        assertEquals("(1,1,E)[OBSTACLE]", result);
        result = rover3.receiveCommands("B");
        assertEquals("(1,1,E)[OBSTACLE]", result);
        result = rover3.receiveCommands("RRF");
        assertEquals("(1,1,W)[OBSTACLE]", result);
        result = rover3.receiveCommands("B");
        assertEquals("(1,1,W)[OBSTACLE]", result);
    }
}
