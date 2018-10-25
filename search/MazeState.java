package algorithms.search;

/**
 * MazeState represent state on searchable maze problem.
 * MazeState are immutable.
 */
 class MazeState extends AState {

    //Constructors:
    /**
     * Construct state.
     * @param x - X Coordinate of the state.
     * @param y - Y Coordinate of the state.
     * @param prev Previous state of this state, can be null.
     * @param cost Cost for this state as a target.
     */
    MazeState(int x,int y,AState prev,int cost){
        super(x+","+y,prev,cost);
    }
}
