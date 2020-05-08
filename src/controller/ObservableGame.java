package controller;


import model.states.IState;

import static view.graphical.EventNames.*;
import static model.data.GameEnums.*;

import java.beans.PropertyChangeSupport;

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

        firePropertyChange(EVENT_UPDATE_FULL_VIEW_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_INTERACTION_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_LOG_PANE, null, null);
    }

    public void move()
    {
        gameController.move();

        firePropertyChange(EVENT_UPDATE_FULL_VIEW_PANE, null, null);
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

    public String getShieldAmount()
    {
        return gameController.getShieldAmount();
    }

    public String getFuelAmount()
    {
        return gameController.getFuelAmount();
    }

    public String getDronesAmount()
    {
        return gameController.getDronesAmount();
    }

    public String getArtifactsAmount()
    {
        return gameController.getArtifactsAmount();
    }

    public boolean canUpgrade()
    {
        return gameController.canUpgrade();
    }

    public boolean canExplore()
    {
        return gameController.canExplore();
    }

    public ResourceType [][] getPlanetSurface()
    {
        return gameController.getPlanetSurface();
    }

    /* Log */
    public String getMessage()
    {
        return gameController.getMessage();
    }
}
