/*

Cześć Szymon, programujesz

 */
package gra_odbijacz;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;


public class Kwadracik extends JComponent
{
public static Image KWADRAT = new ImageIcon("KwadratDoZbicia.png").getImage();
public static int ZETKA_X = 0;
public static int ZETKA_Y = 0;

int x =0;
int y =0;

//static int z =0;
int odstępX=3;
int odstępY=10;
int xKwadratu =KWADRAT.getWidth(null);
int yKwadratu =KWADRAT.getHeight(null);
int dx = xKwadratu + odstępX;
int dy = yKwadratu + odstępY ;
String name;

public void ustawKwadraty(Kwadracik  kwadrat, JPanel panel)
{
Rectangle układ = panel.getBounds();
//kwadrat.y=5; 
kwadrat.y = Kwadracik.ZETKA_Y;
Kwadracik.ZETKA_X = (kwadrat.x + dx) + Kwadracik.ZETKA_X;
kwadrat.x += Kwadracik.ZETKA_X;

if(kwadrat.x >= układ.getMaxX() - 50)
{
kwadrat.x =0;
Kwadracik.ZETKA_X =0;
kwadrat.y += dy;
Kwadracik.ZETKA_Y = kwadrat.y;


//    System.out.println("Y kwadratu:"+": "+kwadrat.y);
//    System.out.println("X kwaratu" +":"+ kwadrat.x);

Kwadracik.ZETKA_X = (kwadrat.x + dx) + Kwadracik.ZETKA_X;
kwadrat.x += Kwadracik.ZETKA_X;
//    System.out.println("Maksymalny X"+": "+układ.getMaxX());
//    System.out.println("Z instrukcji jeśli "+ kwadrat.x);
//    System.out.println("wywołano metodę wiekszą od x >");
}
}
public void ustawKwadraty2 (ArrayList listaKwadartów, JPanel panel)
{
Rectangle układ = panel.getBounds();
for(int i =0; i< listaKwadartów.size();i++)
{    

//kwadrat.y=5; 
((Kwadracik)listaKwadartów.get(i)).y = Kwadracik.ZETKA_Y;
Kwadracik.ZETKA_X = (((Kwadracik)listaKwadartów.get(i)).x + dx) + Kwadracik.ZETKA_X;
((Kwadracik)listaKwadartów.get(i)).x += Kwadracik.ZETKA_X;

if(((Kwadracik)listaKwadartów.get(i)).x >= układ.getMaxX() - 50)
{
((Kwadracik)listaKwadartów.get(i)).x =0;
Kwadracik.ZETKA_X =0;
((Kwadracik)listaKwadartów.get(i)).y += dy;
Kwadracik.ZETKA_Y = ((Kwadracik)listaKwadartów.get(i)).y;


//    System.out.println("Y kwadratu:"+": "+kwadrat.y);
//    System.out.println("X kwaratu" +":"+ kwadrat.x);

Kwadracik.ZETKA_X = (((Kwadracik)listaKwadartów.get(i)).x + dx) + Kwadracik.ZETKA_X;
((Kwadracik)listaKwadartów.get(i)).x += Kwadracik.ZETKA_X;
}
//    System.out.println("Maksymalny X"+": "+układ.getMaxX());
//    System.out.println("Z instrukcji jeśli "+ kwadrat.x);
//    System.out.println("wywołano metodę wiekszą od x >");
}



//System.out.println("Iksik" + Kwadracik.ZETKA);
//System.out.println("Kwadrat metoda" +": "+ kwadrat.toString());
//System.out.println("Kwadrat wartośc" +": "+ kwadrat.x);



}

public void ustawKwadraty3(Kwadracik  kwadrat, JPanel panel)
{
Rectangle układ = panel.getBounds();
//kwadrat.y=5; 
kwadrat.y = Kwadracik.ZETKA_Y;
Kwadracik.ZETKA_X = (kwadrat.x + dx) + Kwadracik.ZETKA_X;
kwadrat.x += Kwadracik.ZETKA_X;

if(kwadrat.x >= układ.getMaxX() - 50)
{
kwadrat.x =0;
Kwadracik.ZETKA_X =0;
kwadrat.y += dy;
Kwadracik.ZETKA_Y = kwadrat.y;


//    System.out.println("Y kwadratu:"+": "+kwadrat.y);
//    System.out.println("X kwaratu" +":"+ kwadrat.x);

Kwadracik.ZETKA_X = (kwadrat.x + dx) + Kwadracik.ZETKA_X;
kwadrat.x += Kwadracik.ZETKA_X;
//    System.out.println("Maksymalny X"+": "+układ.getMaxX());
//    System.out.println("Z instrukcji jeśli "+ kwadrat.x);
//    System.out.println("wywołano metodę wiekszą od x >");
}
}



    
    public String toString () 
    {  
    return name;
    }

    public int returnX()
    {
    return x;
    }
    
    public int powiększX()
    {
    x+=20;
    return x;
    }
        
}
