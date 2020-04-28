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

        firePropertyChange(EVENT_UPDATE_VIEW_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_INTERACTION_PANE, null, null);
        firePropertyChange(EVENT_UPDATE_LOG_PANE, null, null);
    }

    public void move()
    {
        gameController.move();

        firePropertyChange(EVENT_UPDATE_VIEW_PANE, null, null);
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

    public PlanetType getCurrentSectorPlanetType()
    {
        return gameController.getCurrentSectorPlanetType();
    }

    /* Log */
    public String getMessage()
    {
        return gameController.getMessage();
    }
}
