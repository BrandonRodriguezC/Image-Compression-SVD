package interfazApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import controlador.Controlador;

public class PanelResultado extends JPanel implements ActionListener
{
 // Atributos 		
	BufferedImage img = null;
	JLabel lblimage ;
	String path="src/images/imageUpdated.jpg";
 // Relaciones   
    
    /**
     * Constructor
     */    
    public PanelResultado() 
    {   	
    // ..............................................( T, L, B, R ).............................................
       setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "" ) ) );
       
       setLayout( null );			// Esquema de organizaciÛn libre
       try {
   	    img = ImageIO.read(new File(path));
   	    System.out.println("Image loaded");
   		} catch (IOException e) {
   		}
     
      
      lblimage = new JLabel(new ImageIcon(img));
              
    // Instancia atributos de la clase   

    // Agrega el listener a cada objeto en caso de ser necesario

    // Agrega los actionCommand						// objeto.setActionCommand("????");
      lblimage.setBounds(0, 0, img.getWidth(), img.getHeight());
    // Ubica los controles en el JPanel 			// setBounds(left, top, right, botton)	    
              
    // Agrega los controles al panel				// add( control );   
      add(lblimage);
    }
    public void setPath(String path) {
		this.path = path;
	}
  // Metodos de la interfaz ActionListener    
	public void actionPerformed(ActionEvent e) 
	{ if (e.getActionCommand().equals("????")) 
	  {	  			
	  }
	}
    
}