package model.data;

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

    public PlanetType getCurrentSectorPlanetType()
    {
        return travelSpace.getCurrentSectorPlanetType();
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
