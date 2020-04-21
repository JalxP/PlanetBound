package model.data;

import model.data.GameEnums.*;

import static model.data.Constants.*;

public class Ship
{
    private ShipType shipType;
    private CargoHold cargoHold;
    private int shieldCurrent;
    private final int shieldMax;
    private int weaponsCurrent;
    // private final int weaponsMax; // TODO initialize weapon stuff

    public Ship(ShipType shipType)
    {
        this.shipType = shipType;
        int maxCargoLevel;
        if (shipType == ShipType.MILITARY)
        {
            maxCargoLevel = MILITARY_SHIP_MAX_CARGO_LEVEL;
            shieldMax = MILITARY_SHIP_MAX_SHIELD_CAPACITY;
        }
        else
        {
            maxCargoLevel = MINING_SHIP_MAX_CARGO_LEVEL;
            shieldMax = MINING_SHIP_MAX_SHIELD_CAPACITY;
        }

        shieldCurrent = shieldMax;
        cargoHold = new CargoHold(maxCargoLevel);
    }



    /* Getters */
    public ShipType getShipType()
    {
        return shipType;
    }

    public int getShieldCurrent()
    {
        return shieldCurrent;
    }

    public int getShieldMax()
    {
        return shieldMax;
    }

    // TODO wait teacher answer
    /*public int getWeaponsCurrent()
    {
        return weaponsCurrent;
    }

    public int getWeaponsMax()
    {
        return weaponsMax;
    }*/
}
