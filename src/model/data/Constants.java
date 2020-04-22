package model.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static model.data.GameEnums.*;

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

    public static final double PROBABILITY_SPACE_STATION = 3/10d;
    public static final double PROBABILITY_WORM_HOLE = 1/8d;

    public static final List<GameEnums.ResourceType> LIST_RESOURCES_ON_GREEN_PLANET = new ArrayList<>(
            Arrays.asList(ResourceType.RED, ResourceType.GREEN));
    public static final List<GameEnums.ResourceType> LIST_RESOURCES_ON_BLACK_PLANET = new ArrayList<>(
            Arrays.asList(ResourceType.BLACK, ResourceType.BLUE));
    public static final List<GameEnums.ResourceType> LIST_RESOURCES_ON_RED_PLANET = new ArrayList<>(
            Arrays.asList(ResourceType.RED, ResourceType.BLUE));
    public static final List<GameEnums.ResourceType> LIST_RESOURCES_ON_BLUE_PLANET = new ArrayList<>(
            Arrays.asList(ResourceType.BLACK, ResourceType.GREEN, ResourceType.BLUE, ResourceType.ARTIFACT));


    /* Strings */
    public static final String START_GAME_MESSAGE = "Press Start to begin your game.";
    public static final String SELECT_SHIP_MESSAGE = "Select your type of ship.";
    public static final String MOVE_SHIP_MESSAGE = "Press Move to move your ship.";

}
