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

public class PanelInfo extends JPanel implements ActionListener
{
 // Atributos 		
    JTextField ruta;
    JButton ejecutar;
    Frame frame;
    Controlador ctrl;

	BufferedImage img = null;
    int largo=360;
 // Relaciones   
    
    public void setLargo(int largo) {
		this.largo = largo;
	}

	/**
     * Constructor
     */    
    public PanelInfo(Frame frame, Controlador ctrl) 
    {   	
    // ..............................................( T, L, B, R ).............................................
       setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( " Information " ) ) );
       
       setLayout( null );			// Esquema de organizaciÛn libre
       this.ctrl=ctrl;
       this.frame=frame;
       
    // Instancia atributos de la clase  
       ruta = new JTextField();
       ejecutar= new JButton("Run");
       
    // Agrega el listener a cada objeto en caso de ser necesario
       ejecutar.addActionListener(this);
    // Agrega los actionCommand						// objeto.setActionCommand("????");
       ejecutar.setActionCommand("ejecutar");
    // Ubica los controles en el JPanel 			// setBounds(left, top, right, botton)	    
       ruta.setBounds(10,15,largo*2/3,30); 
       ejecutar.setBounds(largo*2/3+5, 15, largo*1/3-5,30);
    // Agrega los controles al panel				// add( control );   
       add(ruta);add(ejecutar);
    }

  // Metodos de la interfaz ActionListener    
	public void actionPerformed(ActionEvent e) 
	{ if (e.getActionCommand().equals("ejecutar")) 
	  {	  if (ruta.getText().equals("")) {
		  System.out.println("error");
	  		}else {
	  			System.out.println("go on");
	  	
	  			try {
					ctrl.run(ruta.getText());
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
	  			
	  			try {
	  	    	    img = ImageIO.read(new File(ruta.getText()));
	  	    	    System.out.println("Image loaded----");
	  	    	} catch (IOException e3) {
	  	    	}
	  			frame.showImages(img);
	  			
	  		}
	  }
	}
    
}