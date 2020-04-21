package model.data;

import model.data.Constants.*;

import static model.data.Constants.*;

public class Drone implements GameEnums
{
    private int health = DRONE_MAX_HEALTH;
    private boolean collectedResource = false;
    private ResourceType resourceCollected;

    public Drone()
    {

    }

}
