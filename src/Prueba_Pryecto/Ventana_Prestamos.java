package Prueba_Pryecto;

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

public class Ventana_Prestamos extends JFrame {

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
					Ventana_Prestamos frame = new Ventana_Prestamos();
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
	public Ventana_Prestamos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 536);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 742, 59);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbl_Titulo = new JLabel("PRESTÁMOS");
		lbl_Titulo.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_Titulo.setForeground(Color.WHITE);
		lbl_Titulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(lbl_Titulo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 0, 0));
		panel_1.setBackground(new Color(255, 128, 128));
		panel_1.setBounds(0, 70, 742, 49);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lbl_Instrucciones = new JLabel("Introduce el ID del cliente para consultar sus libros prestados");
		lbl_Instrucciones.setForeground(new Color(255, 255, 255));
		lbl_Instrucciones.setBackground(new Color(255, 128, 128));
		lbl_Instrucciones.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Instrucciones.setFont(new Font("Tahoma", Font.BOLD, 24));
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
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setVisible(false);
		textArea.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		
		JButton btn_Buscar = new JButton("Buscar");
		btn_Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setVisible(true);
				textArea.setText(null);
				Usuario cliente = new Usuario();
				if (cliente.existeCliente(textField_IdValor.getText())) {		
					try {
						
						ResultSet resultado = cliente.buscarLibrosPrestados(textField_IdValor.getText());
						while(resultado.next()) {
							String tem_Titulo = resultado.getString("Titulo");
							String tem_Autor = resultado.getString("Autor");
							String tem_ISBN = resultado.getString("ISBN");
							String tem_Fecha = resultado.getString("Fecha_de_Publicacion");
							String tem_Categoria = resultado.getString("Categoria");
							int tem_cliente = resultado.getInt("id_cliente");
							
							//Imprime el resultado de la consulta en el textArea
							textArea.setText(textArea.getText()+"Titulo: "+tem_Titulo+" Autor: "+tem_Autor+" ISBN: "+tem_ISBN+" Fecha de publicación: "+tem_Fecha+" Categoría: "+tem_Categoria+" ID_Cliente: "+tem_cliente+"\n");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					
				} else {
					JOptionPane.showMessageDialog(btn_Buscar,
						    "Este cliente no existe",
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
