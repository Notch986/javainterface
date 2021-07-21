package com.javabydeveloper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Saturation extends JFrame {

	private final String SQL = "INSERT INTO Saturation (id_patient, sat, day) VALUES (?,?,?)";
	private static final long serialVersionUID = -5719026102740307924L;
	private JPanel contentPane;
	private JLabel lblSalir;
	private JTextField txtId;
	private JTextField txtSaturacion;
	private JTextField txtDia;
	private JLabel lblGuardar;

	@SuppressWarnings({ "serial", "unused" })
	public Saturation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel(){
			 protected void paintComponent(Graphics g) {
				 super.paintComponents(g);
				 Color c = new Color(33,120,137,255);
		    	 Graphics2D g2d=(Graphics2D)g;
		    	 int w = getWidth();
		    	 int h = getHeight();
		    	 g2d.setPaint(new GradientPaint(200, 0, c, 200, 350, Color.black));
		    	 g2d.fillRect(0, 0, w, h);
			 }
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		getContentPane().setLayout(null);
		setShape(new RoundRectangle2D.Double(0, 0, 300, 300, 20, 20));
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation( 100, 90 );
		setVisible(true);
		
		lblSalir = new JLabel("");
		lblSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
			}
		});
		contentPane.setLayout(null);
		lblSalir.setIcon(new ImageIcon("images/salir.png"));
		lblSalir.setBounds(265, 10, 25, 25);
		contentPane.add(lblSalir);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 40, 280, 250);
		contentPane.add(panel);
		panel.setLayout(null);
		Color c = new Color(255,255,255,30);
		panel.setBackground(c);
		
		txtId = new JTextField();
		txtId.setBounds(90, 55, 96, 25);
		TextPrompt tp1 = new TextPrompt("ID", txtId);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtSaturacion = new JTextField();
		txtSaturacion.setColumns(10);
		txtSaturacion.setBounds(90, 91, 96, 25);
		TextPrompt tp2 = new TextPrompt("Saturacion", txtSaturacion);
		panel.add(txtSaturacion);
		
		txtDia = new JTextField();
		txtDia.setColumns(10);
		txtDia.setBounds(90, 127, 96, 25);
		TextPrompt tp3 = new TextPrompt("Dia", txtDia);
		panel.add(txtDia);
		
		lblGuardar = new JLabel();
		lblGuardar.setBounds(75, 180, 130, 30);
		lblGuardar.setIcon(new ImageIcon("images/lblGuardar.png"));
		panel.add(lblGuardar);
		
		JLabel lblTitulo = new JLabel("Add Saturation");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setBounds(10, 10, 280, 25);
		contentPane.add(lblTitulo);
		
		lblGuardar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {	
			
				try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root", "12345678");
						PreparedStatement ps2 = conn.prepareStatement(SQL)) {
			
			
			
					ps2.setInt(1, Integer.parseInt(txtId.getText()));
					ps2.setFloat(2, Float.parseFloat(txtSaturacion.getText()));
					ps2.setInt(3, Integer.parseInt(txtDia.getText()));
			
					@SuppressWarnings("unused")
					int row = ps2.executeUpdate();
					JOptionPane.showMessageDialog(null, "Temperatura Guardado");
			
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Parece que no se pudo guardar\nComplete todas las casillas");
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	

}
