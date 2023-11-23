import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Juan 
 * @version November 2023
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Dolphin dolphin = new Dolphin();
        
        addObject(dolphin, 200, 300);
        createBread();
    }
    
    public void createBread()
    {
        // Create a new bread at the top of the screen with a random X position
        
        Bread bread = new Bread();
        int x = Greenfoot.getRandomNumber(600);
        int y = 50;
        addObject(bread, x, y);
    }
}
