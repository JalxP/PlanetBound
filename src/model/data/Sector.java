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
    private PlanetSurface planetSurface;

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
            planetSurface = new PlanetSurface(planetType);
        }
    }

    private void initialize()
    {
        isPlanet = true;
        hasSpaceStation = false;
        travelWormHole = false;
        planetType = null;
        possibleResources = null;
    }

    public boolean isPlanet()
    {
        return isPlanet;
    }

    public boolean hasSpaceStation()
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

    List<ResourceType> getAvailableResources()
    {
        return planetSurface.getAvailableResources();
    }

    public ResourceType[][] getPlanetSurface()
    {
        return planetSurface.getSurface();
    }

    public int getDroneRow()
    {
        return planetSurface.getDroneRow();
    }

    public int getDroneCol()
    {
        return planetSurface.getDroneCol();
    }
}
