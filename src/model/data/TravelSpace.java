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
        return sectorList.get(sectorList.size() - 1).isPlanet();
    }

    public boolean isCurrentSectorTravelModeWormHole()
    {
        return sectorList.get(sectorList.size() - 1).isTravelWormHole();
    }

    public PlanetType getCurrentSectorPlanetType()
    {
        return sectorList.get(sectorList.size() - 1).getPlanetType();
    }

}
