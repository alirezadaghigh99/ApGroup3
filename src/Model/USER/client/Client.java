package Model.USER.client;

import Model.USER.network_models.Message;
import Model.USER.threads.GetDataRunnable;
import Model.USER.threads.MessageListener;
import Model.Utils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client implements MessageListener {
    private Socket clientSocket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private String userName;
    private String nickName;

    public Client(String userName, String nickName) {
        this.userName = userName;
        this.nickName = nickName;
    }

    public void start() {
        try {
            connect2Server();
            initIOStreams();
            startThreads();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void connect2Server() throws IOException {
        clientSocket = new Socket(Utils.SERVER_ADDRESS, Utils.SERVER_PORT);
    }

    private void initIOStreams() throws IOException {
        outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        inputStream = new ObjectInputStream(clientSocket.getInputStream());
    }

    private void startThreads() {
        new Thread(new GetDataRunnable(inputStream, this)).start();
    }

    public void sendData(String text) {
        Message message = new Message(text, this.userName);
        try {
            outputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void receive(Message message) {

    }

    public String getUserName() {
        return userName;
    }

    public String getNickName() {
        return nickName;
    }
}
