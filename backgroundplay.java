import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class backgroundplay extends World
{

    private Bola Bola = new Bola();
    private Tali Tali = new Tali();

    private int centerx=0,centery=0;
    private double agl=0,aglo=0,panjang=0;
    private GreenfootSound backSound;

    public backgroundplay()
    {
        super(400, 700, 1);

        addObject(Tali,0,0);
        addObject(Bola,(int)(0.5*getWidth()),(int)(0.75*getHeight()));

        centerx=(int)(0.5*getWidth());
        centery=(int)(0.25*getHeight());

        prepareSudut();
        UpdateTali();
        
        backSound = new GreenfootSound("Patakas sound.mp3");
        backSound.playLoop();

    }

    public void UpdateTali(){
        double rx=centerx-Bola.getX();
        double ry=centery-Bola.getY();
        double r=Math.sqrt(rx*ry+ry*ry);

        if(r<1)r=1;

        GreenfootImage image=new GreenfootImage((int)r,10);
        image.drawLine(0,5,image.getWidth()-1,5);
        Tali.setImage(image);

        Tali.setLocation((int)Math.round(0.5*(centerx+Bola.getX())),(int)Math.round(0.5*(centery+Bola.getY())));
        Tali.setRotation((int)Math.round(Math.atan2(ry,rx)*180/Math.PI));

    }

    public void prepareSudut(){
        double rx=centerx-Bola.getX();
        double ry=centery-Bola.getY();
        panjang=Math.sqrt(rx*rx+ry*ry);

        agl=Math.atan2(ry,rx)+0.5*Math.PI;
        aglo=agl;
    }

    public void act(){
        if(!Bola.drag){
            double g=1;
            double dt=0.1;

            double agln=2*agl-aglo+g*Math.cos(agl+0.5*Math.PI)*dt*dt;
            int posisix=(int)Math.round(centerx+panjang*Math.cos(agln+0.5*Math.PI)); 
            int posisiy=(int)Math.round(centery+panjang*Math.sin(agln+0.5*Math.PI)); 
            Bola.setLocation(posisix,posisiy);
            UpdateTali();

            aglo=agl;
            agl=agln;

        }
    }
        
}
