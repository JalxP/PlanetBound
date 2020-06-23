package view.graphical.panes.menu;

import controller.GameController;
import controller.ObservableGame;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import model.utility.FileUtility;

import java.io.File;
import java.io.IOException;

import static view.graphical.ConstantsUI.*;

public class MenuPane extends MenuBar
{
    private final ObservableGame observableGame;

    private Menu file;
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
        saveGame = new MenuItem("Save Game");
        saveGame.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        loadGame = new MenuItem("Load Game");
        loadGame.setAccelerator(new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN));
        // TODO loadGame.setDisable(!observableGame.savedGamesExists());
        exitGame = new MenuItem("Exit Game");

        file.getItems().addAll(saveGame, loadGame, new SeparatorMenuItem(), exitGame);

        other = new Menu("_Other");
        about = new MenuItem("About");
        about.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        showState = new MenuItem("Show State");
        other.getItems().addAll(about, showState);
        getMenus().addAll(file, other);
    }

    private void setupListeners()
    {
        saveGame.setOnAction(new SaveGameMenuItemClicked());
        loadGame.setOnAction(new LoadGameMenuItemClicked());

        exitGame.setOnAction(new ExitGameMenuItemClicked());

        // TODO add rest of handlers
        showState.setOnAction(new ShowStateMenuItemClicked());
    }


    /* Handlers */
    class SaveGameMenuItemClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            FileChooser fileChooser = new FileChooser();
            File savedGames = new File(System.getProperty("user.home"), ".PlanetBound/savedGames");
            if (!savedGames.exists())
                savedGames.mkdirs();

            fileChooser.setInitialDirectory(savedGames);
            File selectedFile = fileChooser.showSaveDialog(null);
            if (selectedFile != null)
            {
                try
                {
                    FileUtility.saveGame(selectedFile, observableGame.getGameController());
                } catch (IOException e)
                {
                    Alert resultDialog = new Alert(Alert.AlertType.INFORMATION);
                    resultDialog.setHeaderText("Save");
                    resultDialog.setContentText("Operation failed: " + e);
                    System.out.println(e); //TODO remove me
                    resultDialog.showAndWait();
                }
            }
        }
    }

    class LoadGameMenuItemClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            FileChooser fileChooser = new FileChooser();
            File savedGames = new File(System.getProperty("user.home"), ".PlanetBound/savedGames");
            if (!savedGames.exists())
                savedGames.mkdirs();

            fileChooser.setInitialDirectory(savedGames);
            File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null)
            {
                try
                {
                    GameController gameController = (GameController) FileUtility.loadGame(selectedFile);
                    if (gameController != null)
                    {
                        observableGame.setGameController(gameController);
                        observableGame.updateInterface();
                    }
                } catch (IOException | ClassNotFoundException e)
                {
                    Alert resultDialog = new Alert(Alert.AlertType.INFORMATION);
                    resultDialog.setHeaderText("Load");
                    resultDialog.setContentText("Operation has failed: " + e);
                    resultDialog.showAndWait();
                }
            }
        }
    }

    class ExitGameMenuItemClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            Platform.exit();
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
