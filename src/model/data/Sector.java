package model.data;

import model.utility.Utility;

import java.util.List;

import static model.data.Constants.*;
import static model.data.GameEnums.*;

public class Sector
{
    private boolean isPlanet;
    private boolean hasSpaceStation;
    private boolean travelWormHole;
    private PlanetType planetType;
    private List<ResourceType> possibleResources;
    private int availableResources;

    public Sector(int index)
    {
        if (index == 0)
        {
            initialize();
            return;
        }

        travelWormHole = Utility.didItHappenWithProbability(PROBABILITY_WORM_HOLE);
        isPlanet = index % 2 != 0;
        if (isPlanet)
        {
            hasSpaceStation = Utility.didItHappenWithProbability(PROBABILITY_SPACE_STATION);
            planetType = Utility.getRandomPlanetType();
            possibleResources = Utility.getAvailableResourcesByPlanetType(planetType);
            availableResources = possibleResources != null ? possibleResources.size() : 0;
        }
    }

    private void initialize()
    {
        isPlanet = true;
        hasSpaceStation = false;
        travelWormHole = false;
        planetType = null;
        possibleResources = null;
        availableResources = 0;
    }

    public boolean isPlanet()
    {
        return isPlanet;
    }

    public boolean isHasSpaceStation()
    {
        return hasSpaceStation;
    }

    public boolean isTravelWormHole()
    {
        return travelWormHole;
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
