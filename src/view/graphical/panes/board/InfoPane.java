package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class InfoPane extends VBox
{
    private final ObservableGame observableGame;

    private Text shipType;

    public InfoPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        shipType = new Text();

        setupLayout();
        setupListeners();
    }

    private void setupLayout()
    {
        getChildren().clear();

        shipType.setText(observableGame.getShipType());
        getChildren().addAll(shipType);
    }

    private void setupListeners()
    {
        // TODO empty, will there be any?
    }
}
