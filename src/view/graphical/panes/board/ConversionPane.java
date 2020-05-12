package view.graphical.panes.board;

import controller.ObservableGame;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.data.GameEnums.*;
import view.graphical.panes.controls.ActionButton;
import view.graphical.resources.Images;

import static view.graphical.resources.ResourcesPaths.*;
import static view.graphical.resources.ResourcesPaths.SURFACE_RED;

public class ConversionPane extends HBox
{
    private final ObservableGame observableGame;

    private final ImageView blackResource;
    private final ImageView blueResource;
    private final ImageView greenResource;
    private final ImageView redResource;

    private final GridPane conversionGrid;

    private RadioButton fromBlack;
    private RadioButton fromBlue;
    private RadioButton fromGreen;
    private RadioButton fromRed;

    private RadioButton toBlack;
    private RadioButton toBlue;
    private RadioButton toGreen;
    private RadioButton toRed;

    private ToggleGroup fromGroup;
    private ToggleGroup toGroup;


    private final ActionButton convertResourcesButton;

    public ConversionPane(ObservableGame observableGame)
    {
        this.observableGame = observableGame;

        blackResource = new ImageView(Images.getImage(SURFACE_BLACK));
        blueResource = new ImageView(Images.getImage(SURFACE_BLUE));
        greenResource = new ImageView(Images.getImage(SURFACE_GREEN));
        redResource = new ImageView(Images.getImage(SURFACE_RED));

        conversionGrid = new GridPane();

        fromBlack = new RadioButton();
        fromBlue = new RadioButton();
        fromGreen = new RadioButton();
        fromRed = new RadioButton();

        toBlack = new RadioButton();
        toBlue = new RadioButton();
        toGreen = new RadioButton();
        toRed = new RadioButton();

        fromGroup = new ToggleGroup();
        fromGroup.getToggles().addAll(fromBlack, fromBlue, fromGreen, fromRed);

        toGroup = new ToggleGroup();
        toGroup.getToggles().addAll(toBlack, toBlue, toGreen, toRed);

        convertResourcesButton = new ActionButton("Convert");

        setupLayout();
        setupListeners();
        installTooltips();
    }

    private void installTooltips()
    {
        Tooltip.install(blackResource, new Tooltip(SURFACE_BLACK));
        Tooltip.install(blueResource, new Tooltip(SURFACE_BLUE));
        Tooltip.install(greenResource, new Tooltip(SURFACE_GREEN));
        Tooltip.install(redResource, new Tooltip(SURFACE_RED));
    }

    private void setupLayout()
    {
        getChildren().clear();

        conversionGrid.add(blackResource, 0,0);
        conversionGrid.add(blueResource, 0,1);
        conversionGrid.add(greenResource, 0,2);
        conversionGrid.add(redResource, 0, 3);

        conversionGrid.add(fromBlack,1,0);
        conversionGrid.add(fromBlue,1,1);
        conversionGrid.add(fromGreen,1,2);
        conversionGrid.add(fromRed,1,3);

        conversionGrid.add(toBlack,2,0);
        conversionGrid.add(toBlue,2,1);
        conversionGrid.add(toGreen,2,2);
        conversionGrid.add(toRed,2,3);

        conversionGrid.add(new ImageView(blackResource.getImage()), 3,0);
        conversionGrid.add(new ImageView(blueResource.getImage()), 3,1);
        conversionGrid.add(new ImageView(greenResource.getImage()), 3,2);
        conversionGrid.add(new ImageView(redResource.getImage()), 3, 3);

        getChildren().addAll(conversionGrid, convertResourcesButton);

    }

    private void setupListeners()
    {
        convertResourcesButton.setOnAction(new ConvertResourcesButtonClicked());
        fromGroup.selectedToggleProperty().addListener(new Test());
        toGroup.selectedToggleProperty().addListener(new Test());
    }

    public void update()
    {
        convertResourcesButton.setDisable(true);

        fromBlack.setDisable(!observableGame.hasResources(ResourceType.BLACK));
        fromBlue.setDisable(!observableGame.hasResources(ResourceType.BLUE));
        fromGreen.setDisable(!observableGame.hasResources(ResourceType.GREEN));
        fromRed.setDisable(!observableGame.hasResources(ResourceType.RED));
    }

    private class ConvertResourcesButtonClicked implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent actionEvent)
        {
            int fromN = 0;
            int toN = 0;
            for (int i = 0; i < 4; i++)
            {
                if (fromGroup.getSelectedToggle().equals(fromGroup.getToggles().get(i)))
                    fromN = i;
                if (toGroup.getSelectedToggle().equals(toGroup.getToggles().get(i)))
                    toN = i;
            }

            ResourceType from = ResourceType.values()[fromN];
            ResourceType to = ResourceType.values()[toN];
            observableGame.convertResource(from, to);
        }
    }

    private class Test implements ChangeListener<Toggle>
    {
        @Override
        public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1)
        {
            if (fromGroup.getSelectedToggle() != null && toGroup.getSelectedToggle() != null)
                convertResourcesButton.setDisable(false);
        }
    }
}
