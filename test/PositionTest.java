package test;

import algorithms.mazeGenerators.Position;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by elias_000 on 28/04/2017.
 */
public class PositionTest {

    public void testStartOnEquals() throws Exception{
        int j=0;
        for(int i=0;i<1000; i++ )
        {
            j++;
            Position p=new Position(i,j);
            Position p2=new Position(i,j);
            assertTrue(p.equals((Object)p2));
        }
        j=-1;
        for(int i=0;i<1000; i++ )
        {
            Position p=new Position(i,i);
            Position p2=new Position(j,j);
            assertFalse(p.equals((Object)p2));
        }

    }

}