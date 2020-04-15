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
         Gra_odbijacz.WYNIK ++;
         ((Piłka)listaPiłek.get(j)).odbiciePiłkiodKwadratuPoY();
         listaKwadratów.remove(listaKwadratów.get(i));
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

    }
    
    public void addBelka()
    {
     
    listaBelek.add(belkaa);
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
 
    watekKwadratów = new Thread(new KwadratRunnable(kwadraciki));
    watekKwadratów.start();
    repaint();
    }
        
    public void paintComponent(Graphics g)
    {
    super.paintComponent(g);
    
            
        for(int i =0; i <listaPiłek.size(); i++)
            {
              g.drawImage(Piłka.PIŁKA, ((Piłka)listaPiłek.get(i)).x, ((Piłka)listaPiłek.get(i)).y, null);
            }
        for(int a =0; a< listaBelek.size(); a++)
            {
            g.drawImage(Belka.BELKA,((Belka)listaBelek.get(a)).x,((Belka)listaBelek.get(a)).y, null);
            }
        for(int z =0; z< listaKwadratów.size();z++)
            {
            g.drawImage(Kwadracik.KWADRAT, ((Kwadracik)listaKwadratów.get(z)).x, ((Kwadracik)listaKwadratów.get(z)).y, null);
            }
             
            
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

                piłka.odbijaniePiłki(ten, (Belka)listaBelek.get(listaBelek.size()-1), listaPiłek);
                repaint();
                czyPiłkaSięSpotkałaZKwadratem();
                repaint();
           
                try
                {
                Thread.sleep(Gra_odbijacz.PREDKOSC);
                }
                catch (InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
              
                    
                }
                
                
                if((piłka.y)> (wymiary.getMaxY()+20))
                {
                
                watekPiłki.interrupt();
                
               
                
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
                        ((Kwadracik)listaKwadratów.get(i)).ustawKwadraty3((Kwadracik)listaKwadratów.get(i), ten);
                repaint();
                    }
                
                System.out.println("siemasssssssssssssssssssssss");
               
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
    
    

