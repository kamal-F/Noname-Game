import greenfoot.*;

/**
 * Write a description of class Player here.
 * 
 * @author Dirga Brajamusti Naufal Fakhri
 * @version 1.1
 */
public class Player extends Actor
{
    private int vSpeed = 0;
    private int acceleration = 1;
    public boolean jumping;
    private int jumpStrength = 16;
    private int speed = 4;
    int score = 0;
    int world = 0;
    private boolean punyakunci = false;
    private int direction = 1; 
    private int shootingCounter = 10; 
    int nyawa = 5;

    private GreenfootImage run1r = new GreenfootImage("p1r.png");
    private GreenfootImage run2r = new GreenfootImage("p2r.png");
    private GreenfootImage run3r = new GreenfootImage("p3r.png");
    private GreenfootImage run4r = new GreenfootImage("p4r.png");
    private GreenfootImage run1l = new GreenfootImage("p1l.png");
    private GreenfootImage run2l = new GreenfootImage("p2l.png");
    private GreenfootImage run3l = new GreenfootImage("p3l.png");
    private GreenfootImage run4l = new GreenfootImage("p4l.png");
    private int frame = 1;
    private int animationCounter = 0;

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKey();
        checkFall();
        shooting();
        shootingTouch();
        platformAbove();
        checkRightWalls();
        checkLeftWalls();
        shootingCounter --;
        animationCounter++;
        Death();
        NextLevel();
        Kunci();
        
    }   
    

   public void Kunci()
    {
        if (canSee(Kunci.class) )
        {
            get(Kunci.class);
            punyakunci = true;
            //Greenfoot.playSound("keyfound.wav");
        }
    }
    public void NextLevel()
    {
        if(canSee(Door.class) && punyakunci == true)
        {
            ((MyWorld)getWorld()).stopped();
            World Start = getWorld();
            Start = new MyWorld2();
            Greenfoot.setWorld(Start);
        }
        
        if(canSee(Doorlv2.class) && punyakunci == true)
        {
            ((MyWorld2)getWorld()).stopped();
            World Start = getWorld();
            Start = new Thanks();
            Greenfoot.setWorld(Start);
        }
    }
    
    public void checkKey()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            direction = 1;
            moveRight();
        }
        if(Greenfoot.isKeyDown("left"))
        {
            direction = -1;
            moveLeft();
        }
        if(Greenfoot.isKeyDown("up") && jumping == false)
        {
            jump();
        }
        
    }

    public boolean shooting()
    {
        if(Greenfoot.isKeyDown("space") && shootingCounter <= 0 && direction ==1)
        {
            getWorld().addObject(new RightShoot(), getX(), getY());
            shootingCounter = 20;
            Greenfoot.playSound("pistol.wav");
            return true;
        }
        if(Greenfoot.isKeyDown("space") && shootingCounter <= 0 && direction ==-1)
        {
            getWorld().addObject(new LeftShoot(), getX(), getY());
            shootingCounter = 20;
            Greenfoot.playSound("pistol.wav");
            return true;
        }
        return false;
    }
    
    public boolean shootingTouch()
    {
        boolean touch = getWorld().getObjects(Button.class).get(0).getTouch();
        if(touch == true && shootingCounter <= 0 && direction ==1)
        {
            getWorld().addObject(new RightShoot(), getX(), getY());
            shootingCounter = 20;
            Greenfoot.playSound("pistol.wav");
            return true;
        }
        if(touch == true && shootingCounter <= 0 && direction ==-1)
        {
            getWorld().addObject(new LeftShoot(), getX(), getY());
            shootingCounter = 20;
            Greenfoot.playSound("pistol.wav");
            return true;
        }
        return false;
    }

    public void moveRight()
    {
        setLocation(getX()+speed, getY());
        if(animationCounter % 4 == 0)
        {
            animateRight();
        }
    }

    public void animateRight()
    {
        if(frame == 1)
        {
            setImage(run1r);
        }
        else if(frame == 2)
        {
            setImage(run2r);
        }
        else if(frame == 3)
        {
            setImage(run3r);
        }
        else if(frame == 4)
        {
            setImage(run4r);
            frame = 1;
            return;
        }
        frame++;
    }

    public void moveLeft()
    {
        setLocation(getX()-speed, getY());
        if(animationCounter %4 == 0)
        {
            animateLeft();
        }
    }

    public void animateLeft()
    {
        if(frame == 1)
        {
            setImage(run1l);
        }
        else if(frame == 2)
        {
            setImage(run2l);
        }
        else if(frame == 3)
        {
            setImage(run3l);
        }
        else if(frame == 4)
        {
            setImage(run4l);
            frame = 1;
            return;
        }
        frame++;
    }

    public boolean platformAbove()
    {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/-2);
        Actor ceiling = getOneObjectAtOffset(0, yDistance, Platform.class);
        if(ceiling != null)
        {
            vSpeed = 1;
            bopHead(ceiling);
            return true;
        }
        else
        {
            return false;
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
    }

    public void bopHead(Actor ceiling)
    {
        int ceilingHeight = ceiling.getImage().getHeight();
        int newY = ceiling.getY() + (ceilingHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
    }

    public void fall()
    {
        setLocation(getX(), getY() + vSpeed);
        if(vSpeed <=9)
        {
            vSpeed = vSpeed + acceleration;
        }
        jumping = true;
    }

    public boolean onGround()
    {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/2) + 5;
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight()/2, Platform.class);
        if(ground == null)
        {
            jumping = true;
            return false;
        }
        else
        {
            moveToGround(ground);
            return true;
        }
    }

    public void moveToGround(Actor ground)
    {
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
        jumping = false;
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

    public void jump()
    {
        vSpeed = vSpeed - jumpStrength;
        jumping = true;
        fall();
    }
    
    public boolean getJump()
    {
        return jumping;
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

    /**
     * Holds the score variable to be called by the Scores class for display.
     */
    public int getScore()
    {    
        return nyawa;
    }  
    
   public void Death()
    {
        if(getY() >= 530 && nyawa >=1)
        {
            nyawa--;
            setLocation(20,415);
        }
        
        if(nyawa == 0)
            {
               Greenfoot.stop();
               Greenfoot.playSound("gameover.mp3");
               getWorld().addObject(new YouLose(), getWorld().getWidth() /  2, getWorld().getHeight() / 2);
            }
    }
}
