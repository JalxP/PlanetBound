package model.states.concrete;

import model.data.GameData;
import model.states.IState;
import model.states.StateAdapter;

import static model.data.Constants.*;

public class AwaitActionType extends StateAdapter
{
    public AwaitActionType(GameData gameData)
    {
        super(gameData);
        getGameData().setMessage(SELECT_ACTION_MESSAGE);
    }

    @Override
    public IState explore()
    {
        getGameData().explore(); // TODO is this needed?

        return new AwaitExplorationPhase(getGameData());
    }

    @Override
    public IState endTurn()
    {
        getGameData().endTurn();

        if (getGameData().gameIsOver())
            return new Victory(getGameData());
        else if (getGameData().canContinue())
            return new AwaitMovement(getGameData());

        return new Defeat(getGameData());
    }
}
