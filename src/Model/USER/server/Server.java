package Model.USER.server;

import Model.USER.network_models.Message;
import Model.USER.threads.GetDataRunnable;
import Model.USER.threads.MessageListener;
import Model.Utils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements MessageListener {
    private static Server instance = new Server(Utils.SERVER_PORT);
    private int port;



    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    private Server(int port) {
        this.port = port;
    }

    public static Server getInstance() {
        return instance;
    }

    public void start(){
        try {
            setup();
            waitForClient();
            initIOStreams();
            startThreads();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void setup() throws IOException {
        serverSocket = new ServerSocket(port);
    }

    private void waitForClient() throws IOException {
        clientSocket = serverSocket.accept();
    }

    private void initIOStreams() throws IOException {
        outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        inputStream = new ObjectInputStream(clientSocket.getInputStream());
    }

    private void startThreads() {
        new Thread(new GetDataRunnable(inputStream, this)).start();
    }

    public void sendData(String text, String from) {

    }

    @Override
    public void receive(Message message){

    }
}
