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
    public static final int MINING_SHIP_MAX_FUEL_CAPACITY = 53;
    public static final int MINING_SHIP_MAX_SHIELD_CAPACITY = 18;
    public static final int MINING_SHIP_MAX_CARGO_LEVEL = 4;

    public static final int MILITARY_SHIP_MAX_WEAPON_CAPACITY = 6;
    public static final int MILITARY_SHIP_MAX_FUEL_CAPACITY = 35;
    public static final int MILITARY_SHIP_MAX_SHIELD_CAPACITY = 9;
    public static final int MILITARY_SHIP_MAX_CARGO_LEVEL = 2;

    public static final int DRONE_MAX_HEALTH = 6;

    public static final int SURFACE_SIDE_SIZE = 6;

    public static final double PROBABILITY_SPACE_STATION = 3/10d;
    public static final double PROBABILITY_WORM_HOLE = 1/8d;

    /* Aliens */
    public static final int [] BLACK_ALIEN_ATTACK_POSSIBILITIES = {1};
    public static final int [] BLACK_ALIEN_DEATH_POSSIBILITIES = {5,6};
    public static final int [] GREEN_ALIEN_ATTACK_POSSIBILITIES = {1,2};
    public static final int [] GREEN_ALIEN_DEATH_POSSIBILITIES = {4,6};
    public static final int [] BLUE_ALIEN_ATTACK_POSSIBILITIES = {3,4,5};
    public static final int [] BLUE_ALIEN_DEATH_POSSIBILITIES = {3,4,5};
    public static final int [] RED_ALIEN_ATTACK_POSSIBILITIES = {5,6};
    public static final int [] RED_ALIEN_DEATH_POSSIBILITIES = {1,2};

    public static final List<GameEnums.ResourceType> LIST_RESOURCES_ON_GREEN_PLANET = new ArrayList<>(
            Arrays.asList(ResourceType.RED, ResourceType.GREEN));
    public static final List<GameEnums.ResourceType> LIST_RESOURCES_ON_BLACK_PLANET = new ArrayList<>(
            Arrays.asList(ResourceType.BLACK, ResourceType.BLUE));
    public static final List<GameEnums.ResourceType> LIST_RESOURCES_ON_RED_PLANET = new ArrayList<>(
            Arrays.asList(ResourceType.RED, ResourceType.BLUE));
    public static final List<GameEnums.ResourceType> LIST_RESOURCES_ON_BLUE_PLANET = new ArrayList<>(
            Arrays.asList(ResourceType.BLACK, ResourceType.GREEN, ResourceType.BLUE, ResourceType.ARTIFACT));


    /* Strings */
    public static final String AVAILABLE_RESOURCES = "Available Resources: ";

    /* Messages */
    public static final String START_GAME_MESSAGE = "Press Start to begin your game.";
    public static final String SELECT_SHIP_MESSAGE = "Select your type of ship.";
    public static final String TRAVEL_SHIP_MESSAGE = "Press Travel to advance to next sector.";
    public static final String SELECT_ACTION_MESSAGE = "Select your desired action.";
    public static final String SELECT_EVENT_MESSAGE = "Select your event.";
    public static final String DRONE_ACTION_MESSAGE = "Select drone movement.";
    public static final String VICTORY_MESSAGE = "Congratulations, you won!";
    public static final String DEFEAT_MESSAGE = "You were defeated. Good luck next time.";

}
