import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author Dirga Brajamusti Naufal Fakhri
 * @version 1.1
 */
public class Menu extends World
{

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 540, 1);
        setBackground("menu1.jpg");
        prepare();        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Play play = new Play();
        addObject(play,490,363);
        play.setLocation(485,360);
        Tutorial tutorial = new Tutorial();
        addObject(tutorial,490,428);
        tutorial.setLocation(484,423);        
    }
}
