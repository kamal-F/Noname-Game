import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Back here.
 * 
 * @author D.Irga B. Naufal Fakhri
 * @version 1.12
 */
public class Back extends Tombol
{
    public Back(){
        setImage("button_back.png");
    }
    /**
     * Act - do whatever the Back wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            (getWorld()).stopped();
            World Start = getWorld();
            Start = new Menu();
            Greenfoot.setWorld(Start);
        }
    }    
}
