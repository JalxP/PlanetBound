package view.graphical.panes.menu;

import controller.ObservableGame;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MenuPane extends MenuBar implements PropertyChangeListener
{
    private final ObservableGame observableGame;

    private Menu file;
    private MenuItem newGame;
    private MenuItem saveGame;
    private MenuItem loadGame;
    private MenuItem exitGame;

    private Menu other;
    private MenuItem about;

    public MenuPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        // TODO add propertyChangeListener

        setupLayout();
        setupListeners();
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
        other.getItems().add(about);

        getMenus().addAll(file, other);
    }

    private void setupListeners()
    {
        // TODO setOnAction(new newGameMenuItemClicked());
    }


    /* Events */
    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        switch (evt.getPropertyName())
        {
            default:
                System.out.println("<DEBUG> Something fired @ " + this.getClass() );
        }
    }
}
