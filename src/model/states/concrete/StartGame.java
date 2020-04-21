package model.states.concrete;

import model.data.GameData;
import model.states.IState;
import model.states.StateAdapter;

import static model.data.Constants.*;

public class StartGame extends StateAdapter
{
    public StartGame(GameData gameData)
    {
        super(gameData);
        getGameData().setMessage(START_GAME_MESSAGE);
    }

    @Override
    public IState startGame()
    {
        return new AwaitShipSelection(getGameData());
    }
}
