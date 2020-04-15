package model.utility;

import java.util.Random;

public class Entropy
{
    private static Random entropy = new Random();

    public Entropy(){}

    public static int throwDie(int numSides)
    {
        return entropy.nextInt(numSides) + 1;
    }
}
