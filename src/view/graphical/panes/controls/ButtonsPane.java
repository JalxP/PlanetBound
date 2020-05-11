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
    private ActionButton enterStationButton;

    private ActionButton endTurnButton;

    private ActionButton upButton;
    private ActionButton rightButton;
    private ActionButton downButton;
    private ActionButton leftButton;

    private ActionButton leavePlanetButton;

    private ActionButton upgradeCargoButton;
    private ActionButton convertResourceButton;
    private ActionButton hireMemberButton;
    private ActionButton upgradeWeapon;
    private ActionButton fillArmorButton;
    private ActionButton buyDroneButton;
    private ActionButton cancelButton;

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
        enterStationButton = new ActionButton("Enter Space Station");

        endTurnButton = new ActionButton("End Turn");

        upButton = new ActionButton("↑");
        rightButton = new ActionButton("→");
        downButton = new ActionButton("↓");
        leftButton = new ActionButton("←");

        upgradeCargoButton = new ActionButton("Upgrade Cargo Hold");
        convertResourceButton = new ActionButton("Convert Resource");
        hireMemberButton = new ActionButton("Hire Crew Member");
        upgradeWeapon = new ActionButton("Upgrade Weapon");
        fillArmorButton = new ActionButton("Replenish Armor");
        buyDroneButton = new ActionButton("Buy Drone");
        cancelButton = new ActionButton("Cancel");

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
        enterStationButton.managedProperty().bind(enterStationButton.visibleProperty());
        upButton.managedProperty().bind(upButton.visibleProperty());
        rightButton.managedProperty().bind(rightButton.visibleProperty());
        downButton.managedProperty().bind(downButton.visibleProperty());
        leftButton.managedProperty().bind(leftButton.visibleProperty());
        leavePlanetButton.managedProperty().bind(leavePlanetButton.visibleProperty());
        movementButtons.managedProperty().bind(movementButtons.visibleProperty());
        upgradeCargoButton.managedProperty().bind(upgradeCargoButton.visibleProperty());
        convertResourceButton.managedProperty().bind(convertResourceButton.visibleProperty());
        hireMemberButton.managedProperty().bind(hireMemberButton.visibleProperty());
        upgradeWeapon.managedProperty().bind(upgradeWeapon.visibleProperty());
        fillArmorButton.managedProperty().bind(fillArmorButton.visibleProperty());
        buyDroneButton.managedProperty().bind(buyDroneButton.visibleProperty());
        cancelButton.managedProperty().bind(cancelButton.visibleProperty());
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
        enterStationButton.setVisible(false);
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

        upgradeCargoButton.setVisible(false);
        convertResourceButton.setVisible(false);
        hireMemberButton.setVisible(false);
        upgradeWeapon.setVisible(false);
        fillArmorButton.setVisible(false);
        buyDroneButton.setVisible(false);
        cancelButton.setVisible(false);

        leavePlanetButton.setVisible(false);

        getChildren().addAll(startGameButton,
                militaryShipSelectionButton,
                miningShipSelectionButton,
                travelButton,
                exploreButton,
                enterStationButton,
                endTurnButton,
                leavePlanetButton,
                movementButtons,
                upgradeCargoButton,
                convertResourceButton,
                hireMemberButton,
                upgradeWeapon,
                fillArmorButton,
                buyDroneButton,
                cancelButton);
    }

    private void setupListeners()
    {
        startGameButton.setOnAction(new StartGameButtonClicked());
        militaryShipSelectionButton.setOnAction(new MilitaryShipSelectionButtonClicked());
        miningShipSelectionButton.setOnAction(new MiningShipSelectionButtonClicked());
        travelButton.setOnAction(new MoveButtonClicked());
        exploreButton.setOnAction(new ExploreButtonClicked());
        enterStationButton.setOnAction(new EnterStationButtonClicked());
        endTurnButton.setOnAction(new EndTurnButtonClicked());
        upButton.setOnAction(new UpButtonClicked());
        rightButton.setOnAction(new RightButtonClicked());
        downButton.setOnAction(new DownButtonClicked());
        leftButton.setOnAction(new LeftButtonClicked());
        leavePlanetButton.setOnAction(new LeavePlanetButtonClicked());
        upgradeCargoButton.setOnAction(new UpgradeCargoButtonClicked());
        convertResourceButton.setOnAction(new ConvertResourceButtonClicked());
        hireMemberButton.setOnAction(new HireMemberButtonClicked());
        upgradeWeapon.setOnAction(new UpgradeWeaponButtonClicked());
        fillArmorButton.setOnAction(new FillArmorButtonClicked());
        buyDroneButton.setOnAction(new BuyDroneButtonClicked());
        cancelButton.setOnAction(new CancelButtonClicked());
    }

    public void update()
    {
        IState currentState = observableGame.getState();

        startGameButton.setVisible(currentState instanceof StartGame);

        militaryShipSelectionButton.setVisible(currentState instanceof AwaitShipSelection);
        miningShipSelectionButton.setVisible(currentState instanceof AwaitShipSelection);

        travelButton.setVisible(currentState instanceof AwaitMovement);

        exploreButton.setVisible(currentState instanceof AwaitActionType && observableGame.canExplore());

        enterStationButton.setVisible(currentState instanceof AwaitActionType && observableGame.canEnterSpaceStation());

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

        upgradeCargoButton.setVisible(currentState instanceof AwaitUpgrade);
        convertResourceButton.setVisible(currentState instanceof AwaitUpgrade);
        hireMemberButton.setVisible(currentState instanceof AwaitUpgrade);
        upgradeWeapon.setVisible(currentState instanceof AwaitUpgrade);
        fillArmorButton.setVisible(currentState instanceof AwaitUpgrade);
        buyDroneButton.setVisible(currentState instanceof AwaitUpgrade);
        cancelButton.setVisible(currentState instanceof AwaitUpgrade);

        upgradeCargoButton.setDisable(!observableGame.canUpgrade(UpgradeType.UPGRADE_CARGO));
        convertResourceButton.setDisable(!observableGame.canUpgrade(UpgradeType.CONVERT_RESOURCE));
        hireMemberButton.setDisable(!observableGame.canUpgrade(UpgradeType.HIRE_MEMBER));
        upgradeWeapon.setDisable(!observableGame.canUpgrade(UpgradeType.UPGRADE_WEAPON));
        fillArmorButton.setDisable(!observableGame.canUpgrade(UpgradeType.FULL_ARMOR));
        buyDroneButton.setDisable(!observableGame.canUpgrade(UpgradeType.NEW_DRONE));
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

    private class EnterStationButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.enterSpaceStation();
        }
    }

    private class EndTurnButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.endTurn();
        }
    }

    private class UpButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.moveDrone(DroneDirection.UP);
        }
    }

    private class RightButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.moveDrone(DroneDirection.RIGHT);
        }
    }

    private class DownButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.moveDrone(DroneDirection.DOWN);
        }
    }

    private class LeftButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.moveDrone(DroneDirection.LEFT);
        }
    }

    private class LeavePlanetButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.leavePlanet();
        }
    }

    private class UpgradeCargoButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.upgrade(UpgradeType.UPGRADE_CARGO);
        }
    }

    private class ConvertResourceButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.upgrade(UpgradeType.CONVERT_RESOURCE);
        }
    }

    private class HireMemberButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.upgrade(UpgradeType.HIRE_MEMBER);
        }
    }

    private class UpgradeWeaponButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.upgrade(UpgradeType.UPGRADE_WEAPON);
        }
    }

    private class FillArmorButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.upgrade(UpgradeType.FULL_ARMOR);
        }
    }

    private class BuyDroneButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.upgrade(UpgradeType.NEW_DRONE);
        }
    }

    private class CancelButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.cancel();
        }
    }
}
