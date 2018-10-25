package algorithms.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS algorithm for searchable problem, finding the shortest Solution from the initial state to goal state.
 * Null searchable lead to empty solution. with zero evaluated.
 * Unsolved searchable lead to empty solution with actual evaluated.
 */
public class BreadthFirstSearch extends ASearchingAlgorithm<String> {

    /**
     * Solve searchable problem.
     * Null searchable lead to empty solution. with zero evaluated.
     * Unsolved searchable lead to empty solution with actual evaluated.
     *
     * @param searchable Searchable problem to be solved.
     * @return List of the states are leads to the goal state.
     */
    public Solution solve(ISearchable searchable) {
        if (searchable == null) return new Solution(null, 0);
        if (super.visited==null) super.visited=new HashSet<>();
        AState temp = searchable.getInitialState();
        Queue<AState> queue = UpdateQueue();
        super.resetEvaluated();
        super.incEvaluated();
        queue.add(temp);
        visited.add(temp.toString());
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (searchable.isGoalState(temp)) {
                break;
            } else {
                for (AState state : searchable.getAllPossibleStates(temp)) {
                    if (!(super.visited.contains(state.toString()))) {
                        super.visited.add(state.toString());
                        super.incEvaluated();
                        queue.add(state);
                    }
                }
            }
        }
        super.clear();
        if (searchable.isGoalState(temp))
            return new Solution(super.backTrace(temp), super.getNumberOfNodesEvaluated());
        return new Solution(null, super.getNumberOfNodesEvaluated());
    }

    /**
     * @return The name of the algorithm.
     */
    public String getName() {
        return ("BreadthFirstSearch");
    }

    /**
     * @return List as queue for BFS algorithm usage.
     */
    protected Queue<AState> UpdateQueue() {
        return new LinkedList<>();
    }

}