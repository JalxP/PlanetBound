package view.graphical.panes.controls;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static view.graphical.ConstantsUI.*;

public class ActionButton extends Button
{
    public ActionButton(String name)
    {
        super(name);
        setTextFill(Color.rgb(45,45,45));
        setFont(new Font("Verdana", 12));
        setMinSize(DIM_X_ACTION_BUTTON, DIM_Y_ACTION_BUTTON);
        setBackground(new Background(new BackgroundFill(Color.rgb(180,180,180), null, null)));
        setBackground(new Background(new BackgroundFill(Color.rgb(180,180,180), null, null)));
        setBorder(new Border(new BorderStroke(Color.rgb(75,75,75),
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.FULL)));

        setWrapText(true);
        setAlignment(Pos.CENTER);

        this.setOnMouseEntered(new HandleMouseEnter());
        this.setOnMouseExited(new HandleMouseExit());
    }

    private class HandleMouseEnter implements EventHandler<MouseEvent>
    {
        @Override
        public void handle(MouseEvent event)
        {
            setEffect(new DropShadow());
            setBackground(new Background(new BackgroundFill(Color.rgb(200,200,200), null, null)));
            setCursor(Cursor.DEFAULT);
        }
    }

    private class HandleMouseExit implements EventHandler<MouseEvent>
    {
        @Override
        public void handle(MouseEvent event)
        {
            setEffect(null);
            setBackground(new Background(new BackgroundFill(Color.rgb(180,180,180), null, null)));
            setCursor(Cursor.HAND);
        }
    }
}
