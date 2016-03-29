/**
 * Created by Tatka on 16.03.2016.
 * Class describes game unit position
 */
public class Coord {

    private int x;
    private int y;


    /**Initializes new instance of class Coord
     * Creates unit position
     * @param x  the first axe of position
     * @param y  the second axe of position
     */
   public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /** Returns the first axe of position
     * @return X
     */
    public int getX() {
        return x;
    }

    /** Returns the second axe of position
     * @return Y
     */
    public int getY() {
        return y;
    }

    /**Method always returns the same hashCode for objects, which have the same positions
     * @return object hashCode
     */
    @Override
    public int hashCode() {
        return this.x * 1000 + this.y;
    }

    /** Method always returns true if objects have the same positions and returns false in opposite situation
     * @param obj - object with which method has to compare current object
     * @return true/false that the objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Coord)) {
            return false;
        }

        Coord tempObj = (Coord) obj;
        if (this.x == tempObj.x && this.y == tempObj.y) {
            return true;
        } else {
            return false;
        }
    }

   }
