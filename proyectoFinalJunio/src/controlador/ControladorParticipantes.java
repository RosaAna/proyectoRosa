package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import modelo.Filechoossee;
import modelo.UserLoginDTO;
import modeloDAO.UserLoginDAO;
import vista.PanelParticipantes;
import vista.VistaLogin;


public class ControladorParticipantes implements ActionListener  {
private VistaLogin vista;
private PanelParticipantes vistap;
private UserLoginDAO userLoginDAO;
private List<UserLoginDTO> listaUsuarios;
private static int contador1 = 0;




public ControladorParticipantes(VistaLogin vista, PanelParticipantes vistap, UserLoginDAO userLoginDAO) {
	this.vista=vista;
	this.vistap = vistap;
	this.userLoginDAO = userLoginDAO;
	actionListener(this);
	listaUsuarios = userLoginDAO.getListaUserLogin();
	mostrarUsuario(0);
}


public void actionPerformed(ActionEvent e) {
    if (e.getSource().getClass() == JMenuItem.class) {
	       JMenuItem menuItem = (JMenuItem) e.getSource();
	        if (vista.getMntmParticipantes().getText().equals("Participantes")) {
	    	UserLoginDAO u1=new UserLoginDAO();
	        Filechoossee fe=new Filechoossee();
	        u1. addListaUsuarios(u1.readListUserDesdeJson(fe.darRuta(   )));
	        
	        }else if (vista.getMntmSobreNosotros().getText().equals("Sobre Nosotros")) {
		    desplegarInformacion();
            }
		
      }
	
       if (e.getSource().getClass() == JButton.class) {
   
	      if (e.getActionCommand().equals(">")){
			 deshabilitarTextField();
			 contador1++;
			 if (contador1 == listaUsuarios.size())
				contador1 = 0;
			mostrarUsuario(contador1);
	    }
		
	    if (e.getActionCommand().equals("<")){
				deshabilitarTextField();
				contador1--;
				if (contador1 <0)
					contador1 = 0;
				mostrarUsuario(contador1);
		}
			
		
		if (e.getActionCommand().equals("<<")){
			deshabilitarTextField();
			contador1 = contador1 - 25;
			if (contador1 < 0)
				contador1 = listaUsuarios.size() - 1;
			mostrarUsuario(contador1);
		}
		
		if (e.getActionCommand().equals(">>")){
			deshabilitarTextField();
			contador1 = contador1 + 25;
			if (contador1 > 25) {
				contador1 = listaUsuarios.size() - 1;
			}	
			mostrarUsuario(contador1);
		}   	
       }
	}
	
	//registramos los eventos de la vista
		public void actionListener(ActionListener escuchador){
			vistap.getButtonMA().addActionListener(escuchador);
			vistap.getButtonMAMA().addActionListener(escuchador);
			vistap.getButtonME().addActionListener(escuchador);
			vistap.getButtonMEME().addActionListener(escuchador);
			vista.getMntmParticipantes().addActionListener(escuchador);
			vista.getMntmSobreNosotros().addActionListener(escuchador);
		}
	

		private void mostrarUsuario(int indice){
			vistap.getTextFieldNacionalidad().setText(
					listaUsuarios.get(indice).getLogin());
			vistap.getTextFieldProfesion().setText(
					listaUsuarios.get(indice).getPass());
			vistap.getTextFieldSexo().setText(
					listaUsuarios.get(indice).getFecha());
			
		}	
		
		
		private void deshabilitarTextField(){
			vistap.getTextFieldNacionalidad().setEditable(false);
			vistap.getTextFieldProfesion().setEditable(false);
			vistap.getTextFieldSexo().setEditable(false);
		}
		
		
	

		

	private void desplegarInformacion() {
		JOptionPane jpJOptionPane = new JOptionPane();
		jpJOptionPane.showMessageDialog(vista.getFrame(), " Bravo.SL", "Credo por Events Singels",JOptionPane.INFORMATION_MESSAGE);

	}


	private void salirAplicacion() {
		System.exit(0);

	}

}


