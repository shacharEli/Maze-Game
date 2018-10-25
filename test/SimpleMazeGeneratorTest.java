
    package test;

import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.SimpleMazeGenerator;
import algorithms.search.BreadthFirstSearch;
import algorithms.search.SearchableMaze;
import algorithms.search.Solution;
import org.junit.Test;
import static org.junit.Assert.*;

    @SuppressWarnings("Duplicates") //  todo remove this supp

    public class SimpleMazeGeneratorTest {


        IMazeGenerator myMaze = new SimpleMazeGenerator();
        Maze maze;


        @Test
        public void testStartOnZero() throws Exception{
            for (int i = 0; i <= 1000; i++) {
                maze = myMaze.generate(10, 10);
                int startX, startY;
                startX = maze.getStartPosition().getColumnIndex();
                startY = maze.getStartPosition().getRowIndex();
                assertTrue(maze.getCellValue(startX, startY) == 0);
            }
        }

        @Test
        public void testGoalOnZero() throws Exception {
            for (int i = 0; i <= 1000; i++) {
                maze = myMaze.generate(10, 10);
                int goalX, goalY;
                goalX = maze.getGoalPosition().getColumnIndex();
                goalY = maze.getGoalPosition().getRowIndex();
                assertTrue(maze.getCellValue(goalX, goalY) == 0);
            }
        }

        @Test

        public void generateTest() throws Exception {
            for (int i = 0; i < 1000; i++) {
                IMazeGenerator simple=new SimpleMazeGenerator();
                Maze maze = simple.generate(10, 10);
                SearchableMaze searchableMaze = new SearchableMaze(maze);
                BreadthFirstSearch bfs = new BreadthFirstSearch();
                Solution sol = bfs.solve(searchableMaze);
                sol.toString();
                assertTrue(sol.getSolutionLength() > 1);


            }
        }


    }

