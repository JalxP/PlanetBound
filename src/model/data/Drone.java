package model.data;

import java.io.Serializable;

import static model.data.Constants.*;

public class Drone implements GameEnums, Serializable
{
    private int health;
    private final int maxHealth;
    private ResourceType resourceCollected;

    public Drone()
    {
        maxHealth = DRONE_MAX_HEALTH;
        health = maxHealth;
        resourceCollected = ResourceType.NONE;
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
    }

    public boolean isOperational()
    {
        return health > 0;
    }

    public void setToMaxHealth()
    {
        health = maxHealth;
    }
}
