package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import view.graphical.resources.Images;

import static view.graphical.resources.ResourcesPaths.*;
import static model.data.Constants.*;
import static model.data.GameEnums.*;

public class TravelPane extends VBox
{
    private ObservableGame observableGame;

    private final Text travelTitle;
    private final Text travelTypeTitle;
    private final Text travelTypeText;
    private final Text planetTitle;
    private final Text availableResourcesTitle;
    private final GridPane planetGridPane;
    private final GridPane availableResources;

    private ImageView unknownPlanet;
    private ImageView greenPlanet;
    private ImageView blackPlanet;
    private ImageView redPlanet;
    private ImageView bluePlanet;
    private ImageView spaceStation;
    private ImageView eventToken;

    public TravelPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;

        travelTitle = new Text("Space");
        travelTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        travelTypeTitle = new Text("Travel Type");
        travelTypeTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        travelTypeText = new Text("*");
        travelTypeText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));

        planetTitle = new Text("Planet Type");
        planetTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        availableResourcesTitle = new Text("Available Resources");
        availableResourcesTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        planetGridPane = new GridPane();
        availableResources = new GridPane();

        unknownPlanet = new ImageView(Images.getImage(UNKNOWN_PLANET));
        greenPlanet = new ImageView(Images.getImage(GREEN_PLANET));
        blackPlanet = new ImageView(Images.getImage(BLACK_PLANET));
        redPlanet = new ImageView(Images.getImage(RED_PLANET));
        bluePlanet = new ImageView(Images.getImage(BLUE_PLANET));
        spaceStation = new ImageView(Images.getImage(SPACE_STATION));
        eventToken = new ImageView(Images.getImage(EVENT_TOKEN));

        setupSize();
        setupLayout();
        setupToolTips();
    }

    private void setupSize()
    {
        // TODO setupSize() on TravelPane
    }

    private void setupLayout()
    {
        setAlignment(Pos.TOP_CENTER);

        planetGridPane.setAlignment(Pos.CENTER);
        planetGridPane.add(unknownPlanet,0,0);

        getChildren().addAll(travelTitle,
                new Separator(),
                travelTypeTitle,
                travelTypeText,
                new Separator(),
                planetTitle,
                planetGridPane,
                new Separator(),
                availableResourcesTitle,
                availableResources);
    }

    public void update()
    {
        getChildren().clear();
        planetGridPane.getChildren().clear();
        availableResources.getChildren().clear();


        ImageView currentPlanet = unknownPlanet;
        PlanetType planetType = observableGame.getCurrentSectorPlanetType();
        if (planetType != null)
        {
            switch (planetType)
            {
                case GREEN:
                    currentPlanet = greenPlanet;
                    break;
                case BLACK:
                    currentPlanet = blackPlanet;
                    break;
                case RED:
                    currentPlanet = redPlanet;
                    break;
                case BLUE:
                    currentPlanet = bluePlanet;
                    break;
                default: break;
            }
        }

        travelTypeText.setText(observableGame.isCurrentSectorTravelModeWormHole() ? "Wormhole" : "Normal");

        planetGridPane.add(currentPlanet, 0, 0);

        /* Extra Layers */
        if (observableGame.currentSectorHasSpaceStation())
            planetGridPane.add(spaceStation, 0, 0);
        if (observableGame.currentSectorIsEvent())
            planetGridPane.add(eventToken, 0, 0);

        getChildren().addAll(travelTitle,
                new Separator(),
                travelTypeTitle,
                travelTypeText,
                new Separator(),
                planetTitle,
                planetGridPane,
                new Separator(),
                availableResourcesTitle,
                availableResources);
    }

    private void setupToolTips()
    {
        Tooltip.install(unknownPlanet, new Tooltip(UNKNOWN_PLANET));
        Tooltip.install(greenPlanet, new Tooltip(AVAILABLE_RESOURCES +
                LIST_RESOURCES_ON_GREEN_PLANET));
        Tooltip.install(blackPlanet, new Tooltip(AVAILABLE_RESOURCES +
                LIST_RESOURCES_ON_BLACK_PLANET));
        Tooltip.install(redPlanet, new Tooltip(AVAILABLE_RESOURCES +
                LIST_RESOURCES_ON_RED_PLANET));
        Tooltip.install(bluePlanet, new Tooltip(AVAILABLE_RESOURCES +
                LIST_RESOURCES_ON_BLUE_PLANET));
        Tooltip.install(greenPlanet, new Tooltip(AVAILABLE_RESOURCES +
                LIST_RESOURCES_ON_GREEN_PLANET));
    }
}
