package model.states;

import model.data.GameData;
import model.data.GameEnums.*;

public interface IState
{
    GameData getGameData();
    void setGame(GameData gameData);

    IState startGame();
    IState selectShip(ShipType shipType);
    IState travel();
    IState explore();
    IState moveDrone(DroneDirection droneDirection);
    IState leavePlanet();
    IState enterSpaceStation();
    IState cancel();
    IState upgrade(UpgradeType upgradeType);
    //TODO IState convert(ResourceType from, ResourceType to);
    IState endTurn();
    IState endGame();
}
