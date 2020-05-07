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

//    @Override
//    public IState moveDrone(DroneDirection droneDirection)
//    {
//        // TODO getGameData.moveDrone(droneDirection);
//    }
}
