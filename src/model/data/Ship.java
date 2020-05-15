package model.data;

import model.data.GameEnums.*;

import java.util.ArrayList;

import static model.data.Constants.*;

public class Ship
{
    private ShipType shipType;
    private CargoHold cargoHold;
    private Drone drone;
    private int dronesAmount; // se a hp de um drone chegar a zero iniciar outro
    private int shieldCurrent;
    private final int shieldMax;
    private int fuelCurrent;
    private final int fuelMax;
    private int weaponsCurrent;
    private int weaponsMax;
    private int weaponsCurrentLevel;
    private int weaponsMaxLevel;

    private Logger logger;

    public Ship(ShipType shipType)
    {
        this.shipType = shipType;
        int maxCargoLevel;
        if (shipType == ShipType.MILITARY)
        {
            maxCargoLevel = MILITARY_SHIP_MAX_CARGO_LEVEL;
            shieldMax = MILITARY_SHIP_MAX_SHIELD_CAPACITY;
            fuelMax = MILITARY_SHIP_MAX_FUEL_CAPACITY;
            weaponsMax = MILITARY_SHIP_MAX_WEAPON_CAPACITY;
            weaponsMaxLevel = MILITARY_SHIP_MAX_WEAPON_LEVEL;
        }
        else
        {
            maxCargoLevel = MINING_SHIP_MAX_CARGO_LEVEL;
            shieldMax = MINING_SHIP_MAX_SHIELD_CAPACITY;
            fuelMax = MINING_SHIP_MAX_FUEL_CAPACITY;
            weaponsMax = MINING_SHIP_MAX_WEAPON_CAPACITY;
            weaponsMaxLevel = MINING_SHIP_MAX_WEAPON_LEVEL;
        }

        weaponsCurrentLevel = 1;
        shieldCurrent = shieldMax;
        fuelCurrent = fuelMax;
        weaponsCurrent = weaponsMax;
        cargoHold = new CargoHold(maxCargoLevel);
        drone = new Drone();
        dronesAmount = 1;
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

    public CargoHold getCargoHold()
    {
        return cargoHold;
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

    public boolean isDroneOperational()
    {
        return drone.isOperational();
    }

    public int getWeaponsCurrent()
    {
        return weaponsCurrent;
    }

    public int getAvailableDrones()
    {
        return dronesAmount;
    }

    public int getResources(ResourceType resourceType)
    {
        return cargoHold.getResources(resourceType);
    }

    public boolean hasResources(ResourceType resourceType)
    {
        return cargoHold.hasResources(resourceType);
    }

    public int getDroneHealth()
    {
        return drone.getHealth();
    }

    public int getDroneHealthMax()
    {
        return drone.getDroneHealthMax();
    }

    public int getCargoHoldMax()
    {
        return cargoHold.getCargoHoldMax();
    }

    public void decreaseDroneHealth()
    {
        drone.decreaseHealth();
        if (!drone.isOperational())
            dronesAmount--;
    }

    public boolean droneIsOperational()
    {
        return drone.isOperational();
    }

    public boolean hasAvailableDrones()
    {
        return dronesAmount > 0;
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

    public boolean hasResources()
    {
        return cargoHold.hasResources();
    }

    public void setCanConvertResources(boolean option)
    {
        cargoHold.setCanConvertResources(option);
    }

    public void convertResource(ResourceType from, ResourceType to)
    {
        cargoHold.convertResource(from, to);
    }

    public boolean canConvertResources()
    {
        return cargoHold.canConvertResources();
    }

    public void addResourceToCargoHold(ResourceType resourceType)
    {
        cargoHold.increaseResource(resourceType,1);
        logger.add(cargoHold.getAllLogs());
    }

    public void loseRandomResource()
    {
        cargoHold.loseRandomResource();
        logger.add(cargoHold.getAllLogs());
    }

    public void loseFuel()
    {
        fuelCurrent--;
    }

    public void maintain(MaintenanceType maintenanceType)
    {
        switch (maintenanceType)
        {
            case ACQUIRE_SHIELD_UNIT:
                acquireShield();
                break;
            case ACQUIRE_AMMO_UNIT:
                acquireAmmo();
                break;
            case ACQUIRE_FUEL_UNIT:
                acquireFuel();
                break;
            case REPAIR_DRONE:
                acquireDroneRepair();
                break;
        }
    }

    public boolean canUpgradeCargoHold()
    {
        return cargoHold.canBeUpgraded();
    }

    public void upgradeCargoHold()
    {
        cargoHold.upgradeCargoHold();
        logger.add(cargoHold.getAllLogs());
    }

    public boolean canUpgradeFullArmor()
    {
        return shieldCurrent < shieldMax && cargoHold.canUpgradeFullArmor();
    }

    public void upgradeFullArmor()
    {
        shieldCurrent = shieldMax;
        cargoHold.upgradeFullArmor();
        logger.add(cargoHold.getAllLogs());
    }

    public boolean canUpgradeNewDrone()
    {
        return cargoHold.canUpgradeNewDrone();
    }

    public void upgradeNewDrone()
    {
        dronesAmount++;
        cargoHold.upgradeNewDrone();
        logger.add(cargoHold.getAllLogs());
    }

    public boolean canUpgradeCrew()
    {
        return cargoHold.canUpgradeCrew();
    }

    public void upgradeCrew()
    {
        cargoHold.upgradeCrew();
        logger.add(cargoHold.getAllLogs());
    }

    public boolean canUpgradeWeapon()
    {
        boolean canUpgradeLevel = weaponsCurrentLevel < weaponsMaxLevel;
        boolean canUpgrade = shipType == ShipType.MILITARY;
        boolean hasResources = cargoHold.canUpgradeWeaponSystem();

        return canUpgradeLevel && canUpgrade && hasResources;
    }

    public void upgradeWeaponSystem()
    {
        weaponsCurrentLevel++;
        cargoHold.upgradeWeaponSystem();
        logger.add(cargoHold.getAllLogs());
    }

    private void acquireShield()
    {
            cargoHold.acquireShield();
            shieldCurrent++;
            logger.add(cargoHold.getAllLogs());
            logger.add("[OK]Acquired +1 shield.");
    }

    public boolean canAcquireShield()
    {
        return cargoHold.canAcquireShield();
    }

    private void acquireAmmo()
    {
        cargoHold.acquireAmmo();
        weaponsCurrent++;
        logger.add(cargoHold.getAllLogs());
        logger.add("[OK]Acquired +1 ammo.");
    }

    public boolean canAcquireAmmo()
    {
        return cargoHold.canAcquireAmmo();
    }

    public boolean canAcquireFuel()
    {
        return cargoHold.canAcquireFuel();
    }

    private void acquireFuel()
    {
        cargoHold.acquireFuel();
        fuelCurrent++;
        logger.add(cargoHold.getAllLogs());
        logger.add("[OK]Acquired +1 fuel.");
    }

    public boolean canAcquireDroneRepair()
    {
        return cargoHold.canAcquireDroneRepair();
    }

    public void acquireDroneRepair()
    {
        cargoHold.acquireDroneRepair();
        drone.repair();
        logger.add(cargoHold.getAllLogs());
        logger.add("[OK]Fully repaired the drone.");
    }
    /* Log */

    public ArrayList<String> getAllLogs()
    {
        return logger.getLogAndClear();
    }
}
