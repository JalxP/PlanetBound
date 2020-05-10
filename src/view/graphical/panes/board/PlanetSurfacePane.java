package view.graphical.panes.board;

import controller.ObservableGame;
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
import model.states.concrete.AwaitExplorationPhase;
import view.graphical.resources.Images;

import static view.graphical.resources.ResourcesPaths.*;
import static model.data.GameEnums.*;

public class PlanetSurfacePane extends VBox
{
    private final ObservableGame observableGame;

    private final Text surfaceTitle;
    private GridPane surfaceMap;

    private ImageView blackResource;
    private ImageView blueResource;
    private ImageView greenResource;
    private ImageView redResource;

    private ImageView landingZone;

    private ImageView artifact;
    private ImageView drone;

    private ImageView blackAlien;
    private ImageView blueAlien;
    private ImageView greenAlien;
    private ImageView redAlien;


    public PlanetSurfacePane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;

        surfaceTitle = new Text("Planet Surface");
        surfaceTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        surfaceMap = new GridPane();

        blackResource = new ImageView(Images.getImage(SURFACE_BLACK));
        blueResource = new ImageView(Images.getImage(SURFACE_BLUE));
        greenResource = new ImageView(Images.getImage(SURFACE_GREEN));
        redResource = new ImageView(Images.getImage(SURFACE_RED));
        artifact = new ImageView(Images.getImage(SURFACE_ARTIFACT));
        drone = new ImageView(Images.getImage(SURFACE_DRONE));
        landingZone = new ImageView(Images.getImage(SURFACE_LANDING));

        blackAlien = new ImageView(Images.getImage(SURFACE_BLACK_ALIEN));
        blueAlien = new ImageView(Images.getImage(SURFACE_BLUE_ALIEN));
        greenAlien = new ImageView(Images.getImage(SURFACE_GREEN_ALIEN));
        redAlien = new ImageView(Images.getImage(SURFACE_RED_ALIEN));

        installTooltips();
    }

    private void installTooltips()
    {
        Tooltip.install(blackResource, new Tooltip(SURFACE_BLACK));
        Tooltip.install(blueResource, new Tooltip(SURFACE_BLUE));
        Tooltip.install(greenResource, new Tooltip(SURFACE_GREEN));
        Tooltip.install(redResource, new Tooltip(SURFACE_RED));
        Tooltip.install(artifact, new Tooltip(SURFACE_ARTIFACT));
        Tooltip.install(drone, new Tooltip(SURFACE_DRONE));
        Tooltip.install(landingZone, new Tooltip(SURFACE_LANDING));
        Tooltip.install(blackAlien, new Tooltip(SURFACE_BLACK_ALIEN));
        Tooltip.install(blueAlien, new Tooltip(SURFACE_BLUE_ALIEN));
        Tooltip.install(greenAlien, new Tooltip(SURFACE_GREEN_ALIEN));
        Tooltip.install(redAlien, new Tooltip(SURFACE_RED_ALIEN));
    }

    private void setupLayout()
    {
        getChildren().clear();
        surfaceMap.getChildren().clear();
        if (!(observableGame.getState() instanceof AwaitExplorationPhase))
            return;

        setAlignment(Pos.TOP_RIGHT);

        ResourceType [][] surface = observableGame.getPlanetSurface();
        if (surface == null)
            return;

        /* Draw the coordinates and the terrain */
        for (int i = 1; i < surface.length + 1; i++)
        {
            Text tmp = new Text(i + "");
            tmp.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
            surfaceMap.add(tmp, i, 0);
        }
        for (int i = 1; i < surface.length + 1; i++)
        {
            Text tmp = new Text(i + "");
            tmp.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
            surfaceMap.add(tmp, 0, i);
        }
        for (int i = 1; i <= surface.length; i++)
        {
            for (int j = 1; j <= surface[0].length; j++)
            {
                ImageView tmp;
                switch (surface[i-1][j-1])
                {
                    case BLUE:
                        tmp = blueResource;
                        break;
                    case RED:
                        tmp = redResource;
                        break;
                    case GREEN:
                        tmp = greenResource;
                        break;
                    case BLACK:
                        tmp = blackResource;
                        break;
                    case ARTIFACT:
                        tmp = artifact;
                        break;
                    default: tmp = new ImageView(Images.getImage(SURFACE_NONE));
                }
                surfaceMap.add(tmp, j, i);
            }
        }

        /* Draw the landing zone*/
        int[] landingPosition = observableGame.getLandingPosition();
        int landingRow = landingPosition[0];
        int landingCol = landingPosition[1];

        surfaceMap.add(landingZone, landingCol+1, landingRow+1);

        /* Draw the drone */
        int[] dronePosition = observableGame.getDronePosition();
        int droneRow = dronePosition[0];
        int droneCol = dronePosition[1];

        surfaceMap.add(drone, droneCol+1, droneRow+1);

        /* Draw the Alien */
        int [] alienPosition = observableGame.getAlienPosition();
        int alienRow = alienPosition[0];
        int alienCol = alienPosition[1];

        ImageView tmp = greenAlien;
        AlienType alienType = observableGame.getAlienType();
        switch (alienType)
        {
            case BLACK:
                tmp = blackAlien;
                break;
            case GREEN:
                tmp = greenAlien;
                break;
            case BLUE:
                tmp = blueAlien;
                break;
            case RED:
                tmp = redAlien;
                break;
            default: break;
        }

        surfaceMap.add(tmp, alienCol+1, alienRow+1);

        getChildren().addAll(surfaceTitle,
                new Separator(),
                surfaceMap);
    }

    // TODO change setupLayout to Update()
    public void update()
    {
        setupLayout();
    }
}
