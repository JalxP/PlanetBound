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

    public IState move()
    {
        // TODO me
        return null;
    }

}
