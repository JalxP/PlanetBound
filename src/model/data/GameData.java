package model.data;

public class GameData implements GameEnums
{
    private Ship ship;
    private Crew crew;

    private StringBuilder message;

    public GameData()
    {
        ship = null;
        crew = new Crew();

        message = new StringBuilder();
    }

    public void selectShipType(ShipType shipType)
    {
        ship = new Ship(shipType);
    }

    public void move()
    {
        // TODO
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

    /* Log */
    private void clearMessage()
    {
        message.setLength(0);
    }

    public void setMessage(String msg)
    {
        clearMessage();
        message.append(msg);
    }

    public void appendToMessage(String msg)
    {
        message.append("\n" + msg);
    }

    public String getMessage()
    {
        String tmp = message.toString();
        clearMessage();
        return tmp;
    }


}
