package view.graphical;

import controller.GameController;
import controller.ObservableGame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.graphical.panes.PaneOrganizer;

public class App extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        ObservableGame observableGame = new ObservableGame(new GameController());
        PaneOrganizer paneOrganizer = new PaneOrganizer(observableGame);

        Scene scene = new Scene(paneOrganizer.getRoot());

        stage.setScene(scene);
        stage.setTitle("Planet Bound v0.1");
        // stage.setResizable(false);

        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
