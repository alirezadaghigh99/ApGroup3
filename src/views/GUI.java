package views;

import Controller.FarmController;
import Model.OnMaps.Depot;
import Model.OnMaps.Well;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GUI extends Application {
    private Group group = new Group();
    private Scene scene = new Scene(group, 1018.5, 745.5);
    private ImageView background;
    private ImageView firstMenu;
    private ImageView newGameButton;
    private ImageView loadGameButton;
    private ArrayList<Text> players = new ArrayList<>();
    Media music = new Media(new File("music/pirates.mp3").toURI().toString());
    MediaPlayer player = new MediaPlayer(music);

    {
        try {
            FileInputStream bg = new FileInputStream("pictures/bg.jpg");
            Image image = new Image(bg);
            background = new ImageView(image);
            FileInputStream menu = new FileInputStream("pictures/index.jpg");
            Image image1 = new Image(menu);
            firstMenu = new ImageView(image1);
            FileInputStream buttonOfMenu = new FileInputStream("pictures/aquabutton.jpg");
            Image image2 = new Image(buttonOfMenu);
            newGameButton = new ImageView(image2);
            FileInputStream loadGame = new FileInputStream("pictures/load.jpg");
            Image lPic = new Image(loadGame);
            loadGameButton = new ImageView(lPic);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize(ImageView background, ImageView firstMenu, ImageView newGameButton, ImageView loadGameButton) {
        background.setX(0);
        background.setY(0);
        background.setFitHeight(scene.getHeight());
        background.setFitWidth(scene.getWidth());
        group.getChildren().add(background);
        firstMenu.setX(300);
        firstMenu.setY(175);
        firstMenu.setFitHeight(400);
        firstMenu.setFitWidth(400);
        group.getChildren().add(firstMenu);
        newGameButton.setX(400);
        newGameButton.setY(225);
        newGameButton.setFitWidth(200);
        newGameButton.setFitHeight(100);
        group.getChildren().add(newGameButton);
        loadGameButton.setX(400);
        loadGameButton.setY(425);
        loadGameButton.setFitWidth(200);
        loadGameButton.setFitHeight(100);
        group.getChildren().add(loadGameButton);
        Media music = new Media(new File("music/pirates.mp3").toURI().toString());
        MediaPlayer player = new MediaPlayer(music);
        player.play();
        newGameButton.setOnMouseClicked(event -> {
            try {
                newGameCall(firstMenu, newGameButton, loadGameButton);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        loadGameButton.setOnMouseClicked(event -> {
            try {
                loadGameCall(firstMenu, newGameButton, loadGameButton);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void newGameCall(ImageView menu, ImageView newGameButton, ImageView loadGameButton) throws Exception {
        group.getChildren().removeAll(menu, newGameButton, loadGameButton);
        FileInputStream f = new FileInputStream("pictures/secondMenu.jpg");
        Image newGameImg = new Image(f);
        ImageView newGameMenu = new ImageView(newGameImg);
        newGameMenu.setX(150);
        newGameMenu.setY(50);
        newGameMenu.setFitHeight(650);
        newGameMenu.setFitWidth(700);
        group.getChildren().add(newGameMenu);
        FileInputStream back = new FileInputStream("pictures/backbutton2.png");
        Image image = new Image(back);
        ImageView backButton = new ImageView(image);
        backButton.setX(200);
        backButton.setY(600);
        backButton.setFitWidth(100);
        backButton.setFitHeight(80);
        group.getChildren().add(backButton);
        Text text = new Text();
        text.setText("YOUR NAME :");
        text.setFont(Font.font("elephant", 30));
        text.setFill(Color.YELLOWGREEN);
        text.setX(240);
        text.setY(175);
        group.getChildren().add(text);
        TextField textField = new TextField();
        textField.relocate(500, 150);
        group.getChildren().add(textField);
        textField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                String name = textField.getText();
                textField.clear();
                if (name.equals("")) {

                } else {
                    boolean wasInPlayers = false;
                    if (players.isEmpty()) {
                        wasInPlayers = false;
                    }
                    for (Text player : players) {
                        if (player.getText().toLowerCase().equals(name.toLowerCase())) {
                            wasInPlayers = true;
                            players.remove(player);
                            Text newPlayer = new Text();
                            newPlayer.setText(name);
                            players.add(newPlayer);
                            break;
                        }
                    }
                    if (!wasInPlayers) {
                        Text newPlayer = new Text();
                        newPlayer.setText(name);
                        players.add(newPlayer);
                    }
                }
            }
        });
        FileInputStream playFile = new FileInputStream("pictures/play.png");
        Image playIMG = new Image(playFile);
        ImageView playButton = new ImageView(playIMG);
        playButton.setX(400);
        playButton.setY(300);
        playButton.setFitWidth(200);
        playButton.setFitHeight(100);
        group.getChildren().addAll(playButton);
        FileInputStream showFile = new FileInputStream("pictures/show.png");
        Image showIMG = new Image(showFile);
        ImageView showPlayersButton = new ImageView(showIMG);
        showPlayersButton.setX(650);
        showPlayersButton.setY(580);
        showPlayersButton.setFitWidth(180);
        showPlayersButton.setFitHeight(80);
        group.getChildren().addAll(showPlayersButton);
        playButton.setOnMouseClicked(event -> {

        });
        showPlayersButton.setOnMouseClicked(event -> {
            try {
                group.getChildren().removeAll(newGameButton, backButton, showPlayersButton, textField, playButton);
                showPlayers();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        backButton.setOnMouseClicked(event -> {
            group.getChildren().removeAll(group.getChildren());
            initialize(background, firstMenu, newGameButton, loadGameButton);
        });
        playButton.setOnMouseClicked(event -> {
            group.getChildren().removeAll(group.getChildren());
            try {
                playGame();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    public void loadGameCall(ImageView menu, ImageView newGameButton, ImageView loadGameButton) throws Exception {
        group.getChildren().removeAll(menu, newGameButton, loadGameButton);
        FileInputStream f = new FileInputStream("pictures/secondMenu.jpg");
        Image newGameImg = new Image(f);
        ImageView loadGameMenu = new ImageView(newGameImg);
        loadGameMenu.setX(150);
        loadGameMenu.setY(50);
        loadGameMenu.setFitHeight(650);
        loadGameMenu.setFitWidth(700);
        group.getChildren().add(loadGameMenu);
        FileInputStream back = new FileInputStream("pictures/backbutton2.png");
        Image image = new Image(back);
        ImageView backButton = new ImageView(image);
        backButton.setX(200);
        backButton.setY(600);
        backButton.setFitWidth(100);
        backButton.setFitHeight(80);
        group.getChildren().add(backButton);
        backButton.setOnMouseClicked(event -> {
            group.getChildren().removeAll(group.getChildren());
            initialize(background, firstMenu, newGameButton, loadGameButton);
        });
    }

    public void showPlayers() throws Exception {
        FileInputStream f = new FileInputStream("pictures/secondMenu.jpg");
        Image playersIMG = new Image(f);
        ImageView playersInGame = new ImageView(playersIMG);
        playersInGame.setX(150);
        playersInGame.setY(50);
        playersInGame.setFitHeight(650);
        playersInGame.setFitWidth(700);
        group.getChildren().add(playersInGame);
        Text[] texts = new Text[players.size() < 20 ? players.size() : 20];
        int count = 1;
        for (int i = players.size() - 1; i >= players.size() - (players.size() < 20 ? players.size() : 20); i--) {
            texts[count - 1] = new Text();
            texts[count - 1].setText(count + "- " + players.get(i).getText());
            if (count <= 10) {
                texts[count - 1].relocate(200, 50 + (count) * 50);
            } else {
                texts[count - 1].relocate(500, 50 + (count - 10) * 50);
            }
            texts[count - 1].setFont(Font.font("comic sans ms", 30));
            count++;
        }
        FileInputStream back = new FileInputStream("pictures/backbutton2.png");
        Image image = new Image(back);
        ImageView backButton = new ImageView(image);
        backButton.setX(200);
        backButton.setY(600);
        backButton.setFitWidth(100);
        backButton.setFitHeight(80);
        group.getChildren().add(backButton);
        group.getChildren().addAll(texts);
        backButton.setOnMouseClicked(event -> {
            group.getChildren().removeAll(group.getChildren());
            initialize(background, firstMenu, newGameButton, loadGameButton);

            try {
                newGameCall(firstMenu, newGameButton, loadGameButton);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void playGame() throws Exception {
        group.getChildren().addAll(background);
        FarmController.getInstance().listenForCommand();
        showCoins();
        showDepot();
        showWell();
        showCakeBakery();
        showCakeBakery();
        showspinneryFactory();
        showSewingFactory();
        showWeavingFactory();
        showEggPowderPlant();
        FileInputStream timerFile = new FileInputStream("pictures/timer.png");
        Image timerIMG = new Image(timerFile);
        ImageView timerButton = new ImageView(timerIMG);
        timerButton.setX(800);
        timerButton.setY(625);
        timerButton.setFitWidth(215);
        timerButton.setFitHeight(140);
        group.getChildren().add(timerButton);
        Label timer = new Label("0");
        timer.relocate(830, 675);
        timer.setTextFill(Color.YELLOWGREEN);
        timer.setFont(Font.font("cooper black", FontWeight.BOLD, 30));
        group.getChildren().add(timer);
        AnimationTimer animationTimer = new AnimationTimer() {
            private long lastTime = 0;
            private long second = 1000000000;
            private long time = 0;

            @Override

            public void handle(long now) {
                if (lastTime == 0) {
                    lastTime = now;
                }
                if (now > lastTime + second / 10) {
                    lastTime = now;
                    time++;
                    if ((time / 10) % 60 < 10) {
                        timer.setText("Time : " + time / 600 + ".0" + (time / 10) % 60);
                    } else {
                        timer.setText("Time : " + time / 600 + "." + (time / 10) % 60);
                    }
                }
            }
        };
        animationTimer.start();
    }

    public void showDepot() {
        ImageView depotView = Depot.getDepot().getImageView();
        depotView.setFitWidth(200);
        depotView.setFitHeight(200);
        depotView.setX(400);
        depotView.setY(530);
        group.getChildren().add(depotView);
        depotView.setOnMouseClicked(event -> {
            ImageView behindView = Depot.getDepot().getBehindView();
            ImageView backView = Depot.getDepot().getBackView();
            backView.setX(700);
            backView.setY(600);
            behindView.setX(200);
            behindView.setY(100);
            backView.setY(300);
            backView.setFitHeight(50);
            backView.setFitWidth(80);
            behindView.setFitWidth(600);
            behindView.setFitHeight(550);
            behindView.setVisible(true);
            if (!group.getChildren().contains(behindView))
                group.getChildren().add(behindView);
            backView.setVisible(true);
            if (!group.getChildren().contains(backView))
                group.getChildren().add(backView);
            backView.setOnMouseClicked(event1 -> {
                behindView.setVisible(false);
                backView.setVisible(false);
            });
        });


    }

    public void showWell() {
        ImageView wellView = Well.getWell().getImageView1();
        wellView.setX(500);
        wellView.setY(50);
        group.getChildren().add(wellView);
        wellView.setViewport(new Rectangle2D(0, 0, 600, 544));
        Well.getWell().wellAnimation().setCycleCount(Animation.INDEFINITE);
        Well.getWell().wellAnimation().play();
        wellView.setOnMouseClicked(event -> {
            Well.getWell().wellAnimation().setCycleCount(Animation.INDEFINITE);
            Well.getWell().wellAnimation().play();
        });
    }

    public void showCakeBakery() {

    }

    public void showSewingFactory() {

    }

    public void showWeavingFactory() {

    }

    public void showEggPowderPlant() {

    }

    public void showspinneryFactory() {

    }

    public void CookieBakery() {

    }

    private void showCoins() throws Exception {
        Rectangle coinField = new Rectangle(170, 100);
        coinField.relocate(670, 5);
        coinField.setArcWidth(50);
        coinField.setArcHeight(50);
        coinField.setFill(Color.rgb(20, 50, 250, 0.8));
        group.getChildren().addAll(coinField);
        FileInputStream coinFile = new FileInputStream("pictures/coin.png");
        Image coinImg = new Image(coinFile);
        ImageView coinButton = new ImageView(coinImg);
        coinButton.relocate(735, 10);
        coinButton.setFitWidth(40);
        coinButton.setFitHeight(40);
        group.getChildren().add(coinButton);
        Label coin = new Label("" + FarmController.getInstance().getMoney());
        coin.relocate(725, 60);
        coin.setFont(Font.font("cooper black", 30));
        coin.setTextFill(Color.YELLOW);
        group.getChildren().add(coin);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Farm Frenzy");
        initialize(background, firstMenu, newGameButton, loadGameButton);
        primaryStage.setScene(scene);
        Thread thread = new Thread(() -> {
            while (true) {
                player.play();
            }
        });
        thread.start();
        primaryStage.show();
    }
}
