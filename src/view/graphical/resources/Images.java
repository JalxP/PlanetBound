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
        imageMap.put(GREEN_PLANET, new Image(Resources.getResourceFile(PATH_GREEN_PLANET)));
        imageMap.put(BLACK_PLANET, new Image(Resources.getResourceFile(PATH_BLACK_PLANET)));
        imageMap.put(RED_PLANET, new Image(Resources.getResourceFile(PATH_RED_PLANET)));
        imageMap.put(BLUE_PLANET, new Image(Resources.getResourceFile(PATH_BLUE_PLANET)));
        imageMap.put(SPACE_STATION, new Image(Resources.getResourceFile(PATH_SPACE_STATION)));
        imageMap.put(EVENT_TOKEN, new Image(Resources.getResourceFile(PATH_EVENT_TOKEN)));

        /* Surface */
        imageMap.put(SURFACE_NONE, new Image(Resources.getResourceFile(SURFACE_NONE_PATH)));
        imageMap.put(SURFACE_BLACK, new Image(Resources.getResourceFile(SURFACE_BLACK_PATH)));
        imageMap.put(SURFACE_BLUE, new Image(Resources.getResourceFile(SURFACE_BLUE_PATH)));
        imageMap.put(SURFACE_GREEN, new Image(Resources.getResourceFile(SURFACE_GREEN_PATH)));
        imageMap.put(SURFACE_RED, new Image(Resources.getResourceFile(SURFACE_RED_PATH)));
        imageMap.put(SURFACE_ARTIFACT, new Image(Resources.getResourceFile(SURFACE_ARTIFACT_PATH)));
        imageMap.put(SURFACE_DRONE, new Image(Resources.getResourceFile(SURFACE_DRONE_PATH)));
        imageMap.put(SURFACE_LANDING, new Image(Resources.getResourceFile(SURFACE_LANDING_PATH)));
        imageMap.put(SURFACE_BLACK_ALIEN, new Image(Resources.getResourceFile(SURFACE_BLACK_ALIEN_PATH)));
        imageMap.put(SURFACE_BLUE_ALIEN, new Image(Resources.getResourceFile(SURFACE_BLUE_ALIEN_PATH)));
        imageMap.put(SURFACE_GREEN_ALIEN, new Image(Resources.getResourceFile(SURFACE_GREEN_ALIEN_PATH)));
        imageMap.put(SURFACE_RED_ALIEN, new Image(Resources.getResourceFile(SURFACE_RED_ALIEN_PATH)));

    }

    public static Image getImage(String name)
    {
        return imageMap.get(name);
    }
}
