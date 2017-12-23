package card;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.io.File;

public class TestCreatureCard extends CreatureCardBase
{
    //Variables

    //Constructor
    public TestCreatureCard()
    {
        super(new Rectangle(98, 128), new Image(
                new File("src/imageAssets/cards/testCard.png").toURI().toString()));
    }

    //Get Methods

    //Set Methods

    //Public Methods

    @Override
    public void OnMouseOver(MouseEvent e)
    {
        super.OnMouseOver(e);

        Point currLoc = this.NGetLocation();
        currLoc.x += 1;
        this.NSetLocation(currLoc);
    }

    //Private Methods

}
