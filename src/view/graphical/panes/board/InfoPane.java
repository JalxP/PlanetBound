package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class InfoPane extends VBox
{
    private final ObservableGame observableGame;

    private final Text shipType;
    private final CrewPane crewPane;
    private final StatsPane statsPane;
    private final CargoHoldPane cargoHoldPane;

    public InfoPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        shipType = new Text("Ship Type");
        shipType.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        crewPane = new CrewPane(observableGame);
        statsPane = new StatsPane(observableGame);
        cargoHoldPane = new CargoHoldPane(observableGame);


        setupLayout();
        setupListeners();
    }

    private void setupLayout()
    {
        getChildren().clear();
        getChildren().addAll(shipType,
                new Separator(),
                crewPane,
                new Separator(),
                statsPane,
                new Separator(),
                cargoHoldPane);
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
        cargoHoldPane.update();
    }
}
