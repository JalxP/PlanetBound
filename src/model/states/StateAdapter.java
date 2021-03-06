package model.states;

import model.data.GameData;
import model.data.GameEnums;
import model.states.concrete.StartGame;

import java.io.Serializable;

public class StateAdapter implements IState, GameEnums, Serializable

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
    public IState enterSpaceStation()
    {
        return this;
    }

    @Override
    public IState cancel()
    {
        return this;
    }

    @Override
    public IState upgrade(UpgradeType upgradeType)
    {
        return this;
    }

    @Override
    public IState startMaintenance()
    {
        return this;
    }

    @Override
    public IState maintain(MaintenanceType maintenanceType)
    {
        return this;
    }

    @Override
    public IState startConversion()
    {
        return this;
    }

    @Override
    public IState convertResource(ResourceType from, ResourceType to)
    {
        return this;
    }

    @Override
    public IState selectEvent(EventType eventType)
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
        return new StartGame(new GameData());
    }
}
