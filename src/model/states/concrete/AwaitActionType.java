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
        getGameData().explore();

        return new AwaitExplorationPhase(getGameData());
    }

    @Override
    public IState startMaintenance()
    {
        return new AwaitMaintenance(getGameData());
    }

    @Override
    public IState endTurn()
    {
        getGameData().endTurn();

        if (getGameData().collectedAllArtifacts())
            return new Victory(getGameData());
        else if (getGameData().canContinue())
            return new AwaitMovement(getGameData());

        return new Defeat(getGameData());
    }

    @Override
    public IState enterSpaceStation()
    {
        getGameData().enterSpaceStation();

        return new AwaitUpgrade(getGameData());
    }
}
