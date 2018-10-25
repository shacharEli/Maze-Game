package algorithms.search;

import java.util.ArrayList;

/**
 * ISearchable provide many searchable problems can be represented as graph of states.
 */
public interface ISearchable {
    /**
     * @return Initial state of the problem.
     */
    AState getInitialState();

    /**
     * @return Goal state of the problem.
     */
    AState getGoalState();

    /**
     * @param state Specific state for calculation.
     * @return All possible states from specific state.
     */
    ArrayList<AState> getAllPossibleStates(AState state);

    /**
     * @param state Test if that state is goal state.
     * @return Either this state is goal state or not
     */
    Boolean isGoalState(AState state);
}
