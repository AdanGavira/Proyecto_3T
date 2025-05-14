package Prueba_Pryecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_Consultas_Clientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Consultas_Clientes frame = new Ventana_Consultas_Clientes();
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
	public Ventana_Consultas_Clientes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 717, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 701, 59);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbl_Titulo = new JLabel("CONSULTAS DE CLIENTES");
		lbl_Titulo.setBackground(new Color(0, 0, 0));
		lbl_Titulo.setForeground(new Color(0, 0, 0));
		panel.add(lbl_Titulo);
		lbl_Titulo.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_Titulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 192));
		panel_1.setBounds(0, 84, 701, 312);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 192));
		panel_2.setBounds(181, 29, 323, 66);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btn_BuscarCliente = new JButton("Buscar un cliente");
		btn_BuscarCliente.setForeground(new Color(0, 0, 0));
		btn_BuscarCliente.setBounds(10, 11, 303, 45);
		panel_2.add(btn_BuscarCliente);
		btn_BuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_Buscar_Clientes buscar_clientes = new Ventana_Buscar_Clientes();
				buscar_clientes.setVisible(true);
			}
		});
		btn_BuscarCliente.setFont(new Font("Tahoma", Font.BOLD, 30));
		btn_BuscarCliente.setBackground(new Color(0, 255, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 128, 192));
		panel_3.setBounds(181, 125, 323, 57);
		panel_1.add(panel_3);
		
		JButton btn_EliminarCliente_1 = new JButton("Préstamos");
		btn_EliminarCliente_1.setForeground(new Color(0, 0, 0));
		panel_3.add(btn_EliminarCliente_1);
		btn_EliminarCliente_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		btn_EliminarCliente_1.setBackground(new Color(255, 128, 64));
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(0, 128, 192));
		panel_3_1.setBounds(181, 225, 323, 57);
		panel_1.add(panel_3_1);
		
		JButton btn_EliminarCliente = new JButton("Eliminar un cliente");
		btn_EliminarCliente.setForeground(new Color(255, 255, 255));
		panel_3_1.add(btn_EliminarCliente);
		btn_EliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = (String)JOptionPane.showInputDialog(
									btn_EliminarCliente,
				                    "Introduce el ID del cliente que quieres eliminar",
				                    "Eliminar cliente",
				                    JOptionPane.PLAIN_MESSAGE,
				                    null,
				                    null, 
				                    isAlwaysOnTop()
				                    );
				//Añadir consulta de eliminación
			}
		});
		btn_EliminarCliente.setFont(new Font("Tahoma", Font.BOLD, 30));
		btn_EliminarCliente.setBackground(new Color(255, 0, 0));
	}
}
