package view.graphical.panes.board;

import controller.ObservableGame;
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

public class TravelPane extends GridPane
{
    private ObservableGame observableGame;

    private final Text travelTitle;

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
        // TODO setupLayout() on TravelPane
        setBorder(new Border(new BorderStroke(Color.RED,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        add(travelTitle,0,0);
        add(new Text("Warp"), 0,1);
        add(unknownPlanet, 1,1);
    }

    public void update()
    {
        // TODO continue here, get path images, etc...
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
