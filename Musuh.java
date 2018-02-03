import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Musuh here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Musuh extends Pemain
{   
    private int speed = 2;
 
    public Musuh(){
        setImage("bomb.png");
    }
    
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
