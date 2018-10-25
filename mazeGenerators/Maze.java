package algorithms.mazeGenerators;

/**
 * meneging a maze
 */
public class Maze {
    //Data-members:
    /**
     * two-dimensional array of one and zero that represent the maze
     */
    private int[][] maze;
    /**
     * number of columns in the maze
     */
    private int column;
    /**
     * number of rows in the maze
     */
    private int row;
    /**
     * the starting position of the maze
     */
    private Position start;
    /**
     * the goal position of the maze
     */
    private Position goal;

    //Constructor:


    /**constructs new maze with num_colums columns and num_rows rows
     * @param num_colums number of columns in the maze
     * @param num_rows number of rows in the maze
     */
    public Maze(int num_colums, int num_rows) {
        if (num_colums < 10) {
            num_colums = 10;
        }
        if (num_rows < 10) {
            num_rows = 10;
        }
        this.column = num_colums;
        this.row = num_rows;
        this.maze = new int[num_colums][num_rows];
    }

    //Setters:

    /** set the array of the maze with update array
     * @param update two deminsion array of one and zero
     * @param row number of rows of update
     * @param column the columns number of update
     */
    public void SetMaze(int[][] update, int column, int row) {
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                maze[i][j] = update[i][j];
            }
        }
    }

    /** set the starting point of the maze
     * @param x the x cordinate of the starting point
     * @param y the y cordinate of the starting point
     */
    public void setStart(int x, int y) {
        if (start == null)
            start = new Position(x, y);
        this.maze[x][y]=0;
    }

    /** set the goal point of the maze
     * @param x the x cordinate of the goal point
     * @param y the y cordinate of the goal point
     */
    public void setGoal(int x, int y) {
        if (goal == null)
            goal = new Position(x, y);
        maze[x][y] = 0;
    }

    /** set the value of cell in (x,y) position eith spacific value (zero or one)
     * @param x the x cordinate of the cell
     * @param y the y cordinate of the cell
     * @param value the value we want to set in the cell
     */
    public void SetCell(int x, int y, int value) {
        try {
            if (value == 0 || value == 1) {
                this.maze[x][y] = value;
            }
        }
        catch (IndexOutOfBoundsException out) {}
    }

    //Getters:

    /** return the number of rows of the maze
     * @return how much rows the maze have
     */
    public int getRow() {
        return this.row;
    }


    /** return the number of columns of the maze
     * @return how much columns the maze have
     */
    public int getColumn() {
        return this.column;
    }

    /** return the starting position
     * @return position(x,y) of the starting point
     */
    public Position getStartPosition() {
        return this.start;
    }

    /**return the goal position
     * @return position(x,y) of the goal point
     */
    public Position getGoalPosition() {
        return this.goal;
    }

    /** return the value ( zero,one) of cell in (x,y)
     * @param x the x cordinate of the cell
     * @param y the y cordinate of the cell
     * @return the value of (x,y) cell
     */
    public int getCellValue(int x, int y) {
        try {
            return this.maze[x][y];
        } catch (ArrayIndexOutOfBoundsException exp) {
            return -1;
        }
    }

    //Prints:

    /**
     * print the maze
     */
    public void print() {
        if (maze != null) {
            for (int i = 0; i < column; i++) {
                for (int j = 0; j < row; j++) {
                    if (j == 0)
                        System.out.print("|");
                    if (i == start.getColumnIndex() && j == start.getRowIndex())
                        System.out.print("S");
                    else if (i == goal.getColumnIndex() && j == goal.getRowIndex())
                        System.out.print("E");
                    else {
                        if (maze[i][j] == 1)
                            System.out.print("■");
                        if (maze[i][j] == 0)
                            System.out.print(" ");
                    }
                    if (j == row - 1)
                        System.out.print("|");
                }
                System.out.println();
            }
        }
    }


}



