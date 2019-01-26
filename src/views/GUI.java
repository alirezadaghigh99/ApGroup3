package views;

import Controller.FarmController;
import Model.Animals.*;
import Model.OnMaps.*;
import Model.OurFarm;
import Model.Products.*;
import Model.Utils;
import Model.Workshop.CakeBakery;
import Model.Workshop.EggPowderPlantWorkShop;
import Model.Workshop.SewingFactory;
import Model.Workshop.SpinneryFactory;
import javafx.animation.*;
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
import javafx.util.Duration;

import javax.rmi.CORBA.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GUI extends Application {
    private Group group = new Group();
    private Scene scene = new Scene(group, 1018.5, 745.5);
    private ImageView background;
    ImageView[][] henView = new ImageView[Utils.mapSize][Utils.mapSize];

    private ImageView firstMenu;
    private ImageView newGameButton;
    private ImageView loadGameButton;
    ImageView wellView = Well.getWell().getImageView1();

    private boolean sure;

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

    public Label getCoin() {
        Label coin = new Label("" + FarmController.getInstance().getMoney());
        return coin;
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
        showGrass();
        showHen();
        showCow();
        showCoins();
        showUpMap();
        showDepot();
        showWell();
        showCakeBakery();
        showspinneryFactory();
        showSewingFactory();
        showWeavingFactory();
        showEggPowderPlant();
        showUpgradables();
        FarmController.getInstance().passTurn(1);
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
                    Cell[][] cells = FarmController.getInstance().getMap().getCells();
                    if ((time%100 == 8)) {
                        Lion lion = new Lion();
                        lion.setX((int) (Math.random() * Utils.mapSize));
                        lion.setY((int) (Math.random() * Utils.mapSize));
                        cells[lion.getX()][lion.getY()].addCellAnimals(lion);
                    }
                    if (time%1200 == 108) {
                        Bear bear = new Bear();
                        bear.setX((int) (Math.random() * Utils.mapSize));
                        bear.setY((int) (Math.random() * Utils.mapSize));
                        cells[bear.getX()][bear.getY()].addCellAnimals(bear);
                    }
                    OurFarm.getOurFarm().getAnimals().clear();
                    for (int i = 0; i < Utils.mapSize; i++) {
                        for (int j = 0; j < Utils.mapSize; j++) {
                            ArrayList<Animal> animals = cells[i][j].getCellAnimals();
                            for (Animal animal : animals) {
                                OurFarm.getOurFarm().getAnimals().add(animal);
                            }
                            cells[i][j].getCellAnimals().clear();
                        }
                    }
                    for (Animal animal : OurFarm.getOurFarm().getAnimals()) {
                        animal.nextTurn();
                        int x = animal.getX();
                        int y = animal.getY();
                        cells[x][y].getCellAnimals().add(animal);

                    }
                    FarmController.getInstance().collision();

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
    private ImageView[][] cowView = new ImageView[Utils.mapSize][Utils.mapSize];
    private ImageView[][] eggs = new ImageView[Utils.mapSize][Utils.mapSize];
    private ImageView[][] wools = new ImageView[Utils.mapSize][Utils.mapSize];
    private ImageView[][] milks = new ImageView[Utils.mapSize][Utils.mapSize];





    private void showProducts(ArrayList<Product> products) throws Exception {
        Image eggIMG = new Image(new FileInputStream("Products/Egg/normal.png"));
        Image woolIMG = new Image(new FileInputStream("Products/Wool/normal.png"));
        Image milkIMG = new Image(new FileInputStream("Products/Milk.png"));
        for (int i = 0; i < Utils.mapSize; i++) {
            for (int j = 0; j < Utils.mapSize; j++) {
                eggs[i][j] = new ImageView(eggIMG);
                eggs[i][j].relocate(Utils.START_Y + i * Utils.CELL_WIDTH, Utils.START_X + j * Utils.CELL_HEIGHT);
                eggs[i][j].setFitWidth(Utils.CELL_WIDTH);
                eggs[i][j].setFitHeight(Utils.CELL_HEIGHT);
                wools[i][j] = new ImageView(woolIMG);
                wools[i][j].relocate(Utils.START_Y + i * Utils.CELL_WIDTH, Utils.START_X + j * Utils.CELL_HEIGHT);
                wools[i][j].setFitWidth(Utils.CELL_WIDTH);
                wools[i][j].setFitHeight(Utils.CELL_HEIGHT);
                milks[i][j] = new ImageView(milkIMG);
                milks[i][j].relocate(Utils.START_Y + i * Utils.CELL_WIDTH, Utils.START_X + j * Utils.CELL_HEIGHT);
                milks[i][j].setFitWidth(Utils.CELL_WIDTH);
                milks[i][j].setFitHeight(Utils.CELL_HEIGHT);
                eggs[i][j].setVisible(false);
                milks[i][j].setVisible(false);
                wools[i][j].setVisible(false);
                group.getChildren().addAll(wools[i][j], eggs[i][j], milks[i][j]);
            }
        }
        for (int i = 0; i < Utils.mapSize; i++) {
            for (int j = 0; j < Utils.mapSize; j++) {
                for (Product product : products) {
                    if (product instanceof Egg) {
                        eggs[product.getX()][product.getY()].setVisible(true);
                    }
                    if (product instanceof Wool) {
                        wools[product.getX()][product.getY()].setVisible(true);
                    }
                    if (product instanceof Milk) {
                        milks[product.getX()][product.getY()].setVisible(true);
                    }
                }
            }
        }

    }
    private void showCow() {
        for (int i = 0  ; i< Utils.mapSize ; i++)
        {
            for (int j = 0 ; j< Utils.mapSize ; j++)
            {
                if (FarmController.getInstance().getMap().getCells()[i][j].getCellAnimals().size()!=0)
                {

                    for (int k =0 ; k<FarmController.getInstance().getMap().getCells()[i][j].getCellAnimals().size() ;k++ )
                        if (FarmController.getInstance().getMap().getCells()[i][j].getCellAnimals().get(k) instanceof Cow)
                        {

                            try {
                                cowView[i][j] = new ImageView(new Image(new FileInputStream("Animals\\Africa\\Buffalo\\eat.png")));
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            cowView[i][j].setX(200);
                            cowView[i][j].setY(200);
                            group.getChildren().add(cowView[i][j]);
                            cowView[i][j].setViewport(new Rectangle2D(0, 0, 960, 488));
                            Cow.getInstance().eatAnimationOfCow(cowView[i][j]).setCycleCount(Animation.INDEFINITE);
                            Cow.getInstance().eatAnimationOfCow(cowView[i][j]).play();


                        }
                }
            }
        }

    }

    public void showDomestic()
    {
        ImageView[][] henView = new ImageView[Utils.mapSize][Utils.mapSize];
    }

    public void showGrass() throws Exception {
        Image grassIMG = (new Grass()).getImageGrass1();
        ImageView[][] grassView = new ImageView[Utils.mapSize][Utils.mapSize];
        for (int i = 0; i < Utils.mapSize; i++) {
            for (int j = 0; j < Utils.mapSize; j++) {
                grassView[i][j] = new ImageView(grassIMG);
                grassView[i][j].relocate(Utils.START_Y + i * Utils.CELL_WIDTH, Utils.START_X + j * Utils.CELL_HEIGHT);
                grassView[i][j].setViewport(new Rectangle2D(0, 0, 192, 192));
                Grass.getInstance().grassAnimation().setCycleCount(Animation.INDEFINITE);
                Grass.getInstance().grassAnimation().play();
                if (FarmController.getInstance().getMap().getCells()[i][j].getGrass().isGrass())
                    grassView[i][j].setVisible(true);
                else
                    grassView[i][j].setVisible(false);
                group.getChildren().add(grassView[i][j]);
            }
        }
        background.setOnMouseClicked(event -> {
            int i = (int) (event.getX() - Utils.START_Y) / Utils.CELL_WIDTH;
            int j = (int) (event.getY() - Utils.START_Y) / Utils.CELL_HEIGHT;
            if (i >= 0 && j >= 0 && i < Utils.mapSize && j < Utils.mapSize)
                FarmController.getInstance().addGrassAction(i, j);
            try {
                showGrass();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }

    public void showDepot() {
        Depot.getDepot().checkDepotLevel();
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

    public void showUpMap() {
        try {
            Image imageOfBack = new Image(new FileInputStream("pictures\\timer.png"));
            Image imageOfHen = new Image(new FileInputStream("UI\\Icons\\Products\\guinea_fowl.png"));
            Image imageOfCow = new Image(new FileInputStream("UI\\Icons\\Products\\brown_cow.png"));
            Image imageOfSheep = new Image(new FileInputStream("UI\\Icons\\Products\\sheep.png"));
            Image imageOfTruck = new Image(new FileInputStream("UI\\Truck\\01.png"));
            Image imageOfHelicopter = new Image(new FileInputStream("UI\\Helicopter\\01.png"));
            ImageView viewOfTruck = new ImageView(imageOfTruck);
            ImageView viewOfHen = new ImageView(imageOfHen);
            ImageView viewOfCow = new ImageView(imageOfCow);
            ImageView viewOfSheep = new ImageView(imageOfSheep);
            ImageView viewOfHelicopter = new ImageView(imageOfHelicopter);
            ImageView area1 = new ImageView(imageOfBack);
            ImageView area2 = new ImageView(imageOfBack);
            ImageView area3 = new ImageView(imageOfBack);
            area1.relocate(0, -60);
            area1.setFitWidth(80);
            area1.setFitHeight(280);
            area2.relocate(80, -60);
            area2.setFitWidth(80);
            area2.setFitHeight(280);
            area3.relocate(160, -60);
            area3.setFitWidth(80);
            area3.setFitHeight(280);
            viewOfHen.setFitHeight(60);
            viewOfHen.setFitWidth(60);
            viewOfHen.relocate(10, 10);
            viewOfHen.setOnMouseClicked(event -> {
                try {
                    Hen hen = new Hen();
                    FarmController.getInstance().addAnimalAction(hen);
                    showCoins();
                    showHen();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            viewOfCow.setFitHeight(60);
            viewOfCow.setFitWidth(60);
            viewOfCow.relocate(170, 10);
            viewOfCow.setOnMouseClicked(event -> {
                try {
                    Cow cow = new Cow();
                    FarmController.getInstance().addAnimalAction(cow);
                    showCow();
                    showCoins();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            viewOfSheep.setFitHeight(60);
            viewOfSheep.setFitWidth(60);
            viewOfSheep.relocate(90, 10);
            viewOfSheep.setOnMouseClicked(event -> {
                try {
                    Sheep sheep = new Sheep();
                    FarmController.getInstance().addAnimalAction(sheep);
                    showCoins();
                    showDomestic();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            viewOfTruck.setFitHeight(220);
            viewOfTruck.setFitWidth(200);
            viewOfTruck.setX(200);
            viewOfTruck.setY(530);
            viewOfHelicopter.setFitHeight(220);
            viewOfHelicopter.setFitWidth(200);
            viewOfHelicopter.setX(600);
            viewOfHelicopter.setY(530);
            Label henPrice = new Label("" + Utils.HEN_PRICE);
            henPrice.setFont(Font.font("cooper black", 30));
            henPrice.setTextFill(Color.YELLOW);
            henPrice.relocate(30, 80);
            Label sheepPrice = new Label("" + Utils.SHEEP_PRICE);
            sheepPrice.setFont(Font.font("cooper black", 30));
            sheepPrice.setTextFill(Color.YELLOW);
            sheepPrice.relocate(110, 80);
            Label cowPrice = new Label("" + Utils.COW_PRICE);
            cowPrice.setFont(Font.font("cooper black", 30));
            cowPrice.setTextFill(Color.YELLOW);
            cowPrice.relocate(190, 80);
            group.getChildren().addAll(area1, area2, area3);
            group.getChildren().addAll(viewOfHen, viewOfCow, viewOfSheep, viewOfTruck, viewOfHelicopter);
            group.getChildren().addAll(henPrice, sheepPrice, cowPrice);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void showHen() {
        for (int i = 0  ; i< Utils.mapSize ; i++)
        {
            for (int j = 0 ; j< Utils.mapSize ; j++)
            {
                if (FarmController.getInstance().getMap().getCells()[i][j].getCellAnimals().size()!=0)
                {

                    for (int k =0 ; k<FarmController.getInstance().getMap().getCells()[i][j].getCellAnimals().size() ;k++ )
                        if (FarmController.getInstance().getMap().getCells()[i][j].getCellAnimals().get(k) instanceof Hen)
                        {

                            henView[i][j] = (Hen.getInstance().getEatView());
                            henView[i][j].setX(400);
                            henView[i][j].setY(500);
                            group.getChildren().add(henView[i][j]);
                           // henView[i][j].setViewport(new Rectangle2D(0, 0, 370, 320));
                        //  Hen.getInstance().henEatAnimation().setCycleCount(Animation.INDEFINITE);
//                            Hen.getInstance().henEatAnimation().play();
                            Hen.getInstance().henAnimation().setCycleCount(Animation.INDEFINITE);
                            Hen.getInstance().henAnimation().play();


                        }
                }
            }
        }
    }

    public void showWell() {
        //if (Well.getWell().getLevel()==1)
        Well.getWell().checkLevel();
        Well.getWell().getImageView1().setX(500);
        Well.getWell().getImageView1().setY(50);
        group.getChildren().add(Well.getWell().getImageView1());
        if (Well.getWell().getLevel() == 1)
            Well.getWell().getImageView1().setViewport(new Rectangle2D(0, 0, 600, 544));
        if (Well.getWell().getLevel() == 2)
            Well.getWell().getImageView1().setViewport(new Rectangle2D(0, 0, 592, 600));
        if (Well.getWell().getLevel() == 3)
            Well.getWell().getImageView1().setViewport(new Rectangle2D(0, 0, 576, 632));
        if (Well.getWell().getLevel() == 4)
            Well.getWell().getImageView1().setViewport(new Rectangle2D(0, 0, 592, 536));
        Well.getWell().wellAnimation(Well.getWell().getImageView1()).setCycleCount(Animation.INDEFINITE);
        Well.getWell().wellAnimation(Well.getWell().getImageView1()).play();
        Well.getWell().getImageView1().setOnMouseClicked(event -> {
            if (Well.getWell().isfull()) {
                try {
                    Image image = new Image(new FileInputStream("pictures\\Full.jpg"));
                    ImageView viewOfFull = new ImageView(image);
                    viewOfFull.setY(80);
                    viewOfFull.setX(500);
                    viewOfFull.setFitWidth(50);
                    viewOfFull.setFitHeight(50);
                    Timeline timeline = new Timeline(
                            new KeyFrame(Duration.ZERO, new KeyValue(viewOfFull.imageProperty(), image)),
                            new KeyFrame(Duration.seconds(2), new KeyValue(viewOfFull.imageProperty(), null))
                    );
                    timeline.play();
                    group.getChildren().add(viewOfFull);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                FarmController.getInstance().addWaterAction();
                Well.getWell().wellAnimation(Well.getWell().getImageView1()).setCycleCount(Animation.INDEFINITE);
                Well.getWell().wellAnimation(Well.getWell().getImageView1()).play();
            }
            try {
                showCoins();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    public void showCakeBakery() {
        ImageView viewCakeBakery = CakeBakery.getCakeBakery().getViewOfCakeBakery();
       ImageView startView = CakeBakery.getCakeBakery().getStartView();
        startView.setX(110);
        startView.setY(210);


        viewCakeBakery.setX(100);
        viewCakeBakery.setY(200);
        startView.setFitWidth(50);
        startView.setFitHeight(90);
        group.getChildren().add(viewCakeBakery);



        viewCakeBakery.setViewport(new Rectangle2D(0, 0, 536, 568));
        CakeBakery.getCakeBakery().CakeAnimation().setCycleCount(Animation.INDEFINITE);
        CakeBakery.getCakeBakery().CakeAnimation().play();
        viewCakeBakery.setOnMouseClicked(event -> {
            CakeBakery.getCakeBakery().CakeAnimation().setCycleCount(Animation.INDEFINITE);
            CakeBakery.getCakeBakery().CakeAnimation().play();
            if (!group.getChildren().contains(startView)) {

                group.getChildren().add(startView);
            }
            else startView.setVisible(true);
        });
        startView.setOnMouseClicked(event -> {
            startView.setVisible(false);
            CakeBakery.getCakeBakery().makeCake();
        });
        int c =0 ;

    }

    public void showSewingFactory() {
        ImageView viewOfSewingFactory = SewingFactory.getSewingFactory().getViewOfSewing();
        viewOfSewingFactory.setX(30);
        viewOfSewingFactory.setY(360);
        group.getChildren().add(viewOfSewingFactory);
        viewOfSewingFactory.setViewport(new Rectangle2D(0, 0, 680, 520));
        SewingFactory.getSewingFactory().sewingAnimation().setCycleCount(Animation.INDEFINITE);
        SewingFactory.getSewingFactory().sewingAnimation().play();
        viewOfSewingFactory.setOnMouseClicked(event -> {
            SewingFactory.getSewingFactory().sewingAnimation().setCycleCount(Animation.INDEFINITE);
            SewingFactory.getSewingFactory().sewingAnimation().play();
        });

    }

    public void showWeavingFactory() {

    }

    public void showEggPowderPlant() {
        ImageView eggView = EggPowderPlantWorkShop.getEggPowderPlantWorkShop().getImageView1();
        eggView.setX(760);
        eggView.setY(400);
        group.getChildren().add(eggView);
        eggView.setViewport(new Rectangle2D(0, 0, 512, 456));
        EggPowderPlantWorkShop.getEggPowderPlantWorkShop().eggPowderAnimation().setCycleCount(Animation.INDEFINITE);
        EggPowderPlantWorkShop.getEggPowderPlantWorkShop().eggPowderAnimation().play();
        eggView.setOnMouseClicked(event -> {
            EggPowderPlantWorkShop.getEggPowderPlantWorkShop().eggPowderAnimation().setCycleCount(Animation.INDEFINITE);
            EggPowderPlantWorkShop.getEggPowderPlantWorkShop().eggPowderAnimation().play();
        });
    }

    public void showspinneryFactory() {
        ImageView viewOfSpinnery = SpinneryFactory.getSpinneryFactory().getViewOfSpinnery();
        viewOfSpinnery.setY(200);
        viewOfSpinnery.setX(800);
        group.getChildren().add(viewOfSpinnery);
        viewOfSpinnery.setViewport(new Rectangle2D(0, 0, 520, 424));
        SpinneryFactory.getSpinneryFactory().spinneryAnimation().setCycleCount(Animation.INDEFINITE);
        SpinneryFactory.getSpinneryFactory().spinneryAnimation().play();
        viewOfSpinnery.setOnMouseClicked(event -> {
            SpinneryFactory.getSpinneryFactory().spinneryAnimation().setCycleCount(Animation.INDEFINITE);
            SpinneryFactory.getSpinneryFactory().spinneryAnimation().play();
        });

    }

    public void CookieBakery() {

    }

    private void showUpgradables() throws Exception {
        Image upgradeIMG = new Image(new FileInputStream("pictures/upgrade.png"));
        ImageView upgradeButton = new ImageView(upgradeIMG);
        upgradeButton.relocate(0, 650);
        upgradeButton.setFitWidth(170);
        upgradeButton.setFitHeight(130);
        group.getChildren().add(upgradeButton);
        upgradeButton.setOnMouseClicked(event -> {
            try {
                showUpgradeMenu();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void showUpgradeMenu() throws Exception {
        Image upgradeIMG = new Image(new FileInputStream("pictures/upgradeBack.png"));
        ImageView upgradeBackground = new ImageView(upgradeIMG);
        upgradeBackground.relocate(0, 0);
        upgradeBackground.setFitWidth(scene.getWidth());
        upgradeBackground.setFitHeight(scene.getHeight());
        group.getChildren().add(upgradeBackground);
        FileInputStream back = new FileInputStream("pictures/backbutton2.png");
        Image image = new Image(back);
        ImageView backButton = new ImageView(image);
        backButton.setX(0);
        backButton.setY(-10);
        backButton.setFitWidth(90);
        backButton.setFitHeight(60);
        upgradeBackground.setVisible(true);
        backButton.setVisible(true);
        if (!group.getChildren().contains(upgradeBackground))
            group.getChildren().add(upgradeBackground);
        if (!group.getChildren().contains(backButton))
            group.getChildren().add(backButton);
        Image well = Well.getWell().getImageOfWell1();
        ImageView upgradeWell = new ImageView(well);
        Image spinneryIm = new Image(new FileInputStream("pictures\\spinnery.jpg"));
        ImageView viewOfSpinnery = new ImageView(spinneryIm);
        Image upgradeDepot = new Image(new FileInputStream("Service\\Depot\\01.png"));
        ImageView viewUpgradeDepot = new ImageView(upgradeDepot);
        upgradeWell.setX(50);
        upgradeWell.setY(50);
        viewUpgradeDepot.setX(70);
        viewUpgradeDepot.setY(200);
        viewUpgradeDepot.setFitHeight(80);
        viewUpgradeDepot.setFitWidth(80);

        viewOfSpinnery.setX(80);
        viewOfSpinnery.setY(150);
        viewOfSpinnery.setFitWidth(65);
        viewOfSpinnery.setFitHeight(65);
        upgradeWell.setViewport(new Rectangle2D(0, 0, 600, 544));
        Well.getWell().wellBoardAnimation(upgradeWell, 1).setCycleCount(Animation.INDEFINITE);
        Well.getWell().wellBoardAnimation(upgradeWell, 1).play();
        group.getChildren().addAll(upgradeWell, viewOfSpinnery, viewUpgradeDepot);
        Label wellPrice = new Label("" + Utils.UPGRADE_WELL_COST);
        wellPrice.relocate(200, 109);
        wellPrice.setTextFill(Color.YELLOW);
        wellPrice.setFont(Font.font("cooper black", 30));
        Label spinneryPrice = new Label("" + 100);
        Label depotPrice = new Label("" + 100);
        wellPrice.relocate(200, 109);
        wellPrice.setTextFill(Color.YELLOW);
        wellPrice.setFont(Font.font("cooper black", 30));
        spinneryPrice.relocate(200, 159);
        spinneryPrice.setTextFill(Color.ORANGE);
        spinneryPrice.setFont(Font.font("cooper black", 30));
        depotPrice.relocate(200, 209);
        depotPrice.setTextFill(Color.BLUE);
        depotPrice.setFont(Font.font("cooper black", 30));

        group.getChildren().addAll(wellPrice, spinneryPrice, depotPrice);
        backButton.setOnMouseClicked(event -> {
            backButton.setVisible(false);
            upgradeBackground.setVisible(false);
            upgradeWell.setVisible(false);
            wellPrice.setVisible(false);
            viewOfSpinnery.setVisible(false);
            spinneryPrice.setVisible(false);
            depotPrice.setVisible(false);
            viewUpgradeDepot.setVisible(false);
            try {
                showCoins();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        upgradeWell.setOnMouseClicked(event -> {
            try {
                areYouSure("Well");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        viewOfSpinnery.setOnMouseClicked(event -> {
            try {
                areYouSure("SpinneryFactory");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        viewUpgradeDepot.setOnMouseClicked(event -> {
            try {
                areYouSure("depot");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void areYouSure(String toUpgrade) throws Exception {
        Image back = new Image(new FileInputStream("pictures/timer.png"));
        ImageView bg = new ImageView(back);
        bg.relocate(50, 100);
        bg.setFitHeight(600);
        bg.setFitWidth(950);
        bg.setVisible(true);
        if (!group.getChildren().contains(bg))
            group.getChildren().add(bg);
        Label label = new Label("Are you sure about upgrading " + toUpgrade + " ?");
        label.relocate(200, 300);
        label.setFont(Font.font("cooper black", 34));
        label.setTextFill(Color.YELLOW);
        label.setVisible(true);
        if (!group.getChildren().contains(label))
            group.getChildren().add(label);
        Image yesIMG = new Image(new FileInputStream("pictures/yesButton.png"));
        ImageView yesButton = new ImageView(yesIMG);
        yesButton.relocate(290, 380);
        yesButton.setFitWidth(200);
        yesButton.setFitHeight(100);
        yesButton.setVisible(true);
        if (!group.getChildren().contains(yesButton))
            group.getChildren().add(yesButton);
        Image noIMG = new Image(new FileInputStream("pictures/noButton.png"));
        ImageView noButton = new ImageView(noIMG);
        noButton.relocate(510, 380);
        noButton.setFitWidth(200);
        noButton.setFitHeight(100);
        noButton.setVisible(true);
        if (!group.getChildren().contains(noButton))
            group.getChildren().add(noButton);
        noButton.setOnMouseClicked(event -> {
            bg.setVisible(false);
            label.setVisible(false);
            yesButton.setVisible(false);
            noButton.setVisible(false);
        });
        yesButton.setOnMouseClicked(event -> {
            bg.setVisible(false);
            label.setVisible(false);
            yesButton.setVisible(false);
            noButton.setVisible(false);
//            if (toUpgrade.toLowerCase().equals("well")) {
//                group.getChildren().remove(Well.getWell().getImageView1());
//            }
            FarmController.getInstance().upgradeRequest(toUpgrade.toLowerCase());
            if (toUpgrade.toLowerCase().equals("well")) {
                Well.getWell().checkLevel();
                Well.getWell().wellAnimation(Well.getWell().getImageView1()).setCycleCount(Animation.INDEFINITE);
                Well.getWell().wellAnimation(Well.getWell().getImageView1()).play();
                //group.getChildren().add(Well.getWell().getImageView1());
            }
            if (toUpgrade.toLowerCase().equals("depot")) {
                Depot.getDepot().checkDepotLevel();

            }
            if (toUpgrade.toLowerCase().equals("spinneryfactory")) {
                SpinneryFactory.getSpinneryFactory().checkLevelOfSpinnery();
                SpinneryFactory.getSpinneryFactory().spinneryAnimation().setCycleCount(Animation.INDEFINITE);
                SpinneryFactory.getSpinneryFactory().spinneryAnimation().play();
            }

        });
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
        group.getChildren().remove(getCoin());
        Label coin = getCoin();
        coin.relocate(710, 60);
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
