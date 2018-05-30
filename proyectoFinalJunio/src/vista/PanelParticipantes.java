package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelParticipantes extends JPanel {
	private JTextField textFieldNacionalidad;
	private JTextField textFieldProfesion;
	private JLabel lblNacionalidad;
	private JButton buttonMEME;
	private JButton ButtonME;
	private JButton buttonMA;
	private JButton buttonMAMA;
	private JLabel lblSexo;
	private JTextField textFieldSexo;

	/**
	 * Create the panel.
	 */
	public PanelParticipantes() {
		setLayout(null);
		
		lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setForeground(Color.DARK_GRAY);
		lblNacionalidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNacionalidad.setBounds(421, 167, 102, 14);
		add(lblNacionalidad);
		
		textFieldNacionalidad = new JTextField();
		textFieldNacionalidad.setBounds(533, 164, 86, 20);
		add(textFieldNacionalidad);
		textFieldNacionalidad.setColumns(10);
		
		JLabel lblParticipantes = new JLabel("Participantes");
		lblParticipantes.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblParticipantes.setForeground(Color.DARK_GRAY);
		lblParticipantes.setBounds(395, 81, 173, 25);
		add(lblParticipantes);
		
		JLabel lblProfesion = new JLabel("Profesi\u00F3n");
		lblProfesion.setForeground(Color.DARK_GRAY);
		lblProfesion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProfesion.setBounds(421, 227, 102, 14);
		add(lblProfesion);
		
		textFieldProfesion = new JTextField();
		textFieldProfesion.setBounds(533, 226, 86, 20);
		add(textFieldProfesion);
		textFieldProfesion.setColumns(10);
		
		lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(Color.DARK_GRAY);
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSexo.setBounds(432, 294, 74, 14);
		add(lblSexo);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setBounds(533, 293, 86, 20);
		add(textFieldSexo);
		textFieldSexo.setColumns(10);
		
		buttonMEME = new JButton("<<");
		buttonMEME.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonMEME.setBounds(315, 390, 67, 23);
		add(buttonMEME);
		
		ButtonME = new JButton("<");
		ButtonME.setBounds(421, 390, 89, 23);
		add(ButtonME);
		
		buttonMA = new JButton(">");
		buttonMA.setBounds(555, 390, 67, 23);
		add(buttonMA);
		
		buttonMAMA = new JButton(">>");
		buttonMAMA.setBounds(664, 390, 89, 23);
		add(buttonMAMA);

	}

	/**
	 * @return the textFieldNacionalidad
	 */
	public JTextField getTextFieldNacionalidad() {
		return textFieldNacionalidad;
	}

	/**
	 * @return the textFieldProfesion
	 */
	public JTextField getTextFieldProfesion() {
		return textFieldProfesion;
	}

	/**
	 * @return the lblNacionalidad
	 */
	public JLabel getLblNacionalidad() {
		return lblNacionalidad;
	}

	/**
	 * @return the buttonMEME
	 */
	public JButton getButtonMEME() {
		return buttonMEME;
	}

	/**
	 * @return the buttonME
	 */
	public JButton getButtonME() {
		return ButtonME;
	}

	/**
	 * @return the buttonMA
	 */
	public JButton getButtonMA() {
		return buttonMA;
	}

	/**
	 * @return the buttonMAMA
	 */
	public JButton getButtonMAMA() {
		return buttonMAMA;
	}

	/**
	 * @return the lblSexo
	 */
	public JLabel getLblSexo() {
		return lblSexo;
	}

	/**
	 * @return the textFieldSexo
	 */
	public JTextField getTextFieldSexo() {
		return textFieldSexo;
	}

}
