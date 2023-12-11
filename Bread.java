import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The bread, a treat for the Dolphin
 * 
 * @author Juan 
 * @version December 2023
 */
public class Bread extends Actor
{
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        //Bread falling
        setLocation(getX(), getY() + world.getSpeed());
        
        /*Substract a life when bread falls to the floor, 
         * if no lives left draw game over.
         */
        if(getY() > world.getHeight())
        {
            getWorld().removeObject(this);
            world.substractLives();
            if(world.getLives() > 0)
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
