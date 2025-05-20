package Proyecto;

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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		// CONTENIDO DE LA VENTANA
		
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
		panel_1.setBackground(new Color(0, 128, 192));
		panel_1.setBounds(0, 139, 884, 62);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 192));
		panel_2.setBounds(0, 224, 884, 62);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 128, 192));
		panel_3.setBounds(0, 316, 884, 62);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setBounds(0, 0, 884, 59);
		contentPane.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbl_Titulo = new JLabel("CONSULTAS DE LIBROS");
		lbl_Titulo.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_Titulo.setForeground(new Color(255, 255, 255));
		lbl_Titulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_4.add(lbl_Titulo);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{294, 0};
		gbl_panel_1.rowHeights = new int[]{62, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		// BOTONES
		
		JButton btn_AnadirLibro = new JButton("Añadir Libro");
		btn_AnadirLibro.setForeground(new Color(0, 0, 0));
		btn_AnadirLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_Anadir_Libro anadir_libro = new Ventana_Anadir_Libro();
				anadir_libro.setVisible(true);
			}
		});
		GridBagConstraints gbc_btn_AnadirLibro = new GridBagConstraints();
		gbc_btn_AnadirLibro.gridx = 0;
		gbc_btn_AnadirLibro.gridy = 0;
		panel_1.add(btn_AnadirLibro, gbc_btn_AnadirLibro);
		btn_AnadirLibro.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{442, 0};
		gbl_panel_2.rowHeights = new int[]{62, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton btn_BuscarLibros = new JButton("Buscar Libros");
		btn_BuscarLibros.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_btn_BuscarLibros = new GridBagConstraints();
		gbc_btn_BuscarLibros.gridx = 0;
		gbc_btn_BuscarLibros.gridy = 0;
		panel_2.add(btn_BuscarLibros, gbc_btn_BuscarLibros);
		btn_BuscarLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Ventana_Buscar_Libros B1 = new Ventana_Buscar_Libros();
				B1.setVisible(true);
			}
		});
		btn_BuscarLibros.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{884, 0};
		gbl_panel_3.rowHeights = new int[]{62, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btn_EliminarLibro = new JButton("Eliminar Libro");
		btn_EliminarLibro.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_btn_EliminarLibro = new GridBagConstraints();
		gbc_btn_EliminarLibro.gridx = 0;
		gbc_btn_EliminarLibro.gridy = 0;
		panel_3.add(btn_EliminarLibro, gbc_btn_EliminarLibro);
		btn_EliminarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Libro libro = new Libro();
				String ISBN = (String)JOptionPane.showInputDialog(
									btn_EliminarLibro,
				                    "Introduce el ISBN del libro que quieres eliminar",
				                    "Borrar libro",
				                    JOptionPane.PLAIN_MESSAGE,
				                    null,
				                    null, 
				                    isAlwaysOnTop()
				                    );
				if (libro.existeLibro(ISBN)) {
					libro.eliminarLibro(ISBN);
				} else {
					JOptionPane.showMessageDialog(btn_EliminarLibro,
						    "Este libro no existe",
						    "Error en el ISBN",
						    JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btn_EliminarLibro.setFont(new Font("Tahoma", Font.BOLD, 30));
	}
}
