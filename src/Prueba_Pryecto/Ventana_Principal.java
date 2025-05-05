package Prueba_Pryecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
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
		setBounds(100, 100, 1131, 912);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		JLabel lbl_titulo = new JLabel("LA BIBLIOTECA DEL GÉNESIS");
		lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo.setBackground(new Color(245, 227, 200));
		lbl_titulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		contentPane.add(lbl_titulo);
		
		final JLabel lblDelGenesis = new JLabel("");
		lblDelGenesis.setBackground(new Color(245, 227, 200));
		lblDelGenesis.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelGenesis.setIcon(new ImageIcon(Ventana_Principal.class.getResource("/image/Logotipo_Biblioteca_del_Génesis 256x256.png")));
		lblDelGenesis.setBounds(0, 0, 1720, 900);
		contentPane.add(lblDelGenesis);
		
		JButton btn_Consulta_Libros = new JButton(" Consultas de libros");
		btn_Consulta_Libros.setBackground(new Color(255, 128, 128));
		btn_Consulta_Libros.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(btn_Consulta_Libros);
		btn_Consulta_Libros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Ventana_Consultas_Libros C1 = new Ventana_Consultas_Libros();
				C1.setVisible(true);
			}
		});
		
		JButton btn_Registro_Usuarios = new JButton("Registro de clientes");
		btn_Registro_Usuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Ventana_Registro_Usuario V1 = new Ventana_Registro_Usuario();
				V1.setVisible(true);
			}
		});
		btn_Registro_Usuarios.setBackground(new Color(255, 128, 128));
		btn_Registro_Usuarios.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(btn_Registro_Usuarios);
		
		JButton btn_Prestamos_Libros = new JButton("Préstamo de libros");
		btn_Prestamos_Libros.setBackground(new Color(255, 128, 128));
		btn_Prestamos_Libros.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(btn_Prestamos_Libros);
		
		JButton btn_Consultas_Usuario = new JButton("Consultas de clientes");
		btn_Consultas_Usuario.setBackground(new Color(255, 128, 128));
		btn_Consultas_Usuario.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(btn_Consultas_Usuario);
	}
}
