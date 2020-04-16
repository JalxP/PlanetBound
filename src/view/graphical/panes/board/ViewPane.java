package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.scene.layout.HBox;
import model.states.concrete.AwaitShipSelection;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ViewPane extends HBox implements PropertyChangeListener
{
    private final ObservableGame observableGame;

    private InfoPane infoPane;

    public ViewPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        infoPane = new InfoPane(observableGame);

        setupLayout();
    }

    private void setupLayout()
    {
        getChildren().clear();

        getChildren().addAll(infoPane);
    }

    private void setupListeners()
    {

    }

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
