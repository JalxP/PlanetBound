package model.states.concrete;

import model.data.GameData;
import model.states.IState;
import model.states.StateAdapter;

import static model.data.Constants.*;

public class AwaitMaintenance extends StateAdapter
{
    public AwaitMaintenance(GameData gameData)
    {
        super(gameData);
        getGameData().setMessage(SELECT_MAINTENANCE_MESSAGE);
    }

    @Override
    public IState maintain(MaintenanceType maintenanceType)
    {
        getGameData().maintain(maintenanceType);

        return new AwaitActionType(getGameData());
    }

    @Override
    public IState startConversion()
    {
        return new AwaitResourceConversion(getGameData());
    }

    @Override
    public IState cancel()
    {
        return new AwaitActionType(getGameData());
    }
}
