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
        logger.add(getCurrentSector().getAllLogs());

        if (getCurrentSector().isTravelWormHole())
        {
            int spentFuel = (crew.getCrewStatusByIndex(3)) ? 3 : 4;
            logger.add("[!]Spent " + spentFuel + " fuel units.");
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
        logger.add(getCurrentSector().getSurfaceLogs());
    }

    public void moveDrone(DroneDirection droneDirection)
    {
        getCurrentSector().moveDrone(droneDirection);
        if (droneCanGatherResource())
            gatherResource();

        if (!getCurrentSector().alienIsNextToDrone())
            getCurrentSector().moveAlien();

        while (getCurrentSector().alienIsNextToDrone() && droneIsAvailable())
            attack();
    }

    public void leavePlanet()
    {
        // store the gathered resource
        ship.storeResourceOnCargoHold();
        logger.add(ship.getAllLogs());

    }

    public void endTurn()
    {
        // TODO
        // fuel and stuff
    }

    public void enterSpaceStation()
    {
        logger.add("[OK]The ship has docked on the local space station.");
    }

    public void upgrade(UpgradeType upgradeType)
    {
        System.out.println("Upgrading... " + upgradeType.name());
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

    public String getCargoHoldMaxAsString()
    {
        return (ship == null) ? "*" : ship.getCargoHoldMax() + "";
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

    public boolean canEnterSpaceStation()
    {
        return getCurrentSector().hasSpaceStation();
    }

    public boolean canUpgrade(UpgradeType upgradeType)
    {
        return true; // TODO CONTINUE HERE!!
    }

    public boolean canExplore()
    {
        boolean hasDrone = ship.isDroneOperational();
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
        ResourceType collectedResource = getCurrentSector().getPlanetResource();
        ship.storeResourceOnDrone(collectedResource);
        getCurrentSector().gatherResource();
        logger.add("[OK]The drone has collected the " + collectedResource.name() + " resource.");

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
        logger.add("[X]Alien attack.");
        int roll = Utility.throwDie(6);
        int finalRoll0 = roll;
        if (Arrays.stream(attackPossibilities).anyMatch(i -> i == finalRoll0))
        {
            logger.add("[!]The alien has attacked the drone -1HP. Rolled: " + roll);
            ship.decreaseDroneHealth();
            if (!ship.droneIsOperational())
            {
                logger.add("[X]The drone was destroyed.");
                return;
            }
        }
        else
            logger.add("[OK]The alien has missed the drone. Rolled: " + roll);

        /* Drone Attack*/
        logger.add("[OK]Drone attack.");
        roll = Utility.throwDie(6);
        int finalRoll1 = roll;
        if (Arrays.stream(deathPossibilities).anyMatch(i -> i == finalRoll1))
        {
            logger.add("[OK]The alien was destroyed! Rolled: " + roll);
            getCurrentSector().generateAlien();
            logger.add(getCurrentSector().getSurfaceLogs());
        }
        else
            logger.add("[!]The drone has missed the alien. Rolled: " + roll);
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

    public ArrayList<String> getAllLogs()
    {
        return logger.getLogAndClear();
    }


}
