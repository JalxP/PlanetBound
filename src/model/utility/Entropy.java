package model.utility;

import java.util.Random;

public abstract class Entropy
{
    private static final Random random = new Random();

    private Entropy(){}

    public static int throwDie(int numSides)
    {
        return random.nextInt(numSides) + 1;
    }
}
