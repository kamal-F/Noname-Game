import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld2 here.
 * 
 * @author Dirga Brajamusti Naufal Fakhri
 * @version 1.1
 */
public class MyWorld2 extends World
{

    GreenfootSound backgroundMusic = new GreenfootSound("background.wav");
    /**
     * Constructor for objects of class MyWorld2.
     * 
     */
    public MyWorld2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960,540, 1); 
        prepare();
        started();
        setBackground("level2.jpg");
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Block1 block1 = new Block1();
        addObject(block1,54,499);
        block1.setLocation(46,494);
        Player player = new Player();
        addObject(player,17,432);
        player.setLocation(17,430);
        Block1 block12 = new Block1();
        addObject(block12,372,388);
        Block2x2 block2x2 = new Block2x2();
        addObject(block2x2,182,421);
        block12.setLocation(437,494);
        Block2x2nocode block2x2nocode = new Block2x2nocode();
        addObject(block2x2nocode,673,426);
        Block2x2nocode block2x2nocode2 = new Block2x2nocode();
        addObject(block2x2nocode2,497,335);
        Block2x2nocode block2x2nocode3 = new Block2x2nocode();
        addObject(block2x2nocode3,566,342);
        block2x2nocode3.setLocation(560,335);
        Block1 block13 = new Block1();
        addObject(block13,835,319);
        Block2x22 block2x22 = new Block2x22();
        addObject(block2x22,319,145);
        Block2x2nocode block2x2nocode4 = new Block2x2nocode();
        addObject(block2x2nocode4,936,91);
        Doorlv2 door = new Doorlv2();
        addObject(door,941,63);
        door.setLocation(938,61);
        Block2x2nocode block2x2nocode5 = new Block2x2nocode();
        addObject(block2x2nocode5,861,531);
        block2x2nocode5.setLocation(836,526);
        Block2x2nocode block2x2nocode6 = new Block2x2nocode();
        addObject(block2x2nocode6,38,235);
        block2x2nocode6.setLocation(78,236);
        Block2x2nocode block2x2nocode7 = new Block2x2nocode();
        addObject(block2x2nocode7,327,296);
        block2x2nocode6.setLocation(202,249);
        block2x2nocode6.setLocation(164,235);
        Block2x2nocode block2x2nocode8 = new Block2x2nocode();
        addObject(block2x2nocode8,38,142);
        Block1 block14 = new Block1();
        addObject(block14,650,119);
        Block2x2nocode block2x2nocode9 = new Block2x2nocode();
        addObject(block2x2nocode9,844,149);
        Nyawa nyawa = new Nyawa();
        addObject(nyawa,769,29);
        Monster monster = new Monster();
        addObject(monster,829,262);
        monster.setLocation(828,254);
        Monster monster2 = new Monster();
        addObject(monster2,522,312);
        Monster monster3 = new Monster();
        addObject(monster3,330,268);
        Monster monster4 = new Monster();
        addObject(monster4,45,117);
        monster4.setLocation(41,108);
        Monster monster5 = new Monster();
        addObject(monster5,188,390);
        MonsterKunci monsterkunci = new MonsterKunci();
        addObject(monsterkunci,843,499);
        monsterkunci.setLocation(843,492);
        Monster monster6 = new Monster();
        addObject(monster6,857,118);
        Monster monster7 = new Monster();
        addObject(monster7,328,114);
        Monster monster8 = new Monster();
        addObject(monster8,175,210);
        Monster monster9 = new Monster();
        addObject(monster9,651,61);
        monster9.setLocation(650,56);
        monster5.setLocation(434,430);
        Block2x2nocode block2x2nocode10 = new Block2x2nocode();
        addObject(block2x2nocode10,801,532);
        block2x2nocode10.setLocation(797,526);
        Block2x2nocode block2x2nocode23232 = new Block2x2nocode();
        addObject(block2x2nocode23232,716,314);
        
        Joystick joystick = new Joystick();
        addObject(joystick,863,338);
    }
    
    public void started(){
        backgroundMusic.playLoop();
        backgroundMusic.setVolume(50);
    }
    
    public void stopped(){
        backgroundMusic.stop();
    }
}
