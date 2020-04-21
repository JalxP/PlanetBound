package view.graphical.panes.controls;

import controller.ObservableGame;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import static view.graphical.ConstantsUI.*;

public class MessagesPane extends StackPane
{
    private final ObservableGame observableGame;
    private Label message;

    public MessagesPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        message = new Label();

        // TODO add events to listen here

        setupSize();
        setupLayout();
    }

    private void setupSize()
    {
        setMinHeight(INTERACTION_PANE_MESSAGE_HEIGHT);
    }

    private void setupLayout()
    {
        getChildren().clear();
        setAlignment(Pos.CENTER);
        message.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        message.setText(observableGame.getMessage());
        getChildren().addAll(message);
    }

    public void update()
    {
        message.setText(observableGame.getMessage());
    }
}
