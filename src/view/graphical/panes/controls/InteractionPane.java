package view.graphical.panes.controls;

import controller.ObservableGame;
import javafx.geometry.Insets;
import javafx.scene.layout.*;

import static view.graphical.ConstantsUI.*;

public class InteractionPane extends VBox
{
    private final ObservableGame observableGame;

    private MessagesPane messagesPane;
    private ButtonsPane buttonsPane;

    public InteractionPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        messagesPane = new MessagesPane(observableGame);
        buttonsPane = new ButtonsPane(observableGame);

        // TODO add events to listen here

        setupSize();
        setupLayout();
        setupListeners();
    }

    private void setupSize()
    {
        setMinHeight(INTERACTION_PANE_MESSAGE_HEIGHT + INTERACTION_PANE_HEIGHT - 10);
        setMargin(this, new Insets(0,0,10,0));
    }

    private void setupLayout()
    {
        getChildren().clear();
        getChildren().addAll(messagesPane, buttonsPane);
    }

    private void setupListeners()
    {
        // TODO later
    }

    public void update()
    {
        messagesPane.update();
        buttonsPane.update();
    }
}
