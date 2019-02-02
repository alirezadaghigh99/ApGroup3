package Model.USER.server;

import Model.USER.client.Client;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Wait extends Thread {
    private ServerSocket serverSocket;
    private ArrayList<Socket> clients;
    private ArrayList<ObjectOutputStream> outputStream;
    private ArrayList<ObjectInputStream> inputStream;

    public Wait(ServerSocket serverSocket, ArrayList<Socket> clients, ArrayList<ObjectOutputStream> outputStream, ArrayList<ObjectInputStream> inputStream) {
        this.serverSocket = serverSocket;
        this.clients = clients;
        this.outputStream = outputStream;
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                clients.add(clientSocket);
                outputStream.add(new ObjectOutputStream(clientSocket.getOutputStream()));
                inputStream.add(new ObjectInputStream(clientSocket.getInputStream()));
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
