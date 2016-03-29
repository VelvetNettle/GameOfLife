import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Tatka on 16.03.2016.
 */
public class WorldTest {
    RandomCellStateProvider mrX;

    WorldTest() {
       this.mrX = new RandomCellStateProvider();
    }

    @Test
    public void generateWorld_SmallSize_SucssesSize() {
        //Arrange


        World target = new World(mrX);


        //Act
        target.generateWorld(10);

        //Assert
        int actual = target.getCellList().size();
        Assert.assertEquals(100, actual);
    }

    @Test
    public void generateWorld_SmallSize_SucssesGenerated() {
        //Arrange
        World target = new World(mrX);
        Coord[] expected = new Coord[4];
        expected[0] = new Coord(0, 0);
        expected[1] = new Coord(1, 0);
        expected[2] = new Coord(0, 1);
        expected[3] = new Coord(1, 1);


        //Act
        target.generateWorld(2);

        //Assert

        ArrayList<Cell> actualList = target.getCellList();
        Coord[] actual = new Coord[4];
        actual[0] = actualList.get(0).getPosition();
        actual[1] = actualList.get(1).getPosition();
        actual[2] = actualList.get(2).getPosition();
        actual[3] = actualList.get(3).getPosition();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void generateWorld_CenterCell_CorectedNeighbors() {
        //Arrange
        World target = new World(mrX);

        //Act
        target.generateWorld(10);

        //Assert

        Cell tempcell = target.getCellList().get(12);
        int actual = tempcell.getNeighbors().size();
        Assert.assertEquals(8, actual);
    }

    @Test
    public void generateWorld_CornerCell_CorectedNeighbors() {
        //Arrange
        World target = new World(mrX);

        //Act
        target.generateWorld(10);

        //Assert

        Cell tempcell = target.getCellList().get(29);
        int actual = tempcell.getNeighbors().size();
        Assert.assertEquals(5, actual);
    }
}