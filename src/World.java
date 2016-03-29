import java.util.ArrayList;

/**
 * Created by Tatka on 16.03.2016.
 * Describes game world
 */
public class World {
    private ArrayList<Cell> cellList;
    private int size;
    private final ICellStateProvider cellStateProvider;

    /** Retusns world size(sqrt count of cells)
     * @return world size
     */
    public int getSize() {
        return size;
    }

    /**Return array of all game cells
     * @return array of cells
     */
    public ArrayList<Cell> getCellList() {
        return cellList;
    }

    /**Initializes new instance of class World
     * @param cellStateProvider one of cell state provider
     */
    public World(ICellStateProvider cellStateProvider) {

        this.cellStateProvider = cellStateProvider;
    }

    /**Set every cell its neighbors
      */
    private void fillNeighbors() {
        for (Cell currentcell : this.cellList) {
            currentcell.setNeighbors(this.getNeighborsCell(currentcell));
        }
    }

    /** Creates array of neighbors of current cell
     * @param cell current cell
     * @return array of neighbors of current cell
     */
    private ArrayList<Cell> getNeighborsCell(Cell cell) {
        ArrayList<Cell> result = new ArrayList<Cell>();
        Coord currentCoords = cell.getPosition();

        addNeighborToList(result, currentCoords.getX() - 1, currentCoords.getY() - 1);
        addNeighborToList(result, currentCoords.getX(), currentCoords.getY() - 1);
        addNeighborToList(result, currentCoords.getX() + 1, currentCoords.getY() - 1);
        addNeighborToList(result, currentCoords.getX() + 1, currentCoords.getY());
        addNeighborToList(result, currentCoords.getX() + 1, currentCoords.getY() + 1);
        addNeighborToList(result, currentCoords.getX(), currentCoords.getY() + 1);
        addNeighborToList(result, currentCoords.getX() - 1, currentCoords.getY() + 1);
        addNeighborToList(result, currentCoords.getX() - 1, currentCoords.getY());

        return result;
    }

    /** Adds cells by their positions to cell array
     * @param result cell array
     * @param x the first axe of position
     * @param y the second axe of position
     */
    private void addNeighborToList(ArrayList<Cell> result, int x, int y) {
        Cell neighbor = this.getCellByCoord(x, y);
        if (neighbor != null) {
            result.add(neighbor);
        }
    }

    /** Returns cell by its position
     * @param x the first axe of position
     * @param y the second axe of position
     * @return cell
     */
    private Cell getCellByCoord(int x, int y) {
        Cell result = null;
        for (Cell cell : this.cellList) {
            Coord currentCoord = cell.getPosition();
            if (currentCoord.getX() == x && currentCoord.getY() == y) {
                result = cell;
                break;
            }
        }
        return result;
    }

    /** Creates new World by some size
     * @param size  some size
     */
    public void generateWorld(int size) {

        this.cellList = new ArrayList<Cell>();
        int y = 0;

        for (int j = 0; j < size; j++) {

            for (int i = 0; i < size; i++) {
                Cell cell = new Cell(new Coord(i, j), this.cellStateProvider.getCellState(y));
                this.cellList.add(cell);
                y++;
            }
        }

        this.fillNeighbors();
    }


 }
