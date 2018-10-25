package algorithms.search;

/**
 * ISearchingAlgorithm interface provide access to many searching algorithm on a graph.
 */
public interface ISearchingAlgorithm {
    /**
     * Find a possible solution based on the algorithm.
     * @param searchable Searchable problem to be solved.
     * @return Possible solution path.
     */
    Solution solve(ISearchable searchable);

    /**
     * @return Number of the nodes are tested before find the solution.
     */
    int getNumberOfNodesEvaluated();

    /**
     * @return The name of the algorithm provided.
     */
    String getName();
}
