package Prueba_Pryecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Ventana_Buscar_Clientes extends JFrame {

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
					Ventana_Buscar_Clientes frame = new Ventana_Buscar_Clientes();
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
	public Ventana_Buscar_Clientes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 805, 513);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 789, 56);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lbl_Titulo = new JLabel("BUSCAR CLIENTES");
		lbl_Titulo.setBackground(new Color(0, 0, 0));
		lbl_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_Titulo);
		lbl_Titulo.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 192));
		panel_1.setBounds(0, 67, 789, 56);
		contentPane.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {171, 171, 200, 176};
		gbl_panel_1.rowHeights = new int[]{56, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lbl_Filtro = new JLabel("Filtro:");
		lbl_Filtro.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lbl_Filtro = new GridBagConstraints();
		gbc_lbl_Filtro.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_Filtro.gridx = 0;
		gbc_lbl_Filtro.gridy = 0;
		panel_1.add(lbl_Filtro, gbc_lbl_Filtro);
		lbl_Filtro.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_Filtro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JComboBox comboBox_Filtro = new JComboBox();
		GridBagConstraints gbc_comboBox_Filtro = new GridBagConstraints();
		gbc_comboBox_Filtro.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Filtro.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_Filtro.gridx = 1;
		gbc_comboBox_Filtro.gridy = 0;
		panel_1.add(comboBox_Filtro, gbc_comboBox_Filtro);
		comboBox_Filtro.setFont(new Font("Arial", Font.BOLD, 15));
		comboBox_Filtro.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "Apellido", "ID", "Todo"}));
		comboBox_Filtro.setToolTipText("Seleccionar");
		
		textField_Valor = new JTextField();
		GridBagConstraints gbc_textField_Valor = new GridBagConstraints();
		gbc_textField_Valor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Valor.insets = new Insets(0, 0, 0, 5);
		gbc_textField_Valor.gridx = 2;
		gbc_textField_Valor.gridy = 0;
		panel_1.add(textField_Valor, gbc_textField_Valor);
		textField_Valor.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 192));
		panel_2.setBounds(10, 147, 769, 316);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JTextArea textArea = new JTextArea();
		panel_2.add(textArea);
		textArea.setEditable(false);
		textArea.setVisible(false);
		
		JButton btn_Buscar = new JButton("Buscar");
		GridBagConstraints gbc_btn_Buscar = new GridBagConstraints();
		gbc_btn_Buscar.fill = GridBagConstraints.BOTH;
		gbc_btn_Buscar.gridx = 3;
		gbc_btn_Buscar.gridy = 0;
		panel_1.add(btn_Buscar, gbc_btn_Buscar);
		btn_Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setVisible(true);
				Usuario cliente = new Usuario();
				textArea.setVisible(true);
				textArea.setText(null);
				try {
					
					ResultSet resultado = cliente.buscarUsuario((String)comboBox_Filtro.getSelectedItem(), textField_Valor.getText()); //Guarda los datos de la consulta para imprimirlos
					while(resultado.next()) {
						String tem_ID = resultado.getString("ID");
						String tem_Nombre = resultado.getString("Nombre");
						String tem_Apellidos = resultado.getString("Apellidos");
						String tem_Fecha = resultado.getString("Fecha_de_nacimiento");
						String tem_Email = resultado.getString("Email");
						
						//
						//Imprime el resultado de la consulta en el textArea
						textArea.setText(textArea.getText()+"ID de cliente: "+tem_ID+" Nombre: "+tem_Nombre+" Apellidos: "+tem_Apellidos+" Fecha de nacimiento: "+tem_Fecha+" Correo Electrónico: "+tem_Email+"\n");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField_Valor.setText(null);
				
			}
		});
		btn_Buscar.setForeground(new Color(255, 255, 255));
		btn_Buscar.setBackground(new Color(255, 0, 0));
		btn_Buscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
	}
}
