package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class InfoPane extends VBox
{
    private final ObservableGame observableGame;

    private final Text shipType;
    private final Text crewTitle;
    private final CrewPane crewPane;
    private final StatsPane statsPane;

    public InfoPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        shipType = new Text();
        shipType.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        crewTitle = new Text("Crew");
        crewTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        crewPane = new CrewPane(observableGame);

        statsPane = new StatsPane(observableGame);


        setupLayout();
        setupListeners();
    }

    private void setupLayout()
    {
        setBorder(new Border(new BorderStroke(Color.RED,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        getChildren().clear();
        getChildren().addAll(shipType,
                new Separator(),
                crewTitle,
                crewPane,
                new Separator(),
                statsPane);
    }

    private void setupListeners()
    {
        // TODO empty, will there be any?
    }

    public void update()
    {
        shipType.setText(observableGame.getShipType());
        crewPane.update();
        statsPane.update();
    }
}
