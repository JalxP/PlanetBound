package model.data;

public abstract class Constants
{
    private Constants() {}

    /* Game Constants */
    public static final int MINING_SHIP_MAX_WEAPON_CAPACITY = 9;
    public static final int MINING_SHIP_MAX_SHIELD_CAPACITY = 18;
    public static final int MINING_SHIP_MAX_CARGO_LEVEL = 4;

    public static final int MILITARY_SHIP_MAX_WEAPON_CAPACITY = 6;
    public static final int MILITARY_SHIP_MAX_SHIELD_CAPACITY = 9;
    public static final int MILITARY_SHIP_MAX_CARGO_LEVEL = 2;

    public static final int DRONE_MAX_HEALTH = 6;

    /* Strings */
    public static final String START_GAME_MESSAGE = "Press Start to begin your game.";
    public static final String SELECT_SHIP_MESSAGE = "Select your type of ship.";
    public static final String MOVE_SHIP_MESSAGE = "Press Move to move your ship.";

}
