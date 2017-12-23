package card;

import gameObjects.RenderedGameObject;
import javafx.scene.image.Image;

import java.awt.*;

public abstract class CardBase extends RenderedGameObject
{
    //Variables

    //Constructor
    protected CardBase(Rectangle bounds, Image sprite)
    {
        super(bounds, sprite);
        this.SetCanCollide(false);
    }

    //Get Methods

    //Set Methods

    //Public Methods

    //Private Methods

}
