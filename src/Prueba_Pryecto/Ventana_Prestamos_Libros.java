package Prueba_Pryecto;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_Prestamos_Libros extends JFrame {
	private JTextField text_ISBN;
	private JTextField text_ID_Usuario;
	public Ventana_Prestamos_Libros() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 539);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		getContentPane().setBackground(new Color(0, 128, 255));
		setBackground(new Color(240, 240, 240));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(281, 11, 323, 47);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Préstamo de Libros");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 128));
		panel_1.setBounds(0, 124, 813, 59);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_ISBN = new JLabel("ISBN:");
		lbl_ISBN.setBounds(184, 11, 147, 25);
		lbl_ISBN.setToolTipText("");
		lbl_ISBN.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ISBN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lbl_ISBN);
		
		text_ISBN = new JTextField();
		text_ISBN.setBounds(389, 11, 305, 25);
		panel_1.add(text_ISBN);
		text_ISBN.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 128, 128));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 194, 813, 59);
		getContentPane().add(panel_1_1);
		
		JLabel lbl_ID_Usuario = new JLabel("ID de usuario:");
		lbl_ID_Usuario.setToolTipText("");
		lbl_ID_Usuario.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ID_Usuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_ID_Usuario.setBounds(184, 11, 181, 25);
		panel_1_1.add(lbl_ID_Usuario);
		
		text_ID_Usuario = new JTextField();
		text_ID_Usuario.setColumns(10);
		text_ID_Usuario.setBounds(389, 11, 305, 25);
		panel_1_1.add(text_ID_Usuario);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 255));
		panel_2.setBounds(0, 354, 813, 59);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btn_Prestar = new JButton("Prestar");
		btn_Prestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btn_Prestar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Prestar.setBounds(273, 5, 126, 43);
		panel_2.add(btn_Prestar);
		
		JButton btn_Devolver = new JButton("Devolver");
		btn_Devolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btn_Devolver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Devolver.setBounds(409, 5, 126, 43);
		panel_2.add(btn_Devolver);
		
	
	}
}
