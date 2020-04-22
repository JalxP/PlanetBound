package model.states.concrete;

import model.data.GameData;
import model.states.StateAdapter;

import static model.data.Constants.*;

public class AwaitEventSelection extends StateAdapter
{
    public AwaitEventSelection(GameData gameData)
    {
        super(gameData);
        getGameData().setMessage(SELECT_EVENT_MESSAGE);
    }
}
