import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class right here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class right extends Joystick
{
    /**
     * Act - do whatever the right wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mousePressed(this)){
            ((Player)getWorld().getObjects(Player.class).get(0)).moveRight();
        }
    }    
}
