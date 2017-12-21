package mainGame;

import Global.Tuple;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.util.HashMap;

public class GameConstants
{

    //Render Group Constants
    public static final int SKY_RENDER_GROUP = 0;
    public static final int ROOM_RENDER_GROUP = 1;
    public static final int PLAYER_RENDER_GROUP = 3;
    public static final int PLAYER_PROJECTILE_RENDER_GROUP = 3;
    public static final int ENEMY_RENDER_GROUP = 3;
    public static final int ENEMY_PROJECTILE_RENDER_GROUP = 3;
    public static final int PROP_RENDER_GROUP_BACK = 2;
    public static final int PROP_RENDER_GROUP_MID = 4;
    public static final int PROP_RENDER_GROUP_MIDFORWARD = 5;
    public static final int PROP_RENDER_GROUP_FORWARD = 6;
    public static final int TRIGGER_RENDER_GROUP = Integer.MAX_VALUE; //needs to be the highest.

    //Engine Run Constants
    public static final int ENGINE_FPS = 60;
    public static final Point GAME_STARTING_POINT = new Point(300,300);

    //Sector Constants
    public static final int DEFAULT_SECTOR_WIDTH = 2000;//3500;
    public static final int DEFAULT_SECTOR_HEIGHT = 2000;//1050;
    public static final int DEFAULT_SECTOR_GRID_UNIT_SIZE = 30;
    public static final float GRAVITY = 0.5F;

    //Private Static Fields
    private static HashMap<KeyCode, Boolean> keyPressed = new HashMap<>();
    private static HashMap<MouseButton, Tuple<Boolean, MouseEvent>> mousePressed = new HashMap<>();

    //Private Constructor
    private GameConstants(){}

    //Public Static Methods
    public static boolean IsKeyPressed(KeyCode key)
    {
        if(keyPressed.containsKey(key))
            return keyPressed.get(key);

        return false;
    }

    public static void SetKeyPressed(KeyCode key)
    {
        if(keyPressed.containsKey(key))
            keyPressed.remove(key);

        keyPressed.put(key, true);
    }

    public static void SetKeyReleased(KeyCode key)
    {
        if(keyPressed.containsKey(key))
            keyPressed.remove(key);

        keyPressed.put(key, false);
    }

    public static Tuple<Boolean, MouseEvent> IsMousePressed(MouseButton button)
    {
        if(mousePressed.containsKey(button))
            return mousePressed.get(button);

        return new Tuple<>(false, null);
    }

    public static void SetMousePressed(MouseButton button, MouseEvent e)
    {
        if(mousePressed.containsKey(button))
            mousePressed.remove(button);

        mousePressed.put(button, new Tuple<>(true, e));
    }

    public static void SetMouseReleased(MouseButton button, MouseEvent e)
    {
        if(mousePressed.containsKey(button))
            mousePressed.remove(button);

        mousePressed.put(button, new Tuple<>(false, e));
    }

    //Private Methods
}