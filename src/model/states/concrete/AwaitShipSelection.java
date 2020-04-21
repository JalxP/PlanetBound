package model.states.concrete;

import model.data.GameData;
import model.states.IState;
import model.states.StateAdapter;

import static model.data.Constants.*;

public class AwaitShipSelection extends StateAdapter
{
    public AwaitShipSelection(GameData gameData)
    {
        super(gameData);
        getGameData().setMessage(SELECT_SHIP_MESSAGE);
    }

    @Override
    public IState selectShip(ShipType shipType)
    {
        getGameData().selectShipType(shipType);

        return new AwaitMovement(getGameData());
    }
}
