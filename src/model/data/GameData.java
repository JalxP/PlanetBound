package model.data;

import model.utility.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static model.data.Constants.*;

public class GameData implements GameEnums
{
    private Ship ship;
    private Crew crew;
    private List<Sector> sectors;
    private Logger logger;
    private String message;

    public GameData()
    {
        ship = null;
        crew = new Crew();
        sectors = new ArrayList<>();
        sectors.add(new Sector(0));
        logger = new Logger();
        message = "";
    }

    public void selectShipType(ShipType shipType)
    {
        ship = new Ship(shipType);
    }

    public void travel()
    {
        sectors.add(new Sector(sectors.size()));

        if (getCurrentSector().isTravelWormHole())
        {
            int spentFuel = (crew.getCrewStatusByIndex(3)) ? 3 : 4;
            logger.add("[!]Spent " + spentFuel + "fuel units.");
            ship.decreaseFuelBy(spentFuel);

            if (ship.getShieldCurrent() < 1)
            {
                crew.killMember();
                logger.add("[X]A crew member was lost while traveling through the wormhole.");
            }
            else
            {
                int spentShields = (crew.getCrewStatusByIndex(3)) ? 2 : 4;
                logger.add("[!]Spent " + spentShields + " shield units.");
                ship.decreaseShieldsBy(spentShields);
            }
        }
    }

    public void explore()
    {
        // TODO
    }

    public void moveDrone(DroneDirection droneDirection)
    {
        getCurrentSector().moveDrone(droneDirection);
        if (droneCanGatherResource())
            gatherResource();

        if (!getCurrentSector().alienIsNextToDrone())
            getCurrentSector().moveAlien();

        while (getCurrentSector().alienIsNextToDrone() && droneIsAvailable())
        {
            attack();
        }
    }

    public void leavePlanet()
    {
        // store the gathered resource
    }

    public void endTurn()
    {
        // TODO
        // fuel and stuff
    }


    /* Info */
    public String getShipType()
    {
        if (ship.getShipType() == ShipType.MILITARY)
            return "Military Ship";
        else
            return "Mining Ship";
    }

    public boolean getCrewStatusByIndex(int i)
    {
        return crew.getCrewStatusByIndex(i);
    }

    public String getCrewNameByIndex(int i)
    {
        return crew.getCrewNameByIndex(i);
    }

    public boolean isCurrentSectorPlanet()
    {
        return getCurrentSector().isPlanet();
    }

    public boolean isCurrentSectorTravelModeWormHole()
    {
        return getCurrentSector().isTravelWormHole();
    }

    public boolean currentSectorHasSpaceStation()
    {
        return getCurrentSector().hasSpaceStation();
    }

    public boolean currentSectorIsEvent()
    {
        return !getCurrentSector().isPlanet();
    }

    public PlanetType getCurrentSectorPlanetType()
    {
        return getCurrentSector().getPlanetType();
    }

    public String getShieldAmount()
    {
        return ship.getShieldCurrent() + "/" + ship.getShieldMax();
    }

    public String getFuelAmount()
    {
        return ship.getFuelCurrent() + "/" + ship.getFuelMax();
    }

    public String getDronesAmount()
    {
        return ship.getDronesCurrent() + "";
    }

    public String getResourcesAsString(ResourceType resourceType)
    {
        return ship.getResources(resourceType) + "";
    }

    public boolean canUpgrade()
    {
        return getCurrentSector().hasSpaceStation();
    }

    public boolean canExplore()
    {
        boolean hasDrone = ship.getDronesCurrent() > 0;
        boolean hasLandingParty = crew.getAliveCount() > 2;
        boolean hasResources = getCurrentSector().getAvailableResources() > 0;

        return hasDrone && hasLandingParty && hasResources;
    }

    public boolean canLeavePlanet()
    {
        return getCurrentSector().canLeavePlanet();
    }

    public boolean droneIsAvailable()
    {
        return ship.getDronesCurrent() > 0;
    }

    public boolean gameIsOver()
    {
        return ship.getResources(ResourceType.ARTIFACT) >= 5;
    }

    public boolean canContinue()
    {
        return ship.getFuelCurrent() > 0 && ship.getShieldCurrent() > 0 && crew.getAliveCount() > 0;
    }

