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
}


public void odbiciePiłkiodKwadratuPoY()
{
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

    if(y + yKropelki == układ.getMaxY()- belka.yBelki)
    {
        // Nadawanie piłce prędkości
          if((x+xKropelki)>= belka.x && x<= (belka.xBelki/4)+belka.x)  
          {
            Gra_odbijacz.PREDKOSC=10;    
            dy = -2*dy;
          }


          else if(x+xKropelki >= ((belka.xBelki/4)+belka.x) && x<= ((belka.xBelki/2)+belka.x))
          {
            Gra_odbijacz.PREDKOSC=10;
            dy = -2*dy;  
          }

          else if((x+xKropelki)>= (((belka.xBelki)/2)+belka.x)&& x<= (((belka.xBelki/4)*3)+belka.x))
          {
            Gra_odbijacz.PREDKOSC=10;
            dy = -2*dy;
          }

          else if((x+xKropelki)>= (((belka.xBelki/4)*3)+belka.x) && x<= (belka.x+ belka.xBelki))
          {
            Gra_odbijacz.PREDKOSC=10;    
            dy= -2*dy;
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
