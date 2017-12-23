package gameObjects;

import GameObjectBase.GameWorldObject;
import PhysicsBase.Vectors.VelocityVector;
import mainGame.ViewPort;

import java.awt.*;

public abstract class GameObject extends GameWorldObject
{
    public GameObject(Rectangle size)
    {
        super(size, size, false, 1.0f);
        this.SetVelocity(new VelocityVector(0.0, 0.0));
    }

    public Point GetGameDrawPoint()
    {
        Point p = this.getLocation();

        return new Point(ViewPort.DrawLocX(p.x), ViewPort.DrawLocY(p.y));
    }

    public Point GetGameHitBoxDrawPoint()
    {
        Point p = new Point((int)this.GetHitBox().getX(), (int)this.GetHitBox().getY());

        return new Point(ViewPort.DrawLocX(p.x), ViewPort.DrawLocY(p.y));
    }

    //public abstract void Draw(GraphicsContext gc);
}