    public ResourceType [][] getPlanetSurface()
    {
        ResourceType [][] original = getCurrentSector().getPlanetSurface();
        ResourceType [][] surface = new ResourceType[SURFACE_SIDE_SIZE][];

        for (int i = 0; i < original.length; i++)
            surface[i] = original[i].clone();

        return surface;
    }

    public AlienType getAlienType()
    {
        return getCurrentSector().getAlienType();
    }

    public int [] getDronePosition()
    {
        int [] dronePosition = new int[2];
        dronePosition[0] = getCurrentSector().getDroneRow();
        dronePosition[1] = getCurrentSector().getDroneCol();

        return dronePosition;
    }

    public int [] getLandingPosition()
    {
        int [] landingPosition = new int[2];
        landingPosition[0] = getCurrentSector().getLandingRow();
        landingPosition[1] = getCurrentSector().getLandingCol();

        return landingPosition;
    }

    public int [] getAlienPosition()
    {
        int [] alienPosition = new int[2];
        alienPosition[0] = getCurrentSector().getAlienRow();
        alienPosition[1] = getCurrentSector().getAlienCol();

        return alienPosition;
    }

    public boolean droneCanMove(DroneDirection droneDirection)
    {
        return getCurrentSector().droneCanMove(droneDirection);
    }

    public List<ResourceType> getAvailableResourcesOnCurrentPlanet()
    {
        return new ArrayList<>(getCurrentSector().getPossibleResources());
    }

    public boolean droneCanGatherResource()
    {
        return getCurrentSector().droneCanGatherResource();
    }

    private void gatherResource()
    {
        ResourceType gatheredResource = getCurrentSector().getPlanetResource();
        getCurrentSector().gatherResource();
        // TODO log this

    }

    private Sector getCurrentSector()
    {
        return sectors.get(sectors.size() - 1);
    }

    private void attack()
    {
        int [] attackPossibilities;
        int [] deathPossibilities;

        switch (getCurrentSector().getAlienType())
        {
            case BLACK:
                attackPossibilities = BLACK_ALIEN_ATTACK_POSSIBILITIES;
                deathPossibilities = BLACK_ALIEN_DEATH_POSSIBILITIES;
                break;
            case GREEN:
                attackPossibilities = GREEN_ALIEN_ATTACK_POSSIBILITIES;
                deathPossibilities =GREEN_ALIEN_DEATH_POSSIBILITIES;
                break;
            case BLUE:
                attackPossibilities = BLUE_ALIEN_ATTACK_POSSIBILITIES;
                deathPossibilities = BLUE_ALIEN_DEATH_POSSIBILITIES;
                break;
            case RED:
                attackPossibilities = RED_ALIEN_ATTACK_POSSIBILITIES;
                deathPossibilities = RED_ALIEN_DEATH_POSSIBILITIES;
                break;
            default:
                attackPossibilities = new int[]{};
                deathPossibilities = new int[]{};
        }

        /* Alien Attack */
        System.out.println("ALIEN ATTACK...");
        // TODO LOG this
        int roll = Utility.throwDie(6);
        int finalRoll0 = roll;
        if (Arrays.stream(attackPossibilities).anyMatch(i -> i == finalRoll0))
        {
            System.out.println("ALIEN ATTACK SUCCESS: " + roll);
            // The alien attack was successful
            ship.decreaseDroneHealth();
            if (ship.droneWasDestroyed())
            {
                System.out.println("DRONE DESTROYED");
                // TODO log this
                return;
            }
        }

        System.out.println("DRONE ATTACK...");
        /* Drone Attack*/
        roll = Utility.throwDie(6);
        int finalRoll1 = roll;
        if (Arrays.stream(deathPossibilities).anyMatch(i -> i == finalRoll1))
        {
            System.out.println("DRONE ATTACK SUCCESS: " + roll);
            // The drone attack was successful
            // TODO log alien destroyed + rolls, etc.
            getCurrentSector().generateAlien();
        }
    }

    /* Message */
    public void setMessage(String msg)
    {
        message = msg;
    }

    public String getMessage()
    {
        return message;
    }


}
