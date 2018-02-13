import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class About here.
 * 
 * @author D.Irga B. Naufal Fakhri
 * @version 1.12
 */
public class About extends Tombol
{
    /**
     * Act - do whatever the About wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            ((Menu)getWorld()).stopped();
            World Start = getWorld();
            Start = new AboutWorld();
            Greenfoot.setWorld(Start);
        }
    }    
}
