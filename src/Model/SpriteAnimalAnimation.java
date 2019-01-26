package Model;

import Model.Animals.*;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SpriteAnimalAnimation extends Transition {
    private Animal animal;
    private ImageView imageView;
    private int timeConstant;
    private int count = 24;
    private int columns = 24;
    private int offsetX;
    private int offsetY;
    private int width;
    private int height;
    private int lastIndex;
    private final int cellSize = 14;

    public SpriteAnimalAnimation(Animal animal, int timeConstant) {
        this.animal = animal;
        this.timeConstant = timeConstant;
        this.imageView = getAnimalImageView();
        this.setInterpolator(Interpolator.LINEAR);
    }

    @Override
    protected void interpolate(double k) {
        final int index = Math.min((int) Math.floor(k * count), count - 1);
        if (index != lastIndex) {
            final int x = (index % columns) * width + offsetX;
            final int y = (index / columns) * height + offsetY;
            imageView.setViewport(new Rectangle2D(x, y, width, height));
            if (animal.isMoving()) {
                imageView.setX(imageView.getX() + animal.getxDirection() * cellSize / count);
                imageView.setY(imageView.getY() + animal.getyDirection() * cellSize / count);
            }
            lastIndex = index;
        }
    }

    public ImageView getAnimalImageView(){
        String pathToImage = "src/GUI/Textures/Animals/Africa/";
        if (animal instanceof Cat)
            pathToImage = pathToImage.concat("Cat");
        else if (animal instanceof Dog)
            pathToImage = pathToImage.concat("Dog");
        else if (animal instanceof WildAnimal) {
            if (animal instanceof Bear)
                pathToImage = pathToImage.concat("Grizzly");
            else
                pathToImage = pathToImage.concat("Lion");
        } else if (animal instanceof ProducerAnimal) {
            if (animal instanceof Sheep)
                pathToImage = pathToImage.concat("Sheep");
            else if (animal instanceof Cow)
                pathToImage = pathToImage.concat("Cow");
            else
                pathToImage = pathToImage.concat("GuineaFowl");
        }
        pathToImage = pathToImage.concat("/");
        if (animal.isMoving())
            pathToImage = pathToImage.concat(getDirectionString(animal.getxDirection(), animal.getyDirection()));
        else {
            if (animal instanceof WildAnimal)
                pathToImage = pathToImage.concat("cage.png");
            else if (animal instanceof ProducerAnimal)
                pathToImage = pathToImage.concat("eat.png");
        }

        ImageView animalView = null;
        try {
            animalView = new ImageView(new Image(new FileInputStream(pathToImage)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.height = (int)animalView.getFitHeight();
        this.width = (int)animalView.getFitWidth() / this.count;
        if (animal.isMoving()) {
            animalView.setX(170 + cellSize * animal.getX() + animal.getxDirection() * animal.getSpeed());
            animalView.setY(200 + cellSize * animal.getY() + animal.getyDirection() * animal.getSpeed());
            this.setCycleDuration(Duration.millis(timeConstant / animal.getSpeed()));
        } else {
            animalView.setX(170 + cellSize * animal.getX());
            animalView.setY(200 + cellSize * animal.getY());
            this.setCycleDuration(Duration.millis(timeConstant));
        }
        animalView.setViewport(new Rectangle2D(0, 0, this.width, this.height));
        return animalView;
    }

    public String getDirectionString (double xDirection, double yDirection) {
        if (xDirection == 1) {
            if (yDirection == 1)
                return "down_right.png";
            else if (yDirection == 0)
                return "right.png";
            else
                return "up_right.png";

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
                return "left_up.png";
        }
        return "";
    }
}
