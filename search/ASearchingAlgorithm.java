package algorithms.search;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * This class provide skeletal concrete code that used at most searching algorithm.
 * @param <T> The types of element will implement hashCode and equals as criteria
 *           for test if visited already.
 */
public abstract class ASearchingAlgorithm<T> implements ISearchingAlgorithm {

    //Data Members:
    /**
     * Hold information about what nodes are already tested in the algorithm.
     */
    HashSet<T> visited = new HashSet<>();
    /**
     * Represent the number of nodes tested before reaching the goal node.
     */
    private int evaluated;

    /**
     * Construct this class and initialize evaluated nodes with zero.
     */
    //Constructors:
    ASearchingAlgorithm() {
        evaluated=0;
    }

    //Getters:
    /**
     * Get evaluate nodes.
     * @return Number of evaluated not before reaching goal state.
     */
    public int getNumberOfNodesEvaluated() {
        return this.evaluated;
    }

    //General:

    /**
     * Increment evaluated by one.
     */
    void incEvaluated(){
        this.evaluated++;
    }

    /**
     * Create the Trace that lead to the goal node from the starting node.
     * Null argument return empty list.
     * @param state Goal node of the solution for calculating path.
     * @return Trace route from start to the goal node.
     */
    ArrayList<AState> backTrace(AState state) {
        ArrayList<AState> solution=new ArrayList<>();
        while(state!=null) {
            solution.add(state);
            state=state.getPrevious();
        }
        Collections.reverse(solution);
        return solution;
    }

    /**
     * @return The name of the provided algorithm.
     */
    public abstract String getName();

    /**
     * Reset visited list.
     */
    public void clear(){
        this.visited=null;
    }

    public void resetEvaluated(){
        this.evaluated=0;
    }

}
