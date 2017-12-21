package gameObjects;

import javafx.scene.image.Image;

public abstract class RenderedGameObject
{
    //Variables
    private Image _sprite;

    //Constructor
    protected RenderedGameObject(Image sprite)
    {
        _sprite = sprite;
    }

    //Public Methods
    public Image GetSprite()
    {
        return _sprite;
    }
}
