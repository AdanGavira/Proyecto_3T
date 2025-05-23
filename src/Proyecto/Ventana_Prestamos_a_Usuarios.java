package Proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Ventana_Prestamos_a_Usuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_IdValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Prestamos_a_Usuarios frame = new Ventana_Prestamos_a_Usuarios();
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
	public Ventana_Prestamos_a_Usuarios() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 758, 536);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// CONTENIDO DE LA VENTANA
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 742, 59);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{742, 0};
		gbl_panel.rowHeights = new int[]{59, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lbl_Titulo = new JLabel("PRESTAMOS A USUARIOS");
		lbl_Titulo.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_Titulo.setForeground(Color.WHITE);
		lbl_Titulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		GridBagConstraints gbc_lbl_Titulo = new GridBagConstraints();
		gbc_lbl_Titulo.gridx = 0;
		gbc_lbl_Titulo.gridy = 0;
		panel.add(lbl_Titulo, gbc_lbl_Titulo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 0, 0));
		panel_1.setBackground(new Color(255, 128, 128));
		panel_1.setBounds(0, 70, 742, 49);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lbl_Instrucciones = new JLabel("Introduce el ID del usuario para consultar sus libros prestados");
		lbl_Instrucciones.setForeground(new Color(255, 255, 255));
		lbl_Instrucciones.setBackground(new Color(255, 128, 128));
		lbl_Instrucciones.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Instrucciones.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_1.add(lbl_Instrucciones);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 192));
		panel_2.setBounds(10, 130, 722, 29);
		contentPane.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{371, 371, 0};
		gbl_panel_2.rowHeights = new int[]{29, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		textField_IdValor = new JTextField();
		textField_IdValor.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textField_IdValor = new GridBagConstraints();
		gbc_textField_IdValor.fill = GridBagConstraints.BOTH;
		gbc_textField_IdValor.insets = new Insets(0, 0, 0, 5);
		gbc_textField_IdValor.gridx = 0;
		gbc_textField_IdValor.gridy = 0;
		panel_2.add(textField_IdValor, gbc_textField_IdValor);
		textField_IdValor.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 185, 722, 301);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setVisible(false);
		textArea.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		
		// BOTONES
		
		JButton btn_Buscar = new JButton("Buscar");
		btn_Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setVisible(true);
				scrollPane.setVisible(true);
				textArea.setText(null);
				Usuario usuario = new Usuario();
				if (usuario.existeUsuario(textField_IdValor.getText())) {		
					try {
						
						ResultSet resultado = usuario.buscarLibrosPrestados(textField_IdValor.getText());
						while(resultado.next()) {
							String tem_Titulo = resultado.getString("Titulo");
							String tem_Autor = resultado.getString("Autor");
							String tem_ISBN = resultado.getString("ISBN");
							String tem_Fecha = resultado.getString("Fecha_de_Publicacion");
							String tem_Categoria = resultado.getString("Categoria");
							int tem_usuario = resultado.getInt("id_usuario");
							
							//Imprime el resultado de la consulta en el textArea
							textArea.setText(textArea.getText()+"Titulo: "+tem_Titulo+" Autor: "+tem_Autor+" ISBN: "+tem_ISBN+" Fecha de publicación: "+tem_Fecha+" Categoría: "+tem_Categoria+" ID_Usuario: "+tem_usuario+"\n");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					
				} else {
					JOptionPane.showMessageDialog(btn_Buscar,
						    "Este usuario no existe",
						    "Error en el ID",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn_Buscar.setForeground(new Color(255, 255, 255));
		btn_Buscar.setBackground(new Color(255, 0, 0));
		GridBagConstraints gbc_btn_Buscar = new GridBagConstraints();
		gbc_btn_Buscar.fill = GridBagConstraints.BOTH;
		gbc_btn_Buscar.gridx = 1;
		gbc_btn_Buscar.gridy = 0;
		panel_2.add(btn_Buscar, gbc_btn_Buscar);
		
		
		
		
	}
}
