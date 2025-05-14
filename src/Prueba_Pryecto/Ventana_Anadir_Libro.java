package Prueba_Pryecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.security.Principal;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

public class Ventana_Anadir_Libro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Anadir_Libro frame = new Ventana_Anadir_Libro();
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
	public Ventana_Anadir_Libro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 844, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JLabel lbl_ANADIR_LIBRO = new JLabel("AÑADIR LIBRO");
		lbl_ANADIR_LIBRO.setFont(new Font("SansSerif", Font.BOLD, 36));
		lbl_ANADIR_LIBRO.setBounds(276, 11, 276, 50);
		contentPane.add(lbl_ANADIR_LIBRO);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(136, 93, 554, 330);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_NombreFormulario = new JLabel("Nombre");
		lbl_NombreFormulario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_NombreFormulario.setBounds(133, 11, 76, 23);
		panel.add(lbl_NombreFormulario);
		
		JLabel lbl_AutorFormulario = new JLabel("Autor");
		lbl_AutorFormulario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_AutorFormulario.setBounds(141, 63, 55, 14);
		panel.add(lbl_AutorFormulario);
		
		JLabel lbl_CategoriaFormulario = new JLabel("Categoría");
		lbl_CategoriaFormulario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_CategoriaFormulario.setBounds(120, 211, 89, 23);
		panel.add(lbl_CategoriaFormulario);
		
		JTextArea textArea_Nombre = new JTextArea();
		textArea_Nombre.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_Nombre.setBackground(new Color(192, 192, 192));
		textArea_Nombre.setForeground(new Color(0, 0, 0));
		textArea_Nombre.setBounds(313, 12, 123, 22);
		panel.add(textArea_Nombre);
		
		JTextArea textArea_Autor = new JTextArea();
		textArea_Autor.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_Autor.setBackground(new Color(192, 192, 192));
		textArea_Autor.setBounds(313, 60, 123, 23);
		panel.add(textArea_Autor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Accion", "Drama", "Infantil", "Terror"}));
		comboBox.setBounds(313, 213, 123, 22);
		panel.add(comboBox);
		

		JSpinField spinField = new JSpinField();
		spinField.setMinimum(1);
		spinField.setMaximum(31);
		spinField.setBounds(243, 156, 44, 20);
		panel.add(spinField);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setMonth(0);
		monthChooser.setBounds(297, 156, 96, 20);
		panel.add(monthChooser);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(403, 156, 78, 20);
		panel.add(yearChooser);
		
		JLabel lbl_ISBNFormulario = new JLabel("ISBN");
		lbl_ISBNFormulario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_ISBNFormulario.setBounds(141, 113, 55, 14);
		panel.add(lbl_ISBNFormulario);
		
		JTextArea textArea_ISBN = new JTextArea();
		textArea_ISBN.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_ISBN.setBackground(Color.LIGHT_GRAY);
		textArea_ISBN.setBounds(313, 110, 123, 23);
		panel.add(textArea_ISBN);
		
		JLabel lbl_FechaFormulario = new JLabel("Fecha de publicación");
		lbl_FechaFormulario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_FechaFormulario.setBounds(48, 162, 185, 14);
		panel.add(lbl_FechaFormulario);
		
		// BOTONES
		
		JButton btn_AnadirLibro = new JButton("Añadir");
		btn_AnadirLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean anadido = false;
				do {
					try {
						Libro libro = new Libro();
						//Añadir nuevo libro apartir de los datos del formulario
						libro.anadirLibro(textArea_ISBN.getText(), textArea_Nombre.getText(), textArea_Autor.getText(), (String) comboBox.getSelectedItem(), spinField.getValue(), monthChooser.getMonth()+1, yearChooser.getValue());
						anadido = true;
					} catch (Exception error) {
						
					}
				} while(anadido == false);

			}
		});
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
		
		
	}
}
