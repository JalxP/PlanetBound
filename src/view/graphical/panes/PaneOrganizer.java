package view.graphical.panes;

import controller.ObservableGame;
import javafx.scene.layout.Pane;

public class PaneOrganizer
{
    private final Pane root;

    public PaneOrganizer(ObservableGame observableGame)
    {
        root = new RootPane(observableGame);
    }

    public Pane getRoot()
    {
        return root;
    }
}
