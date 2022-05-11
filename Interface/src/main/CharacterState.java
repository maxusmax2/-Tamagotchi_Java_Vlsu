package main;

import java.io.Serializable;
/** A class that stores the state of the tamagotchi*/
public class CharacterState implements Serializable{

    public int feedValue;
    public int playValue;
    public int sleepValue;
    public int cleanValue;
}