package model.states.concrete;

import model.data.GameData;
import model.states.IState;
import model.states.StateAdapter;

import static model.data.Constants.*;

public class AwaitUpgrade extends StateAdapter
{
    public AwaitUpgrade(GameData gameData)
    {
        super(gameData);
        getGameData().setMessage(SPACE_STATION_MESSAGE);
    }

    @Override
    public IState upgrade(UpgradeType upgradeType)
    {
        getGameData().upgrade(upgradeType);

        return new AwaitActionType(getGameData());
    }

    @Override
    public IState cancel()
    {
        return new AwaitActionType(getGameData());
    }
}
