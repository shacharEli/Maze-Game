package algorithms.mazeGenerators;

import java.util.Random;

/**
 * an abstarct class of maze jeneration classes
 */
public abstract class AMazeGenerator implements IMazeGenerator {


    /**
     * generate a maze
     * @param num_columns the number of the columns in the maze
     * @param num_rows the number of rows in the maze
     * @return maze
     */
    // abstract generate
    public abstract Maze generate(int num_columns, int num_rows);

    /**
     * measuring the time it takes to create maze
     * @param num_columns number of columns in the maze
     * @param num_rows number of rows in the maze
     * @return the time it took to create the maze in milu seconds
     */
    //measure the time of the algorithm maze generation
    public long measureAlgorithmTimeMillis(int num_columns,int num_rows) {
        long start=System.currentTimeMillis();
        generate(num_columns,num_rows);
        long end=System.currentTimeMillis();
        return (end-start);
    }

    /**
     * initilize a maze cells with zeros
     * @param maze a maze
     */
    // Initilize a new maze to zero
    void InitializeMaze(Maze maze) {
        if(maze!=null) {
            int x = maze.getColumn();
            int y = maze.getRow();
            int[][] array = new int[x][y];
            for (int i = 0; i < x; i++)
                for (int j = 0; j < y; j++)
                  //  array[i][j] = 0;
                    array[i][j] = 0;
            maze.SetMaze(array, x, y);
        }
    }

    //Setters

    /** set a random starting point to the maze
     * @param maze a maze
     */
    protected void SetStartPoint(Maze maze) {
        int num_columns=maze.getColumn();
        int num_rows=maze.getRow();
        int column_start=0;
        Random rand_R=new Random();
        int row_start=rand_R.nextInt(num_rows-1);
        maze.setStart(column_start, row_start);
    }

    /** set a random goal point to the maze
     * @param maze a maze
     */
    protected void SetEndPoint(Maze maze) {
        int num_columns=maze.getColumn();
        int num_rows=maze.getRow();
        Random rand = new Random();
        int row_end = rand.nextInt(num_rows-1);
       int column_end = num_columns-1;
        maze.setGoal(column_end, row_end);
    }




}
