package model.data;

import model.utility.Utility;

import java.util.ArrayList;
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
    private int availableResources;

    private Logger logger;

    public Sector(int index)
    {
        logger = new Logger();
        if (index == 0)
        {
            initialize();
            return;
        }

        travelWormHole = Utility.didItHappenWithProbability(PROBABILITY_WORM_HOLE);

        logger.add((travelWormHole) ? "[!]Traveled through a wormhole!" : "[OK]Traveled through space.");

        isPlanet = index % 2 != 0;
        if (isPlanet)
        {
            hasSpaceStation = Utility.didItHappenWithProbability(PROBABILITY_SPACE_STATION);
            logger.add((hasSpaceStation) ? "[!]A space station was detected!": "[OK]No space station detected.");

            planetType = Utility.getRandomPlanetType();
            logger.add("[!]Detected a " + planetType.name() + " planet!");

            possibleResources = Utility.getAvailableResourcesByPlanetType(planetType);

            availableResources = possibleResources != null ? possibleResources.size() : 0;
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
        availableResources = 0;
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

    List<ResourceType> getPossibleResources()
    {
        return planetSurface.getAvailableResources();
    }

    public ResourceType[][] getPlanetSurface()
    {
        return planetSurface.getSurface();
    }

    public int getAvailableResources()
    {
        return availableResources;
    }

    public AlienType getAlienType()
    {
        return planetSurface.getAlienType();
    }

    public int getDroneRow()
    {
        return planetSurface.getDroneRow();
    }

    public int getDroneCol()
    {
        return planetSurface.getDroneCol();
    }

    public int getLandingRow()
    {
        return planetSurface.getLandingRow();
    }

    public int getLandingCol()
    {
        return planetSurface.getLandingCol();
    }

    public int getAlienRow()
    {
        return planetSurface.getAlienRow();
    }

    public int getAlienCol()
    {
        return planetSurface.getAlienCol();
    }

    public boolean droneCanMove(DroneDirection droneDirection)
    {
        switch (droneDirection)
        {
            case UP:
                return getDroneRow() > 0;
            case RIGHT:
                return getDroneCol() < 5;
            case DOWN:
                return getDroneRow() < 5;
            case LEFT:
                return getDroneCol() > 0;
            default: return false;
        }
    }

    public boolean canLeavePlanet()
    {
        if (planetSurface == null) return false;
        return planetSurface.canLeavePlanet();
    }

    public boolean droneCanGatherResource()
    {
        return planetSurface.droneCanGatherResource();
    }

    public ResourceType getPlanetResource()
    {
        return planetSurface.getPlanetResource();
    }

    public void gatherResource()
    {
        planetSurface.gatherResource();
    }

    public void moveDrone(DroneDirection droneDirection)
    {
        planetSurface.moveDrone(droneDirection);
    }

    public void moveAlien()
    {
        planetSurface.moveAlien();
    }

    public boolean alienIsNextToDrone()
    {
        return planetSurface.alienIsNextToDrone();
    }

    public void generateAlien()
    {
        planetSurface.generateAlien();
        //logger.add(planetSurface.getAllLogs());
    }

    /* Log */
    public ArrayList<String> getAllLogs()
    {
        return logger.getLogAndClear();
    }
    public ArrayList<String> getSurfaceLogs()
    {
        return planetSurface.getAllLogs();
    }
}
