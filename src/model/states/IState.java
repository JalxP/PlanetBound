package model.states;

import model.data.GameData;
import model.data.GameEnums.*;

public interface IState
{
    GameData getGameData();
    void setGame(GameData gameData);

    IState startGame();
    IState selectShip(ShipType shipType);
    IState move();
}
