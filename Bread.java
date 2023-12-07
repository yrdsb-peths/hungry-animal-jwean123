import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The bread, a treat for the Dolphin
 * 
 * @author Juan 
 * @version November 2023
 */
public class Bread extends Actor
{
    int speed = 1;
    
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        //Bread falling
        setLocation(getX(), getY() + speed);
        
        /*Substract a life when bread falls to the floor, 
         * if no lives left draw game over.
         */
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
    
    public void increaseSpeed()
    {
        MyWorld world = (MyWorld) getWorld();        
         if(world.oldScore + 10 == world.score)
         {
             speed += 1;
         }
    }
}
