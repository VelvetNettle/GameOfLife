import java.util.ArrayList;

/**
 * Created by Tatka on 17.03.2016.
 * Class GameManager controls agame process
 */
public class GameManager {
    private World world;

    /** Initializes new instance of class  GameManager
     * @return World Object
     */
    public World getWorld() {
        return world;
    }

    /** Initializes new instance of class  GameManager by parameters
     * @param stateProvider chose state provider
     * @param size chose size
     */
    public GameManager(ICellStateProvider stateProvider, int size) {
        this.world = new World(stateProvider);
        this.resetGame(size);
    }


    /**  Regenerate world for current game
     * @param size chose size
     */
    public void resetGame(int size) {
        this.world.generateWorld(size);
    }

    /** After every tick kills amd makes alive cells by rules:
     * 1)
     * 2)
     * 3)
     */
    public void processTick() {

        ArrayList<Cell> cellList = this.world.getCellList();
        int[] stateArray = new int[cellList.size()];
        for (int i = 0; i < cellList.size(); i++) {
            Cell cell = cellList.get(i);
            int countNeighbours = this.getAliveNeighbors(cell);

            if (countNeighbours > 3 || countNeighbours < 2) {
                stateArray[i] = 1;
            }
            if (countNeighbours == 3) {
                stateArray[i] = 2;
            }

        }
        for (int i = 0; i < stateArray.length; i++) {
            if (stateArray[i] == 1) {
                cellList.get(i).kill();
            }
            if (stateArray[i] == 2) {
                cellList.get(i).makeAlive();
            }

        }
    }

    /** Returns array of alive neighbors of current cell
     * @param cell current cell
     * @return array of alive neighbors
     */
    private int getAliveNeighbors(Cell cell) {
        int result = 0;
        for (Cell neighbor : cell.getNeighbors()) {
            if (neighbor.getIsAlive()) {
                result = result + 1;
            }

        }

        return result;
    }
}
