package Proyecto;

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
import java.awt.GridLayout;
import java.awt.GridBagLayout;

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
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(136, 93, 554, 330);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_NombreFormulario = new JLabel("Nombre");
		lbl_NombreFormulario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_NombreFormulario.setBounds(132, 40, 76, 23);
		panel.add(lbl_NombreFormulario);
		
		JLabel lbl_AutorFormulario = new JLabel("Autor");
		lbl_AutorFormulario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_AutorFormulario.setBounds(140, 92, 55, 14);
		panel.add(lbl_AutorFormulario);
		
		JLabel lbl_CategoriaFormulario = new JLabel("Categoría");
		lbl_CategoriaFormulario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_CategoriaFormulario.setBounds(119, 240, 89, 23);
		panel.add(lbl_CategoriaFormulario);
		
		JTextArea textArea_Nombre = new JTextArea();
		textArea_Nombre.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_Nombre.setBackground(new Color(192, 192, 192));
		textArea_Nombre.setForeground(new Color(0, 0, 0));
		textArea_Nombre.setBounds(312, 41, 123, 22);
		panel.add(textArea_Nombre);
		
		JTextArea textArea_Autor = new JTextArea();
		textArea_Autor.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_Autor.setBackground(new Color(192, 192, 192));
		textArea_Autor.setBounds(312, 89, 123, 23);
		panel.add(textArea_Autor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Accion", "Drama", "Infantil", "Terror"}));
		comboBox.setBounds(312, 242, 123, 22);
		panel.add(comboBox);
		

		JSpinField spinField = new JSpinField();
		spinField.setMinimum(1);
		spinField.setMaximum(31);
		spinField.setBounds(242, 185, 44, 20);
		panel.add(spinField);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setMonth(0);
		monthChooser.setBounds(296, 185, 96, 20);
		panel.add(monthChooser);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(402, 185, 78, 20);
		panel.add(yearChooser);
		
		JLabel lbl_ISBNFormulario = new JLabel("ISBN");
		lbl_ISBNFormulario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_ISBNFormulario.setBounds(140, 142, 55, 14);
		panel.add(lbl_ISBNFormulario);
		
		JTextArea textArea_ISBN = new JTextArea();
		textArea_ISBN.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea_ISBN.setBackground(Color.LIGHT_GRAY);
		textArea_ISBN.setBounds(312, 139, 123, 23);
		panel.add(textArea_ISBN);
		
		JLabel lbl_FechaFormulario = new JLabel("Fecha de publicación");
		lbl_FechaFormulario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_FechaFormulario.setBounds(47, 191, 185, 14);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 828, 62);
		contentPane.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{828, 0};
		gbl_panel_1.rowHeights = new int[]{62, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		// CONTENIDO DE LA VENTANA
		
		JLabel lbl_ANADIR_LIBRO = new JLabel("AÑADIR LIBRO");
		lbl_ANADIR_LIBRO.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lbl_ANADIR_LIBRO = new GridBagConstraints();
		gbc_lbl_ANADIR_LIBRO.gridx = 0;
		gbc_lbl_ANADIR_LIBRO.gridy = 0;
		panel_1.add(lbl_ANADIR_LIBRO, gbc_lbl_ANADIR_LIBRO);
		lbl_ANADIR_LIBRO.setFont(new Font("SansSerif", Font.BOLD, 36));
		
		
	}
}
