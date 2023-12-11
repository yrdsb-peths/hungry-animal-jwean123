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
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        mainLabel = new Label("Welcome to hungry dolphin!\n \n Press [E] to start!", 40);
        addObject(mainLabel, getWidth() / 2, (getHeight() / 2));
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
