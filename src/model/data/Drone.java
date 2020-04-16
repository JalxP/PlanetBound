package model.data;

public class Drone implements GameEnums ,Constants
{
    private int health = DRONE_MAX_HEALTH;
    private boolean collectedResource = false;
    private ResourceType resourceCollected;

    public Drone()
    {

    }

}
