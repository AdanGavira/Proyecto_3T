package Prueba_Pryecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_Consultas_Libros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Consultas_Libros frame = new Ventana_Consultas_Libros();
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
	public Ventana_Consultas_Libros() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 697, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consultas de Libros");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(154, 11, 367, 67);
		contentPane.add(lblNewLabel);
		
		JButton btn_AñadirLibros = new JButton("Añadir Libros");
		btn_AñadirLibros.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_AñadirLibros.setBounds(389, 261, 207, 60);
		contentPane.add(btn_AñadirLibros);
		
		JButton btn_EliminarLibros = new JButton("Eliminar Libros");
		btn_EliminarLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] opciones = {"Eliminar", "Cancelar"};
				String id = (String)JOptionPane.showInputDialog(
									btn_EliminarLibros,
				                    "Introduce el ID del libro que quieres eliminar",
				                    "Borrar libro",
				                    JOptionPane.PLAIN_MESSAGE,
				                    null,
				                    null, 
				                    isAlwaysOnTop()
				                    );
				//Añadir consulta de eliminación
			}
		});
		btn_EliminarLibros.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_EliminarLibros.setBounds(51, 261, 256, 60);
		contentPane.add(btn_EliminarLibros);
		
		JButton btn_BuscarLibros = new JButton("Buscar Libros");
		btn_BuscarLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Ventana_Buscar_Libros B1 = new Ventana_Buscar_Libros();
				B1.setVisible(true);
			}
		});
		btn_BuscarLibros.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_BuscarLibros.setBounds(240, 135, 216, 58);
		contentPane.add(btn_BuscarLibros);
	}
}
