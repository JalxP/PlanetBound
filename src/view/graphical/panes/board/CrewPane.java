package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import view.graphical.resources.ImagesCrew;

import static view.graphical.resources.ResourcesPaths.*;
import static view.graphical.resources.ResourcesPaths.WEAPONS_DEAD;

public class CrewPane extends GridPane
{
    private ObservableGame observableGame;

    public CrewPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;

        setupSize();
        setupLayout();
    }

    private void setupSize()
    {

    }

    private void setupLayout()
    {
        add(new ImageView(ImagesCrew.getImage(CAPTAIN_DEAD)), 0, 0);
        add(new ImageView(ImagesCrew.getImage(NAVIGATION_DEAD)), 1, 0);
        add(new ImageView(ImagesCrew.getImage(LANDING_DEAD)), 2, 0);
        add(new ImageView(ImagesCrew.getImage(SHIELDS_DEAD)), 3, 0);
        add(new ImageView(ImagesCrew.getImage(WEAPONS_DEAD)), 4, 0);
        add(new ImageView(ImagesCrew.getImage(CARGO_DEAD)), 5, 0);
    }

    public void update()
    {
        // TODO continue here
    }
}
