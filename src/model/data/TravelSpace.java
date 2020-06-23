package model.data;

import java.util.ArrayList;
import java.util.List;

import static model.data.GameEnums.*;

public class TravelSpace
{
    private final List<Sector> sectorList;

    public TravelSpace()
    {
        sectorList = new ArrayList<>();
        sectorList.add(new Sector(0));
    }

    public boolean isCurrentSectorPlanet()
    {
        return getCurrentSector().isPlanet();
    }

    public boolean isCurrentSectorTravelModeWormHole()
    {
        return getCurrentSector().isTravelWormHole();
    }

    public boolean currentSectorHasSpaceStation()
    {
        return getCurrentSector().hasSpaceStation();
    }

    public PlanetType getCurrentSectorPlanetType()
    {
        return getCurrentSector().getPlanetType();
    }

    public ResourceType [][] getCurrectSectorPlanetSurface()
    {
        return getCurrentSector().getPlanetSurface();
    }

    public AlienType getAlienType()
    {
        return getCurrentSector().getAlienType();
    }

    public int [] getDronePosition()
    {
        int [] dronePosition = new int[2];
        dronePosition[0] = getCurrentSector().getDroneRow();
        dronePosition[1] = getCurrentSector().getDroneCol();

        return dronePosition;
    }

    public int [] getLandingPosition()
    {
        int [] landingPosition = new int[2];
        landingPosition[0] = getCurrentSector().getLandingRow();
        landingPosition[1] = getCurrentSector().getLandingCol();

        return landingPosition;
    }

    public int [] getAlienPosition()
    {
        int [] alienPosition = new int[2];
        alienPosition[0] = getCurrentSector().getAlienRow();
        alienPosition[1] = getCurrentSector().getAlienCol();

        return alienPosition;
    }

    public List<ResourceType> getPossibleResources()
    {
        return getCurrentSector().getPossibleResources();
    }

    private Sector getCurrentSector()
    {
        return sectorList.get(sectorList.size() - 1);
    }

    public boolean droneCanMove(DroneDirection droneDirection)
    {
        return getCurrentSector().droneCanMove(droneDirection);
    }

    public boolean droneCanGatherResource()
    {
        return getCurrentSector().droneCanGatherResource();
    }

    public void gatherResource()
    {
        getCurrentSector().gatherResource();
    }

    public void moveDrone(DroneDirection droneDirection)
    {
        getCurrentSector().moveDrone(droneDirection);
    }

    public void moveAlien()
    {
        getCurrentSector().moveAlien();
    }

    public boolean alienIsNextToDrone()
    {
        return getCurrentSector().alienIsNextToDrone();
    }

}
