package card;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import mainGame.ViewPort;

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
    public void OnMouseDragged(MouseEvent e)
    {
        super.OnMouseDragged(e);

        int x = ViewPort.SecLocX((int)e.getX()) - (int)this.GetHalfWidth();
        int y = ViewPort.SecLocY((int)e.getY()) - (int)this.GetHalfHeight();

        this.NSetLocation(new Point(x,y));
    }

    //Private Methods

}
