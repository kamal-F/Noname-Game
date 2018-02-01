import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block2x2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block2x2 extends Platform
{
    /**
     * Act - do whatever the Block2x2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 2;
    private int arah = 1; 
    public void act()
    {
        move();
    }
     
    private void move()
    {
        if(arah == 1)
        {
            move(1);
        }
        
        if(arah == -1)
        {
            move(-1);
        }
        
        if(getX() == 300)
        {
            arah = -1;
        }
        
        if(getX() == 150)
        {
            arah = 1;
        }
    }
}
