package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static view.graphical.ConstantsUI.*;

public class ViewPane extends HBox implements PropertyChangeListener
{
    private final ObservableGame observableGame;

    private InfoPane infoPane;

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

    private void setupListeners()
    {

    }

    /* Handlers */

    /* Events */

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        switch (evt.getPropertyName())
        {
            default:
                System.out.println("<DEBUG> Something fired ("+ evt.getPropertyName() + ") @ " + this.getClass());
        }
    }
}
