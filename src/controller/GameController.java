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

    public void move()
    {
        setState(state.move());
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

    public PlanetType getCurrentSectorPlanetType()
    {
        return gameData.getCurrentSectorPlanetType();
    }

    /* Log */
    public String getMessage()
    {
        return gameData.getMessage();
    }


}
