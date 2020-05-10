package model.data;

import model.data.GameEnums.*;

import static model.data.Constants.*;

public class Ship
{
    private ShipType shipType;
    private CargoHold cargoHold;
    private int shieldCurrent;
    private final int shieldMax;
    private int fuelCurrent;
    private final int fuelMax;
    private int dronesCurrent;
    private int droneHealth;

    private int weaponsCurrent;
    //private final int weaponsMax; // TODO initialize weapon stuff

    public Ship(ShipType shipType)
    {
        this.shipType = shipType;
        int maxCargoLevel;
        if (shipType == ShipType.MILITARY)
        {
            maxCargoLevel = MILITARY_SHIP_MAX_CARGO_LEVEL;
            shieldMax = MILITARY_SHIP_MAX_SHIELD_CAPACITY;
            fuelMax = MILITARY_SHIP_MAX_FUEL_CAPACITY;
        }
        else
        {
            maxCargoLevel = MINING_SHIP_MAX_CARGO_LEVEL;
            shieldMax = MINING_SHIP_MAX_SHIELD_CAPACITY;
            fuelMax = MINING_SHIP_MAX_FUEL_CAPACITY;
        }

        dronesCurrent = 1;
        droneHealth = DRONE_MAX_HEALTH;
        shieldCurrent = shieldMax;
        fuelCurrent = fuelMax;
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

    public int getFuelCurrent()
    {
        return fuelCurrent;
    }

    public int getFuelMax()
    {
        return fuelMax;
    }

    public int getDronesCurrent()
    {
        return dronesCurrent;
    }

    public int getWeaponsCurrent()
    {
        return weaponsCurrent;
    }

    public int getResources(ResourceType resourceType)
    {
        return cargoHold.getResources(resourceType);
    }

    public int getDroneHealth()
    {
        return droneHealth;
    }

    public void decreaseDroneHealth()
    {
        droneHealth--;
        if (droneHealth < 1)
            dronesCurrent = 0;
    }

    public boolean droneWasDestroyed()
    {
        return droneHealth < 1;
    }

    public void decreaseShieldsBy(int amount)
    {
        shieldCurrent -= amount;
    }

    public void decreaseFuelBy(int amount)
    {
        fuelCurrent -= amount;
    }
}
