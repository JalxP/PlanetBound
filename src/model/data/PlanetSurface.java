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

    private int droneRow;
    private int droneCol;

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

        int randomRow = Utility.throwDie(6) - 1;
        int randomCol = Utility.throwDie(6) - 1;

        surface[randomRow][randomCol] = Utility.pickRandomResourceFromPossible(availableResources);

        do
        {
            randomRow = Utility.throwDie(6) - 1;
            randomCol = Utility.throwDie(6) - 1;
        } while (surface[randomRow][randomCol] != ResourceType.NONE);

        droneRow = randomRow;
        droneCol = randomCol;
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

    public List<ResourceType> getAvailableResources()
    {
        return availableResources;
    }
}
