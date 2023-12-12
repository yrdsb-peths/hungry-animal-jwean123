import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author Juan
 * @version December 2023
 */
public class TitleScreen extends World
{
    Label mainLabel;
    Label rulesLabel;
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        mainLabel = new Label("Welcome to hungry dolphin!\n Press [E] to start and \n [F] to end game", 40);
        addObject(mainLabel, getWidth() / 2, (getHeight() / 2) - 30);
        
        rulesLabel = new Label("speed increases by 1 for every 5 score \n you have 3 lives", 25);
        addObject(rulesLabel, getWidth() / 2, (getHeight() / 2) + 100);
    }
    
    public void act()
    {
        MyWorld world = new MyWorld();
        if(Greenfoot.isKeyDown("E"))
        {
            Greenfoot.setWorld(world);
        }
    }
}
