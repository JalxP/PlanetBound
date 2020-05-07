package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StatsPane extends GridPane
{
    private final ObservableGame observableGame;

    private final Text shieldLabel;
    private final Text shieldAmount;
    private final Text fuelLabel;
    private final Text fuelAmount;
    private final Text artifactsLabel;
    private final Text artifactsAmount;
    private final Text dronesLabel;
    private final Text dronesAmount;

    public StatsPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;

        shieldLabel = new Text("Shields");
        shieldLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        shieldAmount = new Text("   *");

        fuelLabel = new Text("Fuel");
        fuelLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        fuelAmount = new Text("   *");

        artifactsLabel = new Text("Artifacts");
        artifactsLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        artifactsAmount = new Text("  *");

        dronesLabel = new Text("Drones");
        dronesLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        dronesAmount = new Text("  *");


        setupLayout();
    }

    private void setupLayout()
    {
        setAlignment(Pos.CENTER);

        add(shieldLabel, 0, 0);
        add(shieldAmount, 1, 0);
        add(new Separator(Orientation.VERTICAL), 2,0);
        add(fuelLabel, 3, 0);
        add(fuelAmount, 4, 0);
        add(new Separator(Orientation.VERTICAL), 5,0);
        add(dronesLabel, 6,0);
        add(dronesAmount, 7,0);
        add(new Separator(Orientation.VERTICAL), 8,0);
        add(artifactsLabel, 9,0);
        add(artifactsAmount,10,0);
    }

    public void update()
    {
        shieldAmount.setText(" " + observableGame.getShieldAmount());
        fuelAmount.setText(" " + observableGame.getFuelAmount());
        dronesAmount.setText(" " + observableGame.getDronesAmount());
        artifactsAmount.setText(" " + observableGame.getArtifactsAmount());
    }
}
