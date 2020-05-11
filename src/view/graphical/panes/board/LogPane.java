package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

import java.util.ArrayList;

public class LogPane extends VBox
{
    private final ObservableGame observableGame;

    private final Text logTitle;
    private ScrollPane scrollPane;
    private TextFlow textFlow;

    public LogPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;

        logTitle = new Text("Status Log");
        logTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        textFlow = new TextFlow();
        scrollPane = new ScrollPane(textFlow);

        setupLayout();
    }

    private void setupLayout()
    {
        setAlignment(Pos.CENTER);
        getChildren().addAll(logTitle,
                scrollPane);
    }

    public void update()
    {
        ArrayList<String> log = observableGame.getAllLogs();
        for (String s : log)
        {
            Text text = new Text(s + "\n");
            text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
            changeMessageColour(text);
            textFlow.getChildren().add(text);
        }
        scrollPane.setVvalue(1.0); // auto scroll to bottom
    }

    private void changeMessageColour(Text text)
    {
        String message = text.getText();
        if (message.length() > 1)
        {
            switch (message.charAt(1))
            {
                case '!':
                    text.setFill(Color.ORANGE);
                    break;
                case 'X':
                    text.setFill(Color.RED);
                    break;
                default:
                    text.setFill(Color.rgb(100, 200, 100));
            }
        }
    }
}
