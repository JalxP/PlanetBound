package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static model.data.GameEnums.ResourceType.*;

public class StatsPane extends HBox
{
    private final ObservableGame observableGame;

    private final VBox shipStatsVBox;

    private final HBox shieldsHBox;
    private final Text shieldLabel;
    private final Text shieldAmount;

    private final HBox fuelHBox;
    private final Text fuelLabel;
    private final Text fuelAmount;

    private final HBox ammoHBox;
    private final Text ammoLabel;
    private final Text ammoAmount;

    private final VBox droneVBox;
    private final HBox droneAmountHBox;
    private final Text dronesLabel;
    private final Text dronesAmountLabel;
    private final Text dronesAmount;
    private final HBox droneHealthHBox;
    private final Text droneHealthLabel;
    private final Text droneHealthAmount;

    public StatsPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;

        shipStatsVBox = new VBox();

        shieldsHBox = new HBox();
        shieldLabel = new Text("Shields");
        shieldLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        shieldAmount = new Text("*");
        shieldAmount.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));

        fuelHBox = new HBox();
        fuelLabel = new Text("Fuel");
        fuelLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        fuelAmount = new Text("*");
        fuelAmount.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));

        ammoHBox = new HBox();
        ammoLabel = new Text("Ammo");
        ammoLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        ammoAmount = new Text("*");
        ammoAmount.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));

        droneVBox = new VBox();
        droneAmountHBox = new HBox();
        dronesLabel = new Text("Drone");
        dronesLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        dronesAmountLabel = new Text("Amount");
        dronesAmountLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        dronesAmount = new Text("*");
        dronesAmount.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        droneHealthHBox = new HBox();
        droneHealthLabel = new Text("Health");
        droneHealthLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        droneHealthAmount = new Text("*");
        droneHealthAmount.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));


        setupLayout();
    }

    private void setupLayout()
    {
        shieldsHBox.getChildren().addAll(shieldLabel, new Separator(Orientation.VERTICAL), shieldAmount);
        shieldsHBox.setAlignment(Pos.CENTER_RIGHT);
        fuelHBox.getChildren().addAll(fuelLabel, new Separator(Orientation.VERTICAL), fuelAmount);
        fuelHBox.setAlignment(Pos.CENTER_RIGHT);
        ammoHBox.getChildren().addAll(ammoLabel, new Separator(Orientation.VERTICAL), ammoAmount);
        ammoHBox.setAlignment(Pos.CENTER_RIGHT);

        shipStatsVBox.getChildren().addAll(shieldsHBox,
                new Separator(),
                fuelHBox,
                new Separator(),
                ammoHBox);

        droneAmountHBox.getChildren().addAll(dronesAmountLabel, new Separator(Orientation.VERTICAL), dronesAmount);
        droneHealthHBox.getChildren().addAll(droneHealthLabel, new Separator(Orientation.VERTICAL), droneHealthAmount);
        droneAmountHBox.setAlignment(Pos.CENTER);
        droneAmountHBox.setHgrow(dronesAmountLabel, Priority.ALWAYS);
        droneHealthHBox.setAlignment(Pos.CENTER);
        droneVBox.setAlignment(Pos.CENTER);
        droneVBox.getChildren().addAll(droneAmountHBox, new Separator(), droneHealthHBox);

        setHgrow(droneVBox, Priority.ALWAYS);
        setAlignment(Pos.CENTER_LEFT);
        getChildren().addAll(shipStatsVBox, new Separator(Orientation.VERTICAL), dronesLabel, new Separator(Orientation.VERTICAL), droneVBox);
    }

    public void update()
    {
        shieldAmount.setText(observableGame.getShieldAmount());
        fuelAmount.setText(observableGame.getFuelAmount());
        dronesAmount.setText(observableGame.getAvailableDrones());
        ammoAmount.setText(observableGame.getAmmoAmount());
        droneHealthAmount.setText(observableGame.getDroneHealth());
    }
}
