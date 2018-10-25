package algorithms.search;
import algorithms.mazeGenerators.Maze;
import java.util.ArrayList;

/**
 * Maze that can be solved.
 */
public class SearchableMaze implements ISearchable {

    //Fieds:
    /**
     * Maze for being search.
     */
    private Maze maze;

    /**
     * Initial state of the maze.
     */
    private AState initialState;

    /**
     * Goal state of the maze.
     */
    private AState goalState;

    //Constructors:

    /**
     * Construct and initialize SearchableMaze with specific maze, update initial state and goal state.
     * @param maze Maze for being searchable.
     */
    public SearchableMaze(Maze maze){
        if (maze!=null) {
            this.maze = maze;
            this.initialState = new MazeState(maze.getStartPosition().getColumnIndex(), maze.getStartPosition().getRowIndex(), null, 0);
            this.goalState = new MazeState(maze.getGoalPosition().getColumnIndex(), maze.getGoalPosition().getRowIndex(), null, 0);
        }
    }

    //Getters:

    /**
     * @return Starting state of the problem.
     */
    public AState getInitialState() {
        return initialState;
    }

    /**
     * @return Goal state of the problem.
     */
    public AState getGoalState() {
        return this.goalState;
    }

    /**
     * Calculate all states are available from specific state.
     * Null AState or bad maze may return empty list.
     * @param state Specific state for calculation.
     * @return List of all possible states from specific state.
     */
    public ArrayList<AState> getAllPossibleStates(AState state) {
        if (state == null || this.maze==null) return new ArrayList<>();
        int x =Integer.parseInt(state.getState().split(",")[0]);
        int y=Integer.parseInt(state.getState().split(",")[1]);
        ArrayList<AState> possibleStates=new ArrayList<>();

        if (maze.getCellValue(x-1,y)==0){
            possibleStates.add(new MazeState(x-1,y,state,state.getCost()+1));
        }
        if (maze.getCellValue(x,y+1)==0){
            possibleStates.add(new MazeState(x,y+1,state,state.getCost()+1));
        }
        if (maze.getCellValue(x+1,y)==0){
            possibleStates.add(new MazeState(x+1,y,state,state.getCost()+1));
        }
        if (maze.getCellValue(x,y-1)==0){
            possibleStates.add(new MazeState(x,y-1,state,state.getCost()+1));
        }
        return possibleStates;
    }

    //General:

    /**
     * Tell if specific state is goal or not.
     * Null argument return false.
     * @param state Check if that state is goal state.
     * @return Either that state is goal state or not.
     */
    public Boolean isGoalState(AState state) {
        if (state==null ||this.maze ==null) return false;
        int x =Integer.parseInt(state.getState().split(",")[0]);
        int y=Integer.parseInt(state.getState().split(",")[1]);
        return ((x==this.maze.getGoalPosition().getColumnIndex())&&(y==this.maze.getGoalPosition().getRowIndex()));
    }

    /**
     * Print maze.
     */
    public void print(){
        if (this.maze!=null){
            this.maze.print();
        }
    }
}
