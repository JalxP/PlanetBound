package model.data;

import model.utility.Utility;

import java.util.ArrayList;
import java.util.EnumMap;

public class CargoHold implements GameEnums
{
    private EnumMap<ResourceType, Integer> resources;

    private int currentLevel = 1;
    private final int maxLevel;

    private boolean canConvertResources;

    private Logger logger;

    public CargoHold(int maxLevel)
    {
        this.maxLevel = maxLevel;
        resources = new EnumMap<>(ResourceType.class);
        resources.put(ResourceType.BLUE, 0);
        resources.put(ResourceType.BLACK, 0);
        resources.put(ResourceType.GREEN, 0);
        resources.put(ResourceType.RED, 0);
        resources.put(ResourceType.ARTIFACT, 0);

        canConvertResources = false;

        logger = new Logger();
    }

    /* Getters */
    public int getResources(ResourceType resourceType)
    {
        return resources.get(resourceType);
    }

    public int getCurrentLevel()
    {
        return currentLevel;
    }

    public int getMaxLevel()
    {
        return maxLevel;
    }

    public int getCargoHoldMax()
    {
        return 6 * currentLevel;
    }

    /* Other methods*/

    public boolean canBeUpgraded()
    {
        /* Can upgrade if has at least 2 resources of each */
        return currentLevel < maxLevel &&
                resources.get(ResourceType.RED) > 1 &&
                resources.get(ResourceType.GREEN) > 1 &&
                resources.get(ResourceType.BLUE) > 1 &&
                resources.get(ResourceType.BLACK) > 1;
    }

    public void storeResource(ResourceType resourceType)
    {
        if (resourceType == ResourceType.ARTIFACT)
        {
            int amount = resources.get(ResourceType.ARTIFACT);
            resources.put(ResourceType.ARTIFACT, amount + 1);
            return;
        }

        switch (resourceType)
        {
            case RED:
                increaseResource(ResourceType.RED, "Red Resource");
                break;
            case GREEN:
                increaseResource(ResourceType.GREEN, "Green Resource");
                break;
            case BLUE:
                increaseResource(ResourceType.BLUE, "Blue Resource");
                break;
            case BLACK:
                increaseResource(ResourceType.BLACK, "Black Resource");
                break;
            default:
                break;
        }
    }

    public boolean hasResources()
    {
        for(ResourceType resourceType : resources.keySet())
            if (resources.get(resourceType) > 0)
                return true;

        return false;
    }

    public boolean hasResources(ResourceType resourceType)
    {
        return resources.get(resourceType) > 0;
    }

    private void increaseResource(ResourceType resourceType, String resourceName)
    {
        int resourcesGenerated = Utility.throwDie(6);
        logger.add("[OK]Found " + resourcesGenerated + " resource" + ((resourcesGenerated > 1 ) ? "s.": ".") + " Rolled: " + resourcesGenerated);

        int capacity = 6 * currentLevel;
        int before = resources.get(resourceType);
        int surplus = resourcesGenerated - (capacity - before);
        resources.put(resourceType, Math.min(before + resourcesGenerated, capacity));
        int stored = resources.get(resourceType) - before;

        logger.add("[OK]Stored " + stored + " " + resourceName + ((stored > 1) ? "s." : "."));

        if (surplus > 0)
            logger.add("[!]There was a surplus of " + surplus + " that could not be stored.");
    }

    public void setCanConvertResources(boolean option)
    {
        canConvertResources = option;
    }

    public boolean canConvertResources()
    {
        return canConvertResources && hasResources();
    }

    public boolean canAcquireShield()
    {
        return resources.get(ResourceType.BLACK) > 1 &&
                resources.get(ResourceType.GREEN) > 1 &&
                resources.get(ResourceType.BLUE) > 1;
    }

    public void acquireShield()
    {
        resources.put(ResourceType.BLACK, (resources.get(ResourceType.BLACK) - 1));
        resources.put(ResourceType.GREEN, (resources.get(ResourceType.GREEN) - 1));
        resources.put(ResourceType.BLUE, (resources.get(ResourceType.BLUE) - 1));

        logger.add("[!]Spent 1 Black resource, 1 Green resource and 1 Blue resource.");
    }

    public boolean canAcquireAmmo()
    {
        return resources.get(ResourceType.BLACK) > 0 &&
                resources.get(ResourceType.BLUE) > 0;
    }

    public void acquireAmmo()
    {
        resources.put(ResourceType.BLACK, (resources.get(ResourceType.BLACK) - 1));
        resources.put(ResourceType.BLUE, (resources.get(ResourceType.BLUE) - 1));

        logger.add("[!]Spent 1 Black resource and 1 Blue resource.");
    }

    public boolean canAcquireFuel()
    {
        return resources.get(ResourceType.BLACK) > 0 &&
                resources.get(ResourceType.RED) > 0 &&
                resources.get(ResourceType.GREEN) > 0;
    }

    public void acquireFuel()
    {
        resources.put(ResourceType.BLACK, (resources.get(ResourceType.BLACK) - 1));
        resources.put(ResourceType.GREEN, (resources.get(ResourceType.GREEN) - 1));
        resources.put(ResourceType.RED, (resources.get(ResourceType.RED) - 1));

        logger.add("[!]Spent 1 Black resource, 1 Green resource and 1 Red resource.");
    }

    public boolean canAcquireDroneRepair()
    {
        return resources.get(ResourceType.BLACK) > 0 &&
                resources.get(ResourceType.RED) > 0 &&
                resources.get(ResourceType.GREEN) > 0 &&
                resources.get(ResourceType.BLUE) > 0;
    }

    public void acquireDroneRepair()
    {
        resources.put(ResourceType.BLACK, (resources.get(ResourceType.BLACK) - 1));
        resources.put(ResourceType.BLUE, (resources.get(ResourceType.BLUE) - 1));
        resources.put(ResourceType.GREEN, (resources.get(ResourceType.GREEN) - 1));
        resources.put(ResourceType.RED, (resources.get(ResourceType.RED) - 1));

        logger.add("[!]Spent 1 Black resource, 1 Blue resource, 1 Green resource and 1 Red resource.");
    }

    /* Log */
    public ArrayList<String> getAllLogs()
    {
        return logger.getLogAndClear();
    }

}
