package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class PanelLogin extends JPanel {
	private JLabel lblLogin;
	private JButton btnNewButton;
	private JPasswordField passwordField;
	private JTextField textFLogin;

	/**
	 * Create the panel.
	 */
	public PanelLogin() {
		setLayout(null);
		
		btnNewButton = new JButton("ENTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				char[] login=passwordField.getPassword();
	        	String pass=new String(login);
	        	
	        	    if(textFLogin.getText().equals("login") && (pass.equals("pass"))) {
	        		
	        	      //  dispose();
	        	
	        	        JOptionPane.showMessageDialog(null, "Bienvenido al sistema", "Has ingresado correctamente", JOptionPane.INFORMATION_MESSAGE);
	        	       
	        	           Vista v=new  Vista();
	        	           v.setVisible(true);
	        	
	             	}
	        	
	        	    else {
	        	    	JOptionPane.showMessageDialog(null, "Login o pass incorrecto", "ERROR", JOptionPane.INFORMATION_MESSAGE);
	        	    }
	      	
			}
		});
		
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(428, 372, 114, 31);
		add(btnNewButton);
		
		JLabel lblFPass = new JLabel("Pass");
		lblFPass.setForeground(Color.DARK_GRAY);
		lblFPass.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFPass.setBounds(385, 324, 46, 14);
		add(lblFPass);
		

		
		passwordField = new JPasswordField();
		passwordField.setBounds(456, 323, 86, 20);
		add(passwordField);
		
		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogin.setForeground(Color.DARK_GRAY);
		lblLogin.setBounds(385, 299, 46, 14);
		add(lblLogin);
		
		textFLogin = new JTextField();
		textFLogin.setBounds(456, 292, 86, 20);
		add(textFLogin);
		textFLogin.setColumns(10);

	}
}
