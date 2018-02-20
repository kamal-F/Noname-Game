import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AboutWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AboutWorld extends World
{

    /**
     * Constructor for objects of class AboutWorld.
     * 
     */
    public AboutWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 540, 1);
        setBackground("about.jpg");
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Back back = new Back();
        addObject(back,87,505);
        back.setLocation(76,497);
    }
}
