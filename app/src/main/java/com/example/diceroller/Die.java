package com.example.diceroller;

import java.util.Random;

public class Die
{
    private int numberOfSides;

    public Die(int numberOfSides)
    {
        this.numberOfSides = numberOfSides;
    }

    public int roll()
    {
        Random r = new Random();
        return r.nextInt(this.numberOfSides)+1;
    }
}
