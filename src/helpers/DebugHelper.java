package helpers;


import gameObjects.GameObject;

public final class DebugHelper
{

    //Variables

    //Private Constructor
    private DebugHelper(){}

    //Get Methods

    //Set Methods

    //Public Methods
    public static String BuildFormattedPropertyString(GameObject gObj)
    {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%-15s%s", "Name: ",
                gObj.GetAlias()) + "\n");

        sb.append(String.format("%-15s%s", "X: ",
                gObj.x) + "\n");
        sb.append(String.format("%-15s%s", "Y: ",
                gObj.y) + "\n");


        if(gObj.GetVelocity() == null)
        {
            sb.append(String.format("%-15s%.6f", "Speed: ",
                    0.0F) + "\n");
            sb.append(String.format("%-15s%.6f", "Direction: ",
                    0.0F) + "\n");
        }
        else
        {
            sb.append(String.format("%-15s%.6f", "Speed: ",
                    gObj.GetVelocity().GetSpeed()) + "\n");
            sb.append(String.format("%-15s%.6f", "Direction: ",
                    gObj.GetVelocity().GetRadianRotation()) + "\n");
        }

        sb.append(String.format("%-15s%.6f", "Mass: ",
                gObj.GetMass()) + "\n");

        return sb.toString();
    }

    //Private Methods

}
