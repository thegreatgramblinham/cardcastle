package mainGame;

import Interfaces.IGameWorldObject;
import SectorBase.SectorMap;
import gameObjects.RenderedGameObject;
import javafx.scene.input.MouseEvent;

import java.util.Iterator;

public class MouseEventManager
{
    //Variables
    private SectorMap _map;

    private int _width;
    private int _height;
    private int _gridUnitSize;

    //Constructor
    public MouseEventManager(int width, int height, int gridUnitSize)
    {
        _width = width;
        _height = height;
        _gridUnitSize = gridUnitSize;
        _map = new SectorMap(width, height, gridUnitSize);
    }

    //Public Methods
    public void AddTrackedObject(RenderedGameObject obj)
    {
        _map.InsertObject(obj);
    }

    public void RemoveTrackedObject(RenderedGameObject obj)
    {
        _map.RemoveObject(obj);
    }

    public void ClearTrackedObjects()
    {
        _map = new SectorMap(_width, _height, _gridUnitSize);
    }

    public void OnMousePressed(MouseEvent e)
    {
        Iterator<IGameWorldObject> iter
                = _map.GetObjectsAtSubSector(
                        ViewPort.SecLocX((int)e.getX()),
                        ViewPort.SecLocY((int)e.getY()));

        while(iter.hasNext())
        {
            RenderedGameObject obj = (RenderedGameObject)iter.next();

            if(obj.contains(e.getX(), e.getY()))
                obj.OnMousePressed(e);
        }
    }

    public void OnMouseReleased(MouseEvent e)
    {
        Iterator<IGameWorldObject> iter
                = _map.GetObjectsAtSubSector(
                        ViewPort.SecLocX((int)e.getX()),
                        ViewPort.SecLocY((int)e.getY()));

        while(iter.hasNext())
        {
            RenderedGameObject obj = (RenderedGameObject)iter.next();

            if(obj.contains(e.getX(), e.getY()))
                obj.OnMouseReleased(e);
        }
    }

    public void OnMouseMove(MouseEvent e)
    {
        Iterator<IGameWorldObject> iter
                = _map.GetObjectsAtSubSector(
                        ViewPort.SecLocX((int)e.getX()),
                        ViewPort.SecLocY((int)e.getY()));

        while(iter.hasNext())
        {
            RenderedGameObject obj = (RenderedGameObject)iter.next();

            if(obj.contains(e.getX(), e.getY()))
                obj.OnMouseOver(e);
        }
    }

    //Private Methods


}
