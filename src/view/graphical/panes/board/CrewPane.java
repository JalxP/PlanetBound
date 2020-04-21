package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import view.graphical.resources.ImagesCrew;

import java.util.ArrayList;
import java.util.List;

import static view.graphical.resources.ResourcesPaths.*;
import static view.graphical.resources.ResourcesPaths.WEAPONS_DEAD;

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

        aliveCrew.add(new ImageView(ImagesCrew.getImage(CAPTAIN)));
        aliveCrew.add(new ImageView(ImagesCrew.getImage(NAVIGATION)));
        aliveCrew.add(new ImageView(ImagesCrew.getImage(LANDING)));
        aliveCrew.add(new ImageView(ImagesCrew.getImage(SHIELDS)));
        aliveCrew.add(new ImageView(ImagesCrew.getImage(WEAPONS)));
        aliveCrew.add(new ImageView(ImagesCrew.getImage(CARGO)));

        deadCrew.add(new ImageView(ImagesCrew.getImage(CAPTAIN_DEAD)));
        deadCrew.add(new ImageView(ImagesCrew.getImage(NAVIGATION_DEAD)));
        deadCrew.add(new ImageView(ImagesCrew.getImage(LANDING_DEAD)));
        deadCrew.add(new ImageView(ImagesCrew.getImage(SHIELDS_DEAD)));
        deadCrew.add(new ImageView(ImagesCrew.getImage(WEAPONS_DEAD)));
        deadCrew.add(new ImageView(ImagesCrew.getImage(CARGO_DEAD)));

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
        setBorder(new Border(new BorderStroke(Color.RED,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

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
