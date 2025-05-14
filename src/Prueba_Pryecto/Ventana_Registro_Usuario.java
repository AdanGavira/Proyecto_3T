package Prueba_Pryecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.security.Principal;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;

import com.toedter.components.JSpinField;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JDayChooser;

public class Ventana_Registro_Usuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_Nombre;
	private JTextField text_Apellidos;
	private JTextField text_Correo;
	private final JLabel lblFondo = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Registro_Usuario frame = new Ventana_Registro_Usuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana_Registro_Usuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 668, 461);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JLabel lbl_RegistroUsuarios = new JLabel("Registro de Usuarios");
		lbl_RegistroUsuarios.setForeground(new Color(0, 0, 0));
		lbl_RegistroUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_RegistroUsuarios.setBackground(new Color(240, 240, 240));
		lbl_RegistroUsuarios.setToolTipText("");
		lbl_RegistroUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl_RegistroUsuarios.setBounds(175, 11, 290, 57);
		contentPane.add(lbl_RegistroUsuarios);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 128));
		panel.setBounds(97, 79, 449, 332);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_FechaNacimiento = new JLabel("Fecha de nacimiento: ");
		lbl_FechaNacimiento.setBounds(10, 170, 155, 26);
		panel.add(lbl_FechaNacimiento);
		lbl_FechaNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_FechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lbl_Correo = new JLabel("Correo Electrónico: ");
		lbl_Correo.setBounds(31, 207, 134, 26);
		panel.add(lbl_Correo);
		lbl_Correo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Correo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lbl_Apellidos = new JLabel("Apellidos: ");
		lbl_Apellidos.setBounds(91, 133, 79, 26);
		panel.add(lbl_Apellidos);
		lbl_Apellidos.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Apellidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		text_Correo = new JTextField();
		text_Correo.setBounds(175, 212, 141, 20);
		panel.add(text_Correo);
		text_Correo.setColumns(10);
		
		text_Correo.setInputVerifier(new InputVerifier() {
		    @Override
		    public boolean verify(JComponent input) {
		        String text = ((JTextField) input).getText();
		        if (!text.contains("@")) {
		            JOptionPane.showMessageDialog(null, "El correo debe contener '@'", "Error", JOptionPane.ERROR_MESSAGE);
		            return false;
		        }
		        return true;
		    }
		});
		
		text_Correo.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusLost(FocusEvent e) {
		        String text = text_Correo.getText();
		        if (!text.contains("@")) {
		            JOptionPane.showMessageDialog(null, "El correo debe contener '@'", "Error", JOptionPane.ERROR_MESSAGE);
		            text_Correo.requestFocus(); // Devuelve el foco si no es válido
		        }
		    }
		});


		
		text_Apellidos = new JTextField();
		text_Apellidos.setBounds(175, 138, 141, 20);
		panel.add(text_Apellidos);
		text_Apellidos.setColumns(10);
		
		text_Nombre = new JTextField();
		text_Nombre.setBounds(175, 101, 141, 20);
		panel.add(text_Nombre);
		text_Nombre.setColumns(10);
		
		JLabel lbl_Nombre = new JLabel("Nombre: ");
		lbl_Nombre.setBounds(91, 96, 74, 26);
		panel.add(lbl_Nombre);
		lbl_Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Nombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btn_Enviar = new JButton("Enviar");
		btn_Enviar.setForeground(new Color(0, 128, 0));
		btn_Enviar.setBackground(new Color(0, 255, 0));
		btn_Enviar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_Enviar.setBounds(91, 298, 89, 23);
		panel.add(btn_Enviar);
		
		JButton btn_EliminarCampos = new JButton("Eliminar campos");
		btn_EliminarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_Nombre.setText(null);
				text_Apellidos.setText(null);
				text_Correo.setText(null);
			}
		});
		btn_EliminarCampos.setBackground(new Color(255, 0, 0));
		btn_EliminarCampos.setBounds(251, 298, 130, 23);
		panel.add(btn_EliminarCampos);
		
		JSpinField spinField = new JSpinField();
		spinField.setMinimum(1);
		spinField.setMaximum(31);
		spinField.setBounds(175, 176, 44, 20);
		panel.add(spinField);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setMonth(0);
		monthChooser.setBounds(229, 176, 96, 20);
		panel.add(monthChooser);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(335, 176, 78, 20);
		panel.add(yearChooser);
		
		JLabel lbl_DatosGenerales = new JLabel("Datos Generales");
		lbl_DatosGenerales.setBounds(136, 24, 193, 35);
		panel.add(lbl_DatosGenerales);
		lbl_DatosGenerales.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_DatosGenerales.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(175, 11, 290, 57);
		contentPane.add(panel_1);
	}
}
