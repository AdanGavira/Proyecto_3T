package Prueba_Pryecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.security.Principal;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Ventana_Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Principal frame = new Ventana_Principal();
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
	public Ventana_Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1132, 914);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		//titulo de la aplicación 
		JLabel lbl_titulo = new JLabel("LA BIBLIOTECA DEL GÉNESIS");
		lbl_titulo.setBounds(5, 5, 547, 282);
		lbl_titulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_titulo.setBackground(new Color(245, 227, 200));
		lbl_titulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		contentPane.add(lbl_titulo);
		
		//Logotipo biblioteca
		final JLabel lblDelGenesis = new JLabel("");
		lblDelGenesis.setBounds(557, 5, 552, 282);
		lblDelGenesis.setBackground(new Color(245, 227, 200));
		lblDelGenesis.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelGenesis.setIcon(new ImageIcon(Ventana_Principal.class.getResource("/image/Logotipo_Biblioteca_del_Génesis 256x256.png")));
		contentPane.add(lblDelGenesis);
		
		//Botón registro clientes
		JButton btn_Registro_Usuarios = new JButton("Registro de clientes");
		btn_Registro_Usuarios.setBounds(557, 292, 552, 284);
		btn_Registro_Usuarios.setBorderPainted(false);
		btn_Registro_Usuarios.setContentAreaFilled(false);
		ImageIcon icono3 = new ImageIcon (Ventana_Principal.class.getResource("/image/registro_clientes_escala.png")); //imagen
		Image imagen3 = icono3.getImage().getScaledInstance(btn_Registro_Usuarios.getWidth(), btn_Registro_Usuarios.getHeight(), Image.SCALE_SMOOTH); //imagen a escala del botón
		ImageIcon iconoAjustado3 = new ImageIcon (imagen3);
		btn_Registro_Usuarios.setIcon(iconoAjustado3);
		btn_Registro_Usuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Ventana_Registro_Usuario V1 = new Ventana_Registro_Usuario();
				V1.setVisible(true);
			}
		});
		contentPane.add(btn_Registro_Usuarios);
		
		//Botón consulta de libros
		JButton btn_Consulta_Libros = new JButton(" Consultas de libros");
		btn_Consulta_Libros.setBounds(5, 587, 547, 284);
		btn_Consulta_Libros.setBorderPainted(false);
		btn_Consulta_Libros.setContentAreaFilled(false);
		ImageIcon icono4 = new ImageIcon (Ventana_Principal.class.getResource("/image/consulta_libros_escala.png")); //imagen
		Image imagen4 = icono4.getImage().getScaledInstance(btn_Consulta_Libros.getWidth(), btn_Consulta_Libros.getHeight(), Image.SCALE_SMOOTH); //imagen a escala del botón
		ImageIcon iconoAjustado4 = new ImageIcon (imagen4);
		btn_Consulta_Libros.setIcon(iconoAjustado4);
		btn_Consulta_Libros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Ventana_Consultas_Libros C1 = new Ventana_Consultas_Libros();
				C1.setVisible(true);
			}
		});
		contentPane.add(btn_Consulta_Libros);
		
		//Botón Préstamo de libros
		JButton btn_Prestamos_Libros = new JButton("Préstamo de libros");
		btn_Prestamos_Libros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Ventana_Prestamos_Libros P2 = new Ventana_Prestamos_Libros();
				P2.setVisible(true);
			}
		});
		btn_Prestamos_Libros.setBounds(5, 292, 547, 284);
		btn_Prestamos_Libros.setBorderPainted(false);
		btn_Prestamos_Libros.setContentAreaFilled(false);
		ImageIcon icono2 = new ImageIcon(Ventana_Principal.class.getResource("/image/prestamo_libros_escala.png")); //imagen 
		Image imagen2 = icono2.getImage().getScaledInstance(btn_Prestamos_Libros.getWidth(), btn_Prestamos_Libros.getHeight(), Image.SCALE_SMOOTH); //imagen a escala del botón
		ImageIcon iconoAjustado2 = new ImageIcon (imagen2);
		btn_Prestamos_Libros.setIcon(iconoAjustado2);
	
		contentPane.add(btn_Prestamos_Libros);
		
		//Botón consulta clientes
		JButton btn_Consultas_Clientes = new JButton("Consulta Clientes");
		btn_Consultas_Clientes.setBounds(559, 587, 547, 284);
		btn_Consultas_Clientes.setBorderPainted(false);
		btn_Consultas_Clientes.setContentAreaFilled(false);
		ImageIcon icono6 = new ImageIcon(Ventana_Principal.class.getResource("/image/consulta_clientes_escala.png")); //imagen
		Image imagen6 = icono6.getImage().getScaledInstance(btn_Consultas_Clientes.getWidth(), btn_Consultas_Clientes.getHeight(), Image.SCALE_SMOOTH); //imagen a escala del boton
		ImageIcon iconoAjustado6 = new ImageIcon (imagen6);
		btn_Consultas_Clientes.setIcon(iconoAjustado6);
		/*btn_Consultas_Clientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Ventana_Consultas_Clientes C6 = new Ventana_Consultas_Clientes();
				C6.setVisible(true);
			}
		});*/
		contentPane.add(btn_Consultas_Clientes);
	}
}
