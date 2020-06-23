package model.data;

import model.data.GameEnums.*;
import model.utility.Utility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static model.data.Constants.*;

public class PlanetSurface implements Serializable
{
    private final PlanetType planetType;
    private ResourceType[][] surface;
    private List<ResourceType> possibleResources;
    private List<ResourceType> availableResources;
    private int availableExtractions;

    private int resourceRow;
    private int resourceCol;
    private ResourceType resourceType;
    private boolean lastResourceWasGathered;

    private int landingRow;
    private int landingCol;

    private int droneRow;
    private int droneCol;

    private AlienType alienType;
    private int alienRow;
    private int alienCol;

    private Logger logger;

    public PlanetSurface(PlanetType planetType)
    {
        this.planetType = planetType;
        surface = new ResourceType[SURFACE_SIDE_SIZE][SURFACE_SIDE_SIZE];
        lastResourceWasGathered = true;

        logger = new Logger();

        getPossibleResources();
    }

    private void getPossibleResources()
    {
        switch (planetType)
        {
            case BLACK:
                possibleResources = LIST_RESOURCES_ON_BLACK_PLANET;
                break;
            case GREEN:
                possibleResources = LIST_RESOURCES_ON_GREEN_PLANET;
                break;
            case RED:
                possibleResources = LIST_RESOURCES_ON_RED_PLANET;
                break;
            case BLUE:
                possibleResources = LIST_RESOURCES_ON_BLUE_PLANET;
                break;
            default: break;
        }
        availableResources = new ArrayList<>(possibleResources);
        availableExtractions = availableResources.size();
    }

    public void generateSurface()
    {
        if (lastResourceWasGathered)
        {
            for (int i = 0; i < SURFACE_SIDE_SIZE; i++)
                for (int j = 0; j < SURFACE_SIDE_SIZE; j++)
                    surface[i][j] = ResourceType.NONE;

            generateResource();
            generateLandingZone();
            generateAlien();
        }
        else
            surface[resourceRow][resourceCol] = resourceType;
    }

    private void generateResource()
    {
        resourceRow = Utility.throwDie(6) - 1;
        resourceCol = Utility.throwDie(6) - 1;

        resourceType = Utility.pickRandomResourceFromPossible(availableResources);
        surface[resourceRow][resourceCol] = resourceType;

        logger.add("[OK]New " + surface[resourceRow][resourceCol].name() + " resource generated at (" + (resourceRow+1) + "," + (resourceCol+1) + ")");

        lastResourceWasGathered = false;
    }

    private void generateLandingZone()
    {
        int randomRow;
        int randomCol;

        do
        {
            randomRow = Utility.throwDie(6) - 1;
            randomCol = Utility.throwDie(6) - 1;
        } while (surface[randomRow][randomCol] != ResourceType.NONE);

        logger.add("[OK]New landing zone generated at (" + (randomRow+1) + "," + (randomCol+1) + ")");

        droneRow = randomRow;
        droneCol = randomCol;
        landingRow = droneRow;
        landingCol = droneCol;
    }

    public void generateAlien()
    {
        int randomRow;
        int randomCol;

        do
        {
            randomRow = Utility.throwDie(6) - 1;
            randomCol = Utility.throwDie(6) - 1;
        } while (surface[randomRow][randomCol] != ResourceType.NONE && randomCol == droneCol || randomRow == droneRow);

        // TODO add randomRow and randomCol to LOG
        alienRow = randomRow;
        alienCol = randomCol;
        alienType = Utility.getRandomAlienType();

        logger.add("[OK]New " + alienType.name() + " alien generated at (" + (randomRow+1) + "," + (randomCol+1) + ")");
    }

    public void moveDrone(DroneDirection droneDirection)
    {
        switch (droneDirection)
        {
            case UP:
                droneRow--;
                break;
            case RIGHT:
                droneCol++;
                break;
            case DOWN:
                droneRow++;
                break;
            case LEFT:
                droneCol--;
                break;
        }
    }

    public void moveAlien()
    {
        int rowDistance = Math.abs(droneRow - alienRow);
        int colDistance = Math.abs(droneCol - alienCol);

        if (rowDistance > colDistance)
        {
            if (alienRow > droneRow)
                alienRow--;
            else if (alienRow < droneRow)
                alienRow++;
        }
        else
        {
            if (alienCol > droneCol)
                alienCol--;
            else if (alienCol < droneCol)
                alienCol++;
        }
    }

    public boolean alienIsNextToDrone()
    {
        return droneRow + 1 == alienRow && droneCol == alienCol ||
                droneRow - 1 == alienRow && droneCol == alienCol ||
                droneCol + 1 == alienCol && droneRow == alienRow ||
                droneCol - 1 == alienCol && droneRow == alienRow;
    }

    public boolean droneCanGatherResource()
    {
        return surface[droneRow][droneCol] != ResourceType.NONE;
    }

    public boolean canLeavePlanet()
    {
        return droneRow == landingRow && droneCol == landingCol;
    }

    public ResourceType getPlanetResource()
    {
        return surface[droneRow][droneCol];
    }

    public void gatherResource()
    {
        surface[droneRow][droneCol] = ResourceType.NONE;
        if (resourceType == ResourceType.ARTIFACT)
            availableResources.remove(resourceType);
        resourceType = ResourceType.NONE;
        lastResourceWasGathered = true;
        availableExtractions--;
    }

    public ResourceType[][] getSurface()
    {
        return surface;
    }

    public int getDroneRow()
    {
        return droneRow;
    }

    public int getDroneCol()
    {
        return droneCol;
    }

    public int getLandingRow()
    {
        return landingRow;
    }

    public int getLandingCol()
    {
        return landingCol;
    }

    public int getAlienRow()
    {
        return alienRow;
    }

    public int getAlienCol()
    {
        return alienCol;
    }

    public AlienType getAlienType()
    {
        return alienType;
    }

    public boolean hasAvailableResources()
    {
        return availableExtractions > 0;
    }

    public List<ResourceType> getAvailableResources()
    {
        return availableResources;
    }

    /* Log */

    public ArrayList<String> getAllLogs()
    {
        return logger.getLogAndClear();
    }
}
