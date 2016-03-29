/**
 * Created by Tatka on 17.03.2016.
 * interface defines providers of cell states
 */
public interface ICellStateProvider {

    /**Returns cell state by general cell index
     * @param y general cell index
     * @return cell state
     */
    Boolean getCellState(int y);
}
