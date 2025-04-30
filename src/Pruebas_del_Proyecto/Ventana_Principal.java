package Pruebas_del_Proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 765, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_titulo = new JLabel("LA BIBLIOTECA DEL GÉNESIS");
		lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo.setBackground(new Color(240, 240, 240));
		lbl_titulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lbl_titulo.setBounds(40, 30, 651, 46);
		contentPane.add(lbl_titulo);
		
		JButton btn_Consulta_Libros = new JButton(" Consultas de libros");
		btn_Consulta_Libros.setBackground(new Color(255, 128, 128));
		btn_Consulta_Libros.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_Consulta_Libros.setBounds(40, 139, 314, 94);
		contentPane.add(btn_Consulta_Libros);
		btn_Consulta_Libros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Ventana_Consultas_Clientes C1 = new Ventana_Consultas_Clientes();
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
		btn_Registro_Usuarios.setBounds(377, 139, 314, 94);
		contentPane.add(btn_Registro_Usuarios);
		
		JButton btn_Prestamos_Libros = new JButton("Préstamo de libros");
		btn_Prestamos_Libros.setBackground(new Color(255, 128, 128));
		btn_Prestamos_Libros.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_Prestamos_Libros.setBounds(40, 274, 314, 106);
		contentPane.add(btn_Prestamos_Libros);
		
		JButton btn_Consultas_Usuario = new JButton("Consultas de clientes");
		btn_Consultas_Usuario.setBackground(new Color(255, 128, 128));
		btn_Consultas_Usuario.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_Consultas_Usuario.setBounds(377, 274, 314, 106);
		contentPane.add(btn_Consultas_Usuario);
	}
}
