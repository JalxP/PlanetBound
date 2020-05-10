package model.states;

import model.data.GameData;
import model.data.GameEnums;

public class StateAdapter implements IState, GameEnums

{
    private GameData gameData;

    public StateAdapter(GameData gameData)
    {
        this.gameData = gameData;
    }

    @Override
    public GameData getGameData()
    {
        return gameData;
    }

    @Override
    public void setGame(GameData gameData)
    {
        this.gameData = gameData;
    }


    /* Actions */
    @Override
    public IState startGame()
    {
        return this;
    }

    @Override
    public IState selectShip(ShipType shipType)
    {
        return this;
    }

    @Override
    public IState travel()
    {
        return this;
    }

    @Override
    public IState explore()
    {
        return this;
    }

    @Override
    public IState moveDrone(DroneDirection droneDirection)
    {
        return this;
    }

    @Override
    public IState leavePlanet()
    {
        return this;
    }

    @Override
    public IState endTurn()
    {
        return this;
    }

    @Override
    public IState endGame()
    {
        return this;
    }
}
