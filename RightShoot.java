import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RightShoot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RightShoot extends Tembakan
{
    /**
     * Act - do whatever the RightShoot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        setLocation(getX() + 8, getY());
        killMusuh();
   }    
}