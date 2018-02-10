import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JoyAll here.
 * 
 * @author kamal_F 
 * @version v1
 */
public class Joystick extends Actor
{
    public Joystick(){
        setImage("fire3_reva.png");    
    }
    
    /**
     * Act - do whatever the JoyAll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseDragged(this) || Greenfoot.mouseClicked(this)){
            MouseInfo m = Greenfoot.getMouseInfo();
            int mX = m.getX();
            int mY = m.getY();
                    
            actLoc(mX,mY);
        }
        
    }
    
    public int getWidth2(){    
        return this.getImage().getWidth()/2;
    }
    
    public int getHeight2(){
        return this.getImage().getHeight()/2;
    }
    
    private void actLoc(int px, int py){
        int x;
        int y;
        
        // lokasi pada image
        x = px-(this.getX()-this.getImage().getWidth()/2);
        y = py-(this.getY()-this.getImage().getHeight()/2);
        
        //image Width dibagi 3, dapat per kotak
        //image Height dibagi 3, dapat per kotak
        int imgWp3;
        int imgHp3;
        
        imgWp3 = this.getImage().getWidth()/3;
        imgHp3 = this.getImage().getHeight()/3;
              
        int mx;
        int my;
        
        mx = x/imgWp3;
        my = y/imgHp3;
        
        System.out.println("mx=" + mx);
        System.out.println("my=" + my);
        /*
           012
           345
           678
           
              mx   my
           0 = 0    0
           1 = 1    0
           2 = 2    0
           3 = 0    1
           4 = 1    1
           5 = 2    1
           6 = 0    2
           7 = 1    2
           8 = 2    2
           
           
           */
        
        if(mx==1 && my==0){
            try {
                boolean jumping = getWorld().getObjects(Player.class).get(0).getJump();
                if(jumping == false){
                    ((Player)getWorld().getObjects(Player.class).get(0)).jump();
                }
            } catch (Exception e){}

        }
        
        if(mx==0 && my==1){
            try{
                ((Player)getWorld().getObjects(Player.class).get(0)).moveLeft();
            } catch(Exception e){}
        }
        
        if(mx>=2 && my==1){
            try{
                ((Player)getWorld().getObjects(Player.class).get(0)).moveRight();
            } catch(Exception e){}
        }
        
        
        if(mx>=2 && my==0){
            try {
                boolean jumping = getWorld().getObjects(Player.class).get(0).getJump();
                if(jumping == false){
                    ((Player)getWorld().getObjects(Player.class).get(0)).jump();
                }
                ((Player)getWorld().getObjects(Player.class).get(0)).moveRight();
            } catch (Exception e){}
        }
        
        if(mx==0 && my==0){
            try {
                boolean jumping = getWorld().getObjects(Player.class).get(0).getJump();
                if(jumping == false){
                    ((Player)getWorld().getObjects(Player.class).get(0)).jump();
                }
                ((Player)getWorld().getObjects(Player.class).get(0)).moveLeft();
            } catch (Exception e){}
        }
        
        if(mx==0 && my>=2){
            try{
                ((Player)getWorld().getObjects(Player.class).get(0)).shooting();
            } catch(Exception e){}
        }
        
        if(mx==1 && my>=2){
            try{
                ((Player)getWorld().getObjects(Player.class).get(0)).shooting();
            } catch(Exception e){}
        }
        
        if(mx>=2 && my>=2){
            try{
                ((Player)getWorld().getObjects(Player.class).get(0)).shooting();
            } catch(Exception e){}
        }
        
    }
}
