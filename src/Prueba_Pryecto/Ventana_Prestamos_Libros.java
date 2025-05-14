package Prueba_Pryecto;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class Ventana_Prestamos_Libros extends JFrame {
	private JTextField text_ISBN;
	private JTextField text_ID_Usuario;
	public Ventana_Prestamos_Libros() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 539);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		getContentPane().setBackground(new Color(0, 128, 255));
		setBackground(new Color(240, 240, 240));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(281, 11, 323, 47);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Préstamo de Libros");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 128));
		panel_1.setBounds(0, 124, 884, 59);
		getContentPane().add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{184, 147, 58, 305, 0};
		gbl_panel_1.rowHeights = new int[]{25, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lbl_ISBN = new JLabel("ISBN:");
		lbl_ISBN.setToolTipText("");
		lbl_ISBN.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ISBN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lbl_ISBN = new GridBagConstraints();
		gbc_lbl_ISBN.fill = GridBagConstraints.VERTICAL;
		gbc_lbl_ISBN.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_ISBN.gridx = 1;
		gbc_lbl_ISBN.gridy = 0;
		panel_1.add(lbl_ISBN, gbc_lbl_ISBN);
		
		text_ISBN = new JTextField();
		GridBagConstraints gbc_text_ISBN = new GridBagConstraints();
		gbc_text_ISBN.gridwidth = 2;
		gbc_text_ISBN.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_ISBN.gridx = 2;
		gbc_text_ISBN.gridy = 0;
		panel_1.add(text_ISBN, gbc_text_ISBN);
		text_ISBN.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 128, 128));
		panel_1_1.setBounds(0, 194, 884, 59);
		getContentPane().add(panel_1_1);
		GridBagLayout gbl_panel_1_1 = new GridBagLayout();
		gbl_panel_1_1.columnWidths = new int[]{184, 181, 305, 0};
		gbl_panel_1_1.rowHeights = new int[]{25, 0};
		gbl_panel_1_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1_1.setLayout(gbl_panel_1_1);
		
		JLabel lbl_ID_Usuario = new JLabel("ID de usuario:");
		lbl_ID_Usuario.setToolTipText("");
		lbl_ID_Usuario.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ID_Usuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lbl_ID_Usuario = new GridBagConstraints();
		gbc_lbl_ID_Usuario.fill = GridBagConstraints.VERTICAL;
		gbc_lbl_ID_Usuario.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_ID_Usuario.gridx = 1;
		gbc_lbl_ID_Usuario.gridy = 0;
		panel_1_1.add(lbl_ID_Usuario, gbc_lbl_ID_Usuario);
		
		text_ID_Usuario = new JTextField();
		text_ID_Usuario.setColumns(10);
		GridBagConstraints gbc_text_ID_Usuario = new GridBagConstraints();
		gbc_text_ID_Usuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_ID_Usuario.gridx = 2;
		gbc_text_ID_Usuario.gridy = 0;
		panel_1_1.add(text_ID_Usuario, gbc_text_ID_Usuario);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 255));
		panel_2.setBounds(0, 354, 813, 59);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btn_Prestar = new JButton("Prestar");
		btn_Prestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Libro libro = new Libro();
				try {
					if (libro.existeLibro(text_ISBN.getText())) {
						if (libro.isPrestado()) {
							JOptionPane.showMessageDialog(btn_Prestar,
								    "Este libro ya está prestado",
								    "Libro prestado",
								    JOptionPane.ERROR_MESSAGE);
						} else {
							if (!(text_ISBN.getText().length() == 0)) {
								libro.prestarLibro(Integer.parseInt(text_ID_Usuario.getText()), text_ISBN.getText());
							}
							else {
								JOptionPane.showMessageDialog(btn_Prestar,
									    "Introduce el ISBN del libro a prestar",
									    "Error en el ISBN",
									    JOptionPane.ERROR_MESSAGE);
							}	
					}
					
					} else {
						JOptionPane.showMessageDialog(btn_Prestar,
							    "Este libro no existe",
							    "Error en el ISBN",
							    JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (Exception err) {
					JOptionPane.showMessageDialog(btn_Prestar,
						    "Error al prestar el libro, consulta que el ID de usuario es correcto",
						    "Error con el ID de usuario",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn_Prestar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Prestar.setBounds(273, 5, 126, 43);
		panel_2.add(btn_Prestar);
		
		JButton btn_Devolver = new JButton("Devolver");
		btn_Devolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Libro libro = new Libro();
				if (libro.existeLibro(text_ISBN.getText())) {
					if (libro.isPrestado()) {
						libro.devolverLibro(text_ISBN.getText());		
					} else {
						JOptionPane.showMessageDialog(btn_Prestar,
							    "Este libro no está prestado",
							    "Libro no prestado",
							    JOptionPane.ERROR_MESSAGE);	
					}
					
				} else {
					JOptionPane.showMessageDialog(btn_Devolver,
						    "Este libro no existe",
						    "Error en el ISBN",
						    JOptionPane.ERROR_MESSAGE);			
				}
			}
		});
		btn_Devolver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Devolver.setBounds(409, 5, 126, 43);
		panel_2.add(btn_Devolver);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 264, 884, 59);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lbl_Explicacion = new JLabel("Para devolver los libros es solo necesario introducir el ISBN del libro");
		lbl_Explicacion.setForeground(new Color(255, 0, 0));
		lbl_Explicacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Explicacion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_3.add(lbl_Explicacion);
		
	
	}
}
