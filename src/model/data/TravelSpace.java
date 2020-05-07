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

    public void move()
    {
        sectorList.add(new Sector(sectorList.size()));
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

    public List<ResourceType> getAvailableResourcesOnCurrentSector()
    {
        return getCurrentSector().getAvailableResources();
    }

    private Sector getCurrentSector()
    {
        return sectorList.get(sectorList.size() - 1);
    }
}
