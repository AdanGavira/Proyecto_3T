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
import java.awt.event.ActionEvent;
import java.awt.Color;

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
		setBounds(100, 100, 703, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Titulo = new JLabel("Buscar Libros");
		lbl_Titulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lbl_Titulo.setBounds(221, 11, 235, 42);
		contentPane.add(lbl_Titulo);	
		
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(20, 133, 629, 274);
		contentPane.add(textArea);
		
		textField_Valor = new JTextField();
		textField_Valor.setBounds(262, 87, 287, 30);
		contentPane.add(textField_Valor);
		textField_Valor.setColumns(10);
		textArea.setVisible(false);
		
		JButton btn_Buscar = new JButton("Buscar");
		btn_Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setVisible(true);
				textField_Valor.setText(null);
			}
		});
		btn_Buscar.setForeground(new Color(255, 255, 255));
		btn_Buscar.setBackground(new Color(255, 0, 0));
		btn_Buscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Buscar.setBounds(559, 87, 118, 30);
		contentPane.add(btn_Buscar);
		
		JLabel lbl_Filtro = new JLabel("Filtro:");
		lbl_Filtro.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Filtro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Filtro.setBounds(10, 89, 124, 27);
		contentPane.add(lbl_Filtro);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(113, 87, 124, 35);
		contentPane.add(menuBar);
		
		JMenu mn_Filtros = new JMenu("Seleccionar");
		menuBar.add(mn_Filtros);
		
		JMenuItem mntm_Nombre = new JMenuItem("Nombre");
		mntm_Nombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mn_Filtros.setText(mntm_Nombre.getText());
			}
		});
		mn_Filtros.add(mntm_Nombre);
		
		JMenuItem mntm_ID = new JMenuItem("ID");
		mntm_ID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mn_Filtros.setText(mntm_ID.getText());
			}
		});
		mn_Filtros.add(mntm_ID);
		
		JMenuItem mntm_Categoria = new JMenuItem("Categoria");
		mntm_Categoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mn_Filtros.setText(mntm_Categoria.getText());
			}
		});
		mn_Filtros.add(mntm_Categoria);
		
		JMenuItem mntm_Autor = new JMenuItem("Autor");
		mntm_Autor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mn_Filtros.setText(mntm_Autor.getText());
			}
		});
		mn_Filtros.add(mntm_Autor);
	}
}
