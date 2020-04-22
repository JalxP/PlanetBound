package model.states.concrete;

import model.data.GameData;
import model.states.StateAdapter;

import static model.data.Constants.*;

public class AwaitActionType extends StateAdapter
{
    public AwaitActionType(GameData gameData)
    {
        super(gameData);
        getGameData().setMessage(SELECT_ACTION_MESSAGE);
    }

    // TODO implement selectAction(ActionType actionType)
}
