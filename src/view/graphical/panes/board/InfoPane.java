package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.scene.control.Separator;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class InfoPane extends VBox
{
    private final ObservableGame observableGame;

    private Text shipType;
    private Text crewTitle;
    private CrewPane crewPane;

    public InfoPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        shipType = new Text();
        shipType.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        crewTitle = new Text("Crew");
        crewTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));


        crewPane = new CrewPane(observableGame);

        setupLayout();
        setupListeners();
    }

    private void setupLayout()
    {
        getChildren().clear();
        getChildren().addAll(shipType,
                new Separator(),
                crewTitle,
                crewPane);
    }

    private void setupListeners()
    {
        // TODO empty, will there be any?
    }

    public void update()
    {
        shipType.setText(observableGame.getShipType());
        crewPane.update();
    }
}
