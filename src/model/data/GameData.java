package model.data;

public class GameData implements GameEnums
{
    private Ship ship;

    public GameData()
    {
        // TODO
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
}
