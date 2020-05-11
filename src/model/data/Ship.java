package model.data;

import model.data.GameEnums.*;

import java.util.ArrayList;

import static model.data.Constants.*;

public class Ship
{
    private ShipType shipType;
    private CargoHold cargoHold;
    private Drone drone;
    private int shieldCurrent;
    private final int shieldMax;
    private int fuelCurrent;
    private final int fuelMax;

    private Logger logger;

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

        shieldCurrent = shieldMax;
        fuelCurrent = fuelMax;
        cargoHold = new CargoHold(maxCargoLevel);
        drone = new Drone();
        logger = new Logger();
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
        return (drone.isOperational()) ? 1 : 0;
    }

    public boolean isDroneOperational()
    {
        return drone.isOperational();
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
        return drone.getHealth();
    }

    public int getCargoHoldMax()
    {
        return cargoHold.getCargoHoldMax();
    }

    public void decreaseDroneHealth()
    {
        drone.decreaseHealth();
    }

    public boolean droneIsOperational()
    {
        return drone.isOperational();
    }

    public void decreaseShieldsBy(int amount)
    {
        shieldCurrent -= amount;
    }

    public void decreaseFuelBy(int amount)
    {
        fuelCurrent -= amount;
    }

    public void storeResourceOnCargoHold()
    {
        cargoHold.storeResource(drone.getStoredResource());
        logger.add(cargoHold.getAllLogs());
    }

    public void storeResourceOnDrone(ResourceType resourceType)
    {
        drone.storeResource(resourceType);
    }

    /* Log */

    public ArrayList<String> getAllLogs()
    {
        return logger.getLogAndClear();
    }
}
