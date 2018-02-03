import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends Pemain
{
    int frame = 0;
    private int animationCount;
    private int vSpeed = 0;
    private int acceleration = 2;
    
    private int spriteHeight = getImage().getHeight();
    private int spriteWidth = getImage().getWidth();
    private int lookForGroundDistance = (int)spriteHeight/2;
    private int lookForEdge = (int)spriteWidth/2;
    
    private int speed = 1;
    
    GreenfootImage monster1l = new GreenfootImage("monster1l.png");
    GreenfootImage monster2l = new GreenfootImage("monster2l.png");
    GreenfootImage monster3l = new GreenfootImage("monster3l.png");
    GreenfootImage monster4l = new GreenfootImage("monster4l.png");
    
    GreenfootImage monster1r = new GreenfootImage("monster1r.png");
    GreenfootImage monster2r = new GreenfootImage("monster2r.png");
    GreenfootImage monster3r = new GreenfootImage("monster3r.png");
    GreenfootImage monster4r = new GreenfootImage("monster4r.png");
    
    public Monster(){
        setImage("monster1l.png");
        spriteHeight = getImage().getHeight();
        spriteWidth = getImage().getWidth();
        lookForGroundDistance = (int)spriteHeight/2;
        lookForEdge = (int)spriteWidth/2;
    }
    
    public void act() 
    {
        tryToGetPlayer();
        checkFall();
        checkEdge();
        move();
        setAnimation();
        animationCount ++;
        checkRightWalls();
        checkLeftWalls();
        
    }    
    
    // If the animation count is divisible by 4, animate (slows down animation)
    public void setAnimation()
    {
    if(speed<0)
        {
            if(animationCount % 4 == 0)
            animateLeft();
        }
        else
        {
            if(animationCount % 4 == 0)
            animateRight();
        }
    }
   
    // Check for the edge of the world and, if so, reverse direction
    public void checkEdge()
    {
    if(getX() < 10 || getX() > getWorld().getWidth() - 10)
        {
            speed *= -1;
        }
    }   
    
    public void move()
    {
        Actor ground = getOneObjectAtOffset(lookForEdge, lookForGroundDistance, Platform.class);
        if(ground == null)
        {
            speed *= -1; // Reverses direction
            lookForEdge *= -1; // Looks for a negative number
        }
        else
        {
            move(speed);
        }
    }
    
    public void animateLeft()
    {
        if(frame == 0)
        {
            setImage(monster1l);
        }
        if(frame == 1)
        {
            setImage(monster2l);
        }
        if(frame == 2)
        {
            setImage(monster3l);
        }
        if(frame == 3)
        {
            setImage(monster4l);
            frame = 0;
        }
        frame++;
    }
    
        public void animateRight()
    {
        if(frame == 0)
        {
            setImage(monster1r);
        }
        if(frame == 1)
        {
            setImage(monster2r);
        }
        if(frame == 2)
        {
            setImage(monster3r);
        }
        if(frame == 3)
        {
            setImage(monster4r);
            frame = 0;
        }
        frame++;
    }
    
        public void fall()
    {
        setLocation(getX(), getY() + vSpeed);
        if(vSpeed <=9)
        {
            vSpeed = vSpeed + acceleration;
        }
        
    }
    
    public boolean onGround()
    {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/2) + 5;
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight()/2, Platform.class);
        if(ground == null)
        {
            return false;
        }
        else
        {
            moveToGround(ground);
            return true;
        }
    }
    
    public boolean checkRightWalls()
    {
        int spriteWidth = getImage().getWidth();
        int xDistance = (int)(spriteWidth/2);
        Actor rightWall = getOneObjectAtOffset(xDistance, 0, Platform.class);
        if(rightWall == null)
        {
            return false;
        }
        else
        {
            stopByRightWall(rightWall);
            return true;
        }
    }

    public void stopByRightWall(Actor rightWall)
    {
        int wallWidth = rightWall.getImage().getWidth();
        int newX = rightWall.getX() - (wallWidth + getImage().getWidth())/2;
        setLocation(newX - 5, getY());
        speed *= -1;

    }

    public boolean checkLeftWalls()
    {
        int spriteWidth = getImage().getWidth();
        int xDistance = (int)(spriteWidth/-2);
        Actor leftWall = getOneObjectAtOffset(xDistance, 0, Platform.class);
        if(leftWall == null)
        {
            return false;
        }
        else
        {
            stopByLeftWall(leftWall);
            return true;
        }
    }

    public void stopByLeftWall(Actor leftWall)
    {
        int wallWidth = leftWall.getImage().getWidth();
        int newX = leftWall.getX() + (wallWidth + getImage().getWidth())/2;
        setLocation(newX + 5, getY());
        speed *= -1;

    }

    public void moveToGround(Actor ground)
    {
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
    }
    
    public void checkFall()
    {
        if(onGround())
        {
            vSpeed = 0;
        }
        else
        {
            fall();
        }
    }
    
    public void tryToGetPlayer()
    {
        if (canSee(Player.class) )
        {
            get(Player.class);
            Greenfoot.playSound("gameover.mp3");
            Greenfoot.stop();
            getWorld().addObject(new YouLose(), getWorld().getWidth() /  2, getWorld().getHeight() / 2);
        }
    }
    
    
    /**
     * Return true if we can see an object of class 'clss' right where we are. 
     * False if there is no such object here.
     */
    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }
    
    /**
     * Try to grab an object of class 'clss'. This is only successful if there
     * is such an object where we currently are. Otherwise this method does
     * nothing.
     */
    public void get(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) {
            getWorld().removeObject(actor);
        }
    }
}
