package controller;

import model.data.GameData;
import model.data.GameEnums;
import model.states.IState;
import model.states.concrete.StartGame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameController implements GameEnums, Serializable
{
    private GameData gameData;
    private IState state;

    public GameController()
    {
        gameData = new GameData();
        setState(new StartGame(gameData));
    }

    public IState getState()
    {
        return state;
    }

    public void setState(IState state)
    {
        this.state = state;
    }

    /* Actions */
    public void startGame()
    {
        setState(state.startGame());
    }

    public void selectShip(ShipType shipType)
    {
        setState(state.selectShip(shipType));
    }

    public void travel()
    {
        setState(state.travel());
    }

    public void explore()
    {
        setState(state.explore());
    }

    public void endTurn()
    {
        setState(state.endTurn());
    }

    public void moveDrone(DroneDirection droneDirection)
    {
        setState(state.moveDrone(droneDirection));
    }

    public void leavePlanet()
    {
        setState(state.leavePlanet());
    }

    public void enterSpaceStation()
    {
        setState(state.enterSpaceStation());
    }

    public void upgrade(UpgradeType upgradeType)
    {
        setState(state.upgrade(upgradeType));
    }

    public void selectEvent(EventType eventType)
    {
        setState(state.selectEvent(eventType));
    }

    public void cancel()
    {
        setState(state.cancel());
    }

    public void startMaintenance()
    {
        setState(state.startMaintenance());
    }

    public void maintain(MaintenanceType maintenanceType)
    {
        setState(state.maintain(maintenanceType));
    }

    public void startConversion()
    {
        setState(state.startConversion());
    }

    public void convertResource(ResourceType from, ResourceType to)
    {
        setState(state.convertResource(from, to));
    }

    public void endGame()
    {
        setState(state.endGame());
        gameData = state.getGameData();
    }

    /* Info */

    public String getShipType()
    {
        return gameData.getShipType();
    }

    public boolean getCrewStatusByIndex(int i)
    {
        return gameData.getCrewStatusByIndex(i);
    }

    public String getCrewNameByIndex(int i)
    {
        return gameData.getCrewNameByIndex(i);
    }

    public boolean isCurrentSectorTravelModeWormHole()
    {
        return gameData.isCurrentSectorTravelModeWormHole();
    }

    public boolean currentSectorHasSpaceStation()
    {
        return gameData.currentSectorHasSpaceStation();
    }

    public boolean currentSectorIsEvent()
    {
        return gameData.currentSectorIsEvent();
    }

    public PlanetType getCurrentSectorPlanetType()
    {
        return gameData.getCurrentSectorPlanetType();
    }

    public List<ResourceType> getAvailableResourcesOnCurrentPlanet()
    {
        return gameData.getAvailableResourcesOnCurrentPlanet();
    }

    public String getCargoHoldMaxAsString()
    {
        return gameData.getCargoHoldMaxAsString();
    }

    public String getShieldAmount()
    {
        return gameData.getShieldAmount();
    }

    public String getFuelAmount()
    {
        return gameData.getFuelAmount();
    }

    public String getAvailableDrones()
    {
        return gameData.getAvailableDrones();
    }

    public String getAmmoAmount()
    {
        return gameData.getAmmoAmount();
    }

    public String getDroneHealth()
    {
        return gameData.getDroneHealth();
    }

    public String getResourcesAsString(ResourceType resourceType)
    {
        return gameData.getResourcesAsString(resourceType);
    }

    public boolean hasResources(ResourceType resourceType)
    {
        return gameData.hasResources(resourceType);
    }

    public ResourceType [][] getPlanetSurface()
    {
        return gameData.getPlanetSurface();
    }

    public AlienType getAlienType()
    {
        return gameData.getAlienType();
    }

    public int [] getDronePosition()
    {
        return gameData.getDronePosition();
    }

    public int [] getLandingPosition()
    {
        return gameData.getLandingPosition();
    }

    public int [] getAlienPosition()
    {
        return gameData.getAlienPosition();
    }

    public boolean droneCanMove(DroneDirection droneDirection)
    {
        return gameData.droneCanMove(droneDirection);
    }

    public boolean canEnterSpaceStation()
    {
        return gameData.canEnterSpaceStation();
    }

    public boolean canUpgrade(UpgradeType upgradeType)
    {
        return gameData.canUpgrade(upgradeType);
    }

    public boolean canExplore()
    {
        return gameData.canExplore();
    }

    public boolean canLeavePlanet()
    {
        return gameData.canLeavePlanet();
    }

    public boolean canMaintainShip()
    {
        return gameData.canMaintainShip();
    }

    public boolean canMaintain(MaintenanceType maintenanceType)
    {
        return gameData.canMaintain(maintenanceType);
    }

    public boolean canConvert()
    {
        return gameData.canConvert();
    }

    public String getLevelOfCargoHold()
    {
        return gameData.getLevelOfCargoHold();
    }

    public String getLevelOfAmmo()
    {
        return gameData.getLevelOfAmmo();
    }

    public String getMessage()
    {
        return gameData.getMessage();
    }

    public ArrayList<String> getAllLogs()
    {
        return gameData.getAllLogs();
    }
}
