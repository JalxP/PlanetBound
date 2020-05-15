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
        getGameData().setMessage(TRAVEL_SHIP_MESSAGE);
    }


    @Override
    public IState travel()
    {
        getGameData().travel();

        if (getGameData().isCurrentSectorPlanet())
            return new AwaitActionType(getGameData());

        return new AwaitEventSelection(getGameData());
    }
}
