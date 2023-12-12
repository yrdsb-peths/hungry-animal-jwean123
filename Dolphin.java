import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Dolphin, a dolphin.
 * 
 * @author Juan 
 * @version December 2023
 */
public class Dolphin extends Actor
{
    GreenfootSound ate = new GreenfootSound("NomNomNom.mp3");
    
    GreenfootImage dolphinsRight[] = new GreenfootImage[5];
    GreenfootImage dolphinsLeft[] = new GreenfootImage[5];
    
    private boolean facingRight;
    SimpleTimer animationTimer = new SimpleTimer();
    
    /**
     * Constructor
     */
    public Dolphin()
    {
        for(int i = 0; i < dolphinsRight.length; i++)
        {
            dolphinsRight[i] = new GreenfootImage("images/dolphin_stuff/dolphinRight" + i + ".png");
            dolphinsRight[i].scale(80, 55);
        }
        
        for(int i = 0; i < dolphinsLeft.length; i++)
        {
            dolphinsLeft[i] = new GreenfootImage("images/dolphin_stuff/dolphinLeft" + i + ".png");
            dolphinsLeft[i].scale(80, 55);
        }
        
        animationTimer.mark();
        
        //Initial dolphin image
        setImage(dolphinsRight[0]);
        facingRight = true;
    }
    
    /**
     * Animate the dolphin
     */
    
    int imageIndex = 0;
    public void animateDolphin()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        
        if(facingRight)
        {
            setImage(dolphinsRight[imageIndex]);
            imageIndex = (imageIndex + 1) % dolphinsRight.length;
        }
        else
        {
            setImage(dolphinsLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % dolphinsLeft.length;    
        }
    }
    
    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        
        // Movement
        if(Greenfoot.isKeyDown("A"))
        {
            facingRight = false;
            move(-world.getSpeed());
        }
        else if(Greenfoot.isKeyDown("D"))
        {
            facingRight = true;
            move(world.getSpeed());
        }
        
        // Remove bread if dolphin eats it
        eat();
        
        // Animate the dolphin
        animateDolphin();
    }
    
    
    public void eat()
    {
        MyWorld world = (MyWorld) getWorld();
        if(isTouching(Bread.class))
        {
            ate.play();
            removeTouching(Bread.class);
            world.createBread();
            world.increaseScore();
        }
    }
}
