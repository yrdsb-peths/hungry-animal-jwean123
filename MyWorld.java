import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Juan 
 * @version December 2023
 */
public class MyWorld extends World
{
    private int score = 0;
    private int oldScore = score;
    Label scoreLabel;
    
    private int speed = 2;
    Label speedLabel;
    
    private int lives = 3;
    Label livesLabel;
    
    Dolphin dolphin;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        //Create the dolphin object
        dolphin = new Dolphin();
        addObject(dolphin, 200, 370);
        
        //Create the labels
        scoreLabel = new Label("score: " + score, 30);
        addObject(scoreLabel, 50, 40);
        
        livesLabel = new Label("lives: " + lives, 30);
        addObject(livesLabel, 540, 40);
        
        speedLabel = new Label("speed: " + speed, 30);
        addObject(speedLabel, 50, 90);
        
        //Create the bread object
        createBread();
        
        
    }
    
    public void act()
    {
        increaseSpeed();
    }
    
    public int getScore()
    {
        return score;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public int getLives()
    {
        return lives;
    }
    
    /**
     * Create a new bread at the top of the screen with a random X position
     */
    public void createBread()
    {
        Bread bread = new Bread();
        int x;
        if(dolphin.getX() > 300)
        {
            x = dolphin.getX() - Greenfoot.getRandomNumber(300);
        }
        else
        {
            x = dolphin.getX() + Greenfoot.getRandomNumber(300);
        }
        int y = -16;
        addObject(bread, x, y);
    }
    
    /**
     * Increase the score by 1 when an apple is picked up
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue("score: " + score);
    }
    
    /**
     * Substract lives by 1 when apple reaches the bottom
     */
    
    public void substractLives()
    {
        lives--;
        livesLabel.setValue("lives: " + lives);
    }
    
    /**
     * Increase speed number by 1 whenever the score increases by 5
     */
    
    public void increaseSpeed()
    {
        if(oldScore + 5 == score)
        {
            oldScore = score;
            speed += 1;
            speedLabel.setValue("speed: " + speed);
        }
    }
    
    /**
     * Draw game over when the game is over
     */
    public void gameOver()
    {
        Label gameOver = new Label("Game over", 100);
        addObject(gameOver, 300, 200);
    }
}
