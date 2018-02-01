import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Joystick
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean touch=false;
    
    public void act() 
    {
        // Add your action code here
        if(Greenfoot.mouseClicked(this)){
            touch = true;
            ((Player)getWorld().getObjects(Player.class).get(0)).shootingTouch();
            touch = false;
        }
    }  
        
    public boolean getTouch()
    {    
        return touch;
    } 
}

