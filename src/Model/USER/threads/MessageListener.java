package Model.USER.threads;

import Model.USER.network_models.Message;

public interface MessageListener {
    void receive(Message message);
}

