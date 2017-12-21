package gameObjects;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.awt.*;

public abstract class RenderedGameObject extends GameObject
{
    //Variables
    private Image _sprite;

    //Constructor
    protected RenderedGameObject(Rectangle bounds, Image sprite)
    {
        super(bounds);
        _sprite = sprite;
    }

    //Public Methods
    public Image GetSprite()
    {
        return _sprite;
    }

    public void OnMousePressed(MouseEvent e) { }

    public void OnMouseReleased(MouseEvent e) { }

    public void OnMouseOver(MouseEvent e) { }
}
