package model.states.concrete;

import model.data.GameData;
import model.states.IState;
import model.states.StateAdapter;

public class AwaitShipSelection extends StateAdapter
{
    public AwaitShipSelection(GameData gameData)
    {
        super(gameData);
    }

    @Override
    public IState selectShip(ShipType shipType)
    {
        getGameData().setShipType(shipType);

        return null; // TODO next state goes here
    }
}
