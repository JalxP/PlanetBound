package model.data;

import static model.data.Constants.*;

public class Drone implements GameEnums
{
    private int health;
    private ResourceType resourceCollected;
    private boolean operational;

    public Drone()
    {
        health = DRONE_MAX_HEALTH;
        resourceCollected = ResourceType.NONE;
        operational = true;
    }

    public void storeResource(ResourceType resourceType)
    {
        resourceCollected = resourceType;
    }

    public ResourceType getStoredResource()
    {
        ResourceType storedResource = resourceCollected;
        resourceCollected = ResourceType.NONE;
        return storedResource;
    }

    public int getHealth()
    {
        return health;
    }

    public void decreaseHealth()
    {
        health--;
        operational = isOperational();
    }

    public boolean isOperational()
    {
        return health > 1;
    }

}
