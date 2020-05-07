package view.graphical.panes.controls;

import controller.ObservableGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import model.states.IState;
import model.states.concrete.AwaitActionType;
import model.states.concrete.AwaitMovement;
import model.states.concrete.AwaitShipSelection;
import model.states.concrete.StartGame;

import static model.data.GameEnums.*;
import static view.graphical.ConstantsUI.*;

public class ButtonsPane extends HBox
{
    private final ObservableGame observableGame;

    private ActionButton startGameButton;
    private ActionButton militaryShipSelectionButton;
    private ActionButton miningShipSelectionButton;
    private ActionButton moveButton;
    private ActionButton exploreButton;
    private ActionButton upgradeButton;
    private ActionButton endTurnButton;

    public ButtonsPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        startGameButton = new ActionButton("Start Game");
        militaryShipSelectionButton = new ActionButton("Military Ship");
        miningShipSelectionButton = new ActionButton("Mining Ship");
        moveButton = new ActionButton("Move");
        exploreButton = new ActionButton("Explore");
        upgradeButton = new ActionButton("Upgrade");
        endTurnButton = new ActionButton("End Turn");

        setupSize();
        setupLayout();
        setupListeners();
        bindButtonsVisibilityToLayout();
    }

    private void setupSize()
    {
        setMinHeight(INTERACTION_PANE_HEIGHT);
    }

    private void bindButtonsVisibilityToLayout()
    {
        startGameButton.managedProperty().bind(startGameButton.visibleProperty());
        militaryShipSelectionButton.managedProperty().bind(militaryShipSelectionButton.visibleProperty());
        miningShipSelectionButton.managedProperty().bind(miningShipSelectionButton.visibleProperty());
        moveButton.managedProperty().bind(moveButton.visibleProperty());
        exploreButton.managedProperty().bind(exploreButton.visibleProperty());
        upgradeButton.managedProperty().bind(upgradeButton.visibleProperty());

    }

    private void setupLayout()
    {
        getChildren().clear();
        setAlignment(Pos.CENTER);
        setSpacing(10);

        militaryShipSelectionButton.setVisible(false);
        miningShipSelectionButton.setVisible(false);
        moveButton.setVisible(false);
        exploreButton.setVisible(false);
        upgradeButton.setVisible(false);
        endTurnButton.setVisible(false);

        getChildren().addAll(startGameButton,
                militaryShipSelectionButton,
                miningShipSelectionButton,
                moveButton,
                exploreButton,
                upgradeButton,
                endTurnButton);
    }

    private void setupListeners()
    {
        startGameButton.setOnAction(new StartGameButtonClicked());
        militaryShipSelectionButton.setOnAction(new MilitaryShipSelectionButtonClicked());
        miningShipSelectionButton.setOnAction(new MiningShipSelectionButtonClicked());
        moveButton.setOnAction(new MoveButtonClicked());
        exploreButton.setOnAction(new ExploreButtonClicked());
        upgradeButton.setOnAction(new UpgradeButtonClicked());
        endTurnButton.setOnAction(new EndTurnButtonClicked());

    }

    public void update()
    {
        IState currentState = observableGame.getState();

        startGameButton.setVisible(currentState instanceof StartGame);

        militaryShipSelectionButton.setVisible(currentState instanceof AwaitShipSelection);
        miningShipSelectionButton.setVisible(currentState instanceof AwaitShipSelection);

        moveButton.setVisible(currentState instanceof AwaitMovement);

        exploreButton.setVisible(currentState instanceof AwaitActionType && observableGame.canExplore());

        upgradeButton.setVisible(currentState instanceof AwaitActionType && observableGame.canUpgrade());

        endTurnButton.setVisible(currentState instanceof AwaitActionType);

    }

    /* Handlers */
    private class StartGameButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.startGame();
        }
    }

    private class MilitaryShipSelectionButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.selectShip(ShipType.MILITARY);
        }
    }

    private class MiningShipSelectionButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.selectShip(ShipType.MINING);
        }
    }

    private class MoveButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.move();
        }
    }

    private class ExploreButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.explore();
        }
    }

    private class UpgradeButtonClicked implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent)
        {
            // observableGame.upgrade(); TODO
        }
    }

    private class EndTurnButtonClicked implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.endTurn();
        }
    }
}
