package view.graphical.panes.controls;

import controller.ObservableGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.states.IState;
import model.states.concrete.*;
import view.graphical.panes.board.ConversionPane;
import view.graphical.resources.Images;

import static model.data.GameEnums.*;
import static view.graphical.ConstantsUI.*;
import static view.graphical.resources.ResourcesPaths.*;

public class ButtonsPane extends HBox
{
    private final ObservableGame observableGame;

    private final ActionButton startGameButton;

    private final ActionButton militaryShipSelectionButton;
    private final ActionButton miningShipSelectionButton;

    private final ActionButton travelButton;
    private final ActionButton exploreButton;
    private final ActionButton enterStationButton;

    private final ActionButton endTurnButton;

    private final ActionButton upButton;
    private final ActionButton rightButton;
    private final ActionButton downButton;
    private final ActionButton leftButton;

    private final ActionButton leavePlanetButton;

    private final ActionButton maintainShipButton;
    private final ActionButton acquireShieldButton;
    private final ActionButton acquireAmmoButton;
    private final ActionButton acquireFuelButton;
    public  final ActionButton acquireDroneRepair;

    private final ActionButton convertResourceButton;
    private final ActionButton fillArmorButton;

    private final ActionButton upgradeCargoButton;
    private final ActionButton hireMemberButton;
    private final ActionButton upgradeWeapon;
    private final ActionButton buyDroneButton;
    private final ActionButton cancelButton;

    private final BorderPane movementButtons;

    private final ImageView drone;
    private final ConversionPane conversionPane;


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

        maintainShipButton = new ActionButton("Maintain Ship");
        acquireShieldButton = new ActionButton("+1 Shield");
        acquireAmmoButton = new ActionButton("+1 Ammo");
        acquireFuelButton = new ActionButton("+1 Fuel");
        acquireDroneRepair = new ActionButton("Repair Drone");

        movementButtons = new BorderPane();

        drone = new ImageView(Images.getImage(SURFACE_DRONE));

        conversionPane = new ConversionPane(observableGame);

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
        maintainShipButton.managedProperty().bind(maintainShipButton.visibleProperty());
        acquireShieldButton.managedProperty().bind(acquireShieldButton.visibleProperty());
        acquireAmmoButton.managedProperty().bind(acquireAmmoButton.visibleProperty());
        acquireFuelButton.managedProperty().bind(acquireFuelButton.visibleProperty());
        acquireDroneRepair.managedProperty().bind(acquireDroneRepair.visibleProperty());
        movementButtons.managedProperty().bind(movementButtons.visibleProperty());
        upgradeCargoButton.managedProperty().bind(upgradeCargoButton.visibleProperty());
        convertResourceButton.managedProperty().bind(convertResourceButton.visibleProperty());
        hireMemberButton.managedProperty().bind(hireMemberButton.visibleProperty());
        upgradeWeapon.managedProperty().bind(upgradeWeapon.visibleProperty());
        fillArmorButton.managedProperty().bind(fillArmorButton.visibleProperty());
        buyDroneButton.managedProperty().bind(buyDroneButton.visibleProperty());
        cancelButton.managedProperty().bind(cancelButton.visibleProperty());
        conversionPane.managedProperty().bind(conversionPane.visibleProperty());
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

        maintainShipButton.setVisible(false);
        acquireShieldButton.setVisible(false);
        acquireAmmoButton.setVisible(false);
        acquireFuelButton.setVisible(false);
        acquireDroneRepair.setVisible(false);

        conversionPane.setVisible(false);

        getChildren().addAll(startGameButton,
                militaryShipSelectionButton,
                miningShipSelectionButton,
                travelButton,
                exploreButton,
                enterStationButton,
                leavePlanetButton,
                maintainShipButton,
                acquireShieldButton,
                acquireAmmoButton,
                acquireFuelButton,
                acquireDroneRepair,
                movementButtons,
                upgradeCargoButton,
                convertResourceButton,
                hireMemberButton,
                upgradeWeapon,
                fillArmorButton,
                buyDroneButton,
                conversionPane,
                cancelButton,
                endTurnButton);
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
        maintainShipButton.setOnAction(new MaintainShipButtonClicked());
        acquireShieldButton.setOnAction(new AcquireShieldButtonClicked());
        acquireAmmoButton.setOnAction(new AcquireAmmoButtonClicked());
        acquireFuelButton.setOnAction(new AcquireFuelButtonClicked());
        acquireDroneRepair.setOnAction(new AcquireDroneRepairButtonClicked());
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
        conversionPane.update();
        IState currentState = observableGame.getState();

