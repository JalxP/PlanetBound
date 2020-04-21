package view.graphical.resources;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

import static view.graphical.resources.ResourcesPaths.*;

public class ImagesCrew
{
    private static final Map<String, Image> crewImages = new HashMap<>();

    static {
        crewImages.put(CAPTAIN, new Image(Resources.getResourceFile(PATH_CAPTAIN)));
        crewImages.put(CAPTAIN_DEAD, new Image(Resources.getResourceFile(PATH_CAPTAIN_DEAD)));

        crewImages.put(NAVIGATION, new Image(Resources.getResourceFile(PATH_NAVIGATION)));
        crewImages.put(NAVIGATION_DEAD, new Image(Resources.getResourceFile(PATH_NAVIGATION_DEAD)));

        crewImages.put(LANDING, new Image(Resources.getResourceFile(PATH_LANDING)));
        crewImages.put(LANDING_DEAD, new Image(Resources.getResourceFile(PATH_LANDING_DEAD)));

        crewImages.put(SHIELDS, new Image(Resources.getResourceFile(PATH_SHIELDS)));
        crewImages.put(SHIELDS_DEAD, new Image(Resources.getResourceFile(PATH_SHIELDS_DEAD)));

        crewImages.put(WEAPONS, new Image(Resources.getResourceFile(PATH_WEAPONS)));
        crewImages.put(WEAPONS_DEAD, new Image(Resources.getResourceFile(PATH_WEAPONS_DEAD)));

        crewImages.put(CARGO, new Image(Resources.getResourceFile(PATH_CARGO)));
        crewImages.put(CARGO_DEAD, new Image(Resources.getResourceFile(PATH_CARGO_DEAD)));
    }

    public static Image getImage(String crewName)
    {
        return crewImages.get(crewName);
    }
}
