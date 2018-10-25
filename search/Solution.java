package algorithms.search;

import java.util.ArrayList;

/**
 * Solution may represent an possible solution as path of states for searching problem.
 */
public class Solution {

    //Fields:
    /**
     *List of the states of the solution.
     */
    private ArrayList<AState> solutionPath;
    /**
     * solutionLength - The number of states of the solution.
     * numberOfNodesEvaluated - The number of node are tested in finding this solution process.
     */
    private int solutionLength,numberOfNodesEvaluated;

    //Constructors:
    /**
     * @param solution List of calculated path of states null solution mean that solution length is zero.
     * @param numberOfNodesEvaluated the number of states are tested before reaching the goal state.
     */
    public Solution(ArrayList<AState> solution, int numberOfNodesEvaluated) {
        if (solution != null) {
            this.solutionPath = solution;
            this.solutionLength = solution.size();
            this.numberOfNodesEvaluated = numberOfNodesEvaluated;
        }else{
            this.solutionPath=new ArrayList<>();
            this.numberOfNodesEvaluated=numberOfNodesEvaluated;
            this.solutionLength=0;
        }
    }

    /**
     * @return List of the states that lead to the goal state.
     */
    public ArrayList<AState> getSolutionPath() {
        return solutionPath;
    }

    /**
     * @return number of states are in the solution list.
     */
    public int getSolutionLength() {
        return solutionLength;
    }

    /**
     * @return Number of the states are tested before reaching that goal state of the solution.
     */
    public int getNumberOfNodesEvaluated() {
        return numberOfNodesEvaluated;
    }
}
