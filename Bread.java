import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The bread, a treat for the Dolphin
 * 
 * @author Juan 
 * @version November 2023
 */
public class Bread extends Actor
{
    public void act()
    {
        // Apple falling
        setLocation(getX(), getY() + 2);
        
        // Substract a life when apple falls to the floor, if no lives left draw game over.
        MyWorld world = (MyWorld) getWorld();
        if(getY() == world.getHeight())
        {
            world.substractLives();
            if(world.lives > 0)
            {
                world.createBread();
            }
            else
            {
                world.gameOver();
            }
        }
    }
}
