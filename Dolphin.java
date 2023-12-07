import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Dolphin, a dolphin.
 * 
 * @author Juan 
 * @version November 2023
 */
public class Dolphin extends Actor
{
    int speed = 2;
    int score = 0;
    int oldScore = score;
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
        
        //Makes sure speed will increase over time
        increaseSpeed();
    }
    
    public void increaseSpeed()
    {
        if(oldScore + 5 == score)
        {
            speed++;
            oldScore = score;
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
            score++;
        }
    }
}
