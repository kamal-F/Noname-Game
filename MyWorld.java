import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Dirga Brajamusti Naufal Fakhri
 * @version 1.1
 */
public class MyWorld extends World
{
    private int addPlayer = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    GreenfootSound backgroundMusic = new GreenfootSound("background.wav");
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 540, 1); 
        prepare();
        started();
        setBackground("level1.jpg");

    }
 
    public void prepare()
    {
        Player player = new Player();
        addObject(player,20,415);
        //Block lv1

        addObject(new Block1(),48,493);
        addObject(new Block1(),892,193);
        addObject(new Block2x2(),155,402);
        addObject(new Block2x2nocode(),383,332);
        addObject(new Block2x2nocode(),480,332);
        addObject(new Block2x2nocode(),440,332);
        addObject(new Block2x2nocode(),576,268);
        addObject(new Block2x2nocode(),640,268);
        addObject(new Block2x2nocode(),202,289);
        addObject(new Block2x2nocode(),33,234);
        addObject(new Block2x2nocode(),97,234);
        addObject(new Block2x22(),435,222);
        addObject(new Block2x2nocode(),343,132);
        addObject(new Block2x2nocode(),279,132);
        addObject(new Block2x2nocode(),189,63);
        addObject(new Block2x2nocode(),130,63);
        addObject(new Block2x2nocode(),75,63);
        addObject(new Block2x2nocode(),25,63);
        addObject(new Block1(),560,493);
        addObject(new Block1(),720,388);
        addObject(new Block2x2nocode(),846,460);
        addObject(new Block2x2nocode(),897,460);

        //nextlevel
        addObject(new Door(),24,31);

        //monster
        addObject(new Monster(),707,321);
        addObject(new Monster(),317,100);
        addObject(new Monster(),48,198);
        addObject(new Monster(),882,128);
        addObject(new MonsterKunci(),566,432);

        Block2x2nocode block2x2nocode17 = new Block2x2nocode();
        addObject(block2x2nocode17,730,180);
        Nyawa nyawa = new Nyawa();
        addObject(nyawa,732,23);
        
        Joystick joystick = new Joystick();
        addObject(joystick,863,338);
    }
    
    public void started(){
        backgroundMusic.playLoop();
        backgroundMusic.setVolume(90);
        //Greenfoot.setSpeed(55);
    }
    
    public void stopped(){
        backgroundMusic.stop();
    }
}
