package Pruebas_del_Proyecto;

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
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Ventana_Buscar_Libros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

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
		setBounds(100, 100, 703, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar Libros");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(221, 11, 235, 42);
		contentPane.add(lblNewLabel);
		
		JButton btn_Buscar = new JButton("Buscar");
		btn_Buscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Buscar.setBounds(559, 87, 118, 30);
		contentPane.add(btn_Buscar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(82, 162, 528, 229);
		contentPane.add(textArea);
		
		textField = new JTextField();
		textField.setBounds(262, 87, 287, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lbl_Filtro = new JLabel("Filtro");
		lbl_Filtro.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Filtro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Filtro.setBounds(10, 89, 124, 27);
		contentPane.add(lbl_Filtro);
		
		JMenu mn_Filtros = new JMenu("Selecciona");
		mn_Filtros.setHorizontalAlignment(SwingConstants.CENTER);
		mn_Filtros.setBounds(116, 91, 117, 26);
		contentPane.add(mn_Filtros);
		
		JMenuItem mntm_Nombre = new JMenuItem("Nombre");
		mn_Filtros.add(mntm_Nombre);
	}
}
