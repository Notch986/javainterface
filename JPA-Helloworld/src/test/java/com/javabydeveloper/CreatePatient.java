package com.javabydeveloper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class CreatePatient {

	private final String SQL = "INSERT INTO patients "
			+ "(dni, names, father_surname, mother_surname, gender, birth, blood_type, size, weight, phone, address, email, others)"
			+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public JPanel panel;
	public int gender2;
	
	public CreatePatient() {
		createPatients();
	}
	@SuppressWarnings("unused")
	public void createPatients() {

		panel = new JPanel();
		panel.setBounds(30, 30, 290, 290);
		Border bordejpanel = new TitledBorder(new EtchedBorder(), "Datos Paciente");
		panel.setBorder(bordejpanel);
		panel.setForeground(Color.WHITE);
		Color c = new Color(255,255,255,30);
		panel.setBackground(c);
		panel.setOpaque(false);
		panel.setLayout(null);
		
		JTextField dni = new JTextField(10);
		dni.setBounds(60, 25, 86, 20);
		TextPrompt tp1 = new TextPrompt("DNI", dni);
		panel.add(dni);
		
		JTextField names = new JTextField(10);
		names.setBounds(150, 25, 86, 20);
		TextPrompt tp2 = new TextPrompt("Nombres", names);
		panel.add(names);
		
		JTextField father_surname = new JTextField(10);
		father_surname.setBounds(60, 50, 86, 20);
		TextPrompt tp3 = new TextPrompt("Apellido Paterno", father_surname);
		panel.add(father_surname);
		
		JTextField mother_surname = new JTextField(10);
		mother_surname.setBounds(150, 50, 86, 20);
		TextPrompt tp4 = new TextPrompt("Apellido Materno", mother_surname);
		panel.add(mother_surname);
		
		JComboBox<String> gender = new JComboBox<String>();
		gender.setBounds(60, 75, 86, 22);
		gender.addItem("Mujer");
		gender.addItem("Hombre");
		Dimension d = new Dimension(8,5);
		gender.setMaximumSize(d);
		if(gender.getSelectedItem().toString().equals("Hombre")) {
			gender2 = 1;
		} else if(gender.getSelectedItem().toString().equals("Mujer")){
			gender2 = 2;
		}
		panel.add(gender);
		
		JTextField birth = new JTextField(10);
		birth.setBounds(150, 75, 86, 20);
		TextPrompt tp6 = new TextPrompt("DD/MM/YYYY", birth);
		panel.add(birth);
		
		JTextField blood_type = new JTextField(10);
		blood_type.setBounds(60, 100, 86, 20);
		TextPrompt tp7 = new TextPrompt("Tipo de sangre", blood_type);
		panel.add(blood_type);
		
		JTextField size = new JTextField(10);
		size.setBounds(150, 100, 86, 20);
		TextPrompt tp8 = new TextPrompt("Altura", size);
		panel.add(size);
		
		JTextField weight = new JTextField(10);
		weight.setBounds(60, 125, 86, 20);
		TextPrompt tp9 = new TextPrompt("Peso", weight);
		panel.add(weight);
		
		JTextField phone = new JTextField(10);
		phone.setBounds(150, 125, 86, 20);
		TextPrompt tp10 = new TextPrompt("Numero", phone);
		panel.add(phone);
		
		JTextField address = new JTextField(10);
		address.setBounds(60, 150, 176, 20);
		TextPrompt tp11 = new TextPrompt("Direccion", address);
		panel.add(address);
		
		JTextField email = new JTextField(10);
		email.setBounds(60, 175, 176, 20);
		TextPrompt tp12 = new TextPrompt("Correo", email);
		panel.add(email);
		
		JTextField others = new JTextField(10);
		others.setBounds(100, 200, 86, 20);
		TextPrompt tp13 = new TextPrompt("Otros", others);
		panel.add(others);
		
		JLabel lblGuardar = new JLabel();
		lblGuardar.setBounds(75, 240, 150, 30);
		lblGuardar.setIcon(new ImageIcon("images/GuardarPaciente.png"));
		panel.add(lblGuardar);
		
		lblGuardar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {	
			
				try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root", "12345678");
						PreparedStatement ps2 = conn.prepareStatement(SQL)) {
			
			
			
					ps2.setString(1, dni.getText());
					ps2.setString(2, names.getText());
					ps2.setString(3, father_surname.getText());
					ps2.setString(4, mother_surname.getText());
					ps2.setInt(5, gender2);
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					Date date = df.parse(birth.getText());
					long time = date.getTime();
					Timestamp ts = new Timestamp(time);
					ps2.setTimestamp(6, ts);
					ps2.setString(7, blood_type.getText());
					ps2.setDouble(8, Float.parseFloat(size.getText()));
					ps2.setDouble(9, Float.parseFloat(weight.getText()));
					ps2.setString(10, phone.getText());
					ps2.setString(11, address.getText());
					ps2.setString(12, email.getText());
					ps2.setString(13, others.getText());
			
					@SuppressWarnings("unused")
					int row = ps2.executeUpdate();
					JOptionPane.showMessageDialog(null, "Paciente Guardado");
			
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
