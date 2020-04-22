package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static view.graphical.ConstantsUI.*;

public class ViewPane extends HBox
{
    private final ObservableGame observableGame;

    private InfoPane infoPane;
    private TravelPane travelPane;
    //private PlanetPane planetPane;

    public ViewPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        infoPane = new InfoPane(observableGame);
        travelPane = new TravelPane(observableGame);

        // TODO add events to listen here

        setupSize();
        setupLayout();
    }

    private void setupSize()
    {
        setMinHeight(VIEW_PANE_HEIGHT);
    }

    private void setupLayout()
    {

        // TODO Remove me
        setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        getChildren().clear();

        getChildren().addAll(infoPane,
                new Separator(Orientation.VERTICAL),
                travelPane);
    }

    public void update()
    {
        infoPane.update();
    }


}
