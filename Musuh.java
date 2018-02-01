import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Musuh here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Musuh extends Pemain
{
    /**
     * Act - do whatever the Musuh wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int speed = 2;
 
    public void act()
    {
        move();
    }
     
    private void move()
    {
        
        if((speed > 0 && getX() >= 741 || (speed < 0 && getX()<= 562)))
        {
            speed = -speed;
        }
        move(speed);
    }
}
