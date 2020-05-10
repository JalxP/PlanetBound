package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LogPane extends VBox
{
    private final ObservableGame observableGame;

    private final Text logTitle;

    public LogPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;

        logTitle = new Text("Status Log");
        logTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        setupLayout();
    }

    private void setupLayout()
    {
        setAlignment(Pos.CENTER);
        getChildren().addAll(logTitle,
                new Separator());
    }

    public void update()
    {
        // TODO
    }
}
