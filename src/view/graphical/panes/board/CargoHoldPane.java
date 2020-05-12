package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import view.graphical.resources.Images;

import model.data.GameEnums.*;
import static view.graphical.resources.ResourcesPaths.*;

public class CargoHoldPane extends VBox
{
    private final ObservableGame observableGame;

    private final Text cargoHoldTitle;
    private GridPane cargoHold;

    private ImageView blackResource;
    private ImageView blueResource;
    private ImageView greenResource;
    private ImageView redResource;

    private Text blackResourceAmount;
    private Text blueResourceAmount;
    private Text greenResourceAmount;
    private Text redResourceAmount;


    public CargoHoldPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        cargoHoldTitle = new Text("Cargo Hold");
        cargoHoldTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        String cargoHoldMax = observableGame.getCargoHoldMaxAsString();
        blackResourceAmount = new Text("0/" + cargoHoldMax);
        blackResourceAmount.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        blueResourceAmount = new Text("0/" + cargoHoldMax);
        blueResourceAmount.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        greenResourceAmount = new Text("0/" + cargoHoldMax);
        greenResourceAmount.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
        redResourceAmount = new Text("0/" + cargoHoldMax);
        redResourceAmount.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));

        cargoHold = new GridPane();

        blackResource = new ImageView(Images.getImage(SURFACE_BLACK));
        blueResource = new ImageView(Images.getImage(SURFACE_BLUE));
        greenResource = new ImageView(Images.getImage(SURFACE_GREEN));
        redResource = new ImageView(Images.getImage(SURFACE_RED));

        installTooltips();
        setupLayout();
    }

    private void installTooltips()
    {
        Tooltip.install(blackResource, new Tooltip(SURFACE_BLACK));
        Tooltip.install(blueResource, new Tooltip(SURFACE_BLUE));
        Tooltip.install(greenResource, new Tooltip(SURFACE_GREEN));
        Tooltip.install(redResource, new Tooltip(SURFACE_RED));
    }

    private void setupLayout()
    {
        cargoHold.setAlignment(Pos.CENTER);
        getChildren().clear();
        cargoHold.getChildren().clear();

        cargoHold.add(blackResource, 0, 0);
        cargoHold.add(blackResourceAmount, 1, 0);
        cargoHold.add(new Separator(Orientation.VERTICAL), 2,0);
        cargoHold.add(blueResource, 3, 0);
        cargoHold.add(blueResourceAmount, 4, 0);
        cargoHold.add(new Separator(Orientation.VERTICAL), 5,0);
        cargoHold.add(greenResource, 6,0);
        cargoHold.add(greenResourceAmount, 7,0);
        cargoHold.add(new Separator(Orientation.VERTICAL), 8,0);
        cargoHold.add(redResource, 9,0);
        cargoHold.add(redResourceAmount,10,0);

        getChildren().addAll(cargoHoldTitle,
                cargoHold);
    }

    public void update()
    {
        getChildren().clear();
        cargoHold.getChildren().clear();

        blackResourceAmount.setText(observableGame.getResourcesAsString(ResourceType.BLACK));
        blueResourceAmount.setText(observableGame.getResourcesAsString(ResourceType.BLUE));
        greenResourceAmount.setText(observableGame.getResourcesAsString(ResourceType.GREEN));
        redResourceAmount.setText(observableGame.getResourcesAsString(ResourceType.RED));

        cargoHold.add(blackResource, 0, 0);
        cargoHold.add(blackResourceAmount, 1, 0);
        cargoHold.add(new Separator(Orientation.VERTICAL), 2,0);
        cargoHold.add(blueResource, 3, 0);
        cargoHold.add(blueResourceAmount, 4, 0);
        cargoHold.add(new Separator(Orientation.VERTICAL), 5,0);
        cargoHold.add(greenResource, 6,0);
        cargoHold.add(greenResourceAmount, 7,0);
        cargoHold.add(new Separator(Orientation.VERTICAL), 8,0);
        cargoHold.add(redResource, 9,0);
        cargoHold.add(redResourceAmount,10,0);

        getChildren().addAll(cargoHoldTitle,
                cargoHold);
    }
}
