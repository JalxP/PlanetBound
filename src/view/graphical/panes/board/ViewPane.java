package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static view.graphical.ConstantsUI.*;

public class ViewPane extends HBox
{
    private final ObservableGame observableGame;

    private InfoPane infoPane;
    //private SpacePane spacePane;
    //private PlanetPane planetPane;

    public ViewPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        infoPane = new InfoPane(observableGame);

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

        getChildren().addAll(infoPane);
    }

    public void update()
    {
        infoPane.update();
    }


}
