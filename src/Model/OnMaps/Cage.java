package Model.OnMaps;

import Model.SpriteAnimation;
import javafx.animation.Animation;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Cage {
    public Animation cageAnimation(ImageView imageView)
    {
        return new SpriteAnimation(imageView , Duration.millis(3000),9 , 3 , 0 , 0 , 780/3 ,780/3 );
    }
   private static Cage instanse = new Cage() ;

    public Cage() {
    }

    public Cage getInstanse() {
        return instanse;
    }
}
