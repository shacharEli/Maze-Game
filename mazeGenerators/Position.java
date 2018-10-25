package algorithms.mazeGenerators;


/**
 * andeling two coordinates x and y
 */
public class Position  {

    /**
     *  X cordinate
     */
    //Data-members:
    int x;


    /**
     * Y coordinate
     */
    int y;

    //constructor
    /**
     * constructs and initielize a point on position(x,y)
     * @param x  x coordinate
     * @param y   y coordinate
     *
     *
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    //Getters:


    /**
     * getter of a the x cordinate
     *
     * @return x cordinate of the point
     */
    public int getColumnIndex() {
        return x;
    }


    /**
     * getter of a the y cordinate
     *
     * @return y cordinate of the point
     */
    public int getRowIndex() {
        return y;
    }

    //toStaring

    /**
     * print the point
     * @return String of the point
     */
    @Override
    public String toString() {
        return "{"+x+","+y+"}";
    }

    /**
     * cheking if two object of kind position are equals
     * @param other another object
     * @return true if the object are equal and false aither
     */
    //equals
   @Override
    public boolean equals(Object other) {
        Position oposition= (Position)other;

        return (this.x==oposition.getColumnIndex()&& this.y==oposition.getRowIndex());
    }
}
