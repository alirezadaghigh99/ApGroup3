package Model;

import Model.Animals.*;
import Model.OnMaps.Cage;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SpriteAnimalAnimation extends Transition {
    private final int cellSize = Utils.CELL_WIDTH;
    int flag1 = 0;
    int flag2 = 0;
    int flag3 = 0;
    long timeLine ;
    long now ;
    Image image;

    {
        try {
            image = new Image(new FileInputStream("Cages\\build01.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    Image image2;

    {
        try {
            image2 = new Image(new FileInputStream("Cages\\break01.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    ImageView animalView = new ImageView();
    Cage cage = new Cage();
    private Animal animal;
    private ImageView imageView;
    private int timeConstant;
    private int count = 25;
    private int columns = 5;
    private int offsetX = 0;
    private int offsetY = 0;
    private int width;
    private int height;
    private int lastIndex;
    private Group group;
    private int x;
    private int y;

    {
        try {
            image = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Textures\\Cages\\build01.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public SpriteAnimalAnimation(Animal animal, int timeConstant, Group group, long now) {
        this.animal = animal;
        this.timeConstant = 2000;
        this.group = group;
        this.now = now ;
        this.imageView = getAnimalImageView();
        this.setInterpolator(Interpolator.LINEAR);


//        if (!group.getChildren().contains(this.imageView))
        group.getChildren().add(this.imageView);

    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    protected void interpolate(double k) {
        int index = Math.min((int) Math.floor(k * count), count - 1);
        if (index != lastIndex) {
            int x = (index % columns) * width + offsetX;
            int y = (index / columns) * height + offsetY;
            imageView.setViewport(new Rectangle2D(x, y, width, height));
            imageView.relocate(Utils.START_Y + x * Utils.CELL_WIDTH, Utils.START_X + y * Utils.CELL_HEIGHT);
            imageView.setVisible(false);
            if (animal.isMoving()) {
                imageView.setX(imageView.getX() + animal.getxDirection() * cellSize / count);
                imageView.setY(imageView.getY() + animal.getyDirection() * cellSize / count);
            }
            lastIndex = index;
        }

    }


    public ImageView getAnimalImageView() {
        String pathToImage = "Animals\\Africa\\";
        String finalPathToImage = new String();
        String finalPathRightsToImage = new String();
        if (animal instanceof Cat)
            pathToImage = pathToImage.concat("Cat");
        else if (animal instanceof Dog)
            pathToImage = pathToImage.concat("Dog");
        else if (animal instanceof Bear)
            pathToImage = pathToImage.concat("Grizzly");
        else if (animal instanceof Lion)
            pathToImage = pathToImage.concat("Lion");
        else if (animal instanceof Sheep)
            pathToImage = pathToImage.concat("Sheep");


        else if (animal instanceof Cow) {
            pathToImage = pathToImage.concat("Cow");
        } else {
            pathToImage = pathToImage.concat("GuineaFowl");
        }

        pathToImage = pathToImage.concat("\\");
        if (animal.isMoving()) {

            if (!getDirectionString(animal.getxDirection(), animal.getyDirection()).equals("alireza") && !getDirectionString(animal.getxDirection(),
                    animal.getyDirection()).equals("nima") && !getDirectionString(animal.getxDirection(), animal.getyDirection()).equals("mehrdad")) {
                finalPathToImage = pathToImage.concat(getDirectionString(animal.getxDirection(), animal.getyDirection()));
            } else if (getDirectionString(animal.getxDirection(), animal.getyDirection()).equals("alireza")) {
                finalPathRightsToImage = pathToImage.concat("down_left.png");
                flag1 = 1;

            } else if (getDirectionString(animal.getxDirection(), animal.getyDirection()).equals("nima")) {
                finalPathRightsToImage = pathToImage.concat("left.png");
                flag2 = 1;

            } else if (getDirectionString(animal.getxDirection(), animal.getyDirection()).equals("mehrdad")) {
                finalPathRightsToImage = pathToImage.concat("up_left.png");
                flag3 = 1;

            }

        } else if (!animal.isMoving()) {
            flag2 = 0;
            flag1 = 0;
            flag3 = 0;
            if (animal instanceof WildAnimal)
                finalPathToImage = pathToImage.concat("caged.png");
            else if (animal instanceof ProducerAnimal) {
                if (!((ProducerAnimal) animal).isDead() && !((ProducerAnimal) animal).dontShow())
                    finalPathToImage = pathToImage.concat("eat.png");
                if (((ProducerAnimal) animal).isDead())
                    finalPathToImage = pathToImage.concat("death.png");
                if (((ProducerAnimal) animal).dontShow()) {
                    if (group.getChildren().contains(imageView))
                        group.getChildren().remove(imageView);
                }


            }
        }


        try {
            if (flag2 != 1 && flag1 != 1 && flag3 != 1) {

                // animalView = new ImageView(new Image(new FileInputStream(finalPathToImage)));
//                if (group.getChildren().contains(this.imageView))
//                    group.getChildren().remove(this.imageView);
                animalView.setImage(new Image(new FileInputStream(finalPathToImage)));
            }

            if (flag1 == 1 || flag2 == 1 || flag3 == 1) {

                //  animalView = new ImageView(new Image(new FileInputStream(finalPathRightsToImage)));
                animalView.setImage(new Image(new FileInputStream(finalPathRightsToImage)));
                animalView.setScaleX(-1);
            }
            if (animal instanceof WildAnimal) {
                ImageView cageView = new ImageView(image);
                animalView.setOnMouseClicked(event -> {
                    animal.setMoved(false);
                    timeLine = now ;
                    cageView.setX(Utils.START_X + cellSize * animal.getX() - 40);
                    cageView.setY(Utils.START_Y + Utils.CELL_HEIGHT * animal.getY() - 30);
                    if (!group.getChildren().contains(cageView))
                    group.getChildren().add(cageView);
                    cageView.setViewport(new Rectangle2D(0, 0, image.getWidth() / 3, image.getHeight() / 3));
                    cage.cageAnimation(cageView).setCycleCount(Animation.INDEFINITE);
                    cage.cageAnimation(cageView).play();
                });
                if (!animal.isMoved()&&(now - timeLine)==50)
                {
                    if (group.getChildren().contains(cageView)) {
                        group.getChildren().remove(cageView);
                    }
                        ImageView freeView = new ImageView(image2);
                        freeView.setX(Utils.START_X + cellSize * animal.getX() - 40);
                        freeView.setY(Utils.START_Y + Utils.CELL_HEIGHT * animal.getY() - 30);

                    if (!group.getChildren().contains(freeView))
                        group.getChildren().add(freeView);
                    freeView.setViewport(new Rectangle2D(0, 0, image2.getWidth() / 3, image2.getHeight() / 3));
                    cage.cageAnimation(freeView).setCycleCount(Animation.INDEFINITE);
                    cage.cageAnimation(freeView).play();
                }
            }
            if (animal.isMoving()) {//ismoving
                if ((animal.getxDirection() == 1 && animal.getyDirection() == 1)) {//OK//ALANCHECKSHOD
                    if (animal instanceof Cow) {
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_OF_LEFT_DOWN_COW));
                        this.width = (int) (animalView.getImage().getWidth() / (Utils.COLUMNS_OF_LEFT_DOWN_COW));
                    }
                    if (animal instanceof Sheep) {
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_OF_LEFT_DOWN_COW));
                        this.width = (int) (animalView.getImage().getWidth() / (Utils.COLUMNS_OF_LEFT_DOWN_COW));

                    }
                    if (animal instanceof Hen) {
                        this.height = (int) (animalView.getImage().getHeight() / Math.ceil(count / Utils.COLUMNS_OF_HEN));
                        this.width = (int) (animalView.getImage().getWidth() / (Utils.COLUMNS_OF_HEN));
                    }
                    if (animal instanceof Lion) {
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_DOWN_OF_LION + 1));
                        this.width = (int) (animalView.getImage().getWidth() / (Utils.COLUMNS_LEFT_DOWN_OF_LION));
                    }
                    if (animal instanceof Bear) {
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_DOWN_OF_BEAR));
                        this.width = (int) (animalView.getImage().getWidth() / (Utils.COLUMNS_LEFT_DOWN_OF_BEAR));
                    }
                    if (animal instanceof Dog) {
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_DOWN_OF_DOG));
                        this.width = (int) (animalView.getImage().getWidth() / (Utils.COLUMNS_LEFT_DOWN_OF_DOG));
                    }
                    if (animal instanceof Cat) {
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_DOWN_OF_CAT));
                        this.width = (int) (animalView.getImage().getWidth() / (Utils.COLUMNS_LEFT_DOWN_OF_CAT));
                    }

                }
                if ((animal.getxDirection() == 1 && animal.getyDirection() == -1) || (animal.getxDirection() == -1 && animal.getyDirection() == -1)) {
                    if (animal instanceof Cow) {
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_LEFT_OF_COW));
                        this.width = (int) (animalView.getImage().getWidth() / (Utils.COLUMNS_UP_LEFT_OF_COW));
                    }
                    if (animal instanceof Sheep) {
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_LEFT_OF_SHEEP));
                        this.width = (int) (animalView.getImage().getWidth() / (Utils.COLUMNS_UP_LEFT_OF_SHEEP));

                    }
                    if (animal instanceof Hen) {
                        this.height = (int) (animalView.getImage().getHeight() / Math.ceil(count / Utils.COLUMNS_OF_HEN));
                        this.width = (int) (animalView.getImage().getWidth() / (Utils.COLUMNS_OF_HEN));
                    }
                    if (animal instanceof Lion) {
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_LEFT_OF_LION));
                        this.width = (int) (animalView.getImage().getWidth() / (Utils.COLUMNS_UP_LEFT_OF_LION + 1));
                    }
                    if (animal instanceof Bear) {
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_DOWN_OF_BEAR));
                        this.width = (int) (animalView.getImage().getWidth() / (Utils.COLUMNS_LEFT_DOWN_OF_BEAR));
                    }
                    if (animal instanceof Dog) {
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_LEFT_OF_DOG));
                        this.width = (int) (animalView.getImage().getWidth() / (Utils.COLUMNS_UP_LEFT_OF_DOG));
                    }
                    if (animal instanceof Cat) {
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_LEFT_OF_CAT));
                        this.width = (int) (animalView.getImage().getWidth() / (Utils.COLUMNS_UP_LEFT_OF_CAT));
                    }
                }
                if (animal.getxDirection() == 1 && animal.getyDirection() == 0) {///OK ALANCHECKSHOD
                    if (animal instanceof Cow) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_COLUMNS_LEFT_OF_COW);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_COLUMNS_LEFT_OF_COW));
                    }
                    if (animal instanceof Sheep) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_LEFT_OF_SHEEP);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_OF_SHEEP));
                    }
                    if (animal instanceof Hen) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_OF_HEN);
                        this.height = (int) (animalView.getImage().getHeight() / Math.ceil(count / Utils.COLUMNS_OF_HEN));

                    }
                    if (animal instanceof Lion) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_LEFT_OF_LION);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_OF_LION + 1));
                    }
                    if (animal instanceof Bear) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_LEFT_OF_BEAR);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_OF_BEAR));
                    }
                    if (animal instanceof Dog) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_LEFT_OF_DOG);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_OF_DOG));
                    }
                    if (animal instanceof Cat) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_LEFT_OF_CAT);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_OF_CAT));
                    }

                }
                if (animal.getxDirection() == -1 && animal.getyDirection() == 1) {//OKALANCHECKSHOD
                    if (animal instanceof Cow) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_OF_LEFT_DOWN_COW);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_OF_LEFT_DOWN_COW));
                    }
                    if (animal instanceof Sheep) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_LEFT_DOWN_OF_SHEEP);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_DOWN_OF_SHEEP));
                    }
                    if (animal instanceof Hen) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_OF_HEN);
                        this.height = (int) (animalView.getImage().getHeight() / Math.ceil(count / Utils.COLUMNS_OF_HEN));

                    }
                    if (animal instanceof Lion) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_LEFT_DOWN_OF_LION);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_DOWN_OF_LION));
                    }
                    if (animal instanceof Bear) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_LEFT_DOWN_OF_BEAR);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_DOWN_OF_BEAR));
                    }
                    if (animal instanceof Dog) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_LEFT_DOWN_OF_DOG);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_DOWN_OF_DOG));
                    }
                    if (animal instanceof Cat) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_LEFT_DOWN_OF_CAT);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_DOWN_OF_CAT));
                    }

                }
                if (animal.getxDirection() == -1 && animal.getyDirection() == -1) {//CURRENT//OK ALANCHECKSHOD

                    if (animal instanceof Cow) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_UP_LEFT_OF_COW);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_LEFT_OF_COW));
                    }
                    if (animal instanceof Sheep) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_UP_LEFT_OF_SHEEP);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_LEFT_OF_SHEEP));
                    }
                    if (animal instanceof Hen) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_OF_HEN);
                        this.height = (int) (animalView.getImage().getHeight() / Math.ceil(count / Utils.COLUMNS_OF_HEN));

                    }
                    if (animal instanceof Lion) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_UP_LEFT_OF_LION);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_LEFT_OF_LION + 1));
                    }
                    if (animal instanceof Bear) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_UP_LEFT_OF_BEAR);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_LEFT_OF_BEAR));
                    }
                    if (animal instanceof Dog) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_UP_LEFT_OF_DOG);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_LEFT_OF_DOG));
                    }
                    if (animal instanceof Cat) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_UP_LEFT_OF_CAT);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_LEFT_OF_CAT));
                    }

                }
                if (animal.getxDirection() == -1 && animal.getyDirection() == 0) {//OK
                    if (animal instanceof Cow) {
                        System.out.println("bala");

                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_COLUMNS_LEFT_OF_COW);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_COLUMNS_LEFT_OF_COW));
                    }
                    if (animal instanceof Sheep) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_EAT_SHEEP);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_OF_SHEEP));
                    }
                    if (animal instanceof Hen) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_OF_HEN);
                        this.height = (int) (animalView.getImage().getHeight() / Math.ceil(count / Utils.COLUMNS_OF_HEN));

                    }
                    if (animal instanceof Lion) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_LEFT_OF_LION);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_OF_LION + 1));
                    }
                    if (animal instanceof Bear) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_LEFT_OF_BEAR);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_OF_BEAR));
                    }
                    if (animal instanceof Dog) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_LEFT_OF_DOG);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_OF_DOG));
                    }
                    if (animal instanceof Cat) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_LEFT_OF_CAT);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_OF_CAT));
                    }
                }
                if (animal.getxDirection() == 0 && animal.getyDirection() == 1) {//OKALANCHEKCSHOD
                    if (animal instanceof Cow) {

                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_DOWN_OF_COW);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_DOWN_OF_COW));
                    }
                    if (animal instanceof Sheep) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_DOWN_OF_SHEEP);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_DOWN_OF_SHEEP));
                    }
                    if (animal instanceof Hen) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_OF_HEN);
                        this.height = (int) (animalView.getImage().getHeight() / Math.ceil(count / Utils.COLUMNS_OF_HEN));

                    }
                    if (animal instanceof Lion) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_DOWN_OF_LION);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_DOWN_OF_LION + 1));
                    }
                    if (animal instanceof Bear) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_DOWN_OF_BEAR);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_DOWN_OF_BEAR));
                    }
                    if (animal instanceof Dog) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_DOWN_OF_DOG);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_DOWN_OF_DOG));
                    }
                    if (animal instanceof Cat) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_DOWN_OF_CAT);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_DOWN_OF_CAT));
                    }

                }

                if (animal.getxDirection() == 0 && animal.getyDirection() == -1) {//OK//ALANCHECKSHOD
                    if (animal instanceof Cow) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_UP_OF_COW);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_OF_COW));
                    }
                    if (animal instanceof Sheep) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_UP_OF_SHEEP);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_OF_SHEEP));
                    }
                    if (animal instanceof Hen) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_OF_HEN);
                        this.height = (int) (animalView.getImage().getHeight() / Math.ceil(count / Utils.COLUMNS_OF_HEN));
                    }
                    if (animal instanceof Lion) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_UP_OF_LION);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_OF_LION + 1));
                    }
                    if (animal instanceof Bear) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_UP_OF_BEAR);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_OF_BEAR));
                    }
                    if (animal instanceof Dog) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_UP_OF_DOG);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_OF_DOG));
                    }
                    if (animal instanceof Cat) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_UP_OF_CAT);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_OF_CAT));
                    }

                }


            }
            if (!animal.isMoving()) {
                if (animal instanceof WildAnimal) {
                    if (animal instanceof Lion) {

                        this.width = (int) (792 / (Utils.COLUMNS_CAGE_LION));
                        this.height = (int) (568 / (4));

                    }
                } else if (animal instanceof ProducerAnimal) {
                    if (((ProducerAnimal) animal).isDead()) {
                        if (animal instanceof Cow) {
                            this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_OF_HEN);
                            this.height = (int) (animalView.getImage().getHeight() / (24 / Utils.COLUMNS_OF_HEN));
                            Duration.millis(5000);

                        }
                        if (animal instanceof Hen) {
                            System.out.println("shshsshshshshshsh");
                            this.width = (int) (390 / Utils.COLUMNS_OF_HEN);
                            this.height = (int) (350 / (25 / Utils.COLUMNS_OF_HEN));
                            // group.getChildren().remove(imageView);

                        }
                        if (animal instanceof Sheep) {
                            this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_OF_DEATH_SHEEP);
                            this.height = (int) (animalView.getImage().getHeight() / (24 / Utils.COLUMNS_OF_DEATH_SHEEP));


                        }
                    } else if (!((ProducerAnimal) animal).isDead() && !((ProducerAnimal) animal).dontShow()) {
                        System.out.println("mn daram mikhoraaaaaaaam");
                        if (animal instanceof Sheep) {
                            this.height = (int) Math.floor(animalView.getImage().getHeight() / 5);
                            this.width = (int) (animalView.getImage().getWidth() / 5);
                        }
                        if (animal instanceof Cow) {
                            this.height = (int) (animalView.getImage().getHeight() / 5 + 1);
                            this.width = (int) (animalView.getImage().getWidth() / 5);
                        }
                        if (animal instanceof Hen) {
                            this.height = (int) (animalView.getImage().getHeight() / 5 + 1);
                            this.width = (int) (animalView.getImage().getWidth() / 5);
                        }
                    }
