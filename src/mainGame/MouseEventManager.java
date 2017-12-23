package mainGame;

import Interfaces.IGameWorldObject;
import SectorBase.Sector;
import SectorBase.SectorMap;
import gameObjects.RenderedGameObject;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.util.Iterator;

public class MouseEventManager
{
    //Variables
    private Sector _map;

    //Constructor
    public MouseEventManager(Sector sector)
    {
        _map = sector;
    }

    //Public Methods
//    public void AddTrackedObject(RenderedGameObject obj)
//    {
//        _map.AddObject(ob);
//    }
//
//    public void RemoveTrackedObject(RenderedGameObject obj)
//    {
//        _map.RemoveObject(obj);
//    }


    public void OnMousePressed(MouseEvent e)
    {
        Iterator<IGameWorldObject> iter
                = _map.GetObjectsAtPoint(new Point(
                        ViewPort.SecLocX((int)e.getX()),
                        ViewPort.SecLocY((int)e.getY())));

        if(iter == null) return;

        while(iter.hasNext())
        {
            RenderedGameObject obj = (RenderedGameObject)iter.next();

            if(obj.contains(
                    ViewPort.SecLocX((int)e.getX()),
                    ViewPort.SecLocY((int)e.getY())))
                obj.OnMousePressed(e);
        }
    }

    public void OnMouseReleased(MouseEvent e)
    {
        Iterator<IGameWorldObject> iter
                = _map.GetObjectsAtPoint(new Point(
                ViewPort.SecLocX((int)e.getX()),
                ViewPort.SecLocY((int)e.getY())));

        if(iter == null) return;

        while(iter.hasNext())
        {
            RenderedGameObject obj = (RenderedGameObject)iter.next();

            if(obj.contains(
                    ViewPort.SecLocX((int)e.getX()),
                    ViewPort.SecLocY((int)e.getY())))
                obj.OnMouseReleased(e);
        }
    }

    public void OnMouseMove(MouseEvent e)
    {
        int x = ViewPort.SecLocX((int)e.getX());
        int y = ViewPort.SecLocY((int)e.getY());

        Iterator<IGameWorldObject> iter
                = _map.GetObjectsAtPoint(new Point(x,y));

        if(iter == null) return;

        while(iter.hasNext())
        {
            RenderedGameObject obj = (RenderedGameObject)iter.next();

            if(obj.contains(x,y))
                obj.OnMouseOver(e);
        }
    }

    public void OnMouseDragged(MouseEvent e)
    {
        int x = ViewPort.SecLocX((int)e.getX());
        int y = ViewPort.SecLocY((int)e.getY());

        Iterator<IGameWorldObject> iter
                = _map.GetObjectsAtPoint(new Point(x,y));

        if(iter == null) return;

        while(iter.hasNext())
        {
            RenderedGameObject obj = (RenderedGameObject)iter.next();

            if(obj.contains(x,y))
                obj.OnMouseDragged(e);
        }
    }

    //Private Methods


}
