package model.data;

public class GameData implements GameEnums
{
    private Ship ship;

    private StringBuilder message;

    public GameData()
    {
        // TODO
        message = new StringBuilder();
    }

    public void selectShipType(ShipType shipType)
    {
        ship = new Ship(shipType);
    }

    /* Info */
    public String getShipType()
    {
        return "OK";
        // TODO need to check state before!!
//        if (ship.getShipType() == ShipType.MILITARY)
//            return "Military Ship";
//        else
//            return "Mining Ship";
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
