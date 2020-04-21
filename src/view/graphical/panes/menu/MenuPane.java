package view.graphical.panes.menu;

import controller.ObservableGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

import static view.graphical.ConstantsUI.*;

public class MenuPane extends MenuBar
{
    private final ObservableGame observableGame;

    private Menu file;
    private MenuItem newGame;
    private MenuItem saveGame;
    private MenuItem loadGame;
    private MenuItem exitGame;

    private Menu other;
    private MenuItem about;
    private MenuItem showState;

    public MenuPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;

        setupSize();
        setupLayout();
        setupListeners();
    }

    private void setupSize()
    {
        setHeight(MENU_PANE_HEIGHT);
    }

    private void setupLayout()
    {
        file = new Menu("_File");
        newGame = new MenuItem("New Game");
        newGame.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        saveGame = new MenuItem("Save Game");
        saveGame.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        loadGame = new MenuItem("Load Game");
        loadGame.setAccelerator(new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN));
        // TODO loadGame.setDisable(!observableGame.savedGamesExists());
        exitGame = new MenuItem("Exit Game");

        file.getItems().addAll(newGame, saveGame, loadGame, new SeparatorMenuItem(), exitGame);

        other = new Menu("_Other");
        about = new MenuItem("About");
        about.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        showState = new MenuItem("Show State");
        other.getItems().addAll(about, showState);
        getMenus().addAll(file, other);
    }

    private void setupListeners()
    {
        newGame.setOnAction(new NewGameMenuItemClicked());

        // TODO add rest of handlers
        showState.setOnAction(new ShowStateMenuItemClicked());
    }


    /* Handlers */
    class NewGameMenuItemClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            observableGame.startGame();
        }
    }

    class ShowStateMenuItemClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            String rawStateString = observableGame.getState() + "";
            rawStateString = rawStateString.split("\\.")[3].split("@")[0];
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("State Log");
            alert.setHeaderText("The current state is:");
            alert.setContentText(rawStateString);
            alert.showAndWait();
        }
    }
}
