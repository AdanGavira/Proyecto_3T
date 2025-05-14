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
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(102, 0, 458, 50);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbl_Titulo = new JLabel("CONSULTAS DE CLIENTES");
		lbl_Titulo.setForeground(new Color(255, 255, 255));
		panel.add(lbl_Titulo);
		lbl_Titulo.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_Titulo.setFont(new Font("Tahoma", Font.BOLD, 33));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 84, 701, 312);
		contentPane.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{350, 350, 0};
		gbl_panel_1.rowHeights = new int[]{379, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btn_BuscarCliente = new JButton("Buscar un cliente");
		btn_BuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_Buscar_Clientes buscar_clientes = new Ventana_Buscar_Clientes();
				buscar_clientes.setVisible(true);
			}
		});
		GridBagConstraints gbc_btn_BuscarCliente = new GridBagConstraints();
		gbc_btn_BuscarCliente.fill = GridBagConstraints.BOTH;
		gbc_btn_BuscarCliente.insets = new Insets(0, 0, 0, 5);
		gbc_btn_BuscarCliente.gridx = 0;
		gbc_btn_BuscarCliente.gridy = 0;
		panel_1.add(btn_BuscarCliente, gbc_btn_BuscarCliente);
		btn_BuscarCliente.setFont(new Font("Tahoma", Font.BOLD, 30));
		btn_BuscarCliente.setBackground(new Color(255, 128, 128));
		
		JButton btn_EliminarCliente = new JButton("Eliminar un cliente");
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
		GridBagConstraints gbc_btn_EliminarCliente = new GridBagConstraints();
		gbc_btn_EliminarCliente.fill = GridBagConstraints.BOTH;
		gbc_btn_EliminarCliente.gridx = 1;
		gbc_btn_EliminarCliente.gridy = 0;
		panel_1.add(btn_EliminarCliente, gbc_btn_EliminarCliente);
		btn_EliminarCliente.setFont(new Font("Tahoma", Font.BOLD, 30));
		btn_EliminarCliente.setBackground(new Color(255, 128, 128));
	}
}
