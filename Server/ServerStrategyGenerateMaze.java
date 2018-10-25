package Server;

import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by elias_000 on 20/05/2017.
 */
public class ServerStrategyGenerateMaze implements IServerStrategy {


    public ServerStrategyGenerateMaze() {
    }

    public void serverStrategy(InputStream inFromClient, OutputStream outToClient) throws IOException
    {
        int[] sizes=new int[2];
        sizes[0]=inFromClient.read();
        sizes[1]=inFromClient.read();
       IMazeGenerator generator=new MyMazeGenerator();
        Maze maze= generator.generate(sizes[0],sizes[1]);
        MyCompressorOutputStream compress=new MyCompressorOutputStream(outToClient);
        compress.write(maze.toByteArray());

    }



}
