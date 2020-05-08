package model.data;

import static model.data.Constants.SURFACE_SIDE_SIZE;

public class GameData implements GameEnums
{
    private Ship ship;
    private Crew crew;
    private TravelSpace travelSpace;

    private String message;
    private StringBuilder log;

    public GameData()
    {
        ship = null;
        crew = new Crew();
        travelSpace = new TravelSpace();

        message = "";
        log = new StringBuilder();
    }

    public void selectShipType(ShipType shipType)
    {
        ship = new Ship(shipType);
    }

    public void move()
    {
        travelSpace.move();

        if (travelSpace.isCurrentSectorTravelModeWormHole())
        {
            //TODO Log me
            // -3 fuel
            // -2 shields

            // if no shield officer
            // -1 extra fuel
            // -2 extra shields

        }
    }

    public void explore()
    {
        // TODO
    }

    public void endTurn()
    {
        // TODO
        // fuel and stuff
    }
    /* Info */
    public String getShipType()
    {
        if (ship.getShipType() == ShipType.MILITARY)
            return "Military Ship";
        else
            return "Mining Ship";
    }

    public boolean getCrewStatusByIndex(int i)
    {
        return crew.getCrewStatusByIndex(i);
    }

    public String getCrewNameByIndex(int i)
    {
        return crew.getCrewNameByIndex(i);
    }

    public boolean isCurrentSectorPlanet()
    {
        return travelSpace.isCurrentSectorPlanet();
    }

    public boolean isCurrentSectorTravelModeWormHole()
    {
        return travelSpace.isCurrentSectorTravelModeWormHole();
    }

    public boolean currentSectorHasSpaceStation()
    {
        return travelSpace.currentSectorHasSpaceStation();
    }

    public boolean currentSectorIsEvent()
    {
        return !travelSpace.isCurrentSectorPlanet();
    }

    public PlanetType getCurrentSectorPlanetType()
    {
        return travelSpace.getCurrentSectorPlanetType();
    }

    public String getShieldAmount()
    {
        return ship.getShieldCurrent() + "/" + ship.getShieldMax();
    }

    public String getFuelAmount()
    {
        return ship.getFuelCurrent() + "/" + ship.getFuelMax();
    }

    public String getDronesAmount()
    {
        return ship.getDronesCurrent() + "";
    }

    public String getArtifactsAmount()
    {
        return ship.getArtifactsAmount() + "";
    }

    public boolean canUpgrade()
    {
        return travelSpace.currentSectorHasSpaceStation();
    }

    public boolean canExplore()
    {
        boolean hasDrone = ship.getDronesCurrent() > 0;
        boolean hasLandingParty = crew.getAliveCount() > 2;
        boolean hasResources = travelSpace.getAvailableResourcesOnCurrentSector().size() > 0;

        return hasDrone && hasLandingParty && hasResources;
    }

    public boolean gameIsOver()
    {
        return ship.getArtifactsAmount() >= 5;
    }

    public boolean canContinue()
    {
        return ship.getFuelCurrent() > 0 && ship.getShieldCurrent() > 0 && crew.getAliveCount() > 0;
    }

    public ResourceType [][] getPlanetSurface()
    {
        ResourceType [][] original = travelSpace.getCurrectSectorPlanetSurface();
        ResourceType [][] surface = new ResourceType[SURFACE_SIDE_SIZE][];

        for (int i = 0; i < original.length; i++)
            surface[i] = original[i].clone();

        return surface;
    }

    /* Message */
    public void setMessage(String msg)
    {
        message = msg;
    }

    public String getMessage()
    {
        return message;
    }

    /* Log */
    private void clearLog()
    {
        log.setLength(0);
    }

    public void setLog(String msg)
    {
        clearLog();
        log.append(msg);
    }

    public void appendToLog(String msg)
    {
        log.append("\n" + msg);
    }

    public String getLog()
    {
        String tmp = log.toString();
        clearLog();
        return tmp;
    }



}
