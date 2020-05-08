package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import view.graphical.resources.Images;

import java.util.ArrayList;
import java.util.List;

import static view.graphical.resources.ResourcesPaths.*;

public class CrewPane extends GridPane
{
    private ObservableGame observableGame;

    private List<ImageView> aliveCrew;
    private List<ImageView> deadCrew;

    public CrewPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        aliveCrew = new ArrayList<>();
        deadCrew = new ArrayList<>();

        aliveCrew.add(new ImageView(Images.getImage(CAPTAIN)));
        aliveCrew.add(new ImageView(Images.getImage(NAVIGATION)));
        aliveCrew.add(new ImageView(Images.getImage(LANDING)));
        aliveCrew.add(new ImageView(Images.getImage(SHIELDS)));
        aliveCrew.add(new ImageView(Images.getImage(WEAPONS)));
        aliveCrew.add(new ImageView(Images.getImage(CARGO)));

        deadCrew.add(new ImageView(Images.getImage(CAPTAIN_DEAD)));
        deadCrew.add(new ImageView(Images.getImage(NAVIGATION_DEAD)));
        deadCrew.add(new ImageView(Images.getImage(LANDING_DEAD)));
        deadCrew.add(new ImageView(Images.getImage(SHIELDS_DEAD)));
        deadCrew.add(new ImageView(Images.getImage(WEAPONS_DEAD)));
        deadCrew.add(new ImageView(Images.getImage(CARGO_DEAD)));

        for (int i = 0; i < 6; i++)
        {
            String name = observableGame.getCrewNameByIndex(i);
            Tooltip.install(aliveCrew.get(i), new Tooltip(name));
            Tooltip.install(deadCrew.get(i), new Tooltip(name + "(DEAD)"));
        }

        setupSize();
        setupLayout();
    }

    private void setupSize()
    {
        // TODO setupSize() on CrewPane
    }

    private void setupLayout()
    {
        for (int i = 0; i < 6; i++)
            add(deadCrew.get(i), i, 0);
    }

    public void update()
    {
        getChildren().clear();
        for (int i = 0; i < 6; i++)
        {
            if (observableGame.getCrewStatusByIndex(i))
                add(aliveCrew.get(i), i, 0);
            else
                add(deadCrew.get(i), i, 0);
        }

    }
}
