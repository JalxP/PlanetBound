package model.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Crew
{
    private final List<String> crewNames;
    private List<Boolean> crewStatuses;

    public Crew()
    {
        crewNames = new ArrayList<>(Arrays.asList(
                "Captain",
                "Navigation Officer",
                "Exploration Officer",
                "Shields Officer",
                "Weapons Officer",
                "Cargo Hold Officer"));

        crewStatuses = new ArrayList<>();
        while(crewStatuses.size() < 6) crewStatuses.add(true);
    }

    public int getAliveCount()
    {
        int count = 0;
        for (boolean status : crewStatuses)
            count += (status) ? 1 : 0;
        return count;
    }

    public String getCrewNameByIndex(int i)
    {
        return crewNames.get(i);
    }

    public boolean getCrewStatusByIndex(int i)
    {
        return crewStatuses.get(i);
    }

    public void killMember()
    {
        int alive = getAliveCount();
        if (alive > 0)
            crewStatuses.set(alive - 1, false);

    }
}
