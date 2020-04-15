/*

Cześć Szymon, programujesz

 */
package gra_odbijacz;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Szymoon
 */
public class Piłka {
    
    
public static Image PIŁKA = new ImageIcon("piksel.png").getImage();

int x;
int y; 
double dx =1;
double dy =1;
int xKropelki = PIŁKA.getWidth(null);
int yKropelki = PIŁKA.getHeight(null);

public void przypiszPozycjePiłki(ArrayList listaBelek, Piłka piłka)
{
    piłka.y = ((((Belka)listaBelek.get(listaBelek.size()-1)).y - piłka.yKropelki) -1);
    piłka.x = ((((Belka)listaBelek.get(listaBelek.size()-1)).x +(((Belka)listaBelek.get(listaBelek.size()-1)).xBelki)/2)); 
 
    //System.out.println("Y Piłki "+" :"+piłka.y);11
    //System.out.println("X Piłki "+" :"+piłka.x);
}


public void odbiciePiłkiodKwadratuPoY()
{
//dx = -dx;
//dy=-1;
dy = -dy;
}

public void odbiciePiłkiodKwadartuPoX()
{

dx= -dx;
}

public void odbijaniePiłki(JPanel panel, Belka belka, ArrayList lista)
{
Rectangle układ = panel.getBounds();


x +=dx;
y +=dy;

// System.out.println("x + xKropelki" + (x + xKropelki) );
//    System.out.println("xBelki x2"+ ": "+(belka.x+ belka.xBelki)  );
if(y + yKropelki == układ.getMaxY()- belka.yBelki)
{
//    if(x  <= (belka.x+ belka.xBelki) && (x + xKropelki) >= (belka.x)) //&& (y - yKropelki) <= (układ.getMaxY() - belka.yBelki) )
//    {
//    dy = -dy;
//    dx =-dx;
//    System.out.println("działa ");
//    }
    
    //if((x+xKropelki)>= belka.x && x <= ((((belka.x + belka.xBelki)-belka.x)/4)))
      if((x+xKropelki)>= belka.x && x<= (belka.xBelki/4)+belka.x)  
    {
    //dy=2;
    Gra_odbijacz.PREDKOSC=10;    
    dy = -2*dy;
    //dx = -dx;
        System.out.println("1"+ dy);
    }
    
   // else if(x+xKropelki>= ((((belka.x + belka.xBelki)-belka.x)/4)*3) && x <= (((belka.x + belka.xBelki)-belka.x)/2))
      else if(x+xKropelki >= ((belka.xBelki/4)+belka.x) && x<= ((belka.xBelki/2)+belka.x))
   {
        //dy= 1.5;
        Gra_odbijacz.PREDKOSC=10;
        dy = -2*dy;
       System.out.println("2"+ dy);
    }
    
    //else if(x+xKropelki>= (((belka.x + belka.xBelki)-belka.x)/2) && x<= ((((belka.x + belka.xBelki)-belka.x)/4)*3))
      else if((x+xKropelki)>= (((belka.xBelki)/2)+belka.x)&& x<= (((belka.xBelki/4)*3)+belka.x))
    {
    //dy =1.5;
    Gra_odbijacz.PREDKOSC=10;
    dy = -2*dy;
        System.out.println("3"+ dy);
    }
    
   // else if(x+xKropelki>=((((belka.x + belka.xBelki)-belka.x)/4)*3) && x<= (belka.x +belka.xBelki) )
      else if((x+xKropelki)>= (((belka.xBelki/4)*3)+belka.x) && x<= (belka.x+ belka.xBelki))
    {
    //dy=1;
    Gra_odbijacz.PREDKOSC=10;    
    dy= -2*dy;
   // dx= -dx;
        System.out.println("4"+ dy);
    }
}
else if(x + xKropelki >= układ.getMaxX())
{
dx = -dx;
}
else if(y < układ.getMinY())
{
dy = -dy;
}
else if(x < układ.getMinX())
{
dx = -dx;
}
}


}
