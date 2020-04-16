package controller;

import model.states.IState;

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


    /* Info */
    public String getShipType()
    {
        return gameController.getShipType();
    }
}
