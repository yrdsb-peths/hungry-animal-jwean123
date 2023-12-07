import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Dolphin, a dolphin.
 * 
 * @author Juan 
 * @version November 2023
 */
public class Dolphin extends Actor
{
    int speed = 1;
    public void act()
    {
        // Movement
        if(Greenfoot.isKeyDown("A"))
        {
            move(-speed);
        }
        else if(Greenfoot.isKeyDown("D"))
        {
            move(speed);
        }
        
        // Remove bread if dolphin eats it
        eat();
    }
    
    public void increaseSpeed()
    {
        MyWorld world = (MyWorld) getWorld();
         if(world.oldScore + 10 == world.score)
         {
             speed += 1;
         }
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
