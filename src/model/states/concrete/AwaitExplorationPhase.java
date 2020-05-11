package model.states.concrete;

import model.data.GameData;
import model.states.IState;
import model.states.StateAdapter;

import static model.data.Constants.*;

public class AwaitExplorationPhase extends StateAdapter
{
    public AwaitExplorationPhase(GameData gameData)
    {
        super(gameData);
        getGameData().setMessage(DRONE_ACTION_MESSAGE);
    }

    @Override
    public IState moveDrone(DroneDirection droneDirection)
    {
        getGameData().moveDrone(droneDirection);

        if (getGameData().droneIsAvailable())
            return this;
        else
            return new AwaitActionType(getGameData());
    }

    @Override
    public IState leavePlanet()
    {
        getGameData().leavePlanet();
        // TODO
        return new AwaitActionType(getGameData());
    }
}
