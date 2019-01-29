package Model;

import Model.Animals.*;
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
    ImageView animalView = new ImageView();
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

    public SpriteAnimalAnimation(Animal animal, int timeConstant, Group group) {
        this.animal = animal;
        this.timeConstant = timeConstant;
        this.group = group;
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
            imageView.setFitWidth(Utils.CELL_WIDTH);
            imageView.setFitHeight(Utils.CELL_HEIGHT);
            System.out.println(height);
            if (animal.isMoving()) {
                imageView.setX(imageView.getX() + animal.getxDirection() * cellSize / count);
                imageView.setY(imageView.getY() + animal.getyDirection() * cellSize / count);
            }
            lastIndex = index;
        }

//        group.getChildren().remove(imageView);
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
            System.out.println("/////////////////////////////////////////////");
        }

        pathToImage = pathToImage.concat("\\");
        if (animal.isMoving()) {
            System.out.println("itsmoving");

            if (!getDirectionString(animal.getxDirection(), animal.getyDirection()).equals("alireza") && !getDirectionString(animal.getxDirection(),
                    animal.getyDirection()).equals("nima") && !getDirectionString(animal.getxDirection(), animal.getyDirection()).equals("mehrdad")) {
                finalPathToImage = pathToImage.concat(getDirectionString(animal.getxDirection(), animal.getyDirection()));
                System.out.println(finalPathToImage);
            } else if (getDirectionString(animal.getxDirection(), animal.getyDirection()).equals("alireza")) {
                finalPathRightsToImage = pathToImage.concat("down_left.png");
                flag1 = 1;
                System.out.println(finalPathRightsToImage);

            } else if (getDirectionString(animal.getxDirection(), animal.getyDirection()).equals("nima")) {
                finalPathRightsToImage = pathToImage.concat("left.png");
                flag2 = 1;
                System.out.println(4);

            } else if (getDirectionString(animal.getxDirection(), animal.getyDirection()).equals("mehrdad")) {
                finalPathRightsToImage = pathToImage.concat("up_left.png");
                flag3 = 1;

            }

        } else {
            if (animal instanceof WildAnimal)
                pathToImage = pathToImage.concat("cage.png");
            else if (animal instanceof ProducerAnimal)
                pathToImage = pathToImage.concat("eat.png");
        }


        try {
            if (flag2 != 1 && flag1 != 1 && flag3 != 1) {
                System.out.println(finalPathToImage);

                // animalView = new ImageView(new Image(new FileInputStream(finalPathToImage)));
                if (group.getChildren().contains(this.imageView))
                    group.getChildren().remove(this.imageView);
                animalView.setImage(new Image(new FileInputStream(finalPathToImage)));
            }

            if (flag1 == 1 || flag2 == 1 || flag3 == 1) {
                System.out.println(finalPathRightsToImage + "alll");

                //  animalView = new ImageView(new Image(new FileInputStream(finalPathRightsToImage)));
                animalView.setImage(new Image(new FileInputStream(finalPathRightsToImage)));
                System.out.println("qolamreza");
                animalView.setScaleX(-1);
            }
            if (true) {//ismoving
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
                        System.out.println("shshshshshshshhshshhsssh");
                    }
                    if (animal instanceof Lion) {
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_DOWN_OF_LION));
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
                        System.out.println("shhshshshshshshshshshsh");
                    }
                    if (animal instanceof Lion) {
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_LEFT_OF_LION));
                        this.width = (int) (animalView.getImage().getWidth() / (Utils.COLUMNS_UP_LEFT_OF_LION));
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
                        System.out.println("shshshshshshshshshshshshshshshshshsh");

                    }
                    if (animal instanceof Lion) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_LEFT_OF_LION);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_OF_LION));
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
                        System.out.println("shshshshshshshshshshshshshshshshshsh");

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
                        System.out.println("shshshshshshshshshshshshshshshshshsh");

                    }
                    if (animal instanceof Lion) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_UP_LEFT_OF_LION);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_LEFT_OF_LION));
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
                        System.out.println("shshshshshshshshshshshshshshshshshsh");

                    }
                    if (animal instanceof Lion) {
                        this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_LEFT_OF_LION);
                        this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_LEFT_OF_LION));
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
                    if (animal.getxDirection() == 0 && animal.getyDirection() == 1) {//OKALANCHEKCSHOD
                        if (animal instanceof Cow) {
                            System.out.println("bala");

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
                            System.out.println("shshshshshshshshshshshshshshshshshsh");

                        }
                        if (animal instanceof Lion) {
                            this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_DOWN_OF_LION);
                            this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_DOWN_OF_LION));
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
                            System.out.println("shshshshshshshshshshshshshshshshshsh");
                        }
                        if (animal instanceof Lion) {
                            this.width = (int) (animalView.getImage().getWidth() / Utils.COLUMNS_UP_OF_LION);
                            this.height = (int) (animalView.getImage().getHeight() / (count / Utils.COLUMNS_UP_OF_LION));
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
            }
            if (animal.isMoving()) {
                animalView.setX(Utils.START_X + cellSize * animal.getX() + animal.getxDirection() * animal.getSpeed());

                animalView.setY(Utils.START_Y + Utils.CELL_HEIGHT * animal.getY() + animal.getyDirection() * animal.getSpeed());
                this.setCycleDuration(Duration.millis(timeConstant / animal.getSpeed()));
            } else {
                animalView.setX(170 + cellSize * animal.getX());
                animalView.setY(200 + cellSize * animal.getY());
                this.setCycleDuration(Duration.millis(timeConstant));
            }
            return animalView;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
