package model.states.concrete;

import model.data.GameData;
import model.states.IState;
import model.states.StateAdapter;

import static model.data.Constants.*;

public class AwaitResourceConversion extends StateAdapter
{
    public AwaitResourceConversion(GameData gameData)
    {
        super(gameData);
        getGameData().setMessage(SELECT_CONVERSION_MESSAGE);
    }

    @Override
    public IState convertResource(ResourceType from, ResourceType to)
    {
        getGameData().convertResource(from, to);

        return new AwaitMaintenance(getGameData());
    }

    @Override
    public IState cancel()
    {
        return new AwaitMaintenance(getGameData());
    }
}
