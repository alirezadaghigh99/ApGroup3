package Model.USER.threads;

import Model.USER.network_models.Message;

import java.io.ObjectInputStream;

public class GetDataRunnable implements Runnable {
    private ObjectInputStream inputStream;
    private MessageListener listener;

    public GetDataRunnable(ObjectInputStream inputStream, MessageListener listener) {
        this.inputStream = inputStream;
        this.listener = listener;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = (Message) inputStream.readObject();
                listener.receive(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
