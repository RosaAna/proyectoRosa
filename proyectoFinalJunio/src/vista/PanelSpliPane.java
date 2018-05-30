package vista;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PanelSpliPane {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame = new Ventana();
				frame.setVisible(true);
			}
		});

	}

}
class Ventana extends JFrame{

	PanelVentas p =new PanelVentas();
	public Ventana() {
		crearVentana();
		crearPanelPestannas();
	}

	private void crearPanelPestannas() {
		
		JTabbedPane jTabbedPane = new JTabbedPane();
		JSplitPane jSplitPane = crearJSplitPane();
		jTabbedPane.addTab("LOGIN", jSplitPane);
		jTabbedPane.setToolTipTextAt(0, "Panel con jsplitpane");
		
		jTabbedPane.addTab("PROGRAMA", crearJScrollPane());
		jTabbedPane.setToolTipTextAt(1, "Panel con jscrollpane");
		
		this.add(jTabbedPane);
		
	}

	private JSplitPane crearJSplitPane() {
		JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, crearJScrollPane(), p);
		return jSplitPane;
	}

	private JScrollPane crearJScrollPane() {
		PanelDevolucione pi= new PanelDevolucione();
		JScrollPane jScrollPane = new JScrollPane(pi);
		return jScrollPane;
	}

	private void crearVentana() {
		
		this.setTitle("II Event'S Singel");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}	
	
}