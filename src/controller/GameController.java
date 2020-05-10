package controller;

import model.data.GameData;
import model.data.GameEnums;
import model.states.IState;
import model.states.concrete.StartGame;

import java.util.List;

public class GameController implements GameEnums
{
    private GameData gameData;
    private IState state;

    public GameController()
    {
        gameData = new GameData();
        setState(new StartGame(gameData));
    }

    public IState getState()
    {
        return state;
    }

    public void setState(IState state)
    {
        this.state = state;
    }

    /* Actions */
    public void startGame()
    {
        setState(state.startGame());
    }

    public void selectShip(ShipType shipType)
    {
        setState(state.selectShip(shipType));
    }

    public void travel()
    {
        setState(state.travel());
    }

    public void explore()
    {
        setState(state.explore());
    }

    public void endTurn()
    {
        setState(state.endTurn());
    }

    public void moveDrone(DroneDirection droneDirection)
    {
        setState(state.moveDrone(droneDirection));
    }

    public void leavePlanet()
    {
        setState(state.leavePlanet());
    }

    /* Info */

    public String getShipType()
    {
        return gameData.getShipType();
    }
    public boolean getCrewStatusByIndex(int i)
    {
        return gameData.getCrewStatusByIndex(i);
    }

    public String getCrewNameByIndex(int i)
    {
        return gameData.getCrewNameByIndex(i);
    }

    public boolean isCurrentSectorTravelModeWormHole()
    {
        return gameData.isCurrentSectorTravelModeWormHole();
    }

    public boolean currentSectorHasSpaceStation()
    {
        return gameData.currentSectorHasSpaceStation();
    }

    public boolean currentSectorIsEvent()
    {
        return gameData.currentSectorIsEvent();
    }

    public PlanetType getCurrentSectorPlanetType()
    {
        return gameData.getCurrentSectorPlanetType();
    }

    public List<ResourceType> getAvailableResourcesOnCurrentPlanet()
    {
        return gameData.getAvailableResourcesOnCurrentPlanet();
    }

    public String getShieldAmount()
    {
        return gameData.getShieldAmount();
    }

    public String getFuelAmount()
    {
        return gameData.getFuelAmount();
    }

    public String getDronesAmount()
    {
        return gameData.getDronesAmount();
    }

    public String getResourcesAsString(ResourceType resourceType)
    {
        return gameData.getResourcesAsString(resourceType);
    }

    public ResourceType [][] getPlanetSurface()
    {
        return gameData.getPlanetSurface();
    }

    public AlienType getAlienType()
    {
        return gameData.getAlienType();
    }

    public int [] getDronePosition()
    {
        return gameData.getDronePosition();
    }

    public int [] getLandingPosition()
    {
        return gameData.getLandingPosition();
    }

    public int [] getAlienPosition()
    {
        return gameData.getAlienPosition();
    }

    public boolean droneCanMove(DroneDirection droneDirection)
    {
        return gameData.droneCanMove(droneDirection);
    }

    public boolean canUpgrade()
    {
        return gameData.canUpgrade();
    }

    public boolean canExplore()
    {
        return gameData.canExplore();
    }

    public boolean canLeavePlanet()
    {
        return gameData.canLeavePlanet();
    }

    public String getMessage()
    {
        return gameData.getMessage();
    }

}
