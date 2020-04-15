/*

Cześć Szymon, programujesz

 */
package gra_odbijacz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class Gra_odbijacz extends JFrame {
    
 Kwadracik [] kwadraciki = new Kwadracik[200];
 public static int PREDKOSC = 5;
    public Gra_odbijacz() throws HeadlessException 
    {
        
        this.setBounds(500, 500, 500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        for(int i= 0; i<kwadraciki.length;i++)
//        {
//        kwadraciki[i] = new Kwadracik("Kwadrat Nr");
//        animacja.add(kwadraciki[i]);
//        }
        
        this.getContentPane().add(panel_Przycisków, BorderLayout.SOUTH);
        this.getContentPane().add(animacja);
        
        panel_Przycisków.add(start_btn);
        panel_Przycisków.add(stop_btn);
        panel_Przycisków.add(dodajKulke_btn);
        animacja.setBackground(Color.gray);
       
        stop_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
        stopAnimacji();
            }
        });
        
        start_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
        startAnimation();
        
            }
        });
       dodajKulke_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            dodajKulke();
            start_btn.requestFocus();
            }
        });
       
       
      
       
       //wynik.setSize(500, 300);
       
//       wynik.setText("Wynik: " + Gra_odbijacz.WYNIK);
//       
//       animacja.add(wynik);
//       repaint();
    }
    
    public void dodajKulke()
    {
    animacja.addPiłka();
    
    }
    
    public void startAnimation()
    {
        
    animacja.addWynik();    
    animacja.addBelka();
    animacja.addKwadraty();
    }
    
    
    public void stopAnimacji()
    {
    stop_btn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
     watekPiłki.interrupt();
        }
    });
    }
    
    JButton start_btn = new JButton("start");
    JButton stop_btn = new JButton("stop");
    JButton dodajKulke_btn = new JButton("Dodaj Kulke");
    JPanel panel_Przycisków = new JPanel();
    PanelAnimacji animacja = new PanelAnimacji();
    JLabel wynik = new JLabel();
    public static int WYNIK = 0;
    Rectangle wymiary;
    public static void main(String[] args) {
        new Gra_odbijacz().setVisible(true);
    }
    Thread watekBelki;
    Thread watekPiłki;
    Thread watekKwadratów;
    Thread watekWyniku;
    
    class PanelAnimacji extends JPanel
    {
    Belka belkaa = new Belka(); 
   
    PanelAnimacji ten = this;
 
    public void addPiłka()  
    {
    listaPiłek.add(new Piłka());
    ((Piłka)listaPiłek.get(listaPiłek.size()-1)).przypiszPozycjePiłki(listaBelek,((Piłka)listaPiłek.get(listaPiłek.size()-1)));
    
    watekPiłki = new Thread(new PiłkaRunnable((Piłka)listaPiłek.get(listaPiłek.size()-1)));
    watekPiłki.start();
     wymiary = animacja.getBounds();
    repaint();
    }
    
    public void addWynik()
    {
    animacja.add(wynik);
    
    watekWyniku = new Thread(new WynikRunnable());
    watekWyniku.start();
    repaint();
    }
    
    public void czyPiłkaSięSpotkałaZKwadratem()
    {
     
    for(int j = 0; j < listaPiłek.size();j++)
    {    
        for(int i=0; i < listaKwadratów.size() ; i++)   
         {
          
         if( ((Piłka)listaPiłek.get(j)).y == (((Kwadracik)listaKwadratów.get(i)).y + ((Kwadracik)listaKwadratów.get(i)).yKwadratu) && (((Piłka)listaPiłek.get(j)).x + ((Piłka)listaPiłek.get(j)).xKropelki) >= ((Kwadracik)listaKwadratów.get(i)).x && ((Piłka)listaPiłek.get(j)).x <= (((Kwadracik)listaKwadratów.get(i)).x + ((Kwadracik)listaKwadratów.get(i)).xKwadratu)) 
         {
             //System.out.println("dotknęlam górnej dolnej cześci");011
         Gra_odbijacz.WYNIK ++;
         ((Piłka)listaPiłek.get(j)).odbiciePiłkiodKwadratuPoY();
         listaKwadratów.remove(listaKwadratów.get(i));
         
         System.out.println("Długość listy kwadratów "+": "+listaKwadratów.size());
        System.out.println("Pozyccja kwadratu zbijanego"+": "+i);
             System.out.println("Instrukcja 1");
             //System.out.println("Piłka dotknęła kwadraiciku" + " "+ "Kwadracik y-yKwadaru wynik "+": "+(kwadraciki[i].y - kwadraciki[i].yKwadratu) + " "+ " Y Piłki" +": "+ ((Piłka)listaPiłek.get(0)).y);
             //System.out.println("Piłka dotknęła kwadraiciku" + " "+ "Kwadracik x "+": "+(kwadraciki[i].x) + " "+ " x Piłki" +": "+ (((Piłka)listaPiłek.get(0)).x + ((Piłka)listaPiłek.get(0)).xKropelki));
           //  System.out.println("Długość listy kwadratów "+": "+listaKwadratów.size());
         }
         
         else if((((Piłka)listaPiłek.get(j)).y+ ((Piłka)listaPiłek.get(j)).yKropelki) == ((Kwadracik)listaKwadratów.get(i)).y && (((Piłka)listaPiłek.get(j)).x + ((Piłka)listaPiłek.get(j)).xKropelki) >= ((Kwadracik)listaKwadratów.get(i)).x && ((Piłka)listaPiłek.get(j)).x <= (((Kwadracik)listaKwadratów.get(i)).x + ((Kwadracik)listaKwadratów.get(i)).xKwadratu))
         {
          Gra_odbijacz.WYNIK ++;    
         ((Piłka)listaPiłek.get(j)).odbiciePiłkiodKwadratuPoY();
         listaKwadratów.remove(listaKwadratów.get(i));   
        
         System.out.println("Długość listy kwadratów "+": "+listaKwadratów.size());
         System.out.println("Pozyccja kwadratu zbijanego"+": "+i);
             System.out.println("Instrukcja 2");
         }
          
         else if((((Piłka)listaPiłek.get(j)).x+ ((Piłka)listaPiłek.get(j)).xKropelki)== ((Kwadracik)listaKwadratów.get(i)).x && ((Piłka)listaPiłek.get(j)).y <= (((Kwadracik)listaKwadratów.get(i)).y+ ((Kwadracik)listaKwadratów.get(i)).yKwadratu) && (((Piłka)listaPiłek.get(j)).y +((Piłka)listaPiłek.get(j)).yKropelki)>= ((Kwadracik)listaKwadratów.get(i)).y  )
          {
        Gra_odbijacz.WYNIK ++; 
        ((Piłka)listaPiłek.get(j)).odbiciePiłkiodKwadartuPoX();
         listaKwadratów.remove(listaKwadratów.get(i));  
         
         System.out.println("Długość listy kwadratów "+": "+listaKwadratów.size());
         System.out.println("Pozyccja kwadratu zbijanego"+": "+i);
              System.out.println("Instrukcja 3");
          }
          
         else if((((Kwadracik)listaKwadratów.get(i)).x + ((Kwadracik)listaKwadratów.get(i)).xKwadratu)== (((Piłka)listaPiłek.get(j)).x)  && ((Piłka)listaPiłek.get(j)).y <= (((Kwadracik)listaKwadratów.get(i)).y+ ((Kwadracik)listaKwadratów.get(i)).yKwadratu) && (((Piłka)listaPiłek.get(j)).y +((Piłka)listaPiłek.get(j)).yKropelki)>= ((Kwadracik)listaKwadratów.get(i)).y )
          {
           Gra_odbijacz.WYNIK ++;    
          ((Piłka)listaPiłek.get(j)).odbiciePiłkiodKwadartuPoX();
         listaKwadratów.remove(listaKwadratów.get(i));  
        
         System.out.println("Długość listy kwadratów "+": "+listaKwadratów.size());
         System.out.println("Pozyccja kwadratu zbijanego"+": "+i);
              System.out.println("Instrukcja 4");
          }
         }
    }
    
        //System.out.println("Wynik:" + Gra_odbijacz.WYNIK);
     
    }
    
    public void addBelka()
    {
     
    listaBelek.add(belkaa);
    //System.out.println("Długość belek: "+listaBelek.size());
    ((Belka)listaBelek.get(0)).przypiszY(ten);
    watekBelki = new Thread(new BelkaRunnable((Belka)listaBelek.get(listaBelek.size()-1)));
    watekBelki.start();
    
    repaint();
    }
    
    public void addKwadraty()
    {
    
    for(int i= 0; i<kwadraciki.length;i++)
    {
    kwadraciki[i] = new Kwadracik();
    listaKwadratów.add(kwadraciki[i]);
    }
    //System.out.println(listaKwadratów.size());
    watekKwadratów = new Thread(new KwadratRunnable(kwadraciki));
    watekKwadratów.start();
    repaint();
    }
        
    public void paintComponent(Graphics g)
    {
    super.paintComponent(g);
    
            
        for(int i =0; i <listaPiłek.size(); i++)
            {
            //g.drawImage(Piłka.PIŁKA, ((Piłka)listaPiłek.get(i)).x, ((Piłka)listaPiłek.get(i)).y, null);
              g.drawImage(Piłka.PIŁKA, ((Piłka)listaPiłek.get(i)).x, ((Piłka)listaPiłek.get(i)).y, null);
            // g.drawImage(Piłka.PIŁKA,(((Belka)listaBelek.get(i)).getX()+((Belka)listaBelek.get(i)).getXBelki())/2,(((Belka)listaBelek.get(i)).getY()-((Belka)listaBelek.get(i)).getYBelki()) , null);
             //  System.out.println( "Y piłki" +((Piłka)listaPiłek.get(i)).y);
            }
        for(int a =0; a< listaBelek.size(); a++)
            {
            g.drawImage(Belka.BELKA,((Belka)listaBelek.get(a)).x,((Belka)listaBelek.get(a)).y, null);
                //System.out.println("Wymalowałem Belke");
                //System.out.println("Y Belki" + ": "+ ((Belka)listaBelek.get(a)).y);
                //System.out.println("X Belki" + ": "+ ((Belka)listaBelek.get(a)).x);
            }
        for(int z =0; z< listaKwadratów.size();z++)
            {
            g.drawImage(Kwadracik.KWADRAT, ((Kwadracik)listaKwadratów.get(z)).x, ((Kwadracik)listaKwadratów.get(z)).y, null);
              //   System.out.println("Długość listy kwadratów z metoda Paint "+": "+listaKwadratów.size());
                  
               // System.out.println("Wymalowałem kwadart nr:" +((Kwadracik)listaKwadratów.get(z)) +" "+ "O wymiarach:" +((Kwadracik)listaKwadratów.get(z)).x );
            }
              //System.out.println("Kiedy zostałem wywołany");
            
    }
    ArrayList listaKwadratów = new ArrayList();
    ArrayList listaPiłek = new ArrayList();
    ArrayList listaBelek = new ArrayList();
    JOptionPane dialog = new JOptionPane();
    
    class BelkaRunnable implements Runnable
    {
        
        Belka belka;
        
            public BelkaRunnable(Belka belka) 
            {
            this.belka = belka;
            }
       
            @Override
            public void run() 
            {
              
              start_btn.addKeyListener(new KeyAdapter() {
              public void keyPressed(KeyEvent ke) {
                  
                    if(KeyEvent.VK_RIGHT == ke.getKeyCode())
                    {
                        ((Belka)listaBelek.get(0)).ruszBelkewPrawo(ten);
                        repaint();
                    }
                    else if(KeyEvent.VK_LEFT == ke.getKeyCode())
                    {
                    ((Belka)listaBelek.get(0)).ruszBelkeWLewo(ten);
                    repaint();
                    }
                        }
                   });
    
            }
    
    }
    
    class PiłkaRunnable implements Runnable
    {

        Piłka piłka;
        
            public PiłkaRunnable(Piłka piłka)
            {
            this.piłka = piłka;
            }
        
        
            @Override
            public void run() 
            {
                while(!Thread.currentThread().isInterrupted())
                {
                 //System.out.println("Początek lini w meotdzie Piłka"); 
                
                piłka.odbijaniePiłki(ten, (Belka)listaBelek.get(listaBelek.size()-1), listaPiłek);
                repaint();
                czyPiłkaSięSpotkałaZKwadratem();
                repaint();
                //System.out.println("Koniec lini w meotdzie Piłka");
                try
                {
                Thread.sleep(Gra_odbijacz.PREDKOSC);
                }
                catch (InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                    //Thread.interrupted();
                    
                }
                
                
                if((piłka.y)> (wymiary.getMaxY()+20))
                {
                
                watekPiłki.interrupt();
                
                //dialog.setVisible(true);
                
                wiadomoscZamknięcia();
                
                    System.out.println("maksymalny y " + wymiary.getMaxY());
                    System.out.println("Game OVER");
                    
                }
                }
                
                
            }
    }
    
    public void wiadomoscZamknięcia()
    {
    JOptionPane.showMessageDialog(ten, "Przegrałeś frajerze w taką prostą grę, żal mi Cię chociaż nie wcale nie");
    }
    
    class KwadratRunnable implements Runnable
    {

        Kwadracik[] kwadrat;
            public KwadratRunnable(Kwadracik [] kwadrat)
            {
            this.kwadrat = kwadrat;  
            }

        
            @Override
            public void run()
            {
            
                for(int i =0; i <kwadraciki.length; i++)
                    {
//                        System.out.println("Pętla górna tabela");
                     //kwadrat[i].ustawKwadraty(kwadrat[i], ten);
                     
                        //(Kwadracik)listaKwadratów.get(i)).ustawKwadraty(kwadrat[i], ten);
                        
                        ((Kwadracik)listaKwadratów.get(i)).ustawKwadraty3((Kwadracik)listaKwadratów.get(i), ten);
//                     System.out.println(kwadrat[i].toString());
//                     System.out.println("Pętla dolna tabela");
                repaint();
                    }
                
                System.out.println("siemasssssssssssssssssssssss");
                
//                kwadrat[0].x = 10;
//                kwadrat[1].x = 55;
//                kwadrat[2].x = 100;
//                kwadrat[3].x = 145;
//                kwadrat[4].x = 190;
                
                   
            } 
            
    }
    
    class WynikRunnable implements Runnable
    {
        
        
         @Override
         public void run()
         {
         while(!Thread.currentThread().isInterrupted() )    
         wynik.setText("Wynik: "+ Gra_odbijacz.WYNIK);
         
         
         }
    
    }
    
       }

    
     
        
    }
    
    

