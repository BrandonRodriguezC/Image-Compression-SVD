package interfazApp;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import controlador.Controlador;

//src/images/imagen0.jpg --- src/images/imagen4.jpg
//	src/images/img.jpg --- src/images/img6.jpg
public class Frame extends JFrame 
{
 // Atributos
PanelInfo pnlInfo;
PanelMuestra pnlMuestra;
PanelResultado pnlResultado;

 // Relaciones
	
	public Frame( Controlador ctrl )
	{ setTitle( "Image Compression" );  			// Titulo de la ventana
 	  getContentPane( ).setLayout( null );		// Esquema de organizaciÛn libre
 	  
  // Integar el controlador
 	  	 
  // Instancia los paneles    
  	pnlInfo= new PanelInfo(this,ctrl);
  	
  // Ubica los paneles en el JFrame 			// setBounds(left, top, right, botton)	 
  	pnlInfo.setBounds(15, 10, 360, 50);
  	
  // Organizar el panel principal. 				// getContentPane( ).add( panel );
    getContentPane( ).add( pnlInfo );
  // Conecta objetos a controlar   
     ctrl.conectar(pnlMuestra,pnlResultado );
 
  // Configuracion del JFrame   
     setSize( pnlInfo.getWidth()+30, pnlInfo.getHeight()+40); 									// Dimensiones del JFrame      
     setResizable( true );									// Se evita redimensionar el JFrame
     setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );		// Se activa el botÛn de cerrado de la ventana
 	        
	}
	
	
	public void showImages(BufferedImage img) {
		setSize( (img.getWidth()*2)+30, pnlInfo.getHeight()+img.getHeight()+40); 	

	  	pnlMuestra= new PanelMuestra(img);
	  	pnlResultado= new PanelResultado();
	  	
		pnlMuestra.setBounds(10, 60, img.getWidth(), img.getHeight());
	  	pnlResultado.setBounds(img.getWidth()+10, 60, img.getWidth(), img.getHeight());

	    getContentPane( ).add( pnlMuestra );
	    getContentPane( ).add( pnlResultado );
	    
	}

	public static void main(String[] args) 
	{ Frame frmMain = new Frame (new Controlador()  );
	  frmMain.setVisible(true);	
	}

}
