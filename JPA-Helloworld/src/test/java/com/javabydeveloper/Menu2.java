package com.javabydeveloper;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu2 extends JFrame {

	private static final long serialVersionUID = -6465358221495242234L;
	private JLayeredPane opciones;
	private JLayeredPane formulario;
	private JLabel lblSalir;
	private JLabel lblAgregarSaturacion;
	private JLabel lblAgregarTemperatura;
	private JLabel lblVerGrafico;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu2 frame = new Menu2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("serial")
	public Menu2() {

		setBounds(100, 100, 500, 350);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		//bordes redondeados
		setShape(new RoundRectangle2D.Double(0, 0, 500, 350, 20, 20));
		//declaracion y degradado
		formulario = new JLayeredPane(){
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
		formulario.setBounds(150, 0, 350, 350);
		getContentPane().add(formulario);
		formulario.setLayout(null);
		
		JLabel Bienvenido = new JLabel("Welcome");
		Bienvenido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Bienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		Bienvenido.setForeground(Color.WHITE);
		Bienvenido.setBounds(132, 160, 90, 20);
		formulario.add(Bienvenido);
		
		lblSalir = new JLabel("");
		lblSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
			}
		});
		lblSalir.setIcon(new ImageIcon("images/salir.png"));
		lblSalir.setBounds(316, 11, 25, 25);
		formulario.add(lblSalir);
		/////////////////////////////////////////////////////////////////
		JLabel lblVer = new JLabel();
		lblVer.setBounds(0, 165, 160, 30);
		lblVer.setOpaque(false);
		lblVer.setBackground(new Color(194,194,194,30));
		lblVer.setHorizontalAlignment(SwingConstants.CENTER);
		lblVer.setForeground(Color.WHITE);
		getContentPane().add(lblVer);
		
		JLabel lblVer2 = new JLabel("Ver Lista");
		lblVer2.setBounds(0, 165, 160, 30);
		lblVer2.setOpaque(true);
		lblVer2.setBackground(new Color(194,194,194,30));
		lblVer2.setHorizontalAlignment(SwingConstants.CENTER);
		lblVer2.setForeground(Color.WHITE);
		getContentPane().add(lblVer2,1);
		
		JLabel lblCrear = new JLabel();
		lblCrear.setForeground(Color.WHITE);
		lblCrear.setBackground(new Color(194,194,194,30));
		lblCrear.setOpaque(false);
		lblCrear.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrear.setBounds(0, 201, 160, 30);
		getContentPane().add(lblCrear);
		
		JLabel lblCrear2 = new JLabel("Registrarse");
		lblCrear2.setForeground(Color.WHITE);
		lblCrear2.setBackground(new Color(194,194,194,30));
		lblCrear2.setOpaque(true);
		lblCrear2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrear2.setBounds(0, 201, 160, 30);
		getContentPane().add(lblCrear2,1);
		
		JLabel lblActualizar = new JLabel();
		lblActualizar.setForeground(Color.WHITE);
		lblActualizar.setBackground(new Color(194,194,194,30));
		lblActualizar.setOpaque(false);
		lblActualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizar.setBounds(0, 237, 160, 30);
		getContentPane().add(lblActualizar);
		
		JLabel lblActualizar2 = new JLabel("Actualizar");
		lblActualizar2.setForeground(Color.WHITE);
		lblActualizar2.setBackground(new Color(194,194,194,30));
		lblActualizar2.setOpaque(true);
		lblActualizar2.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizar2.setBounds(0, 237, 160, 30);
		getContentPane().add(lblActualizar2);
		
		JLabel lblBorrar = new JLabel();
		lblBorrar.setForeground(Color.WHITE);
		lblBorrar.setBackground(new Color(194,194,194,30));
		lblBorrar.setOpaque(false);
		lblBorrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrar.setBounds(0, 273, 160, 30);
		getContentPane().add(lblBorrar);
		
		JLabel lblBorrar2 = new JLabel("Borrar");
		lblBorrar2.setForeground(Color.WHITE);
		lblBorrar2.setBackground(new Color(194,194,194,30));
		lblBorrar2.setOpaque(true);
		lblBorrar2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrar2.setBounds(0, 273, 160, 30);
		getContentPane().add(lblBorrar2);
		/////////////////////////////////////////////////////////////////
		opciones = new JLayeredPane(){
			 protected void paintComponent(Graphics g) {
				 super.paintComponents(g);
		    	  Graphics2D g2d=(Graphics2D)g;
		    	  int w = getWidth();
		    	  int h = getHeight();
		    	  g2d.setPaint(new GradientPaint(200, 0, Color.GRAY, 200, 350, Color.black));
		    	  g2d.fillRect(0, 0, w, h);
			 }
		};
		opciones.setBounds(0, 0, 150, 350);
		getContentPane().add(opciones);
		opciones.setLayout(null);
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setIcon(new ImageIcon("images/logo.png"));
		lblTitulo.setBounds(10, 11, 130, 100);
		opciones.add(lblTitulo, 1);
		
		JLabel lblTitulo2 = new JLabel(){
			 protected void paintComponent(Graphics g) {
				 super.paintComponents(g);
				 Color c = new Color(33,120,137,255);
		    	 Graphics2D g2d=(Graphics2D)g;
		    	 int w = getWidth();
		    	 int h = getHeight();
		    	 g2d.setPaint(new GradientPaint(0, 0, c, 150, 30, Color.black));
		    	 g2d.fillRect(0, 0, w, h);
			 }
		};
		lblTitulo2.setBounds(0, 124, 150, 30);
		opciones.add(lblTitulo2);
		
		JLabel lblTitulo3 = new JLabel("");
		lblTitulo3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo3.setIcon(new ImageIcon("images/icop.png"));
		lblTitulo3.setBounds(0, 124, 150, 30);
		opciones.add(lblTitulo3,1);
		
		lblVer.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblVer.setIcon(new ImageIcon("images/verPaciente.png"));
				readList();
				lblCrear.setIcon(null);
				lblActualizar.setIcon(null);
				lblBorrar.setIcon(null);
			}
		});
		
		lblCrear.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblCrear.setIcon(new ImageIcon("images/crearPaciente.png"));
				createPatient();
				lblActualizar.setIcon(null);
				lblBorrar.setIcon(null);
				lblVer.setIcon(null);
			}
		});
		
		lblActualizar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblActualizar.setIcon(new ImageIcon("images/actualizarPaciente.png"));
				updatePatient();
				lblCrear.setIcon(null);
				lblBorrar.setIcon(null);
				lblVer.setIcon(null);
			}
		});
		
		lblBorrar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblBorrar.setIcon(new ImageIcon("images/borrarPaciente.png"));
				lblCrear.setIcon(null);
				lblActualizar.setIcon(null);
				lblVer.setIcon(null);
			}
		});
		////////////////////////////////////////////////
		lblAgregarSaturacion = new JLabel();
		lblAgregarSaturacion.setIcon(new ImageIcon("images/AgregarSaturacion.png"));
		lblAgregarSaturacion.setBounds(30,300, 90,30);
		
		lblAgregarTemperatura = new JLabel();
		lblAgregarTemperatura.setIcon(new ImageIcon("images/AgregarTemperatura.png"));
		lblAgregarTemperatura.setBounds(230,300, 90,30);
		
		lblVerGrafico = new JLabel();
		lblVerGrafico.setIcon(new ImageIcon("images/VerGrafico.png"));
		lblVerGrafico.setBounds(130,310, 90,30);
		////////////////////////////////////////////////
		lblAgregarSaturacion.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Saturation s = new Saturation();
			}
		});
		
		lblAgregarTemperatura.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Temperature t = new Temperature();
			}
		});
		
		lblVerGrafico.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					ViewGraphics v = new ViewGraphics();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void readList() {
		formulario.removeAll();
		formulario.updateUI();
		formulario.add(lblSalir);
		ReadPatient rp = new ReadPatient();
		formulario.add(rp.scrollLista);
		formulario.add(lblAgregarSaturacion);
		formulario.add(lblAgregarTemperatura);
		formulario.add(lblVerGrafico);
		formulario.updateUI();
	}
	public void createPatient() {
		formulario.removeAll();
		formulario.updateUI();
		formulario.add(lblSalir);
		CreatePatient c = new CreatePatient();
		formulario.add(c.panel);
		formulario.updateUI();
	}
	public void updatePatient() {
		formulario.removeAll();
		formulario.updateUI();
		formulario.add(lblSalir);
		UpdatePatient u = new UpdatePatient();
		formulario.add(u.panel);
		formulario.updateUI();
	}
	public void deletePatient() {
		formulario.removeAll();
		formulario.updateUI();
		formulario.add(lblSalir);
		deletePatient d = new deletePatient();
		//formulario.add(d.panel);
		formulario.updateUI();
	}
}
