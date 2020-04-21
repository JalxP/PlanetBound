package view.graphical.resources;

import java.io.InputStream;

public class Resources
{
    public static InputStream getResourceFile(String name)
    {
        return Resources.class.getResourceAsStream(name);
    }
}
