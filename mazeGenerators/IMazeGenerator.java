package algorithms.mazeGenerators;

/**
 * interface for maze generation
 */
public interface IMazeGenerator {

    /** generate a new maze
     * @param num_columns number of column in the maze
     * @param num_rows number of rows in the maze
     * @return maze with num_columns columns and num_rows rows
     */
    Maze generate(int num_columns, int num_rows);

    /** measuring the time it takes to creat new maze
     * @param num_colums number of columns in the maze
     * @param num_rows number of rows in the maze
     * @return the time it took to creat the maze in mily seconds
     */
    long measureAlgorithmTimeMillis(int num_colums, int num_rows);
}
