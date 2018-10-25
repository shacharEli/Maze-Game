package Server;

import IO.MyDecompressorInputStream;
import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.search.ISearchable;
import algorithms.search.Solution;
import algorithms.search.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ObjectOutputStream;

/**
 * Created by elias_000 on 20/05/2017.
 */
public class ServerStrategySolveSearchProblem implements IServerStrategy {

    public ServerStrategySolveSearchProblem() {
    }

    public void serverStrategy(InputStream inFromClient, OutputStream outToClient) throws IOException
    {
        MyDecompressorInputStream decompress=new MyDecompressorInputStream(inFromClient);

        byte[] byteMaze=new byte[(inFromClient.read()*255+inFromClient.read())*(inFromClient.read()*255+inFromClient.read())+12];
        decompress.read(byteMaze);
        Maze maze=new Maze(byteMaze);
        ISearchable searchableMaze=new SearchableMaze(maze);
        ISearchingAlgorithm searchingAlgorithm=new BestFirstSearch();
        Solution sol= searchingAlgorithm.solve(searchableMaze);
        ObjectOutputStream objectOutToClient = new ObjectOutputStream(outToClient);
        objectOutToClient.writeObject(sol);

    }
}
