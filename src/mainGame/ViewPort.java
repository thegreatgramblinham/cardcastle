package mainGame;

import java.awt.*;

public class ViewPort
{
    /*
        Controls the 'window' that the player is able to see.
        **NOTE: This class has static dependencies, only one instance is allowed.**
    */

    //Private Constants
    private static final int SCROLL_SPEED = 2;
    private static final double LEFT_SCROLL_PARTITION = (1.0/2.5);
    private static final double RIGHT_SCROLL_PARTITION = (1.5/2.5);
    private static final double TOP_SCROLL_PARTITION = (3.0/5.0);
    private static final double BOTTOM_SCROLL_PARTITION = (4.0/5.0);

    //Public Static Fields
    public static final int X_RES = 1067; //1024;
    public static final int Y_RES = 600; //768;

    //Private Fields
    private static Point _location;

    private boolean _isLocked = false;

    private int _xRes;
    private int _yRes;

    private int _minLeft;
    private int _minTop;
    private int _maxRight;
    private int _maxBottom;

    //Constructor
    public ViewPort(int width, int height,
            int minLeft, int minTop, int maxRight, int maxBottom)
    {
        _location = new Point(
                GameConstants.GAME_STARTING_POINT.x,
                GameConstants.GAME_STARTING_POINT.y);
        _xRes = width;
        _yRes = height;
        _minLeft = minLeft;
        _minTop = minTop;
        _maxRight = maxRight;
        _maxBottom = maxBottom;
    }

    //Get Methods
    public Point GetLocation()
    {
        return _location;
    }

    public int GetWidth()
    {
        return _xRes;
    }

    public int GetHeight()
    {
        return _yRes;
    }

    //Set Methods
    public void SetLocation(Point p)
    {
        if(_isLocked) return;

        _location = p;
    }

    //Public Methods
    public void ScrollIntoView(Point p)
    {
        if(_isLocked) return;

        int xPos = GetViewRelativeX(p.x);
        int yPos = GetViewRelativeY(p.y);
        if( xPos < (_xRes * LEFT_SCROLL_PARTITION))
        {
            if(_location.x > _minLeft)
                ScrollLeft();
        }
        if( xPos > (_xRes * RIGHT_SCROLL_PARTITION))
        {
            if(_location.x < _maxRight - X_RES)
                ScrollRight();
        }
        if(yPos < (_yRes * TOP_SCROLL_PARTITION))
        {
            if(_location.y > _minTop)
                ScrollUp();
        }
        if(yPos > (_yRes * BOTTOM_SCROLL_PARTITION))
        {
            if(_location.y < _maxBottom - Y_RES)
                ScrollDown();
        }
    }

    public void JumpToPoint(Point p)
    {
        if(_isLocked) return;

        int xPos = p.x - (int)(X_RES * LEFT_SCROLL_PARTITION);
        int yPos = p.y - (int)(Y_RES * TOP_SCROLL_PARTITION);

        if(xPos > _maxRight - X_RES)
            xPos = _maxRight - X_RES;
        else if(xPos < _minLeft)
            xPos = _minLeft;

        if(yPos > _maxBottom - Y_RES)
            yPos = _maxBottom - Y_RES;
        else if(yPos < _minTop)
            yPos = _minTop;

        _location = new Point(xPos, yPos);
    }

    public void Lock()
    {
        _isLocked = true;
    }

    public void Unlock()
    {
        _isLocked = false;
    }

    //Private Methods
    private void ScrollLeft()
    {
        _location = new Point(_location.x - SCROLL_SPEED,
                _location.y);
    }

    private void ScrollRight()
    {
        _location = new Point(_location.x + SCROLL_SPEED,
                _location.y);
    }

    private void ScrollUp()
    {
        _location = new Point(_location.x,
                _location.y - SCROLL_SPEED);
    }

    private void ScrollDown()
    {
        _location = new Point(_location.x,
                _location.y + SCROLL_SPEED);
    }

    //Public Static Methods
    public static int GetViewRelativeX(int x)
    {
        return x -_location.x;
    }

    public static int GetViewRelativeY(int y)
    {
        return y -_location.y;
    }

    public static int SecLocX(int offset)
    {
        return GameConstants.GAME_STARTING_POINT.x + offset;
    }

    public static int SecLocY(int offset)
    {
        return GameConstants.GAME_STARTING_POINT.y + offset;
    }

    public static int DrawLocX(int offset)
    {
        return  GetDrawPoint().x + offset;
    }

    public static int DrawLocY(int offset)
    {
        return  GetDrawPoint().y + offset;
    }

    //Private Static Methods
    private static Point GetDrawPoint()
    {
        return new Point(-_location.x, -_location.y);
    }
}
