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
        // Movement
        if(Greenfoot.isKeyDown("A"))
        {
            move(-1);
        }
        else if(Greenfoot.isKeyDown("D"))
        {
            move(1);
        }
        
        // Remove bread if dolphin eats it
        eat();
    }
    
    public void eat()
    {
        if(isTouching(Bread.class))
        {
            removeTouching(Bread.class);
            MyWorld world = (MyWorld) getWorld();
            world.createBread();
            world.increaseScore();
        }
    }
}
