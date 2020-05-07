package model.states.concrete;

import model.data.GameData;
import model.states.IState;
import model.states.StateAdapter;

import static model.data.Constants.*;

public class AwaitMovement extends StateAdapter
{
    public AwaitMovement(GameData gameData)
    {
        super(gameData);
        getGameData().setMessage(MOVE_SHIP_MESSAGE);
    }


    @Override
    public IState move()
    {
        getGameData().move();

        if (getGameData().isCurrentSectorPlanet())
            return new AwaitActionType(getGameData());

        return new AwaitEventSelection(getGameData());
    }

    @Override
    public IState explore()
    {
        getGameData().explore();

        return new AwaitExplorationPhase(getGameData());
    }
}
