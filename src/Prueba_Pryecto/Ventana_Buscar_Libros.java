package Prueba_Pryecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;

public class Ventana_Buscar_Libros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Valor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Buscar_Libros frame = new Ventana_Buscar_Libros();
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
	public Ventana_Buscar_Libros() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 797, 493);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 789, 53);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lbl_Titulo = new JLabel("BUSCAR LIBROS");
		lbl_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_Titulo);
		lbl_Titulo.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 192));
		panel_1.setBounds(0, 61, 789, 56);
		contentPane.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{171, 171, 200, 176, 0};
		gbl_panel_1.rowHeights = new int[]{56, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lbl_Filtro_1 = new JLabel("Filtro:");
		lbl_Filtro_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Filtro_1.setForeground(Color.WHITE);
		lbl_Filtro_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lbl_Filtro_1 = new GridBagConstraints();
		gbc_lbl_Filtro_1.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Filtro_1.gridx = 0;
		gbc_lbl_Filtro_1.gridy = 0;
		panel_1.add(lbl_Filtro_1, gbc_lbl_Filtro_1);
		
		JComboBox comboBox_Filtro_1 = new JComboBox();
		comboBox_Filtro_1.setModel(new DefaultComboBoxModel(new String[] {"Titulo", "Autor", "Categoria", "ISBN", "Prestados", "Todo"}));
		comboBox_Filtro_1.setToolTipText("Seleccionar");
		comboBox_Filtro_1.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_comboBox_Filtro_1 = new GridBagConstraints();
		gbc_comboBox_Filtro_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Filtro_1.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_Filtro_1.gridx = 1;
		gbc_comboBox_Filtro_1.gridy = 0;
		panel_1.add(comboBox_Filtro_1, gbc_comboBox_Filtro_1);
		
		textField_Valor = new JTextField();
		textField_Valor.setColumns(10);
		GridBagConstraints gbc_textField_Valor = new GridBagConstraints();
		gbc_textField_Valor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Valor.insets = new Insets(0, 0, 0, 5);
		gbc_textField_Valor.gridx = 2;
		gbc_textField_Valor.gridy = 0;
		panel_1.add(textField_Valor, gbc_textField_Valor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 127, 761, 316);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setVisible(false);
		
		JButton btn_Buscar_1 = new JButton("Buscar");
		btn_Buscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Libro libro = new Libro();
				textArea.setVisible(true);
				scrollPane.setVisible(true);
				textArea.setText(null);
				try {
					
					ResultSet resultado = libro.buscarLibro((String)comboBox_Filtro_1.getSelectedItem(), textField_Valor.getText()); //Guarda los datos de la consulta para imprimirlos
					while(resultado.next()) {
						String tem_Titulo = resultado.getString("Titulo");
						String tem_Autor = resultado.getString("Autor");
						String tem_ISBN = resultado.getString("ISBN");
						String tem_Fecha = resultado.getString("Fecha_de_Publicacion");
						String tem_Categoria = resultado.getString("Categoria");
						int tem_cliente = resultado.getInt("id_cliente");
						
						//id_cliente siempre se imprime aunque los libros elegidos no estén prestados
						//Imprime el resultado de la consulta en el textArea
						textArea.setText(textArea.getText()+"Titulo: "+tem_Titulo+" Autor: "+tem_Autor+" ISBN: "+tem_ISBN+" Fecha de publicación: "+tem_Fecha+" Categoría: "+tem_Categoria+" ID_Cliente: "+tem_cliente+"\n");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				textField_Valor.setText(null);	
			}
		});
		btn_Buscar_1.setForeground(Color.WHITE);
		btn_Buscar_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Buscar_1.setBackground(Color.RED);
		GridBagConstraints gbc_btn_Buscar_1 = new GridBagConstraints();
		gbc_btn_Buscar_1.fill = GridBagConstraints.BOTH;
		gbc_btn_Buscar_1.gridx = 3;
		gbc_btn_Buscar_1.gridy = 0;
		panel_1.add(btn_Buscar_1, gbc_btn_Buscar_1);
		
		
		
		
		
	}
}
