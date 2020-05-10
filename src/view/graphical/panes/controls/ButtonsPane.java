package view.graphical.panes.controls;

import controller.ObservableGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.states.IState;
import model.states.concrete.*;
import view.graphical.resources.Images;

import static model.data.GameEnums.*;
import static view.graphical.ConstantsUI.*;
import static view.graphical.resources.ResourcesPaths.SURFACE_DRONE;

public class ButtonsPane extends HBox
{
    private final ObservableGame observableGame;

    private ActionButton startGameButton;
    private ActionButton militaryShipSelectionButton;
    private ActionButton miningShipSelectionButton;
    private ActionButton travelButton;
    private ActionButton exploreButton;
    private ActionButton upgradeButton;
    private ActionButton endTurnButton;

    private ActionButton upButton;
    private ActionButton rightButton;
    private ActionButton downButton;
    private ActionButton leftButton;

    private ActionButton leavePlanetButton;

    private BorderPane movementButtons;

    private ImageView drone;

    public ButtonsPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        startGameButton = new ActionButton("Start Game");
        militaryShipSelectionButton = new ActionButton("Military Ship");
        miningShipSelectionButton = new ActionButton("Mining Ship");
        travelButton = new ActionButton("Travel");
        exploreButton = new ActionButton("Explore");
        upgradeButton = new ActionButton("Upgrade");
        endTurnButton = new ActionButton("End Turn");

        upButton = new ActionButton("↑");
        rightButton = new ActionButton("→");
        downButton = new ActionButton("↓");
        leftButton = new ActionButton("←");

        leavePlanetButton = new ActionButton("Leave Planet");

        movementButtons = new BorderPane();

        drone = new ImageView(Images.getImage(SURFACE_DRONE));

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
        travelButton.managedProperty().bind(travelButton.visibleProperty());
        exploreButton.managedProperty().bind(exploreButton.visibleProperty());
        upgradeButton.managedProperty().bind(upgradeButton.visibleProperty());
        upButton.managedProperty().bind(upButton.visibleProperty());
        rightButton.managedProperty().bind(rightButton.visibleProperty());
        downButton.managedProperty().bind(downButton.visibleProperty());
        leftButton.managedProperty().bind(leftButton.visibleProperty());
        leavePlanetButton.managedProperty().bind(leavePlanetButton.visibleProperty());

        movementButtons.managedProperty().bind(movementButtons.visibleProperty());
    }

    private void setupLayout()
    {
        getChildren().clear();
        setAlignment(Pos.CENTER);
        setSpacing(10);

        militaryShipSelectionButton.setVisible(false);
        miningShipSelectionButton.setVisible(false);
        travelButton.setVisible(false);
        exploreButton.setVisible(false);
        upgradeButton.setVisible(false);
        endTurnButton.setVisible(false);

        movementButtons.setVisible(false);

        movementButtons.setTop(upButton);
        movementButtons.setAlignment(upButton, Pos.CENTER);
        movementButtons.setRight(rightButton);
        movementButtons.setAlignment(rightButton, Pos.CENTER_RIGHT);
        movementButtons.setBottom(downButton);
        movementButtons.setAlignment(downButton, Pos.CENTER);
        movementButtons.setLeft(leftButton);
        movementButtons.setAlignment(leftButton, Pos.CENTER_LEFT);
        movementButtons.setCenter(drone);

        leavePlanetButton.setVisible(false);

        getChildren().addAll(startGameButton,
                militaryShipSelectionButton,
                miningShipSelectionButton,
                travelButton,
                exploreButton,
                upgradeButton,
                endTurnButton,
                leavePlanetButton,
                movementButtons);
    }

    private void setupListeners()
    {
        startGameButton.setOnAction(new StartGameButtonClicked());
        militaryShipSelectionButton.setOnAction(new MilitaryShipSelectionButtonClicked());
        miningShipSelectionButton.setOnAction(new MiningShipSelectionButtonClicked());
        travelButton.setOnAction(new MoveButtonClicked());
        exploreButton.setOnAction(new ExploreButtonClicked());
        upgradeButton.setOnAction(new UpgradeButtonClicked());
        endTurnButton.setOnAction(new EndTurnButtonClicked());
        upButton.setOnAction(new UpButtonClicked());
        rightButton.setOnAction(new RightButtonClicked());
        downButton.setOnAction(new DownButtonClicked());
        leftButton.setOnAction(new LeftButtonClicked());
        leavePlanetButton.setOnAction(new LeavePlanetButtonClicked());
    }

    public void update()
    {
        IState currentState = observableGame.getState();

        startGameButton.setVisible(currentState instanceof StartGame);

        militaryShipSelectionButton.setVisible(currentState instanceof AwaitShipSelection);
        miningShipSelectionButton.setVisible(currentState instanceof AwaitShipSelection);

        travelButton.setVisible(currentState instanceof AwaitMovement);

        exploreButton.setVisible(currentState instanceof AwaitActionType && observableGame.canExplore());

        upgradeButton.setVisible(currentState instanceof AwaitActionType && observableGame.canUpgrade());

        endTurnButton.setVisible(currentState instanceof AwaitActionType);

        if (currentState instanceof AwaitExplorationPhase)
        {
            leavePlanetButton.setVisible(true);
            movementButtons.setVisible(true);

            upButton.setDisable(!observableGame.droneCanMove(DroneDirection.UP));
            rightButton.setDisable(!observableGame.droneCanMove(DroneDirection.RIGHT));
            downButton.setDisable(!observableGame.droneCanMove(DroneDirection.DOWN));
            leftButton.setDisable(!observableGame.droneCanMove(DroneDirection.LEFT));

            leavePlanetButton.setDisable(!observableGame.canLeavePlanet());
        }
        else
        {
            movementButtons.setVisible(false);
            leavePlanetButton.setVisible(false);
        }
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
            observableGame.travel();
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

    private class UpButtonClicked implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.moveDrone(DroneDirection.UP);
        }
    }

    private class RightButtonClicked implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.moveDrone(DroneDirection.RIGHT);
        }
    }

    private class DownButtonClicked implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.moveDrone(DroneDirection.DOWN);
        }
    }

    private class LeftButtonClicked implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.moveDrone(DroneDirection.LEFT);
        }
    }

    private class LeavePlanetButtonClicked implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.leavePlanet();
        }
    }
}
