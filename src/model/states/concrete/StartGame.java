package model.states.concrete;

import model.data.GameData;
import model.states.IState;
import model.states.StateAdapter;

public class StartGame extends StateAdapter
{
    public StartGame(GameData gameData)
    {
        super(gameData);
    }

    @Override
    public IState startGame()
    {
        return new AwaitShipSelection(getGameData());
    }
}
