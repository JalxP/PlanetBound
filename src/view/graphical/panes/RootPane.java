package view.graphical.panes;

import controller.ObservableGame;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import view.graphical.panes.board.ViewPane;
import view.graphical.panes.controls.InteractionPane;
import view.graphical.panes.menu.MenuPane;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static view.graphical.EventNames.*;


public class RootPane extends VBox implements PropertyChangeListener
{
    private final ObservableGame observableGame;

    private MenuPane menuPane;
    private ViewPane viewPane;
    private InteractionPane interactionPane;

    public RootPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        menuPane = new MenuPane(observableGame);
        viewPane = new ViewPane(observableGame);
        interactionPane = new InteractionPane(observableGame);

        setupLayout();
        setupListeners();
    }

    private void setupLayout()
    {
        getChildren().clear();
        // TODO rest goes here
        getChildren().addAll(menuPane,
                new Separator(),
                viewPane,
                new Separator(),
                interactionPane
        );
    }

    private void setupListeners()
    {
        // TODO setup these listeners

        observableGame.addPropertyChangeListener(EVENT_UPDATE_VIEW_PANE, this);
        observableGame.addPropertyChangeListener(EVENT_UPDATE_INTERACTION_PANE, this);
        observableGame.addPropertyChangeListener(EVENT_UPDATE_LOG_PANE, this);
    }

    private void updateInteractionPane()
    {
        interactionPane.update();
    }

    /* Events */

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        switch (evt.getPropertyName())
        {
            case EVENT_UPDATE_INTERACTION_PANE:
                updateInteractionPane();
                break;

        }
        System.out.println("<DEBUG> Something fired ("+ evt.getPropertyName() + ") @ " + this.getClass());
    }
}