        /* Start Phase*/
        startGameButton.setVisible(currentState instanceof StartGame);

        /* Ship Selection Phase */
        militaryShipSelectionButton.setVisible(currentState instanceof AwaitShipSelection);
        miningShipSelectionButton.setVisible(currentState instanceof AwaitShipSelection);

        /* Travel Phase */
        travelButton.setVisible(currentState instanceof AwaitMovement);

        /* Pick Action Phase*/
        exploreButton.setVisible(currentState instanceof AwaitActionType && observableGame.canExplore());
        enterStationButton.setVisible(currentState instanceof AwaitActionType && observableGame.canEnterSpaceStation());
        endTurnButton.setVisible(currentState instanceof AwaitActionType);
        maintainShipButton.setVisible(currentState instanceof AwaitActionType && observableGame.canMaintainShip());

        /* Exploration Phase */
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

        /* Maintenance Phase */
        boolean isMaintenance = currentState instanceof AwaitMaintenance;
        convertResourceButton.setVisible(isMaintenance);
        acquireDroneRepair.setVisible(isMaintenance);
        acquireShieldButton.setVisible(isMaintenance);
        acquireAmmoButton.setVisible(isMaintenance);
        acquireFuelButton.setVisible(isMaintenance);
        if (isMaintenance)
        {
            // check which ones to disable
            convertResourceButton.setDisable(!observableGame.canConvert());
            acquireDroneRepair.setDisable(!observableGame.canMaintain(MaintenanceType.REPAIR_DRONE));
            acquireShieldButton.setDisable(!observableGame.canMaintain(MaintenanceType.ACQUIRE_SHIELD_UNIT));
            acquireAmmoButton.setDisable(!observableGame.canMaintain(MaintenanceType.ACQUIRE_AMMO_UNIT));
            acquireFuelButton.setDisable(!observableGame.canMaintain(MaintenanceType.ACQUIRE_FUEL_UNIT));
        }

        /* Conversion Phase*/
        conversionPane.setVisible(currentState instanceof AwaitResourceConversion);

        /* Upgrade Phase*/

        convertResourceButton.setVisible(currentState instanceof AwaitUpgrade || currentState instanceof AwaitMaintenance);
        fillArmorButton.setVisible(currentState instanceof AwaitUpgrade);

        fillArmorButton.setDisable(!observableGame.canUpgrade(UpgradeType.FULL_ARMOR));
        convertResourceButton.setDisable(!observableGame.canConvert());

        boolean isUpgrade = currentState instanceof AwaitUpgrade;
        upgradeCargoButton.setVisible(isUpgrade);
        hireMemberButton.setVisible(isUpgrade);
        upgradeWeapon.setVisible(isUpgrade);
        buyDroneButton.setVisible(isUpgrade);

        cancelButton.setVisible(isMaintenance || isUpgrade);

        upgradeCargoButton.setDisable(!observableGame.canUpgrade(UpgradeType.UPGRADE_CARGO));

        hireMemberButton.setDisable(!observableGame.canUpgrade(UpgradeType.HIRE_MEMBER));
        upgradeWeapon.setDisable(!observableGame.canUpgrade(UpgradeType.UPGRADE_WEAPON));

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
            System.out.println("... OK ...");
            observableGame.startConversion();
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

    private class MaintainShipButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.startMaintenance();
        }
    }

    private class AcquireShieldButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.maintain(MaintenanceType.ACQUIRE_SHIELD_UNIT);
        }
    }

    private class AcquireAmmoButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.maintain(MaintenanceType.ACQUIRE_AMMO_UNIT);
        }
    }

    private class AcquireFuelButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.maintain(MaintenanceType.ACQUIRE_FUEL_UNIT);
        }
    }

    private class AcquireDroneRepairButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.maintain(MaintenanceType.REPAIR_DRONE);
        }
    }
}