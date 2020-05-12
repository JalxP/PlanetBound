package controller;


import model.states.IState;

import static view.graphical.EventNames.*;
import static model.data.GameEnums.*;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ObservableGame extends PropertyChangeSupport
{
    private GameController gameController;

    public ObservableGame(GameController gameController)
    {
        super(gameController);
        this.gameController = gameController;
    }

    public GameController getGameController()
    {
        return gameController;
    }

    public void setGameController(GameController gameController)
    {
        this.gameController = gameController;
    }

    public IState getState()
    {
        return gameController.getState();
    }

    /* States */
    public void startGame()
    {
        gameController.startGame();
        firePropertyChange(EVENT_UPDATE_INTERACTION_PANE, null, null);
    }

    public void selectShip(ShipType shipType)
    {
        gameController.selectShip(shipType);

        firePropertyChange(EVENT_UPDATE_INFO_VIEW_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_INTERACTION_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_LOG_PANE, null, null);
    }

    public void travel()
    {
        gameController.travel();

        firePropertyChange(EVENT_UPDATE_INFO_VIEW_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_TRAVEL_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_INTERACTION_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_LOG_PANE, null, null);
    }

    public void explore()
    {
        gameController.explore();

        firePropertyChange(EVENT_UPDATE_PLANET_SURFACE_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_INTERACTION_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_LOG_PANE, null, null);
    }

    public void endTurn()
    {
        gameController.endTurn();

        firePropertyChange(EVENT_UPDATE_FULL_VIEW_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_INTERACTION_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_LOG_PANE, null, null);
    }

    public void moveDrone(DroneDirection droneDirection)
    {
        gameController.moveDrone(droneDirection);

        firePropertyChange(EVENT_UPDATE_FULL_VIEW_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_INTERACTION_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_LOG_PANE, null, null);
    }

    public void leavePlanet()
    {
        gameController.leavePlanet();

        firePropertyChange(EVENT_UPDATE_FULL_VIEW_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_INTERACTION_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_LOG_PANE, null, null);
    }

    public void enterSpaceStation()
    {
        gameController.enterSpaceStation();

        firePropertyChange(EVENT_UPDATE_FULL_VIEW_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_INTERACTION_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_LOG_PANE, null, null);
    }

    public void upgrade(UpgradeType upgradeType)
    {
        gameController.upgrade(upgradeType);

        firePropertyChange(EVENT_UPDATE_FULL_VIEW_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_INTERACTION_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_LOG_PANE, null, null);
    }

    public void cancel()
    {
        gameController.cancel();

        firePropertyChange(EVENT_UPDATE_FULL_VIEW_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_INTERACTION_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_LOG_PANE, null, null);
    }

    public void startMaintenance()
    {
        gameController.startMaintenance();

        firePropertyChange(EVENT_UPDATE_FULL_VIEW_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_INTERACTION_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_LOG_PANE, null, null);
    }

    public void maintain(MaintenanceType maintenanceType)
    {
        gameController.maintain(maintenanceType);

        firePropertyChange(EVENT_UPDATE_FULL_VIEW_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_INTERACTION_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_LOG_PANE, null, null);
    }

    public void startConversion()
    {
        gameController.startConversion();

        firePropertyChange(EVENT_UPDATE_FULL_VIEW_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_INTERACTION_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_LOG_PANE, null, null); // TODO check what needs to be fired
    }

    public void convertResource(ResourceType from, ResourceType to)
    {
        gameController.convertResource(from, to);

        firePropertyChange(EVENT_UPDATE_FULL_VIEW_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_INTERACTION_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_LOG_PANE, null, null); // TODO check what needs to be fired
    }

    /* Info */
    public String getShipType()
    {
        return gameController.getShipType();
    }

    public boolean getCrewStatusByIndex(int i)
    {
        return gameController.getCrewStatusByIndex(i);
    }

    public String getCrewNameByIndex(int i)
    {
        return gameController.getCrewNameByIndex(i);
    }

    public boolean isCurrentSectorTravelModeWormHole()
    {
        return gameController.isCurrentSectorTravelModeWormHole();
    }

    public boolean currentSectorHasSpaceStation()
    {
        return gameController.currentSectorHasSpaceStation();
    }

    public boolean currentSectorIsEvent()
    {
        return gameController.currentSectorIsEvent();
    }

    public PlanetType getCurrentSectorPlanetType()
    {
        return gameController.getCurrentSectorPlanetType();
    }

    public List<ResourceType> getAvailableResourcesOnCurrentPlanet()
    {
        return gameController.getAvailableResourcesOnCurrentPlanet();
    }

    public String getCargoHoldMaxAsString()
    {
        return gameController.getCargoHoldMaxAsString();
    }

    public String getShieldAmount()
    {
        return gameController.getShieldAmount();
    }

    public String getFuelAmount()
    {
        return gameController.getFuelAmount();
    }

    public String getDroneHealth()
    {
        return gameController.getDroneHealth();
    }

    public String getResourcesAsString(ResourceType resourceType)
    {
        return gameController.getResourcesAsString(resourceType);
    }

    public boolean hasResources(ResourceType resourceType)
    {
        return gameController.hasResources(resourceType);
    }

    public ResourceType [][] getPlanetSurface()
    {
        return gameController.getPlanetSurface();
    }

    public AlienType getAlienType()
    {
        return gameController.getAlienType();
    }

    public int [] getDronePosition()
    {
        return gameController.getDronePosition();
    }

    public int [] getLandingPosition()
    {
        return gameController.getLandingPosition();
    }

    public int [] getAlienPosition()
    {
        return gameController.getAlienPosition();
    }

    public boolean droneCanMove(DroneDirection droneDirection)
    {
        return gameController.droneCanMove(droneDirection);
    }

    public boolean canEnterSpaceStation()
    {
        return gameController.canEnterSpaceStation();
    }

    public boolean canUpgrade(UpgradeType upgradeType)
    {
        return gameController.canUpgrade(upgradeType);
    }

    public boolean canExplore()
    {
        return gameController.canExplore();
    }

    public boolean canLeavePlanet()
    {
        return gameController.canLeavePlanet();
    }

    public boolean canMaintainShip()
    {
        return gameController.canMaintainShip();
    }

    public boolean canMaintain(MaintenanceType maintenanceType)
    {
        return gameController.canMaintain(maintenanceType);
    }

    public boolean canConvert()
    {
        return gameController.canConvert();
    }

    /* Log */
    public String getMessage()
    {
        return gameController.getMessage();
    }

    public ArrayList<String> getAllLogs()
    {
        return gameController.getAllLogs();
    }
}
