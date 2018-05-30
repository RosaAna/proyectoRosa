package defecto;

import java.awt.EventQueue;
import controlador.ControladorParticipantes;
import modeloDAO.UserLoginDAO;
import vista.PanelParticipantes;
import vista.VistaLogin;


public class AppkIniciaAplicacion {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaLogin frame = new VistaLogin();
					PanelParticipantes frame2=new PanelParticipantes();
					UserLoginDAO userLoginDAO= new UserLoginDAO();
					new ControladorParticipantes(frame, frame2, userLoginDAO);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
