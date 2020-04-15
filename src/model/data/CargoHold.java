package model.data;

import model.utility.Entropy;

public class CargoHold implements GameEnums
{
    private int resourcesRed = 0;
    private int resourcesGreen = 0;
    private int resourcesBlue = 0;
    private int resourcesBlack = 0;
    private int artifacts = 0;

    private int currentLevel = 1;
    private final int maxLevel;

    private String log = "";

    public CargoHold(int maxLevel)
    {
        this.maxLevel = maxLevel;
    }




     /* Getters */
    public int getResourcesRed()
    {
        return resourcesRed;
    }

    public int getResourcesGreen()
    {
        return resourcesGreen;
    }

    public int getResourcesBlue()
    {
        return resourcesBlue;
    }

    public int getResourcesBlack()
    {
        return resourcesBlack;
    }

    public int getArtifacts()
    {
        return artifacts;
    }

    public int getCurrentLevel()
    {
        return currentLevel;
    }

    public int getMaxLevel()
    {
        return maxLevel;
    }

    /* Other methods*/
    public void upgradeLevel()
    {
        currentLevel++;
    }

    public boolean canBeUpgraded()
    {
        /* Can upgrade if has at least 2 resources of each */
        return currentLevel < maxLevel &&
                resourcesRed > 1 &&
                resourcesGreen > 1 &&
                resourcesBlue > 1 &&
                resourcesBlack > 1;
    }

    public void increaseResource(ResourceType resourceType)
    {
        if (resourceType == ResourceType.ARTIFACT)
        {
            artifacts++;
            return;
        }

        int resourcesGenerated = Entropy.throwDie(6);

        switch (resourceType)
        {
            case RED:
                increaseRedResources(resourcesGenerated);
                break;
            case GREEN:
                increaseGreenResources(resourcesGenerated);
                break;
            case BLUE:
                increaseBlueResources(resourcesGenerated);
                break;
            case BLACK:
                increaseBlackResources(resourcesGenerated);
                break;
            default:
                break;
        }
    }

    private void increaseRedResources(int amount)
    {
        int capacity = 6 * currentLevel;
        int before = resourcesRed;
        int surplus = amount - (capacity - resourcesRed);
        resourcesRed = Math.min(resourcesRed + amount, capacity);
        int stored = resourcesRed - before;

        addToLog("Stored " + stored + "red resource" + ((stored > 1) ? "s." : "."));

        if (surplus > 0)
            addToLog("There was a surplus of " + surplus + " that could not be stored.");
    }

    private void increaseGreenResources(int amount)
    {
        int capacity = 6 * currentLevel;
        int before = resourcesGreen;
        int surplus = amount - (capacity - resourcesGreen);
        resourcesGreen = Math.min(resourcesGreen + amount, capacity);
        int stored = resourcesGreen - before;

        addToLog("Stored " + stored + "green resource" + ((stored > 1) ? "s." : "."));

        if (surplus > 0)
            addToLog("There was a surplus of " + surplus + " that could not be stored.");
    }

    private void increaseBlueResources(int amount)
    {
        int capacity = 6 * currentLevel;
        int before = resourcesBlue;
        int surplus = amount - (capacity - resourcesBlue);
        resourcesBlue = Math.min(resourcesBlue + amount, capacity);
        int stored = resourcesBlue - before;

        addToLog("Stored " + stored + "blue resource" + ((stored > 1) ? "s." : "."));

        if (surplus > 0)
            addToLog("There was a surplus of " + surplus + " that could not be stored.");
    }

    private void increaseBlackResources(int amount)
    {
        int capacity = 6 * currentLevel;
        int before = resourcesBlack;
        int surplus = amount - (capacity - resourcesBlack);
        resourcesBlack = Math.min(resourcesBlack + amount, capacity);
        int stored = resourcesBlack - before;

        addToLog("Stored " + stored + "black resource" + ((stored > 1) ? "s." : "."));

        if (surplus > 0)
            addToLog("There was a surplus of " + surplus + " that could not be stored.");
    }

    /* Log */
    public String getLog()
    {
        String out = log;
        log = "";
        return out;
    }

    private void addToLog(String msg)
    {
        log += " " + msg;
    }
}
