package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.scene.control.Separator;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import view.graphical.resources.Images;

import java.util.ArrayList;
import java.util.List;

import static view.graphical.resources.ResourcesPaths.*;

public class CrewPane extends VBox
{
    private ObservableGame observableGame;

    private List<ImageView> aliveCrew;
    private List<ImageView> deadCrew;

    private Text crewTitle;
    private GridPane crew;

    public CrewPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        aliveCrew = new ArrayList<>();
        deadCrew = new ArrayList<>();

        crewTitle = new Text("Crew");
        crewTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        crew = new GridPane();

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
            crew.add(deadCrew.get(i), i, 0);

        getChildren().addAll(crewTitle,
                crew);
    }

    public void update()
    {
        getChildren().clear();
        crew.getChildren().clear();
        for (int i = 0; i < 6; i++)
        {
            if (observableGame.getCrewStatusByIndex(i))
                crew.add(aliveCrew.get(i), i, 0);
            else
                crew.add(deadCrew.get(i), i, 0);
        }
        getChildren().addAll(crewTitle,
                crew);
    }
}
