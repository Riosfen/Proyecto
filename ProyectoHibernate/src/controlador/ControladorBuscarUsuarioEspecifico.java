package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import persistencia.HibernateUtil;
import vista.Ventana.VistaBuscarUsuarioEspec�fico;

public class ControladorBuscarUsuarioEspecifico implements ActionListener {

	public VistaBuscarUsuarioEspec�fico panelBuscarUsuario;
	
	public ControladorBuscarUsuarioEspecifico(VistaBuscarUsuarioEspec�fico panelBuscarUsuario) {
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
