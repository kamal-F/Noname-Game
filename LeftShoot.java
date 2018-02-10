import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LeftShoot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeftShoot extends Tembakan
{
    public LeftShoot(){
        setImage("shoot1.png");
        Greenfoot.playSound("pistol1.wav");
    }
    
    /**
     * Act - do whatever the LeftShoot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setLocation(getX() - 8, getY());
        killMusuh();
    }    
    
}
