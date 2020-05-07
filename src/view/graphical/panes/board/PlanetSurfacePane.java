package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import view.graphical.resources.Images;

import static view.graphical.resources.ResourcesPaths.*;
import static model.data.GameEnums.*;

public class PlanetSurfacePane extends GridPane
{
    private final ObservableGame observableGame;

    private ImageView blackResource;
    private ImageView blueResource;
    private ImageView greenResource;
    private ImageView redResource;

    private ImageView artifact;
    private ImageView drone;


    public PlanetSurfacePane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;

        blackResource = new ImageView(Images.getImage(SURFACE_BLACK));
        blueResource = new ImageView(Images.getImage(SURFACE_BLACK));
        greenResource = new ImageView(Images.getImage(SURFACE_GREEN));
        redResource = new ImageView(Images.getImage(SURFACE_RED));

        artifact = new ImageView(Images.getImage(SURFACE_ARTIFACT));
        drone = new ImageView(Images.getImage(SURFACE_DRONE));


    }

    private void setupLayout()
    {
        ResourceType [][] surface = observableGame.getPlanetSurface();
        if (surface == null)
            return;

        for (int i = 1; i < surface.length + 1; i++)
        {
            Text tmp = new Text(i + "");
            tmp.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
            add(tmp, i, 0);
        }
        for (int i = 1; i < surface.length + 1; i++)
        {
            Text tmp = new Text(i + "");
            tmp.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
            add(tmp, 0, i);
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
                add(tmp, j, i);
            }
        }
    }

    public void update()
    {
        setupLayout();
    }
}
