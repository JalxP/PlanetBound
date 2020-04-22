package model.data;

import java.util.ArrayList;
import java.util.List;

public class TravelSpace
{
    private final List<Sector> sectorList;

    public TravelSpace()
    {
        sectorList = new ArrayList<>();
    }

    public void move()
    {
        sectorList.add(new Sector(sectorList.size()));
    }


}
