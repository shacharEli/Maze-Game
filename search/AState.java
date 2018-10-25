package algorithms.search;

/**
 * AState represent a specific state in searchable problem.
 * AState are immutable.
 */
public abstract class AState implements Comparable{

    //Data-members:
    /**
     * Represent state as String.
     */
    private String state;
    /**
     * Store previous state reference.
     */
    private AState previous;
    /**
     * The cost to reach that state.
     */
    private int cost;

    //Constructors:
    /**
     * Constructs and initialize state.
     * @param state Actual state.
     * @param prev Previous state.
     * @param cost Cost for this state, can be also negative and positive value.
     */
    AState(String state,AState prev,int cost) {
        this.state=state;
        this.previous=prev;
        this.cost=cost;
    }

    //Getters:
    /**
     * @return Returning the state that lead to this state.
     */
    AState getPrevious() {
        return this.previous;
    }

    /**
     * @return Returning actual state reference.
     */
    String getState() {
        return state;
    }


    /**
     * @return Returning the cost of this state.
     */
    int getCost(){ return this.cost;}



    //===Overrides methods:===

    //ToString:
    /**
     * Override toString method from Object.
     * @return Actual state represented by String.
     */
    @Override
    public String toString() {
        return this.state;
    }

    //CompareTo by (implemented on cost).
    /**
     * Implement compareTo method from comparable interface, compare between two AState objects.
     * Compare made by cost.
     * When the other object is null return positive MAX_VALUE.
     * @see Integer#MAX_VALUE
     * @param o State to be compared to this state.
     * @return The result of subtraction of the other state cost from this state cost.
     */
    @Override
    public int compareTo(Object o) {
        if (o==null) return Integer.MAX_VALUE;
        return cost-((AState)o).getCost();
    }

    //HashCode & Equals:
    /**
     * Calculate hashcode for state by using state and previous data members only,
     * cost not account.
     * @return hashcode for specific state.
     */
    @Override
    public int hashCode() {
        int result = state.hashCode();
        result = 31 * result + (previous != null ? previous.hashCode() : 0);
        return result;
    }

    /**
     * Indicates whether some other AState is "equal to" this one.
     * Compare made by state and previous state only, cost not account.
     * @param o AState to be compare.
     * @return Whether other AState is "equal to" this AState.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AState)) return false;
        AState aState = (AState) o;
        return (state.equals(aState.state)) && (previous != null ? previous.equals(aState.previous) : aState.previous == null);
                    //if != null the equals prev test else test the other for null.
                    //TERNARY OPERATOR.
    }
}