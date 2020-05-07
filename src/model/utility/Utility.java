package model.utility;


import java.util.List;
import java.util.Random;

import model.data.Constants;
import model.data.GameEnums.*;
import model.data.Constants.*;

public abstract class Utility
{
    private static final Random random = new Random();

    private Utility(){}

    public static int throwDie(int numSides)
    {
        return random.nextInt(numSides) + 1;
    }

    public static boolean didItHappenWithProbability(double probability)
    {
        return random.nextDouble() <= probability;
    }

    public static PlanetType getRandomPlanetType()
    {
        List<PlanetType> values = List.of(PlanetType.values());
        return values.get(random.nextInt(values.size()));
    }

    public static ResourceType pickRandomResourceFromPossible(List<ResourceType> possibleResources)
    {
        return possibleResources.get(random.nextInt(possibleResources.size()));
    }

    public static List<ResourceType> getAvailableResourcesByPlanetType(PlanetType planetType)
    {
        switch (planetType)
        {
            case GREEN:
                return Constants.LIST_RESOURCES_ON_GREEN_PLANET;
            case BLACK:
                return Constants.LIST_RESOURCES_ON_BLACK_PLANET;
            case RED:
                return Constants.LIST_RESOURCES_ON_RED_PLANET;
            case BLUE:
                return Constants.LIST_RESOURCES_ON_BLUE_PLANET;
            default:
                return null;
        }
    }
}
