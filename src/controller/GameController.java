package controller;

import model.data.GameData;
import model.data.GameEnums;
import model.states.IState;
import model.states.concrete.StartGame;

public class GameController implements GameEnums
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

}
