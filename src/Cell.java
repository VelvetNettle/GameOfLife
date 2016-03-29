import java.util.ArrayList;

/**
 * Created by Tatka on 16.03.2016.
 * Class describes game unit
 */

public class Cell {
    private final Coord position;
    private ArrayList<Cell> neighbors;
    private boolean isAlive;

    /**Initializes new instance of class Cell
     * Creates dead cell
     * @param coord  cell position
     */
    public Cell(Coord coord) {
        this(coord, false);
    }

    /**Initializes new instance of class Cell
     * Creates cell
     * @param coord cell position
     * @param isAlive cell state
     */
    public Cell(Coord coord, boolean isAlive) {
        this.position = coord;
        this.isAlive = isAlive;
    }

    /** Returns cell position
     * @return object of cell position
     */
    public Coord getPosition() {
        return position;
    }

    /** Returns neighbors of current cell
     * @return array of neighbors
     */
    public ArrayList<Cell> getNeighbors() {
        return neighbors;
    }

    /**Returns state (alive or dead) of current cell
     * @return true/false that cell is alive
     */
    public boolean getIsAlive() {
        return this.isAlive;
    }

    /**Makes current cell dead
     */
    public void kill() {
        this.isAlive = false;
    }

    /**Makes current cell alive
    */
    public void makeAlive() {
        this.isAlive = true;
    }

    /**Sets neighbors for current cell
     * @param neighbors array of neighbors
     */
    public void setNeighbors(ArrayList<Cell> neighbors) {
        this.neighbors = neighbors;
    }
}
