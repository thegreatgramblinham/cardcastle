package grid;

import card.CardBase;
import gameObjects.RenderedGameObject;
import javafx.scene.image.Image;

public abstract class CardGrid extends RenderedGameObject
{
    //Variables
    private int _width;
    private int _height;
    private CardBase[][] _grid;

    //Constructor
    public CardGrid(Image sprite, int width, int height)
    {
        super(sprite);
        _width = width;
        _height = height;
        _grid = new CardBase[_width][_height];
    }

    //Get Methods

    //Set Methods

    //Public Methods

    //Private Methods

}
