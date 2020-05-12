package model.data;

import static model.data.Constants.*;

public class Drone implements GameEnums
{
    private int health;
    private final int maxHealth;
    private ResourceType resourceCollected;
    private boolean operational;

    public Drone()
    {
        maxHealth = DRONE_MAX_HEALTH;
        health = maxHealth;
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

    public void repair()
    {
        health = maxHealth;
    }

    public int getHealth()
    {
        return health;
    }

    public int getDroneHealthMax()
    {
        return maxHealth;
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
