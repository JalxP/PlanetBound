package view.graphical.resources;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

import static view.graphical.resources.ResourcesPaths.*;

public class Images
{
    private static final Map<String, Image> imageMap = new HashMap<>();

    static {
        /* Crew */
        imageMap.put(CAPTAIN, new Image(Resources.getResourceFile(PATH_CAPTAIN)));
        imageMap.put(CAPTAIN_DEAD, new Image(Resources.getResourceFile(PATH_CAPTAIN_DEAD)));

        imageMap.put(NAVIGATION, new Image(Resources.getResourceFile(PATH_NAVIGATION)));
        imageMap.put(NAVIGATION_DEAD, new Image(Resources.getResourceFile(PATH_NAVIGATION_DEAD)));

        imageMap.put(LANDING, new Image(Resources.getResourceFile(PATH_LANDING)));
        imageMap.put(LANDING_DEAD, new Image(Resources.getResourceFile(PATH_LANDING_DEAD)));

        imageMap.put(SHIELDS, new Image(Resources.getResourceFile(PATH_SHIELDS)));
        imageMap.put(SHIELDS_DEAD, new Image(Resources.getResourceFile(PATH_SHIELDS_DEAD)));

        imageMap.put(WEAPONS, new Image(Resources.getResourceFile(PATH_WEAPONS)));
        imageMap.put(WEAPONS_DEAD, new Image(Resources.getResourceFile(PATH_WEAPONS_DEAD)));

        imageMap.put(CARGO, new Image(Resources.getResourceFile(PATH_CARGO)));
        imageMap.put(CARGO_DEAD, new Image(Resources.getResourceFile(PATH_CARGO_DEAD)));

        /* Planets */
        imageMap.put(UNKNOWN_PLANET, new Image(Resources.getResourceFile(PATH_UNKNOWN_PLANET)));
        imageMap.put(GREEN_PLANET_SHIP, new Image(Resources.getResourceFile(PATH_GREEN_PLANET_SHIP)));
        imageMap.put(BLACK_PLANET_SHIP, new Image(Resources.getResourceFile(PATH_BLACK_PLANET_SHIP)));
        imageMap.put(RED_PLANET_SHIP, new Image(Resources.getResourceFile(PATH_RED_PLANET_SHIP)));
        imageMap.put(BLUE_PLANET_SHIP, new Image(Resources.getResourceFile(PATH_BLUE_PLANET_SHIP)));
    }

    public static Image getImage(String name)
    {
        return imageMap.get(name);
    }
}
