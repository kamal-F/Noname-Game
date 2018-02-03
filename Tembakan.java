import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tembakan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tembakan extends Actor
{
    /**
     * Act - do whatever the Tembakan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     
    public void act() 
    {
        killMusuh();
    }    
    
    public void remove()
    {
       Actor walls = getOneIntersectingObject(Platform.class);
       if(getX() <=1 || getX() >= getWorld().getWidth() -1)
       {
           getWorld().removeObject(this);
        }
        else if(walls != null)
        {
            getWorld().removeObject(this);
        }
    }
    
    public boolean amIshot(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0,0, clss);
        return actor !=null;
    }
    
    public void kill(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0,0, clss);
        if(actor != null)
        {
            getWorld().removeObject(actor);
        }
    }
    
    public void killMusuh()
    {
        if(amIshot(Monster.class)) 
        {
            kill(Monster.class);
            getWorld().removeObject(this);
            Greenfoot.playSound("ledakan.wav");
        }
       else if(amIshot(MonsterKunci.class))
       {
           getWorld().addObject(new Kunci(), getX(), getY());
           kill(MonsterKunci.class);
           getWorld().removeObject(this);
           Greenfoot.playSound("ledakan.wav");
       }
       else
       {
         remove();  
       }
    }
    
    
}
