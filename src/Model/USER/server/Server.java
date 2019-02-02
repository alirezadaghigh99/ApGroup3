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
    private int port1;
    private int port2;
    private ArrayList<Integer> ports = new ArrayList<Integer>();


    private ServerSocket serverSocket1;
    private ServerSocket serverSocket2;
    private Socket clientSocket1;
    private ObjectOutputStream outputStream1;
    private ObjectInputStream inputStream1;

    private Server(int port1) {
        this.port1 = port1;
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
        serverSocket1 = new ServerSocket(port1);
    }

    private void waitForClient() throws IOException {
        clientSocket1 = serverSocket1.accept();
    }

    private void initIOStreams() throws IOException {
        outputStream1 = new ObjectOutputStream(clientSocket1.getOutputStream());
        inputStream1 = new ObjectInputStream(clientSocket1.getInputStream());
    }

    private void startThreads() {
        new Thread(new GetDataRunnable(inputStream1, this)).start();
    }

    public void sendData(String text, String from) {

    }

    @Override
    public void receive(Message message){

    }
}
