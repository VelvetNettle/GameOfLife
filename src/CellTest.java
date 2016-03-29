import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Tatka on 16.03.2016.
 */
public class CellTest extends org.junit.Assert {
    @Test
    public void getPosition_SomePosition_ReturnedSamePosition() {

        // Arrange
        Cell cell = new Cell(new Coord(2, 3));
        Coord expected = new Coord(2, 3);

        // Act
        Coord actual = cell.getPosition();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void kill_CellAlive_ReturnCellDead() {

        // Arrange
        Coord tempcoord = new Coord(2, 5);
        Cell temp = new Cell(tempcoord, true);
        boolean expected = false;


        // Act
        temp.kill();
        boolean actual = temp.getIsAlive();

        // Assert
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void makeAlive_CellDead_ReturnCellAlive() {

        // Arrange
        Coord tempcoord = new Coord(2, 5);
        Cell temp = new Cell(tempcoord);
        boolean expected = true;


        // Act
        temp.makeAlive();
        boolean actual = temp.getIsAlive();

        // Assert
        Assert.assertEquals(expected, actual);

    }

}