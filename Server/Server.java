package Server;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by Aviadjo on 3/2/2017.
 */
public class Server {
    private int port;
    private int listeningInterval;
    private IServerStrategy serverStrategy;
    private volatile boolean stop;
  //  private static final Logger logger = LogManager.getLogger(Server.class); //Log4j

    public Server(int port, int listeningInterval, IServerStrategy clietHandler) {
        this.port = port;
        this.listeningInterval = listeningInterval;
        this.serverStrategy = clietHandler;
    }

    public void start() {
        new Thread(() -> {
            runServer();
        }).start();
    }

    private void runServer() {
        try {
            ServerSocket server = new ServerSocket(port);
            server.setSoTimeout(listeningInterval);
            while (!stop) {
                try {
                    Socket aClient = server.accept(); // blocking call
                    new Thread(() -> {
                        handleClient(aClient);
                    }).start();
                } catch (SocketTimeoutException e) {
                   // logger.debug("SocketTimeout!");
                }
            }
            server.close();
        } catch (IOException e) {
           // logger.error("IOException", e);
        }
    }

    private void handleClient(Socket aClient) {
        try {
           // logger.debug("Client excepted!");
            //logger.debug(String.format("Handling client with socket: %s", aClient.toString()));
            serverStrategy.ServerStrategy(aClient.getInputStream(), aClient.getOutputStream());
            aClient.getInputStream().close();
            aClient.getOutputStream().close();
            aClient.close();
        } catch (IOException e) {
            //logger.error("IOException", e);
        }
    }

    public void stop() {
        System.out.println("Stopping server..");
        stop = true;
    }
}
