package Model.USER.client;

import Model.USER.network_models.Message;
import Model.USER.server.Server;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class exGUI extends Application {
    private Group group = new Group();
    private static TextArea chatArea = new TextArea();
    private Button hostButton = new Button("host");
    private Button userButton = new Button("user");

    {
        hostButton.relocate(200, 200);
        userButton.relocate(500, 200);
        group.getChildren().addAll(hostButton, userButton);
    }

    public void host() {
        Server.getInstance().start();
    }

    public void user() {
        TextField name = new TextField();
        TextField id = new TextField();
        name.relocate(100, 0);
        id.relocate(300, 0);
        group.getChildren().addAll(name, id);
        id.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                boolean existed = false;
                for (Client client : Server.getInstance().getClients()) {
                    if (client.getUserName().equals(id.getText())) {
                        existed = true;
                        break;
                    }
                }
                if (!existed) {
                    Client client = new Client(name.getText(), id.getText());
                    Server.getInstance().getClients().add(client);
                    client.start();
                }
                else{
                    System.out.println("existed");
                }
                name.clear();
                id.clear();
                name.setVisible(false);
                id.setVisible(false);
                TextField textField = new TextField();
                textField.relocate(200, 100);
                Button send = new Button("send");
                send.relocate(500, 100);
                send.setOnMouseClicked((event1) -> {
                    textField.clear();
                });
                chatArea.relocate(400, 300);
                group.getChildren().addAll(textField, send, chatArea);

            }
        });

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(group);
        primaryStage.setTitle("Chat room");
        primaryStage.setWidth(1024.0D);
        primaryStage.setHeight(768.0D);
        hostButton.setOnMouseClicked(event -> {
            hostButton.setVisible(false);
            userButton.setVisible(false);
            host();
        });
        userButton.setOnMouseClicked(event -> {
            hostButton.setVisible(false);
            userButton.setVisible(false);
            user();
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void transfer(Message chat) {
        chatArea.appendText(chat.toString() + "\n");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

