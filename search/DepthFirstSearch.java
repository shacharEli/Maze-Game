package algorithms.search;

import java.util.HashSet;
import java.util.Stack;

/**
 * DFS algorithm for searchable problem, finding random Solution path from the initial state to goal state,
 * no guarantee for shortest path.
 * Null searchable lead to empty solution. with zero evaluated.
 * Unsolved searchable lead to empty solution with actual evaluated.
 */
public class DepthFirstSearch extends ASearchingAlgorithm<String> {

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
        Stack<AState> stack = new Stack<>();
        super.resetEvaluated();
        super.incEvaluated();
        stack.push(temp);
        visited.add(temp.toString());
        while (!stack.isEmpty()) {
            temp = stack.pop();
            if (searchable.isGoalState(temp)) {
                break;
            } else {
                for (AState node : searchable.getAllPossibleStates(temp)) {
                    if (!super.visited.contains(node.toString())) {
                        visited.add(node.toString());
                        super.incEvaluated();
                        stack.push(node);
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
        return "Depth First Search";
    }
}