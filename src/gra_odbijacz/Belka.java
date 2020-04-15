/*

Cześć Szymon, programujesz

 */
package gra_odbijacz;

import gra_odbijacz.Gra_odbijacz.PanelAnimacji;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author Szymoon
 */
public class Belka 
{        
    //Belka belka = this;

public static Image BELKA = new ImageIcon("Belka.png").getImage();

int x =0;
int y;
int dx =15;

int xBelki = BELKA.getWidth(null);
int yBelki = BELKA.getHeight(null);

public int getX()
{
return x;
}

public int getY()
{
return y;
}

public int getXBelki()
{
return xBelki;
}

public int getYBelki()
{
return yBelki;
}
        


public void przypiszY(PanelAnimacji panel)
{
Rectangle układ = panel.getBounds();
this.y = (int)układ.getMaxY()-yBelki;
}

public void ruszBelkewPrawo(JPanel panel)
{
Rectangle układ = panel.getBounds();

x+=dx;
    //System.out.println(x+dx);
if(x + xBelki >= układ.getMaxX())
{
x = (int)układ.getMaxX() - xBelki;

}

}

public void ruszBelkeWLewo(JPanel panel)
{
Rectangle układ = panel.getBounds();    

x-=dx;

if(x< układ.getMinX())
{
x=0;
}
}
    
    
}
