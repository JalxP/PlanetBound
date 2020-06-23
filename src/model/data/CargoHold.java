package model.data;

import model.utility.Utility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;

public class CargoHold implements GameEnums, Serializable
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

    private boolean hasAmountOfEachResource(int redAmount, int greenAmount, int blueAmount, int blackAmount)
    {
        return resources.get(ResourceType.RED) >= redAmount &&
                resources.get(ResourceType.GREEN) >= greenAmount &&
                resources.get(ResourceType.BLUE) >= blueAmount &&
                resources.get(ResourceType.BLACK) >= blackAmount;
    }

    public boolean canUpgradeWeaponSystem()
    {
        return hasAmountOfEachResource(2,2,2,2);
    }

    public void upgradeWeaponSystem()
    {
        decreaseResource(ResourceType.RED, 2);
        decreaseResource(ResourceType.GREEN, 2);
        decreaseResource(ResourceType.BLUE,2);
        decreaseResource(ResourceType.BLACK, 2);

        logger.add("[OK]Cost: -2 RED resources, -2 GREEN resources, -2 BLUE resources, -2 BLACK resources");
    }

    public boolean canUpgradeCrew()
    {
        return hasAmountOfEachResource(1,1,1,1);
    }

    public void upgradeCrew()
    {
        decreaseResource(ResourceType.RED,1);
        decreaseResource(ResourceType.GREEN,1);
        decreaseResource(ResourceType.BLUE,1);
        decreaseResource(ResourceType.BLACK,1);

        logger.add("[OK]Cost: -1 RED resources, -1 GREEN resources, -1 BLUE resources, -1 BLACK resources");
    }

    public boolean canUpgradeFullArmor()
    {
        return hasAmountOfEachResource(1,1,1,1);
    }

    public void upgradeFullArmor()
    {
        decreaseResource(ResourceType.RED,1);
        decreaseResource(ResourceType.GREEN,1);
        decreaseResource(ResourceType.BLUE,1);
        decreaseResource(ResourceType.BLACK,1);

        logger.add("[OK]Cost: -1 RED resources, -1 GREEN resources, -1 BLUE resources, -1 BLACK resources");
    }

    public boolean canUpgradeNewDrone()
    {
        return hasAmountOfEachResource(2,2,2,2);
    }

    public void upgradeNewDrone()
    {
        decreaseResource(ResourceType.RED, 2);
        decreaseResource(ResourceType.GREEN, 2);
        decreaseResource(ResourceType.BLUE,2);
        decreaseResource(ResourceType.BLACK, 2);

        logger.add("[OK]Cost: -2 RED resources, -2 GREEN resources, -2 BLUE resources, -2 BLACK resources");
    }

    public boolean canBeUpgraded()
    {
        return currentLevel < maxLevel && hasAmountOfEachResource(2,2,2,2);
    }

    public void upgradeCargoHold()
    {
        currentLevel++;
        decreaseResource(ResourceType.RED, 2);
        decreaseResource(ResourceType.GREEN, 2);
        decreaseResource(ResourceType.BLUE,2);
        decreaseResource(ResourceType.BLACK, 2);

        logger.add("[OK]Cost: -2 RED resources, -2 GREEN resources, -2 BLUE resources, -2 BLACK resources");
    }

    public void storeResource(ResourceType resourceType)
    {
        if (resourceType == ResourceType.NONE)
            return;

        if (resourceType == ResourceType.ARTIFACT)
        {
            int amount = resources.get(ResourceType.ARTIFACT);
            resources.put(ResourceType.ARTIFACT, amount + 1);
            return;
        }

        int resourcesGenerated = Utility.throwDie(6);
        logger.add("[OK]Found " + resourcesGenerated + " resource" + ((resourcesGenerated > 1 ) ? "s.": ".") + " Rolled: " + resourcesGenerated);

        switch (resourceType)
        {
            case RED:
                increaseResource(ResourceType.RED, resourcesGenerated);
                break;
            case GREEN:
                increaseResource(ResourceType.GREEN, resourcesGenerated);
                break;
            case BLUE:
                increaseResource(ResourceType.BLUE, resourcesGenerated);
                break;
            case BLACK:
                increaseResource(ResourceType.BLACK, resourcesGenerated);
                break;
            default:
                break;
        }
    }

    public boolean hasResources()
    {
        for(ResourceType resourceType : resources.keySet())
        {
            if (resourceType == ResourceType.ARTIFACT)
                continue;
            if (resources.get(resourceType) > 0)
                return true;
        }

        return false;
    }

    public boolean hasResources(ResourceType resourceType)
    {
        return resources.get(resourceType) > 0;
    }

    public void increaseResource(ResourceType resourceType, int resourcesGenerated)
    {

        int capacity = 6 * currentLevel;
        int before = resources.get(resourceType);
        int surplus = resourcesGenerated - (capacity - before);
        resources.put(resourceType, Math.min(before + resourcesGenerated, capacity));
        int stored = resources.get(resourceType) - before;

        logger.add("[OK]Stored " + stored + " " + resourceType.name() + " resource" + ((stored > 1) ? "s." : "."));

        if (surplus > 0)
            logger.add("[!]There was a surplus of " + surplus + " that could not be stored.");
    }

    public void decreaseResource(ResourceType resourceType, int amount)
    {
        int previousAmount = resources.get(resourceType);
        int newAmount = Math.max(previousAmount - amount, 0);
        resources.put(resourceType, newAmount);
    }

    public void loseRandomResource()
    {
        if (!hasResources()) return;
        ResourceType resourceType;
        do
        {
            resourceType = Utility.getRandomResourceType();
        } while (!hasResources(resourceType));

        int amount = Utility.throwDie(3);
        int previousAmount = resources.get(resourceType);
        int newAmount = Math.max(previousAmount - amount, 0);
        int lostAmount = newAmount - previousAmount;

        decreaseResource(resourceType, amount);
        logger.add("[X]Lost " + lostAmount + " " + resourceType.name() + " resource" + ((lostAmount > 1) ? "s." : ".") + "Rolled: " + amount);

    }

    public void setCanConvertResources(boolean option)
    {
        canConvertResources = option;
    }

    public void convertResource(ResourceType from, ResourceType to)
    {
        resources.put(from, (resources.get(from) - 1));
        increaseResource(to, 1);
    }

    public boolean canConvertResources()
    {
        return canConvertResources && hasResources();
    }

    public boolean canAcquireShield()
    {
        return hasAmountOfEachResource(0, 1,1,1);
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
        return hasAmountOfEachResource(0, 0, 1, 1);
    }

    public void acquireAmmo()
    {
        resources.put(ResourceType.BLACK, (resources.get(ResourceType.BLACK) - 1));
        resources.put(ResourceType.BLUE, (resources.get(ResourceType.BLUE) - 1));

        logger.add("[!]Spent 1 Black resource and 1 Blue resource.");
    }

    public boolean canAcquireFuel()
    {
        return hasAmountOfEachResource(1,1,0,1);
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
        return hasAmountOfEachResource(1,1,1,1);
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
