package Proyecto;

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

public class Ventana_Consultas_Usuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Consultas_Usuarios frame = new Ventana_Consultas_Usuarios();
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
	public Ventana_Consultas_Usuarios() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 717, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		// CONTENIDO DE LA VENTANA
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 701, 59);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbl_Titulo = new JLabel("CONSULTAS DE USUARIOS");
		lbl_Titulo.setForeground(new Color(255, 255, 255));
		panel.add(lbl_Titulo);
		lbl_Titulo.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_Titulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 192));
		panel_1.setBounds(0, 84, 701, 59);
		contentPane.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(0, 128, 192));
		panel_1_1.setBounds(0, 294, 701, 59);
		contentPane.add(panel_1_1);		
		
		JButton btn_EliminarUsuario = new JButton("Eliminar un usuario");
		btn_EliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_1_1.add(btn_EliminarUsuario);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(0, 128, 192));
		panel_1_2.setBounds(0, 182, 701, 59);
		contentPane.add(panel_1_2);
		
		// BOTONES
		
		JButton btn_Prestamos = new JButton("Prestámos a usuarios");
		btn_Prestamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_Prestamos_a_Usuarios prestamos_usuarios = new Ventana_Prestamos_a_Usuarios();
				prestamos_usuarios.setVisible(true);
			}
		});
		btn_Prestamos.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_1_2.add(btn_Prestamos);
		btn_EliminarUsuario.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JButton btn_BuscarCliente = new JButton("Buscar usuarios");
		btn_BuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_Buscar_Usuarios buscar_usuarios = new Ventana_Buscar_Usuarios();
				buscar_usuarios.setVisible(true);
			}
		});
		

		btn_EliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();
				String id = (String)JOptionPane.showInputDialog(
									btn_EliminarUsuario,
				                    "Introduce el ID del usuario que quieres eliminar",
				                    "Eliminar usuario",
				                    JOptionPane.PLAIN_MESSAGE,
				                    null,
				                    null, 
				                    isAlwaysOnTop()
				                    );
				if (usuario.existeUsuario(id)) {
					if (!usuario.isPrestado(id)) {
						usuario.eliminarUsuario(id);
					} else {
						JOptionPane.showMessageDialog(btn_EliminarUsuario,
							    "Este usuario tiene libros prestados, asegurate de devolverlos antes de eliminar el usuario",
							    "Error al eliminar usuario",
							    JOptionPane.ERROR_MESSAGE);
					}
					
				} else {
					JOptionPane.showMessageDialog(btn_EliminarUsuario,
						    "Este usuario no existe",
						    "Error en el ID",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		GridBagConstraints gbc_btn_BuscarCliente = new GridBagConstraints();
		gbc_btn_BuscarCliente.fill = GridBagConstraints.BOTH;
		gbc_btn_BuscarCliente.insets = new Insets(0, 0, 0, 5);
		gbc_btn_BuscarCliente.gridx = 0;
		gbc_btn_BuscarCliente.gridy = 0;
		panel_1.add(btn_BuscarCliente, gbc_btn_BuscarCliente);
		btn_BuscarCliente.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		GridBagConstraints gbc_btn_EliminarCliente = new GridBagConstraints();
		gbc_btn_EliminarCliente.fill = GridBagConstraints.BOTH;
		gbc_btn_EliminarCliente.gridx = 1;
		gbc_btn_EliminarCliente.gridy = 0;
		panel_1_1.add(btn_EliminarUsuario, gbc_btn_EliminarCliente);
		
	}
}
