package model.data;

import model.utility.Utility;

import java.util.List;

import static model.data.Constants.*;
import static model.data.GameEnums.*;

public class Sector
{
    private boolean isPlanet;
    private boolean isPath;
    private boolean isEvent;
    private boolean hasSpaceStation;
    private boolean isWormHole;
    private PlanetType planetType;
    private List<ResourceType> possibleResources;
    private int availableResources;

    public Sector(int index)
    {
        if (index % 4 == 0)
        {
            isPlanet = true;
            hasSpaceStation = Utility.didItHappenWithProbability(PROBABILITY_SPACE_STATION);
            planetType = Utility.getRandomPlanetType();
            possibleResources = Utility.getAvailableResourcesByPlanetType(planetType);
            availableResources = possibleResources != null ? possibleResources.size() : 0;
        }
        else
        {
            if (index % 2 == 0)
                isEvent = true;
            else
            {
                isPath = true;
                isWormHole = Utility.didItHappenWithProbability(PROBABILITY_WORM_HOLE);
            }
        }
    }

    public boolean isPlanet()
    {
        return isPlanet;
    }

    public boolean isPath()
    {
        return isPath;
    }

    public boolean isEvent()
    {
        return isEvent;
    }

    public boolean isHasSpaceStation()
    {
        return hasSpaceStation;
    }

    public boolean isWormHole()
    {
        return isWormHole;
    }

    public PlanetType getPlanetType()
    {
        return planetType;
    }

    public List<ResourceType> getPossibleResources()
    {
        return possibleResources;
    }

    public int getAvailableResources()
    {
        return availableResources;
    }
}
