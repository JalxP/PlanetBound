package model.data;

public interface GameEnums
{
    enum ShipType
    {
        MINING,
        MILITARY
    }

    enum ResourceType
    {
        BLACK,
        BLUE,
        GREEN,
        RED,
        ARTIFACT,
        NONE
    }

    enum PlanetType
    {
        GREEN,
        BLACK,
        RED,
        BLUE
    }

    enum AlienType
    {
        BLACK,
        GREEN,
        BLUE,
        RED
    }

    enum DroneDirection
    {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }

    enum UpgradeType
    {
        UPGRADE_CARGO,
        HIRE_MEMBER,
        UPGRADE_WEAPON,
        FULL_ARMOR,
        NEW_DRONE
    }

    enum MaintenanceType
    {
        ACQUIRE_SHIELD_UNIT,
        ACQUIRE_AMMO_UNIT,
        ACQUIRE_FUEL_UNIT,
        REPAIR_DRONE
    }

    enum EventType
    {
        RANDOM,
        CREW_DEATH,
        SALVAGE_SHIP,
        CARGO_LOSS,
        FUEL_LOSS,
        NONE,
        CREW_RESCUE
    }
}