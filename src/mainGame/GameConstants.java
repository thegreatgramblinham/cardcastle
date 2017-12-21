package mainGame;

import javafx.scene.input.KeyCode;

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
    public static final Point GAME_STARTING_POINT = new Point(128,300);

    //Sector Constants
    public static final int DEFAULT_SECTOR_WIDTH = 5000;//3500;
    public static final int DEFAULT_SECTOR_HEIGHT = 4000;//1050;
    public static final int DEFAULT_SECTOR_GRID_UNIT_SIZE = 30;
    public static final float GRAVITY = 0.5F;

    //Private Static Fields
    private static HashMap<KeyCode, Boolean> keyPressed = new HashMap<>();

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

    //Private Methods

}
