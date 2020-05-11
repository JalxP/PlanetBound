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
        NONE,
        RED,
        GREEN,
        BLUE,
        BLACK,
        ARTIFACT
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
        CONVERT_RESOURCE,
        HIRE_MEMBER,
        UPGRADE_WEAPON,
        FULL_ARMOR,
        NEW_DRONE
    }
}