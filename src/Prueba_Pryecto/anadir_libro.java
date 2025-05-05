package Prueba_Pryecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class anadir_libro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					anadir_libro frame = new anadir_libro();
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
	public anadir_libro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_ANADIR_LIBRO = new JLabel("AÑADIR LIBRO");
		lbl_ANADIR_LIBRO.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lbl_ANADIR_LIBRO.setBounds(276, 11, 276, 50);
		contentPane.add(lbl_ANADIR_LIBRO);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(136, 93, 554, 330);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_NombreFormulario = new JLabel("Nombre");
		lbl_NombreFormulario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_NombreFormulario.setBounds(133, 47, 76, 23);
		panel.add(lbl_NombreFormulario);
		
		JLabel lbl_AutorFormulario = new JLabel("Autor");
		lbl_AutorFormulario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_AutorFormulario.setBounds(141, 118, 55, 14);
		panel.add(lbl_AutorFormulario);
		
		JLabel lbl_CategoriaFormulario = new JLabel("Categoría");
		lbl_CategoriaFormulario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_CategoriaFormulario.setBounds(120, 185, 89, 23);
		panel.add(lbl_CategoriaFormulario);
		
		JTextArea textArea_Nombre = new JTextArea();
		textArea_Nombre.setBackground(new Color(192, 192, 192));
		textArea_Nombre.setForeground(new Color(255, 255, 255));
		textArea_Nombre.setBounds(313, 48, 123, 22);
		panel.add(textArea_Nombre);
		
		JTextArea textArea_Autor = new JTextArea();
		textArea_Autor.setBackground(new Color(192, 192, 192));
		textArea_Autor.setBounds(313, 115, 123, 23);
		panel.add(textArea_Autor);
		
		// BOTONES
		
		JButton btn_AnadirLibro = new JButton("Añadir");
		btn_AnadirLibro.setBackground(new Color(0, 255, 0));
		btn_AnadirLibro.setBounds(120, 296, 89, 23);
		panel.add(btn_AnadirLibro);
		
		JButton btn_EliminarCampos = new JButton("Eliminar campos");
		btn_EliminarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_Nombre.setText(null);
				textArea_Autor.setText(null);
			}
		});
		btn_EliminarCampos.setBackground(new Color(255, 0, 0));
		btn_EliminarCampos.setBounds(313, 296, 130, 23);
		panel.add(btn_EliminarCampos);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Accion", "Drama", "Infantil", "Terror"}));
		comboBox.setBounds(313, 187, 123, 22);
		panel.add(comboBox);
	}
}
