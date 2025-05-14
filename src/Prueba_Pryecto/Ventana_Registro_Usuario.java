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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
		setBounds(100, 100, 893, 575);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 128));
		panel.setBounds(123, 113, 604, 393);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_FechaNacimiento = new JLabel("Fecha de nacimiento: ");
		lbl_FechaNacimiento.setBounds(87, 184, 155, 26);
		panel.add(lbl_FechaNacimiento);
		lbl_FechaNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_FechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lbl_Correo = new JLabel("Correo Electrónico: ");
		lbl_Correo.setBounds(135, 255, 134, 26);
		panel.add(lbl_Correo);
		lbl_Correo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Correo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lbl_Apellidos = new JLabel("Apellidos: ");
		lbl_Apellidos.setBounds(157, 126, 79, 26);
		panel.add(lbl_Apellidos);
		lbl_Apellidos.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Apellidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		text_Correo = new JTextField();
		text_Correo.setBounds(292, 260, 141, 20);
		panel.add(text_Correo);
		text_Correo.setColumns(10);

		text_Apellidos = new JTextField();
		text_Apellidos.setBounds(292, 131, 141, 20);
		panel.add(text_Apellidos);
		text_Apellidos.setColumns(10);
		
		text_Nombre = new JTextField();
		text_Nombre.setBounds(292, 83, 141, 20);
		panel.add(text_Nombre);
		text_Nombre.setColumns(10);
		
		JLabel lbl_Nombre = new JLabel("Nombre: ");
		lbl_Nombre.setBounds(157, 78, 74, 26);
		panel.add(lbl_Nombre);
		lbl_Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Nombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JSpinField spinField = new JSpinField();
		spinField.setMinimum(1);
		spinField.setMaximum(31);
		spinField.setBounds(252, 190, 44, 20);
		panel.add(spinField);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setMonth(0);
		monthChooser.setBounds(306, 190, 96, 20);
		panel.add(monthChooser);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(412, 190, 78, 20);
		panel.add(yearChooser);
		
		JLabel lbl_DatosGenerales = new JLabel("DATOS GENERALES");
		lbl_DatosGenerales.setBounds(193, 11, 229, 35);
		panel.add(lbl_DatosGenerales);
		lbl_DatosGenerales.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_DatosGenerales.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(202, 25, 438, 47);
		contentPane.add(panel_1);
		
		JLabel lbl_RegistroUsuarios = new JLabel("REGISTRO DE USUARIOS");
		panel_1.add(lbl_RegistroUsuarios);
		lbl_RegistroUsuarios.setForeground(new Color(0, 0, 0));
		lbl_RegistroUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_RegistroUsuarios.setBackground(new Color(240, 240, 240));
		lbl_RegistroUsuarios.setToolTipText("");
		lbl_RegistroUsuarios.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JButton btn_Enviar = new JButton("Enviar");
		btn_Enviar.setForeground(new Color(0, 0, 0));
		btn_Enviar.setBackground(new Color(0, 255, 0));
		btn_Enviar.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		btn_Enviar.setBounds(180, 345, 89, 23);
		panel.add(btn_Enviar);
		
		// EL CORREO ELECTRÓNICO DEBE CONTENER "@"
		
		btn_Enviar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Usuario cliente = new Usuario();
		    	
		        if (!text_Correo.getText().contains("@")) { //Comprueba que el correo contiene @ por lo que no puede estar vacío
		        	JOptionPane.showMessageDialog(null, "El correo debe contener '@'", "Error", JOptionPane.ERROR_MESSAGE);
		        	
		        } else { 
		        	if (!text_Nombre.getText().isEmpty() || !text_Apellidos.getText().isEmpty()){ //Comprueba que nombre y apellido no están vacíos para introducir datos
			            if (yearChooser.getValue() > 2025) { //Comprueba que el año de nacimiento no sea más de 2025
			            	JOptionPane.showMessageDialog(btn_Enviar,
								    "La fecha de nacimiento es inválida",
								    "Error en la fecha de nacimiento",
								    JOptionPane.ERROR_MESSAGE);
			            } else {
			            	//Añadir usuario a través de los datos del formulario
			            	cliente.anadirUsuario(text_Nombre.getText(), text_Apellidos.getText(), spinField.getValue(), monthChooser.getMonth()+1, yearChooser.getValue(), text_Correo.getText());
			            }
		        	} else {
		        		JOptionPane.showMessageDialog(btn_Enviar,
							    "Los campos de nombre y apellido deben tener datos",
							    "Error en el nombre y apellidos",
							    JOptionPane.ERROR_MESSAGE);
		        	}
		        }
		    }
		});
		
		// MOSTRAR UN MENSAJE AL PASAR EL RATÓN POR CADA TEXTAREA
		
		text_Nombre.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        text_Nombre.setToolTipText("Puede ingresar su nombre de pila o un apodo");
		    }
		});
		
		text_Apellidos.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        text_Apellidos.setToolTipText("Introduzca primero el primer apellido y luego el segundo apellido");
		    }
		});
		
		text_Correo.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        text_Correo.setToolTipText("Introduzca su correo electrónico para recibir todas las notificaciones");
		    }
		});



		
		JButton btn_EliminarCampos = new JButton("Eliminar campos");
		btn_EliminarCampos.setFont(new Font("Segoe UI Variable", Font.PLAIN, 11));
		btn_EliminarCampos.setForeground(new Color(255, 255, 255));
		btn_EliminarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_Nombre.setText(null);
				text_Apellidos.setText(null);
				text_Correo.setText(null);
				
			}
		});
		btn_EliminarCampos.setBackground(new Color(255, 0, 0));
		btn_EliminarCampos.setBounds(338, 347, 130, 23);
		panel.add(btn_EliminarCampos);
		
		
	}
}
