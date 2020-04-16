package model.data;

public class GameData implements GameEnums
{
    private ShipType shipType;
    private Ship ship;

    public GameData()
    {
        // TODO
    }

    public void setShipType(ShipType shipType)
    {
        this.shipType = shipType;
        ship = new Ship(shipType);
    }
}
