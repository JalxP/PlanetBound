package view.graphical.panes;

import controller.ObservableGame;
import javafx.scene.layout.VBox;
import view.graphical.panes.board.ViewPane;
import view.graphical.panes.menu.MenuPane;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RootPane extends VBox implements PropertyChangeListener
{
    private final ObservableGame observableGame;

    private MenuPane menuPane;
    private ViewPane viewPane;

    public RootPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        menuPane = new MenuPane(observableGame);
        viewPane = new ViewPane(observableGame);

        setupLayout();
        setupListeners();
    }

    private void setupLayout()
    {
        getChildren().clear();
        // TODO rest goes here
        getChildren().addAll(menuPane, viewPane);
    }

    private void setupListeners()
    {
        // TODO setup these listeners
    }

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
