package model.states.concrete;

import model.data.GameData;
import model.states.IState;
import model.states.StateAdapter;

import static model.data.Constants.*;

public class Defeat extends StateAdapter
{
    public Defeat(GameData gameData)
    {
        super(gameData);
        getGameData().setMessage(DEFEAT_MESSAGE);
    }

    @Override
    public IState endGame()
    {
        return new StartGame(new GameData());
    }
}
