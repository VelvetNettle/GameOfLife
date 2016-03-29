import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Tatka on 16.03.2016.
 */
public class CoordTest {
    @Test
    public void hashCode_EqualObjects_SameHashCode() {
        Coord temp1 = new Coord(2, 4);
        Coord temp2 = new Coord(2, 4);


        Assert.assertEquals(temp1.hashCode(), temp2.hashCode());

    }
    @Test
    public void hashCode_DifObjects_DifHashCode() {
        Coord temp1 = new Coord(2, 4);
        Coord temp2 = new Coord(2, 1);
        Assert.assertNotEquals(temp1.hashCode(), temp2.hashCode());
    }

}