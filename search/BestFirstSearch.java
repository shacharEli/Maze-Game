package algorithms.search;

import java.util.Queue;
import java.util.PriorityQueue;

/**
 * BestFS algorithm for searchable problem, finding the shortest Solution from the initial state to goal state.
 * The same as BFS algorithm except that this algorithm use Priority-queue as its main queue (open) for calculation.
 * Null searchable lead to empty solution. with zero evaluated.
 * Unsolved searchable lead to empty solution with actual evaluated.
 */
public class BestFirstSearch extends BreadthFirstSearch {

    /**
     * @return Priority-queue for algorithm usage.
     */
    @Override
    protected Queue<AState> UpdateQueue() {
        return new PriorityQueue<>();
    }

    /**
     * @return The name of the algorithm.
     */
    public String getName(){
        return "Best First Search";
    }
}