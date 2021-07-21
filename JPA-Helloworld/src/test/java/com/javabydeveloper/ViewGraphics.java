package com.javabydeveloper;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.panayotis.gnuplot.JavaPlot;

public class ViewGraphics extends JFrame {
	
	public static final String SQL = "SELECT * FROM Saturation";
	public static final String SQL2 = "SELECT * FROM Temperature";
	private JPanel contentPane;
	private JLabel lblSalir;
	private JTextField txtId;
	private JLabel lblBuscar;
		
	public ViewGraphics() throws IOException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel(){
			 protected void paintComponent(Graphics g) {
				 super.paintComponents(g);
				 Color c = new Color(33,120,137,255);
		    	 Graphics2D g2d=(Graphics2D)g;
		    	 int w = getWidth();
		    	 int h = getHeight();
		    	 g2d.setPaint(new GradientPaint(200, 0, c, 300, 350, Color.black));
		    	 g2d.fillRect(0, 0, w, h);
			 }
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		getContentPane().setLayout(null);
		setShape(new RoundRectangle2D.Double(0, 0, 300, 150, 20, 20));
		setLocation( 550, 20 );
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
		panel.setBounds(10, 40, 280, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		Color c = new Color(255,255,255,30);
		panel.setBackground(c);
		
		txtId = new JTextField();
		txtId.setBounds(90, 25, 96, 25);
		TextPrompt tp1 = new TextPrompt("ID", txtId);
		panel.add(txtId);
		txtId.setColumns(10);
		
		lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(90, 55, 96, 25);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.white);
		panel.add(lblBuscar);
		
		JLabel lblTitulo = new JLabel("Show Grapichs");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setBounds(10, 10, 280, 25);
		contentPane.add(lblTitulo);
		
		lblBuscar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {	
			
				try {
					saturationPatient(Integer.parseInt(txtId.getText()));
					temperaturePatient(Integer.parseInt(txtId.getText()));
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				 	
				JavaPlot p = new JavaPlot();
				p.addPlot("\"temperature.txt\" with lines");
				p.addPlot("\"saturation.txt\" with lines");
				p.plot();
			
			}
		});
	}
		
		
		public static void saturationPatient(int id) throws IOException {
			File reporte = null;
	    	BufferedWriter bw = null;
	    	FileWriter fw = null;
	    	reporte = new File ("saturation.txt");
	    	
	    	if (!reporte.exists()) {
	            reporte.createNewFile();
	        }

	    	fw = new FileWriter(reporte.getAbsoluteFile());
		    bw = new BufferedWriter(fw);
			try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "12345678");
				PreparedStatement ps = conn.prepareStatement(SQL)) {
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					if(rs.getInt(1)==id) {
						bw.write(rs.getInt(3)+"\t"+rs.getString(2)+"\n");
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			bw.close();
		}
		public static void temperaturePatient(int id) throws IOException{
	    	File reporte = null;
	    	BufferedWriter bw = null;
	    	FileWriter fw = null;
	    	reporte = new File ("temperature.txt");
	    	
	    	if (!reporte.exists()) {
	            reporte.createNewFile();
	        }

	    	fw = new FileWriter(reporte.getAbsoluteFile());
		    bw = new BufferedWriter(fw);
		    
		    try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "12345678");
				PreparedStatement ps = conn.prepareStatement(SQL2)) {
				ResultSet rs = ps.executeQuery();
					
				while (rs.next()) {
					if(rs.getInt(1)==id) {
						bw.write(rs.getInt(3)+"\t"+rs.getString(2)+"\n");
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		    bw.close();
	    }
}

