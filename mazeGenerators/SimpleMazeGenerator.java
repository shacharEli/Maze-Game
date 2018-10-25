package algorithms.mazeGenerators;
import java.util.Random;

/**
 * creat maze with walls spread ramdomly
 */
public class SimpleMazeGenerator extends AMazeGenerator {

    /**
     *
     * constructs simple maze generator
     */
    //constractor
    public SimpleMazeGenerator() {
    }

    //generate

    /** generate new maze
     * @param num_columns the number of the columns in the maze
     * @param num_rows    the number of rows in the maze
     * @return a maze
     */
    public Maze generate (int num_columns, int num_rows) {
        if(num_columns<10)
        {
            num_columns=10;
        }
        if(num_rows<10)
        {
            num_rows=10;
        }
        Maze maze=new Maze(num_columns,num_rows);
        int[][] tempMaze=new int[num_columns][num_rows];
        InitializeMaze(maze);
        SetStartPoint(maze);

        Random rand_w=new Random();
        //put random walls in the maze
        for(int i=0;i<num_columns;i++)
        {
            for(int j=0;j<num_rows;j++) {
                int temp = rand_w.nextInt(4) + 1;
                switch (temp) {
                    case 1:
                        if (j + 1 < num_rows) {
                            tempMaze[i][j + 1] = 1;
                        }
                        break;
                    case 2:
                        if (i + 1 < num_columns) {
                            tempMaze[i + 1][j] = 1;
                        }
                        break;

                    case 3:
                        if (i - 1 > num_columns) {
                            tempMaze[i - 1][j] = 1;
                        }
                        break;
                    case 4:
                        if (j - 1 > num_rows) {
                            tempMaze[i][j - 1] = 1;
                        }
                        break;
                }
            }

        }
        SetEndPoint(maze);
        int column_start=maze.getStartPosition().getColumnIndex();
        int row_start=maze.getStartPosition().getRowIndex();
        int column_end=maze.getGoalPosition().getColumnIndex();
        int row_end=maze.getGoalPosition().getRowIndex();
        int currentX=column_end;
        int currentY=row_end;

        //make a path from the starting point to the end point
        tempMaze[column_start][row_start]=0;
        tempMaze[column_end][row_end]=0;

        currentX=column_end;
        currentY=row_end;
        while(currentX!=column_start)
        {
            if (currentX>column_start)
            {
                tempMaze[currentX-1][currentY]=0;
                currentX=currentX-1;
            }
            if(currentX<column_start)
            {
                tempMaze[currentX+1][currentY]=0;
                currentX=currentX+1;
            }
        }
        while(currentY!=row_start)
        {
            if (currentY>row_start)
            {
                tempMaze[currentX][currentY-1]=0;
                currentY=currentY-1;
            }
            if(currentY<row_start)
            {
                tempMaze[currentX][currentY+1]=0;
                currentY=currentY+1;
            }
        }


        maze.SetMaze(tempMaze,num_columns,num_rows);
       // maze.print();
       // System.out.println();
        return maze;
    }




}
