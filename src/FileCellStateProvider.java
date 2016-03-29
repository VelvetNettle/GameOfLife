import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Tatka on 17.03.2016.
 * Class provides cell states from file
 */
public class FileCellStateProvider implements ICellStateProvider {
    ArrayList<Boolean> startingStates;
    int size;


    /** Returns file size (sqrt count of cells) of the game world
     * @return file size of the game world
     */
    public int getSize() {
        return (int) Math.sqrt((double) this.startingStates.size());

    }

    /**Initializes new instance of class FileCellStateProvider
     * by file with established adress
     */
    public FileCellStateProvider() {
        Path wiki_path = Paths.get("e:/tatka/", "test.txt");

        try {
            List<String> lines = Files.readAllLines(wiki_path);
            this.startingStates = linesToArray(lines);
            //  System.out.println(states);

        } catch (IOException e) {
            System.out.println(e);
            return;
        }
    }

    /** Returns cell state by general cell index using file as provider
     * @param y general cell index
     * @return cell state
     */
    @Override
    public Boolean getCellState(int y) {
        return startingStates.get(y);

    }


    /** Interprets file lines like cell states
     * @param lines collection of file lines
     * @return array of cell states
     */
    private static ArrayList<Boolean> linesToArray(List<String> lines) {
        ArrayList<Boolean> result = new ArrayList<Boolean>();
        //result = null;
        // int i = 0;
        for (String line : lines
                ) {

            int size = line.length();
            char[] chars = line.toCharArray();

            for (int j = 0; j < size; j++) {
                Boolean currentSymbol = stringToBoolean(Character.toString(chars[j]));
                result.add(currentSymbol);
            }
        }

        return result;
    }

    /** Returns true if input argument is "1" and returns false in opposite situation
     * @param symbol one separate symbol from file
     * @return true/false if input argument is "1"
     */
    private static boolean stringToBoolean(String symbol) {
        if (symbol.equals("1")) {
            return true;
        } else
            return false;
    }


}
