package Server;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
/**
 * Created by elias_000 on 20/05/2017.
 */
public interface IServerStrategy {

     void serverStrategy(InputStream inFromClient, OutputStream outToClient) throws IOException;
}
