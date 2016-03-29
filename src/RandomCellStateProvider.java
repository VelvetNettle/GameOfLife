import java.util.Random;

/**
 * Created by Tatka on 17.03.2016.
 * Class provides random cell states
 */
public class RandomCellStateProvider implements ICellStateProvider {

    Random rand;

    /** Generates random state
    */
    public RandomCellStateProvider() {
        this.rand = new Random();
    }

    /** Returns random cell state by general cell index
     * @param y general cell index
     * @return cell state
     */
    @Override
    public Boolean getCellState(int y) {

        return rand.nextBoolean();
    }
}
