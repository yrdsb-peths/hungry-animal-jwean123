import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Dolphin, a dolphin.
 * 
 * @author Juan 
 * @version November 2023
 */
public class Dolphin extends Actor
{
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
        
        //Makes sure speed will increase over time
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
