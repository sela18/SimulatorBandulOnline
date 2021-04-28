import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bola here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bola extends Actor
{
    public boolean drag=false;
    private int rx,ry=0;
    
    public void act() 
    {
        if(Greenfoot.mouseDragged(this)){
            MouseInfo mouse=Greenfoot.getMouseInfo();
            if(!drag){
                drag=true;
                rx=getX()-mouse.getX();
                rx=getY()-mouse.getY();
                
            }else{
                setLocation(mouse.getX()+rx,mouse.getY()+ry);
                ((backgroundplay)getWorld()).UpdateTali();
            }
        }
        if(Greenfoot.mouseDragEnded(this)){
            drag=false;
            ((backgroundplay)getWorld()).prepareSudut();
        }
        
           
        
    }    
}
