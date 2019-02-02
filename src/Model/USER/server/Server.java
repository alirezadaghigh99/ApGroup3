package Model.USER.server;

import Model.USER.client.Client;
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
    private ArrayList<Socket> clientSocket;
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<ObjectOutputStream> outputStream;
    private ArrayList<ObjectInputStream> inputStream;
    private int counter = 0;

    private Server(int port) {
        this.port = port;
    }

    public static Server getInstance() {
        return instance;
    }

    public void start() {
        try {
            setup();
            waitForClient();
            startThreads();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void setup() throws IOException {
        serverSocket = new ServerSocket(port);
    }

    private void waitForClient() throws IOException {
        new Wait(serverSocket,clientSocket,outputStream,inputStream).start();
    }

//    private void initIOStreams() throws IOException {
//        outputStream.add()new ObjectOutputStream(clientSocket[counter].getOutputStream());
//        inputStream = new ObjectInputStream(clientSocket[counter].getInputStream());
//    }

    private void startThreads() {
        new Thread(new GetDataRunnable(inputStream, this)).start();
    }

//    public void sendData(String text, String from) {
//        Message message = new Message(text, from);
//        try {
//            outputStream.writeObject(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    @Override
    public void receive(Message message) {

    }

    public ArrayList<Client> getClients() {
        return clients;
    }

}