//                if (((ProducerAnimal) animal).dontShow()) {
//                    if (imageView != null)
//                        imageView.setVisible(false);
//                }
                }
//                if ((((ProducerAnimal) animal).dontShow())) {
//                    if (group.getChildren().contains(imageView))
//                        group.getChildren().remove(imageView);
//                }
            }
            if (animal.isMoving()) {
                animalView.setX(Utils.START_X + cellSize * animal.getX() + animal.getxDirection() * animal.getSpeed());

                animalView.setY(Utils.START_Y + Utils.CELL_HEIGHT * animal.getY() + animal.getyDirection() * animal.getSpeed());
                this.setCycleDuration(Duration.millis(timeConstant / animal.getSpeed()));
            } else {
                animalView.setX(Utils.START_X + cellSize * animal.getX());
                animalView.setY(Utils.START_Y + Utils.CELL_HEIGHT * animal.getY());
                this.setCycleDuration(Duration.millis(2000));
            }
            return animalView;
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
        }

        return animalView;


    }

    public String getDirectionString(double xDirection, double yDirection) {
        if (xDirection == 1) {
            if (yDirection == 1)
                return "alireza";//rightDown
            else if (yDirection == 0)
                return "nima";//right
            else
                return "mehrdad";//rightUp

        } else if (xDirection == 0) {
            if (yDirection == 1)
                return "down.png";
            else if (yDirection == -1)
                return "up.png";

        } else if (xDirection == -1) {
            if (yDirection == 1)
                return "down_left.png";
            else if (yDirection == 0)
                return "left.png";
            else
                return "up_left.png";
        }
        return "";
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
