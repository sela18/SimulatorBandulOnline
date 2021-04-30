import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class backgroundhome here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class backgroundhome extends World
{

    /**
     * Constructor for objects of class backgroundhome.
     * 
     */
    public backgroundhome()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 700, 1); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        play play = new play();
        addObject(play,191,591);
    }
}
