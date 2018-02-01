import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UP extends Joystick
{
    /**
     * Act - do whatever the UP wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        boolean jumping = getWorld().getObjects(Player.class).get(0).getJump();
        if(Greenfoot.mousePressed(this) && jumping == false){
            ((Player)getWorld().getObjects(Player.class).get(0)).jump();
        }
    }    

}
