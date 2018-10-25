package algorithms.mazeGenerators;


import java.util.LinkedList;
import java.util.Random;


/**
 * initilize a maze using prime algorithm
 */
public class MyMazeGenerator extends AMazeGenerator {

    /**
     * constructs My maze generator
     */
    //conatractor
    public MyMazeGenerator() {}

    /** generate new maze
     * @param num_columns the number of the columns in the maze
     * @param num_rows    the number of rows in the maze
     * @return a maze initilize with one ( represen walls) and zeros(represent passes)
     */
    //generate
    public Maze generate(int num_columns, int num_rows) {
        if(num_columns<10)
        {
            num_columns=10;
        }
        if(num_rows<10)
        {
            num_rows=10;
        }
        Maze maze = new Maze(num_columns,num_rows);
        LinkedList<Position> inCells = new LinkedList<Position>();
        LinkedList<Position> outCells = new LinkedList<Position>();
        LinkedList<Position> wallCells = new LinkedList<Position>();
        SetStartPoint(maze);

        for (int i = 0; i < num_columns; i++)
            for (int j = 0; j < num_rows; j++) {

                if (i == maze.getStartPosition().getColumnIndex() && j == maze.getStartPosition().getRowIndex()) {
                    Position temp = new Position(i, j);
                    inCells.addLast(temp);
                    maze.SetCell( temp.getColumnIndex(),temp.getRowIndex(), 0);
                } else {
                    Position temp = new Position(i, j);
                    maze.SetCell(temp.getColumnIndex(),  temp.getRowIndex(), 1);
                    outCells.addLast(temp);
                }

            }

        int index;
        Position temp = new Position(maze.getStartPosition().getColumnIndex(), maze.getStartPosition().getRowIndex());
        Position walls;
        int x;
        int y;
        int first=1;
        Random rand = new Random();
        while (!wallCells.isEmpty()||first==1) {
            first = 0;

            x = temp.getColumnIndex() - 1;
            y = temp.getRowIndex();
            walls = new Position(x, y);
            //checking this cell is out
            if (!(outCells.indexOf(walls) == -1) && legal(walls, maze)) {
                wallCells.addLast(walls);
                outCells.remove(walls);


            }
            x = temp.getColumnIndex() + 1;
            y = temp.getRowIndex();
            walls = new Position(x, y);
            //checking this cell is out
            if (!(outCells.indexOf(walls) == -1) && legal(walls, maze)) {
                wallCells.addLast(walls);
                outCells.remove(walls);

            }
            x = temp.getColumnIndex();
            y = temp.getRowIndex() + 1;
            walls = new Position(x, y);

            //checking this cell is out
            if (!(outCells.indexOf(walls) == -1) && legal(walls, maze)) {
                wallCells.addLast(walls);
                outCells.remove(walls);
            }
            x = temp.getColumnIndex();
            y = temp.getRowIndex() - 1;
            walls = new Position(x, y);
            //checking this cell is out
            if (!(outCells.indexOf(walls) == -1) && legal(walls, maze)) {
                wallCells.addLast(walls);
                outCells.remove(walls);

            }
            // picking a random cell from the wall list
            if (wallCells.size() > 0) {
                wallCells = updateNeighbors(wallCells, maze);
                if (!wallCells.isEmpty()) {
                    index = rand.nextInt(wallCells.size());
                    temp = new Position(wallCells.get(index).getColumnIndex(), wallCells.get(index).getRowIndex());
                    wallCells.remove(temp);
                    inCells.addLast(temp);
                    maze.SetCell(temp.getColumnIndex(), temp.getRowIndex(), 0);
                }



            }
        }

        SetEndPoint(maze);
        return maze;
    }

    /** additional function for generate that ceking if a cell is legal for evaluated
     * @param p
     * @param maze
     * @return true if the cell is leagal or false aither
     */
    private boolean legal(Position p, Maze maze) {

        int x =p.getColumnIndex();
        int y = p.getRowIndex();
        int neighbors = 0;
        // checking the cell in the maze
        if (x > 0 && x < maze.getColumn() - 1) {
            if (y > 0 && y < maze.getRow() - 1) {
                if (maze.getCellValue(x + 1, y) == 0)
                    neighbors++;
                if (maze.getCellValue(x - 1,  y) == 0)
                    neighbors++;
                if (maze.getCellValue(x, y + 1) == 0)
                    neighbors++;
                if (maze.getCellValue(x, y - 1) == 0)
                    neighbors++;

            } else {
                if (y == 0) {
                    if (maze.getCellValue(x + 1, y) == 0)
                        neighbors++;
                    if (maze.getCellValue(x - 1, y) == 0)
                        neighbors++;
                    if (maze.getCellValue(x, y + 1) == 0)
                        neighbors++;


                }
                if (y == maze.getRow() - 1) {
                    if (maze.getCellValue(x + 1, y) == 0)
                        neighbors++;
                    if (maze.getCellValue(x - 1,y) == 0)
                        neighbors++;
                    if (maze.getCellValue(x, y - 1) == 0)
                        neighbors++;

                }
            }
        } else {
            if (x == 0) {
                if (y == 0) {
                    if (maze.getCellValue(x + 1,  y) == 0)
                        neighbors++;
                    if (maze.getCellValue(x, y + 1) == 0)
                        neighbors++;

                }
                if (y == maze.getRow() - 1) {
                    if (maze.getCellValue(x + 1, y) == 0)
                        neighbors++;
                    if (maze.getCellValue(x, y - 1) == 0)
                        neighbors++;
                    if (neighbors == 0)
                        return true;

                }
                if (y != 0 && y != maze.getRow() - 1) {
                    if (maze.getCellValue(x + 1, y) == 0)
                        neighbors++;
                    if (maze.getCellValue(x, y - 1) == 0)
                        neighbors++;
                    if (maze.getCellValue(x, y + 1) == 0)
                        neighbors++;

                }
            } else {
                if (x == maze.getColumn() - 1) {
                    if (y == 0) {
                        if (maze.getCellValue(x - 1,  y) == 0)
                            neighbors++;
                        if (maze.getCellValue(x, y + 1) == 0)
                            neighbors++;

                    }
                    if (y == maze.getRow() - 1) {
                        if (maze.getCellValue(x - 1,  y) == 0)
                            neighbors++;
                        if (maze.getCellValue(x, y - 1) == 0)
                            neighbors++;

                    }
                    if (y != 0 && y != maze.getRow() - 1) {
                        if (maze.getCellValue(x - 1, y) == 0)
                            neighbors++;
                        if (maze.getCellValue(x, y - 1) ==0)
                            neighbors++;
                        if (maze.getCellValue(x, y + 1) == 0)
                            neighbors++;

                    }
                }
            }
        }

        if (neighbors == 1)
            return true;
        return false;
    }

    /**additional function for generate that updating a cell neighbors list acording to the legalisem setuation
     * @param neighbors
     * @param maze
     * @return
     */
    private LinkedList<Position> updateNeighbors(LinkedList<Position>neighbors, Maze maze) {

    Position current;
   for(int i=0;i<neighbors.size();i++) {
       current=neighbors.get(i);
        if (!legal(current, maze))
            neighbors.remove(current);

    }

    return neighbors;
}

}
