package model.data;

import model.data.GameEnums.*;
import model.utility.Utility;

import java.util.ArrayList;
import java.util.List;

import static model.data.Constants.*;

public class PlanetSurface
{
    private final PlanetType planetType;
    private ResourceType[][] surface;
    private List<ResourceType> possibleResources;
    private List<ResourceType> availableResources;

    private int landingRow;
    private int landingCol;

    private int droneRow;
    private int droneCol;

    private AlienType alienType;
    private int alienRow;
    private int alienCol;

    public PlanetSurface(PlanetType planetType)
    {
        this.planetType = planetType;
        surface = new ResourceType[SURFACE_SIDE_SIZE][SURFACE_SIDE_SIZE];

        getPossibleResources();
        generateSurface();
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
    }

    private void generateSurface()
    {
        for (int i = 0; i < SURFACE_SIDE_SIZE; i++)
        {
            for (int j = 0; j < SURFACE_SIDE_SIZE; j++)
            {
                surface[i][j] = ResourceType.NONE;
            }
        }

        int randomRow = Utility.throwDie(6) - 1; // TODO add this to LOG
        int randomCol = Utility.throwDie(6) - 1; // TODO add this to LOG

        surface[randomRow][randomCol] = Utility.pickRandomResourceFromPossible(availableResources);

        do
        {
            randomRow = Utility.throwDie(6) - 1;
            randomCol = Utility.throwDie(6) - 1;
        } while (surface[randomRow][randomCol] != ResourceType.NONE);

        // TODO add randomRow and randomCol to LOG

        droneRow = randomRow;
        droneCol = randomCol;
        landingRow = droneRow;
        landingCol = droneCol;

        do
        {
            randomRow = Utility.throwDie(6) - 1;
            randomCol = Utility.throwDie(6) - 1;
        } while (surface[randomRow][randomCol] != ResourceType.NONE && randomCol == droneCol || randomRow == droneRow);

        // TODO add randomRow and randomCol to LOG
        alienRow = randomRow;
        alienCol = randomCol;
        alienType = Utility.getRandomAlienType();
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

    public void removeResourceFromPlanet(ResourceType resourceType)
    {
        availableResources.removeIf(r -> r == resourceType);
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

    public List<ResourceType> getAvailableResources()
    {
        return availableResources;
    }
}
