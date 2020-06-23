package model.utility;

import java.io.*;

public class FileUtility
{
    private FileUtility(){}

    public static void saveGame(File file, Object object) throws IOException
    {
        ObjectOutputStream objectOutputStream = null;

        try
        {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(object);
        } finally
        {
            if (objectOutputStream != null)
                objectOutputStream.close();
        }
    }

    public static Object loadGame(File file) throws IOException, ClassNotFoundException
    {
        ObjectInputStream objectInputStream = null;

        try
        {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            return objectInputStream.readObject();
        } finally
        {
            if (objectInputStream != null)
            {
                objectInputStream.close();
            }
        }
    }
}
