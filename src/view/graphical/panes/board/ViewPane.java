package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;

import static view.graphical.ConstantsUI.*;

public class ViewPane extends HBox
{
    private final ObservableGame observableGame;

    private InfoPane infoPane;
    private TravelPane travelPane;
    private PlanetSurfacePane planetSurfacePane;

    public ViewPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        infoPane = new InfoPane(observableGame);
        travelPane = new TravelPane(observableGame);
        planetSurfacePane = new PlanetSurfacePane(observableGame);

        setupSize();
        setupPrimaryLayout();
    }

    private void setupSize()
    {
        setMinHeight(VIEW_PANE_HEIGHT);
    }

    private void setupPrimaryLayout()
    {
        getChildren().clear();

        getChildren().addAll(infoPane,
                new Separator(Orientation.VERTICAL),
                travelPane,
                new Separator(Orientation.VERTICAL));
    }

    private void setupSecondaryLayout()
    {
        getChildren().clear();

        getChildren().addAll(infoPane,
                new Separator(Orientation.VERTICAL),
                travelPane,
                new Separator(Orientation.VERTICAL),
                planetSurfacePane);
    }

    public void update()
    {
        infoPane.update();
        travelPane.update();
        planetSurfacePane.update();
    }

    public void updateInfoPane()
    {
        infoPane.update();
    }

    public void updateTravelPane()
    {
        travelPane.update();
    }

    public void updatePlanetSurfacePane()
    {
        setupSecondaryLayout();
        planetSurfacePane.update();
    }

}
