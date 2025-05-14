package Prueba_Pryecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.Principal;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Ventana_Consultas_Libros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Consultas_Libros frame = new Ventana_Consultas_Libros();
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
	public Ventana_Consultas_Libros() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 539);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("CONSULTAS DE LIBROS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 130, 884, 62);
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btn_AñadirLibro = new JButton("AÑADIR LIBRO");
		btn_AñadirLibro.setForeground(new Color(0, 0, 0));
		btn_AñadirLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_Anadir_Libro anadir_libro = new Ventana_Anadir_Libro();
				anadir_libro.setVisible(true);
			}
		});
		panel_1.add(btn_AñadirLibro);
		btn_AñadirLibro.setBackground(new Color(0, 255, 0));
		btn_AñadirLibro.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel label = new JLabel("");
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 224, 884, 62);
		contentPane.add(panel_2);
		
		JButton btn_BuscarLibros = new JButton("BUSCAR LIBROS");
		btn_BuscarLibros.setForeground(new Color(0, 0, 0));
		panel_2.add(btn_BuscarLibros);
		btn_BuscarLibros.setBackground(new Color(255, 128, 64));
		btn_BuscarLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Ventana_Buscar_Libros B1 = new Ventana_Buscar_Libros();
				B1.setVisible(true);
			}
		});
		btn_BuscarLibros.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(0, 316, 884, 62);
		contentPane.add(panel_3);
		
		JButton btn_EliminarLibro = new JButton("ELIMINAR LIBROS");
		btn_EliminarLibro.setForeground(new Color(255, 255, 255));
		panel_3.add(btn_EliminarLibro);
		btn_EliminarLibro.setBackground(new Color(255, 0, 0));
		btn_EliminarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = (String)JOptionPane.showInputDialog(
									btn_EliminarLibro,
				                    "Introduce el ID del libro que quieres eliminar",
				                    "Borrar libro",
				                    JOptionPane.PLAIN_MESSAGE,
				                    null,
				                    null, 
				                    isAlwaysOnTop()
				                    );
				//Añadir consulta de eliminación
			}
		});
		btn_EliminarLibro.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lbl_titulo = new JLabel("CONSULTAR LIBROS");
		lbl_titulo.setForeground(new Color(0, 0, 0));
		lbl_titulo.setFont(new Font("Dubai", Font.BOLD, 45));
		lbl_titulo.setBounds(223, 26, 429, 46);
		contentPane.add(lbl_titulo);
	}
}
