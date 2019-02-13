package controlador;

import interfazApp.PanelInfo;
import interfazApp.PanelMuestra;
import interfazApp.PanelResultado;
import mundo.*;

public class Controlador {

 PanelInfo pnlInfo;
 PanelMuestra pnlMuestra;
 PanelResultado pnlResultado;
 Runner logic;
 
 
 	public void conectar(PanelMuestra pnlMuestra,PanelResultado pnlResultado) {
		this.pnlMuestra=pnlMuestra;
		this.pnlResultado=pnlResultado;
	}
	

	public Controlador() {
		logic=new Runner();
	}

	public void run(String path) throws Exception {
		logic.run(path);
	}

}
