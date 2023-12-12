import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Dolphin, a dolphin.
 * 
 * @author Juan 
 * @version December 2023
 */
public class Dolphin extends Actor
{
    GreenfootImage dolphins[] = new GreenfootImage[5];
    
    public Dolphin()
    {
        int i;
        for(i = 0; i < dolphins.length; i++)
        {
            dolphins[i] = new GreenfootImage("images/dolphin_stuff/dolphin" + i + ".png");
        }
        setImage(dolphins[0]);
    }
    
    /**
     * Animate the dolphin
     */
    
    int imageIndex = 0;
    public void animateDolphin()
    {
        setImage(dolphins[imageIndex]);
        imageIndex = (imageIndex + 1) % dolphins.length;
    }
    
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        
        // Movement
        if(Greenfoot.isKeyDown("A"))
        {
            move(-world.getSpeed());
        }
        else if(Greenfoot.isKeyDown("D"))
        {
            move(world.getSpeed());
        }
        
        // Remove bread if dolphin eats it
        eat();
        
        // Animate the dolphin
        animateDolphin();
    }
    
    
    public void eat()
    {
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Bread.class))
        {
            removeTouching(Bread.class);
            world.createBread();
            world.increaseScore();
        }
    }
}
