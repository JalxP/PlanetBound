package model.states.concrete;

import model.data.GameData;
import model.states.IState;
import model.states.StateAdapter;

import static model.data.Constants.*;

public class Victory extends StateAdapter
{
    public Victory(GameData gameData)
    {
        super(gameData);
        getGameData().setMessage(VICTORY_MESSAGE);
    }

    @Override
    public IState endGame()
    {
        return new StartGame(new GameData());
    }
}
