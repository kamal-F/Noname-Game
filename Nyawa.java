import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nyawa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nyawa extends Actor
{
    /**
     * Act - do whatever the Nyawa wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int nyawa = 0;
    
    public void act()   
    {   
        try{
            int nyawa = ((Player)getWorld().getObjects(Player.class).get(0)).getScore();
            setImage(new GreenfootImage("Nyawa Jatuh: " + nyawa +" ", 20, Color.WHITE, Color.BLACK));
        } catch(Exception e){}
    }
}
