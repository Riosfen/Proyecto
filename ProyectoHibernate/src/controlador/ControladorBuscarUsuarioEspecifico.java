package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import persistencia.HibernateUtil;
import vista.Ventana.VistaBuscarUsuarioEspecífico;

public class ControladorBuscarUsuarioEspecifico implements ActionListener {

	public VistaBuscarUsuarioEspecífico panelBuscarUsuario;
	
	public ControladorBuscarUsuarioEspecifico(VistaBuscarUsuarioEspecífico panelBuscarUsuario) {
		this.panelBuscarUsuario = panelBuscarUsuario;
        HibernateUtil.buildSessionFactory();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "cancelar":
			break;
		case "seleccionar":
			break;
		case "buscar":
			break;
		}
	}

}
